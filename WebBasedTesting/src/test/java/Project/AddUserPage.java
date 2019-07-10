package Project;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.ExcelDataConfig;

public class AddUserPage extends HomePage{

	@Test(dataProvider="AddUser")
	public void UserDetails(String Firstname,String LastName,String UserName,String Pwd,String Email,String Cell) throws IOException, InterruptedException {

		AddUserPage ap=new AddUserPage();
		ap.Starting();
		ap.UserListTable();
		AddUserObjects apo=new AddUserObjects(driver);
		apo.AddUser.click();
		log.info("Clicked on AddUser button");
		log.debug("Adding the valid user details");
		apo.AddUserDetails(Firstname,LastName,UserName,Pwd,Email,Cell);
		log.info("User Added Sucessfully!!");
		log.debug("Verify the user details added to List");
		apo.ValidationofAddDetails(Firstname);
		log.info("User Details are add to list Sucessfully ");
	}

	@AfterMethod()
	public void CloseDriver() {
		driver.close();
		driver=null;
	}






	@DataProvider(name="AddUser")
	public Object[ ][ ] AddUser()
	{
		ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\Divya\\Documents\\UserDetails.xlsx");
		int rows=excel.getRowCount(0);
		Object[][] obj=new Object[rows][6];
		for(int i=0;i<rows;i++)
		{
			obj[i][0]=excel.getData(0,i,0);
			obj[i][1]=excel.getData(0,i,1);
			obj[i][2]=excel.getData(0,i,2);
			obj[i][3]=excel.getData(0,i,3);
			obj[i][4]=excel.getData(0,i,4);
			obj[i][5]=excel.getData(0,i,5);


		}

		return obj;
	}
}
