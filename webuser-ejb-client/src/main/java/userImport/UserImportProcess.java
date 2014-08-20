package userImport;


import com.webuser.ejb.WebUserManager;
import org.apache.log4j.Logger;
import userImport.model.Parameter;
import userImport.model.WebUser;
import userImport.parser.WebUserParser;
import userImport.parser.jaxbParser.WebUserXmlParser;

import java.io.File;
import java.util.*;

import static userImport.FileUtils.isFileExist;

public final class UserImportProcess {

    private static Logger logger = Logger.getLogger(UserImportProcess.class);

    public static void main(String[] args) {
        if (hasCorrectInputArgs(args)) {
            String propertiesFileName = args[0];
            String userDataFileName = args[1];
            List<WebUser> webUsers = getWebUsersFromInputXml(userDataFileName);
            int size = webUsers.size();
            if (size != 0) {
                ImportUserConfig userConfig = new ImportUserConfig();
                userConfig.initFromPropertyFile(propertiesFileName);
                if (userConfig.isValid()) {
                    EjbClient ejbClient = new EjbClient(propertiesFileName);
                    WebUserManager webUserManager = (WebUserManager) ejbClient.getRemoteEjb(WebUserManager.class);
                    logger.info(String.format("About to process %d records from %s", size, userDataFileName));
                    int cur = 0;
                    int nOnCompleteErrors = 0;
                    int nErrors = 0;
                    for (WebUser importedUser : webUsers) {
                        cur++;
                        com.webuser.model.WebUser webUser = performUserImport(userConfig, webUserManager, importedUser);
                        if (webUser == null) {
                            nErrors++;
                            nOnCompleteErrors++;
                        }
                        if ((cur % 100) == 0) {
                            logger.info(String.format("%d processed, %d success, %d errors", cur
                                    , cur - nErrors, nErrors));
                        }
                    }
                    logger.info(String.format("Load Completed %d processed, %d success, %d errors", cur
                            , cur - nOnCompleteErrors, nOnCompleteErrors));
                } else {
                    logger.error("One of the properties has invalid number or empty string. Please check all properties exist and have valid values");
                }
            } else {
                logger.info("The input webusers collection is empty");
            }
        }

    }

    public static com.webuser.model.WebUser performUserImport(ImportUserConfig userConfig, WebUserManager webUserManager, WebUser importedUser) {
        try {
            if (importedUser.getStoreId()==null || importedUser.getStoreId()==0){
                throw new IllegalArgumentException("The storeId is null or 0");
            }
            com.webuser.model.WebUser userFromStorage = webUserManager
                    .getSingleWebUserByEmailAddressAndStoreId(importedUser.getEmailAddress()
                            , importedUser.getStoreId());
            if (userFromStorage != null) {
                new WebUserCloner().copyLoyaltyMembers(importedUser,userFromStorage);
                userFromStorage.setStoreId(importedUser.getStoreId());
                List<Parameter> parameters = importedUser.getParameters();
                if(parameters != null){
                    for (Parameter parameter : parameters) {
                        userFromStorage.setParameter(parameter.getName(), parameter.getValue());
                    }
                }
                webUserManager.updateWebUser(userFromStorage);
                return userFromStorage;
            } else {
                com.webuser.model.WebUser newUser = new WebUserCloner()
                        .copyWebUser(importedUser);
                newUser.setPasswordFormat(userConfig.getPasswordFormat());
                newUser.setJoinChannelId(userConfig.getJoinChannelId());
                newUser.setEmailAddress(newUser.getUsername());
                webUserManager.createWebUser(newUser, false);
                return newUser;
            }
        } catch (Exception e) {
            logger.error("User Creation Error:ImportedUserId - " + importedUser.getStoreId());
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    private static List<WebUser> getWebUsersFromInputXml(String userDataFileName) {
        File userDataFile = new File(userDataFileName);
        WebUserParser webUserParser = new WebUserXmlParser(userDataFile);
        List<WebUser> webUsers = new ArrayList<WebUser>();
        try {
            webUsers = webUserParser.getAll();
        } catch (Exception e) {
            logger.error("Can't parse input file: " + userDataFile, e);
        }
        return webUsers;
    }

    private static boolean hasCorrectInputArgs(String[] args) {
        boolean result = false;
        if (args.length <= 1) {
            logger.error("Program lack properties error. Requires two properties <config> and <xml file to import>");
        } else {
            if (isFileExist(args[0]) && isFileExist(args[1])) {
                result = true;
            }
        }
        return result;
    }

}
