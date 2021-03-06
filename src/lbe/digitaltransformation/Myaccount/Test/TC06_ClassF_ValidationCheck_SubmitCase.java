package lbe.digitaltransformation.Myaccount.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import lbe.digitaltransformation.Utility.ExcelReadWrite;
import lbe.digitaltransformation.Utility.Utility;

public class TC06_ClassF_ValidationCheck_SubmitCase extends BaseTest
{
	String AccountNumber_heading= "Account number"; 						//Council tax Account number Page heading text
	String AccountDetails_heading= "Account details"; 						//Council tax Account Details Page heading text
	String AppDetails_heading= "Application details"; 					//Council tax Application details Page heading text
	String Support_Info_Declaration_heading= "Supporting information and declaration"; //Council tax Declaration Page heading text
	String ServiceSummary_heading= "Service summary"; 						//Council tax Service summary Page heading text
	String Screenshotname="ClassF_ConfirmationScreen";  							//Screen shot name.
	String Delegation_heading="Please complete details of the person you wish to act on behalf of.";  //Common delegation	
	public static final String Sh_ClassF="ClassF";
	
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
			ct.ClickonclassFlink();
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
			ut.Postcode_SelectAddress(Sh_ClassF,1,2,3);    // Address of Unoccupied Property field (Sheetname, Row, Colunm, Dropdown)  
			cf.Enter_FirstNameInformant(Sh_ClassF, 1, 4);
			cf.Enter_LastNameInformant(Sh_ClassF, 1, 5);
			ut.PostcodeOnbehalf_SelectAddress(Sh_ClassF, 1, 6, 7);
			ut.telphonenumber();
		
			ut.NEXT_2();				//This method will click on Account Details page next button

			s_assert.assertEquals(AppDetails_heading, ut.Page_heading());
			ut.MandatoryFieldCheck();
		
			cf.Enter_FirstName_Deceased(Sh_ClassF, 1, 10);
			cf.Enter_LastName_Deceased(Sh_ClassF, 1, 11);
			cf.Enter_Person_Died_Date(Sh_ClassF, 1, 12);
			cf.Select_PropertyUnoccupied(Sh_ClassF, 1, 13);
			cf.Select_Furnished_Unfurnished(Sh_ClassF, 1, 14);
			cf.Enter_DateFurnitureRemoved(Sh_ClassF, 1, 15);
			cf.Select_AdministrationGranted(Sh_ClassF, 1, 16);
			js.executeScript("window.scrollBy(0, -100)"); 
			cf.Enter_AdministrationGrantedDate(Sh_ClassF, 1, 17);
			cf.Enter_Name_Address_Administrator(Sh_ClassF, 1, 18);
			cf.Enter_Name_Address_Solicitor(Sh_ClassF, 1, 19);
			cf.Select_Deceased_Tenant_Owner(Sh_ClassF, 1, 20);
			cf.Select_NewOwner_Ownership_Y_N(Sh_ClassF, 1, 24);
			cf.Enter_OwnerShipTransfered_Date(Sh_ClassF, 1, 25);
			cf.Enter_NameAddress_NewOwner(Sh_ClassF, 1, 26);
	
