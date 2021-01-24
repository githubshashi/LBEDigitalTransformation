package lbe.digitaltransformation.Myaccount.Test;

import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import lbe.digitaltransformation.Utility.ExcelReadWrite;
import lbe.digitaltransformation.Utility.Utility;

public class TC09_ClassR_ValidationCheck_SubmitCase extends BaseTest
{

	String AccountNumber_heading= "Account number"; 						//Council tax Account number Page heading text
	String AccountDetails_heading= "Account details"; 						//Council tax Account Details Page heading text
	String AppDetails_heading= "Application details"; 					//Council tax Application details Page heading text
	String Support_Info_Declaration_heading= "Supporting information and declaration"; //Council tax Declaration Page heading text
	String ServiceSummary_heading= "Service summary"; 						//Council tax Service summary Page heading text
	String Screenshotname="ClassR_ConfirmationScreen";  							//Screen shot name.
	String Delegation_heading="Please complete details of the person you wish to act on behalf of.";  //Common delegation	
	public static final String Sh_ClassR="ClassR";
	
	SoftAssert s_assert= new SoftAssert();
	
	@Test (groups = {"Apply_for_self"})
	public void ApplyForSelf() throws Exception 
	{	
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		TestCasePass="Customer Selected Apply for self and Submitted case successfully";
		TestCaseFail="Customer is unable to Submit a case for Apply for self, 'Some thing went wrong' Please Check the Code";	
		TestCaseSkip="Test Case is Skipped for 'Submit a case for Apply for self' ";   
		String Casenumber=null;		
		int i=0;  // for Apply for yourself make i=0
			hp.Clickonwhatservicebutton();
			hp.ClickonCounciltax();	
			ct.ClickonclassRlink();
			ut.Verify_SubService_titlepage();
			ut.select_self_onbehalf(i);
			logger.log(LogStatus.INFO, "Customer selected Applyforself Option");
			ut.Click_StartForm();    //Description Page Next Button, Start he form and case will be saved in draft state
							
		
			s_assert.assertEquals(AccountNumber_heading, ut.Page_heading());
			ut.tickboxCouncilTaxAccNo();
		
			ut.NEXT_2();                         //Account Number page next button
		
			s_assert.assertEquals(AccountDetails_heading, ut.Page_heading());
			ut.MandatoryFieldCheck();
			ut.CTAccountnumber(Utility.excelfilepath, 1, 2);
			ut.Postcode_SelectAddress(Sh_ClassR,1,2,3);    // Address of Unoccupied pitch or mooring (Sheetname, Row, Colunm, Dropdown)  
			cr.Enter_Name_Owner_pitch_mooring(Sh_ClassR, 1, 4);
			ut.PostcodeOnbehalf_SelectAddress(Sh_ClassR, 1, 5, 6);
			ut.telphonenumber();
			
			ut.NEXT_2();    //This method will click on Account Details page next button
			
			cr.Select_Property_Boat_Caravan(Sh_ClassR, 1, 8);
			cr.Enter_Mooring_Pitch_Vacated_Date(Sh_ClassR, 1, 9);
			
			ut.NEXT_2();            //This method will Click on Application Details page NEXT button
			logger.log(LogStatus.INFO, "Customer entered all valid data to fields in Application details page");
			
			ut.Uploadedocument();
			ut.NEXT_2();  //This method will click on Upload page NEXT button
			
			s_assert.assertEquals(Support_Info_Declaration_heading, ut.Declarationheading());	
			ut.Select_summons();
			ut.ClickCheckBox();
			ut.ClickSubmit_btn();
			
			s_assert.assertEquals(ServiceSummary_heading, ut.Servicesummaryheading());
			String Service_Casenumber=ut.Casenumber(Casenumber);
			String AddScreenClassR=ut.captureScrenshot(Screenshotname);	
			logger.log(LogStatus.INFO, "Customer uploads relevant documents and submits the case and Case number is genarated");
			logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and "+Service_Casenumber);
			
			ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassR,Service_Casenumber.substring(20, 30), 1, 1);
			
			//logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.captureScrenshot(driver, ClassF_Screenshotname)));
			System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
			logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassR));	
			ut.ClickGotohome_btn();
			s_assert.assertAll();
			System.out.println("Test Run Compleed ");
	
		
	}
			
	
			
}
