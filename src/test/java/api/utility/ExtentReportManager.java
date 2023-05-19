package api.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager{

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    static String reportName;

    public static void setExtent() throws IOException {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.mm.ss").format(new Date());
        reportName = "Test-Report-" + timeStamp + ".html";
        sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+reportName);

        sparkReporter.config().setDocumentTitle("Rest Assured Automation Project");
        sparkReporter.config().setReportName("Pet Store API");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("HostName", "Abhijot");
        extent.setSystemInfo("Application", "Pet Store Api Testing");
        extent.setSystemInfo("OS", "Win10 pro");

    }

    public static void endReport() {
        extent.flush();
    }
}
