package in.edso.testbase;

import in.edso.util.CommonWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {

    public static WebDriver driver;
    public static Properties prop;

    public WebTestBase() {
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
        }catch (FileNotFoundException f)
        {
            f.printStackTrace();
        }
        prop=new Properties();
        try {
            prop.load(fileInputStream);
        }catch (IOException i){
            i.printStackTrace();
        }

    }

    public void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/properties/drivers/chromedriver.exe");
            driver=new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions=new FirefoxOptions();
            firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/properties/drivers/geckodriver.exe");
            driver=new FirefoxDriver(firefoxOptions);
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/src/main/resources/properties/drivers/msedgedriver.exe");
            driver=new EdgeDriver();
        } else {
            throw new RuntimeException("Please select the correct browser name");
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonWaits.PAGE_LOAD_TIMEOUT));
        driver.manage().deleteAllCookies();
    }
}
