package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	
	public static WebDriver IntializeDriver() throws IOException {
		log=LogManager.getLogger(base.class.getName());
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Divya\\WebBasedTesting\\src\\main\\java\\Resources\\Data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("Browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Divya\\Documents\\Study\\Imp\\UFT\\Selenium\\Data\\chromedriver.exe");
			 driver=new ChromeDriver();
			
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Divya\\geckodriver.exe");
			 driver=new FirefoxDriver();
			 
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\Divya\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
			 
		}
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		return driver;
	}
	

}