			ut.NEXT_2();    //This method will click on Account Details page next button
			
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
			String AddScreenClassF=ut.captureScrenshot(Screenshotname);	
			logger.log(LogStatus.INFO, "Customer uploads relevant documents and submits the case and Case number is genarated");
			logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and "+Service_Casenumber);
			
			ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassF,Service_Casenumber.substring(20, 30), 1, 1);
			
			//logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.captureScrenshot(driver, ClassF_Screenshotname)));
			System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
			//logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassF));	
			ut.ClickGotohome_btn();
			s_assert.assertAll();
			System.out.println("Test Run Compleed ");
	
	}
	
	
	@Test (groups = {"Onbehalf_of_SomeOneElse"})
	public void Apply_onbehalfof_some_one_else() throws Exception 
	{	
		TestCasePass="Customer Selected Onbehalf of Some one else and Submitted case successfully";
		TestCaseFail="Customer is unable to Submit a case for Onbehalf of Some one else, 'Some thing went wrong' Please Check the Code";	
		TestCaseSkip="Test Case is Skipped for 'Submit a case for Onbehalf of Some one else' "; 
		String Casenumber=null;
		int i=1; // for Apply for yourself make i=0
		int j=2; //If 1 selects "This time only" option if 2 Selects "Indefinitely (until you advise us otherwise)"
		
			hp.Clickonwhatservicebutton();
			hp.ClickonCounciltax();	
			ct.ClickonclassFlink();	
			ut.Verify_SubService_titlepage();
			ut.select_self_onbehalf(i);
			if(j==1)
			{
				ut.select_Authority_act(j);
				ut.Click_StartForm();
			
				s_assert.assertEquals(ut.Delegationheading(), Delegation_heading);
				ut.FirstNamedelegationTextbox(Sh_ClassF,1,27);
				ut.LastNamedelegationTextbox(Sh_ClassF,1,28);
				ut.AddressdelegationTextbox(Sh_ClassF,1,29,30);                 // Parameter are Sheetname, excel filename & path, Row, Colunm, Dropdown index value (Actual address)  
				logger.log(LogStatus.INFO, "Customer Added New delegation");
				ut.NEXT_2();
				logger.log(LogStatus.INFO, "Customer selected OnBehalf of Some one else (Athourity to act : This time only) ");
				
			}
			else  
			{
				ut.select_Authority_act(j);
				ut.tickdelegationcheckbox();
				ut.Click_StartForm();
			
				s_assert.assertEquals(ut.Delegationheading(), Delegation_heading);
				ut.FirstNamedelegationTextbox(Sh_ClassF,1,27);
				ut.LastNamedelegationTextbox(Sh_ClassF,1,28);
				ut.AddressdelegationTextbox(Sh_ClassF,1,29,30);                // Parameter are Sheetname, excel filename & path, Row, Colunm, Dropdown index value (Actual address)  
				ut.NEXT_2();
				logger.log(LogStatus.INFO, "Customer selected OnBehalf of Some one else (Athourity to act : Indefinitly [until you advise us]) ");
				logger.log(LogStatus.INFO, "Customer Added New delegation");
				
			}
			
			s_assert.assertEquals(AccountDetails_heading, ut.Page_heading());
		
			ut.MandatoryFieldCheck();
			ut.PostcodeOnbehalf_SelectAddress(Sh_ClassF, 1, 6, 7);
			ut.telphonenumber();
		
			ut.NEXT_2();				//This method will click on Account Details page next button

			s_assert.assertEquals(AppDetails_heading, ut.Page_heading());
			ut.MandatoryFieldCheck();
		
			cf.Enter_FirstName_Deceased(Sh_ClassF, 1, 10);
			cf.Enter_LastName_Deceased(Sh_ClassF, 1, 11);
			cf.Enter_Person_Died_Date(Sh_ClassF, 1, 12);
			cf.Select_PropertyUnoccupied(Sh_ClassF, 1, 13);
			cf.Select_Furnished_Unfurnished(Sh_ClassF, 1, 14);
			cf.Enter_DateFurnitureRemoved(Sh_ClassF, 1, 15);
			cf.Select_AdministrationGranted(Sh_ClassF, 1, 16);
			cf.Enter_AdministrationGrantedDate(Sh_ClassF, 1, 17);
			cf.Enter_Name_Address_Administrator(Sh_ClassF, 1, 18);
			cf.Enter_Name_Address_Solicitor(Sh_ClassF, 1, 19);
			cf.Select_Deceased_Tenant_Owner(Sh_ClassF, 1, 20);
			cf.Select_NewOwner_Ownership_Y_N(Sh_ClassF, 1, 24);
			cf.Enter_OwnerShipTransfered_Date(Sh_ClassF, 1, 25);
			cf.Enter_NameAddress_NewOwner(Sh_ClassF, 1, 26);
	
			ut.NEXT_2();    //This method will click on Account Details page next button
			
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
			String AddScreenClassF=ut.captureScrenshot(Screenshotname);	
			logger.log(LogStatus.INFO, "Customer uploads relevant documents and submits the case and Case number is genarated");
			logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and "+Service_Casenumber);
			
			ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassF,Service_Casenumber.substring(20, 30), 1, 1);
			
			//logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.captureScrenshot(driver, ClassF_Screenshotname)));
			System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
			//logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassF));	
			ut.ClickGotohome_btn();
			s_assert.assertAll();
			System.out.println("Test Run Compleed ");
	
	}
	
	
}
