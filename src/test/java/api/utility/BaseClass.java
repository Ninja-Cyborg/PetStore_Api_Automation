package api.utility;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// read config.properties file
// statusCode
public class BaseClass {

    public static Properties props;
    public Logger logger;

    @BeforeSuite
    public void initReporting() throws IOException {
        ExtentReportManager.setExtent();

    }

    static Properties getProperties(){
        // loading prop file
        try {
            props = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\configuration\\Config.properties");
            props.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static int getStatusCode(){
        String code = getProperties().getProperty("status_code");
        return Integer.parseInt(code);
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReportManager.endReport();
    }


}
