package userImport;

import org.apache.log4j.Logger;

import java.util.Properties;

import static userImport.FileUtils.getPropertiesFromFile;


public class ImportUserConfig {
    private static Logger logger = Logger.getLogger(ImportUserConfig.class);
    private Integer passwordFormat;
    private String joinChannelId;


    public Integer getPasswordFormat() {
        return passwordFormat;
    }

    public String getJoinChannelId() {
        return joinChannelId;
    }


    public void setPasswordFormat(Integer passwordFormat) {
        this.passwordFormat = passwordFormat;
    }

    public void setJoinChannelId(String joinChannelId) {
        this.joinChannelId = joinChannelId;
    }

    public void initFromPropertyFile(String propertiesFileName) {
        Properties properties = getPropertiesFromFile(propertiesFileName);
        this.setJoinChannelId(properties.getProperty("newuser.JoinChannelId"));
        try {
            this.setPasswordFormat(Integer.valueOf(properties.getProperty("newuser.PasswordFormat")));
        } catch (NumberFormatException e) {
            logger.error("Invalid number input property. Please check the properties file.", e);
        }
    }

    public boolean isValid() {
        if (getJoinChannelId() == null || getPasswordFormat() == null || getJoinChannelId().length() == 0 ||
                getPasswordFormat() == 0) {
            return false;
        }
        return true;
    }
}
