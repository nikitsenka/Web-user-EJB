package userImport;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class FileUtils {
    private static Logger logger = Logger.getLogger(FileUtils.class);
    public static Properties getPropertiesFromFile(String filePath) {
        Properties prop = new Properties();
        try (FileInputStream inStream = new FileInputStream(new File(filePath))){
            prop.load(inStream);
        } catch (IOException e) {
            logger.error("Can't open property file: "+filePath,e);
        }
        return prop;
    }
    public static boolean isFileExist(String fileName) {
        boolean result =  false;
        if(fileName !=null && fileName.toString().length()>0){
            if(new File(fileName).exists()){
                result = true;
            }else{
                logger.error("The file doesn't exist. File: "+ fileName);
            }
        }else{
            logger.error("Invalid input file name");
        }
        return result;
    }

    private FileUtils() {
    }
}
