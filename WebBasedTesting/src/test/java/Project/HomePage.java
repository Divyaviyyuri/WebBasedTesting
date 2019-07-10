package Project;

import java.io.IOException;
import Resources.base;
public class HomePage extends base{
	

		
		//@BeforeMethod
		public void Starting() throws IOException{

			driver=IntializeDriver();
			log.info("Browser Intialized successfully!!");
		}

		//@Test
		public void UserListTable() throws InterruptedException, IOException{

			driver.get(prop.getProperty("Url"));
			log.info(" Landed on way2automation Page");
			HomePageObjects hp=new HomePageObjects(driver);
			log.debug("Validating the presence of User List Table on the page");
			hp.TableValidation();
			log.info("User List Table is present on the Page");
		
			
		
		}
			
		
		

		
}

