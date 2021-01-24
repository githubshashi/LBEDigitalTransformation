package lbe.digitaltransformation.Myaccount.Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import lbe.digitaltransformation.Utility.ExcelReadWrite;
import lbe.digitaltransformation.Utility.Utility;

public class TC04_ClassI_ValidationCheck_SubmitCase extends BaseTest
{
	
	String AccountNumber_heading= "Account number"; 						//Council tax Account number Page heading text
	String AccountDetails_heading= "Account details"; 						//Council tax Account Details Page heading text
	String AppDetails_heading= "Application details"; 					//Council tax Application details Page heading text
	String Support_Info_Declaration_heading= "Supporting information and declaration"; //Council tax Declaration Page heading text
	String ServiceSummary_heading= "Service summary"; 						//Council tax Service summary Page heading text
	String Screenshotname="ClassIConfirmationScreen";  							//Screen shot name.
	String Delegation_heading="Please complete details of the person you wish to act on behalf of.";  //Common delegation	
	public static final String Sh_ClassI="ClassI";
	
	
	
	SoftAssert s_assert= new SoftAssert();
	
				
		@Test (groups = {"Apply_for_self"})
		public void ApplyForSelf() throws Exception 
		{	
			TestCasePass="Customer Selected Apply for self and Submitted case successfully";
			TestCaseFail="Customer is unable to Submit a case for Apply for self, 'Some thing went wrong' Please Check the Code";	
			TestCaseSkip="Test Case is Skipped for 'Submit a case for Apply for self' ";   
			String Casenumber=null;		
			int i=0;  // for Apply for yourself make i=0
				hp.Clickonwhatservicebutton();
				hp.ClickonCounciltax();	
				ct.ClickonclassIlink();
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
				ut.Postcode_SelectAddress(Sh_ClassI,1,2,3);    // Address of Unoccupied Property field (Sheetname, Row, Colunm, Dropdown)  
				ci.Enter_Firstname_person_left_property(Sh_ClassI, 1, 4);
				ci.Enter_Lastname_person_left_property(Sh_ClassI, 1, 5);
				ut.telphonenumber();
			
				ut.NEXT_2();				//This method will click on Account Details page next button
				
				s_assert.assertEquals(AppDetails_heading, ut.Page_heading());
				ut.MandatoryFieldCheck();
				
				ci.Enter_Date_PropertyOccupied(Sh_ClassI, 1, 10);
				ci.Select_Owner_Tenant_UnoccupiedProperty(ut.excelfilepath,Sh_ClassI, 1,11);
				ci.SelectAddress_Person_receiving_care(ut.excelfilepath,Sh_ClassI, 1, 12, 3);
				ci.Enter_Date_PersonMovedAddress(Sh_ClassI, 1, 14);
				ci.Select_ResonForCare(ut.excelfilepath,Sh_ClassI, 1, 15);
				ci.Enter_Describe_NatureOfCare(Sh_ClassI, 1, 16);

				ut.NEXT_2();            //This method will Click on Application Details page NEXT button
				logger.log(LogStatus.INFO, "Customer entered all valid data in Application details page");
				
				ut.Uploadedocument();
				ut.NEXT_2();  //This method will click on Upload page NEXT button
				
				s_assert.assertEquals(Support_Info_Declaration_heading, ut.Declarationheading());	
				ut.Select_summons();
				ut.ClickCheckBox();
				ut.ClickSubmit_btn();
				
				s_assert.assertEquals(ServiceSummary_heading, ut.Servicesummaryheading());
				String Service_Casenumber=ut.Casenumber(Casenumber);
				String AddScreenClassI=ut.captureScrenshot(Screenshotname);	
				logger.log(LogStatus.INFO, "Customer uploads relevant documents and submits the case and Case number is genarated");
				logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and "+Service_Casenumber);
				
				ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassI,Service_Casenumber.substring(20, 30), 1, 1);
			
				//logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.captureScrenshot(driver, ClassDScreenshotname)));
				System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
				//logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassD));	
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
				ct.ClickonclassIlink();
				ut.Verify_SubService_titlepage();
				ut.select_self_onbehalf(i);
				if(j==1)
				{
					ut.select_Authority_act(j);
					ut.Click_StartForm();
				
					s_assert.assertEquals(ut.Delegationheading(), Delegation_heading);
					ut.FirstNamedelegationTextbox(Sh_ClassI,1,17);
					ut.LastNamedelegationTextbox(Sh_ClassI,1,18);
					ut.AddressdelegationTextbox(Sh_ClassI,1,19,20);                 // Parameter are Sheetname, excel filename & path, Row, Colunm, Dropdown index value (Actual address)  
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
					ut.FirstNamedelegationTextbox(Sh_ClassI,1,17);
					ut.LastNamedelegationTextbox(Sh_ClassI,1,18);
					ut.AddressdelegationTextbox(Sh_ClassI,1,19,20);                 // Parameter are Sheetname, excel filename & path, Row, Colunm, Dropdown index value (Actual address)  
					ut.NEXT_2();
					logger.log(LogStatus.INFO, "Customer selected OnBehalf of Some one else (Athourity to act : Indefinitly [until you advise us]) ");
					logger.log(LogStatus.INFO, "Customer Added New delegation");		
				}
				
				s_assert.assertEquals(AccountDetails_heading, ut.Page_heading());
			
				ut.MandatoryFieldCheck();
				ut.CTAccountnumber(Utility.excelfilepath, 1, 2);
				ut.telphonenumber();
			
				ut.NEXT_2();				//This method will click on Account Details page next button
				
				s_assert.assertEquals(AppDetails_heading, ut.Page_heading());
				ut.MandatoryFieldCheck();
				ci.Enter_Date_PropertyOccupied(Sh_ClassI, 1, 10);
				ci.Select_Owner_Tenant_UnoccupiedProperty(ut.excelfilepath,Sh_ClassI, 1,11);
				ci.SelectAddress_Person_receiving_care(ut.excelfilepath,Sh_ClassI, 1, 12, 3);
				ci.Enter_Date_PersonMovedAddress(Sh_ClassI, 1, 14);
				ci.Select_ResonForCare(ut.excelfilepath,Sh_ClassI, 1, 15);
				ci.Enter_Describe_NatureOfCare(Sh_ClassI, 1, 16);

				ut.NEXT_2();            //This method will Click on Application Details page NEXT button
				logger.log(LogStatus.INFO, "Customer entered all valid data in Application details page");
				
				ut.Uploadedocument();
				ut.NEXT_2();  //This method will click on Upload page NEXT button
				
				s_assert.assertEquals(Support_Info_Declaration_heading, ut.Declarationheading());	
				ut.Select_summons();
				ut.ClickCheckBox();
				ut.ClickSubmit_btn();
				
				s_assert.assertEquals(ServiceSummary_heading, ut.Servicesummaryheading());
				String Service_Casenumber=ut.Casenumber(Casenumber);
				String AddScreenClassI=ut.captureScrenshot(Screenshotname);	
				logger.log(LogStatus.INFO, "Customer uploads relevant documents and submits the case and Case number is genarated");
				logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and "+Service_Casenumber);
				
				ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassI,Service_Casenumber.substring(20, 30), 1, 1);
			
				//logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.captureScrenshot(driver, ClassDScreenshotname)));
				System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
				//logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassD));	
				ut.ClickGotohome_btn();
				s_assert.assertAll();
				System.out.println("Test Run Compleed ");
		}		

}
