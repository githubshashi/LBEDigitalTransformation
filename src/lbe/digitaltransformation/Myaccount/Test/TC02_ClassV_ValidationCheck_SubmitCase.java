package lbe.digitaltransformation.Myaccount.Test;



	import java.util.concurrent.TimeUnit;

	
	import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

	import lbe.digitaltransformation.Utility.BrowserFactory;
	import lbe.digitaltransformation.Utility.ExcelReadWrite;
	import lbe.digitaltransformation.Utility.Utility;

	public class TC02_ClassV_ValidationCheck_SubmitCase extends BaseTest
	{
					
			BrowserFactory bf;
		
			String Support_Info_Declaration_heading= "Supporting information and declaration"; //Council tax Declaration Page heading text
			String ServiceSummary_heading= "Service summary"; 						//Council tax Service summary Page heading text
			String Screenshotname="ClassVConfirmationScreen";  							//Screen shot name.
			String ExpectedPage6heading= "Please complete details of the person you wish to act on behalf of.";  //Common delegation
			String Delegation_heading="Please complete details of the person you wish to act on behalf of.";  //Common delegation	
			String AccountNumber_heading= "Account number"; 						//Council tax Account number Page heading text
			String AccountDetails_heading= "Account details"; 						//Council tax Account Details Page heading text
			String AppDetails_heading= "Application details"; 					//Council tax Application details Page heading text
			
			
			public static final String Sh_ClassV="ClassV";
			
			SoftAssert s_assert= new SoftAssert();
						
			@Test (groups = {"Apply_for_self"})
			public void ApplyForSelf() throws Exception 
			{		
				TestCasePass="Submited  Class V Service";	
				TestCaseFail=" User Failed to Submit case for Class V Service link (OR) Click Functionality is not working,'Some thing went wrong' Please Check the Code";	
				TestCaseSkip="Submit testcase foe Class V Service link is skipped";
				String Casenumber=null;			
				int i=0;  // for Apply for yourself make i=0		
				hp.Clickonwhatservicebutton();
				hp.ClickonCounciltax();
				ct.ClickonclassVlink();
				ut.Verify_SubService_titlepage();
				ut.select_self_onbehalf(i);			
				
				ut.Click_StartForm();    //Description Page Next Button				
								
				s_assert.assertEquals(AccountNumber_heading, ut.Page_heading());
				ut.tickboxCouncilTaxAccNo();
				ut.NEXT_2();                         //Account Number page next button	
				
				s_assert.assertEquals(AccountDetails_heading, ut.Page_heading());
				
				ut.MandatoryFieldCheck();				
				ut.Postcode_SelectAddress(Sh_ClassV,1,2,3);	   // Parameter are Sheetname, excel filename & path, Row, Colunm1, Colunm2-Dropdown index value (Actual address)  			
				cv.FirstNameofdiplomat(Sh_ClassV,1,4);			
				cv.LastNameofdiplomat(Sh_ClassV,1,5);			
				ut.telphonenumber();
				ut.NEXT_2();     
				
				//Application  details page			
				ut.MandatoryFieldCheck();				
				cv.Residence_UnitedKingdom1(1);//Is the property your main residence within the United Kingdom				
				cv.tenancy_agreement1(1);   //cd.Do you have a tenancy agreement forall of the property(); 			                    
				cv.UK_diplomat(Sh_ClassV,1,8);   //On what date did the property become the main residence in the UK of the diplomat					
				cv.Diplomatic_rank(Sh_ClassV,1,9);   //Diplomatic rank, status or position			
				cv.Countryinternational_organisation(Sh_ClassV,1,10);     //Country or international organisation conferring diplomatic rank, status or position	
				cv.British_citizen1(1);      //Is the diplomat any type of British subject or British citizen	
				cv.UK_resident1(1);       //Is the diplomat a permanent UK resident			
				ut.NEXT_2();            //Application Details page next button			
				
				ut.Uploadedocument();
				ut.NEXT_2();            //File Upload page		
			
				s_assert.assertEquals(Support_Info_Declaration_heading, ut.Declarationheading());	
				ut.Select_summons();
				ut.ClickCheckBox();
				ut.ClickSubmit_btn();
				
				s_assert.assertEquals(ServiceSummary_heading, ut.Servicesummaryheading());
				String Service_Casenumber=ut.Casenumber(Casenumber);
				String AddScreenClassV=ut.captureScrenshot(Screenshotname);	
				logger.log(LogStatus.INFO, "Customer uploads relevant documents and submits the case and Case number is genarated");
				logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and "+Service_Casenumber);
				
				ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassV,Service_Casenumber.substring(20, 30), 1, 1);
				
				//logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.captureScrenshot(driver, ClassVScreenshotname)));
				System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
				
			//	logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassV));		
				ut.ClickGotohome_btn();
				s_assert.assertAll();
				System.out.println("Test Run Compleed ");
			}	

			//Delegation
			
			@Test (groups = {"Onbehalf_of_SomeOneElse"})
			public void Apply_onbehalfof_some_one_else() throws Exception 
			{		
				TestCasePass="Customer Selected Onbehalf of Some one else and Submitted case successfully";
				TestCaseFail="Customer is unable to Submit a case for Onbehalf of Some one else, 'Some thing went wrong' Please Check the Code";	
				TestCaseSkip="Test Case is Skipped for 'Submit a case for Onbehalf of Some one else' "; 
				String Casenumber=null;
				int i=1;  // for Apply for yourself make i=0
				int j=2; //If 1 selects "This time only" option if 2 Selects "Indefinitely (until you advise us otherwise)"
					
					hp.Clickonwhatservicebutton();
					hp.ClickonCounciltax();
					ct.ClickonclassVlink();
					ut.Verify_SubService_titlepage();
					ut.select_self_onbehalf(i);
					if(j==1)
					{
						ut.select_Authority_act(j);
						ut.Click_StartForm();
					
						s_assert.assertEquals(ut.Delegationheading(), Delegation_heading);
						ut.FirstNamedelegationTextbox(Sh_ClassV,1,12);
						ut.LastNamedelegationTextbox(Sh_ClassV,1,13);
						ut.AddressdelegationTextbox(Sh_ClassV,1,14,4);              // Parameter are Sheetname, excel filename & path, Row, Colunm, Dropdown index value (Actual address)  
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
						ut.FirstNamedelegationTextbox(Sh_ClassV,1,12);
						ut.LastNamedelegationTextbox(Sh_ClassV,1,13);
						ut.AddressdelegationTextbox(Sh_ClassV,1,14,4);          // Parameter are Sheetname, excel filename & path, Row, Colunm, Dropdown index value (Actual address)  
						ut.NEXT_2();
						logger.log(LogStatus.INFO, "Customer selected OnBehalf of Some one else (Athourity to act : Indefinitly [until you advise us]) ");
						logger.log(LogStatus.INFO, "Customer Added New delegation");
					}
						
					//Account details page			
					s_assert.assertEquals(AccountDetails_heading, ut.Page_heading());						
					ut.MandatoryFieldCheck();
					cv.telphonenumber();
					s_assert.assertEquals(ExcelReadWrite.getCellData(Utility.excelfilepath,Sh_ClassV,1,12), "Mark");  //Checking validation for pre-populated data
					s_assert.assertEquals(ExcelReadWrite.getCellData(Utility.excelfilepath,Sh_ClassV,1,13), "Seena");  //Checking validation for pre-populated data
					s_assert.assertEquals(ExcelReadWrite.getCellData(Utility.excelfilepath,Sh_ClassV,1,6), "shashi@dispostable.com");  //Checking validation for pre-populated data
										
					ut.NEXT_2(); 					
					
					s_assert.assertEquals(AppDetails_heading, ut.Page_heading());
					ut.MandatoryFieldCheck();
					cv.Residence_UnitedKingdom1(1);//Is the property your main residence within the United Kingdom				
					cv.tenancy_agreement1(1);   //cd.Do you have a tenancy agreement forall of the property(); 			                    
					cv.UK_diplomat(Sh_ClassV,1,8);   //On what date did the property become the main residence in the UK of the diplomat					
					cv.Diplomatic_rank(Sh_ClassV,1,9);   //Diplomatic rank, status or position			
					cv.Countryinternational_organisation(Sh_ClassV,1,10);     //Country or international organisation conferring diplomatic rank, status or position	
					cv.British_citizen1(1);      //Is the diplomat any type of British subject or British citizen	
					cv.UK_resident1(1);       //Is the diplomat a permanent UK resident			
					ut.NEXT_2();            //Application Details page next button			
					
					ut.Uploadedocument();
					ut.NEXT_2();            //File Upload page	
								
					
					s_assert.assertEquals(Support_Info_Declaration_heading, ut.Declarationheading());	
					ut.Select_summons();
					ut.ClickCheckBox();
					ut.ClickSubmit_btn();
					
					s_assert.assertEquals(ServiceSummary_heading, ut.Servicesummaryheading());
					String Service_Casenumber=ut.Casenumber(Casenumber);
					String AddScreenClassV=ut.captureScrenshot(Screenshotname);	
					logger.log(LogStatus.INFO, "Customer uploads relevant documents and submits the case and Case number is genarated");
					logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and "+Service_Casenumber);
					
					ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassV,Service_Casenumber.substring(20, 30), 1, 1);	
					//logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.captureScrenshot(driver, ClassVScreenshotname)));
					System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));				
					//logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassV));
					
					ut.ClickGotohome_btn();
					s_assert.assertAll();
					System.out.println("Test Run Compleed ");
				} 
						
}
