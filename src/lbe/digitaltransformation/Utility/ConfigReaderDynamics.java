package lbe.digitaltransformation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReaderDynamics {

	Properties Dynprop;
	
	public ConfigReaderDynamics() {

		try {
			File src = new File("./src/lbe/digitaltransformation/Myaccount/Test/resources/Config.property");
			FileInputStream fis = new FileInputStream(src);
			Dynprop = new Properties();
			Dynprop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBrowsername() {
		String browsername=Dynprop.getProperty("browsername");
		return browsername;
	}

	public String getDriverPath() {
		String path = Dynprop.getProperty("driver_path");
		
		return path;
	}

	public String getDriverValue() {
		String value = Dynprop.getProperty("driver_value");
		
		return value;
	}

	public String getURL() {
		return Dynprop.getProperty("MLdevDYN_url");
		
	}
	
	public String username() {
		return Dynprop.getProperty("Username_txt");
	}
	
	public String Password() {
		return Dynprop.getProperty("password_txt");
	}
	
	public String NEXTbutton() {
		return Dynprop.getProperty("Next_btn");
	}
	public String SignInbutton() {
		return Dynprop.getProperty("SignIn_btn");
	}
	public String NO_button() {
		return Dynprop.getProperty("NO_btn");
	}
	public String Search_LBE_Application() {
		return Dynprop.getProperty("searchLBE_APP");
	}
	public String searchLBE_APPFrame() {
		return Dynprop.getProperty("searchLBE_APPFram");
	}
	public String Click_LBE_Application() {
		return Dynprop.getProperty("LBE_APP");
	}
	
	//------------------------------------Homepage------------------------------------------------------------------------------
	
	public String ClickCasetab() {
		return Dynprop.getProperty("Case_tab");
	}
	
	
	//-------------------------------------Case list page------------------------------------------------------------
	
	public String Search_dynitem() {
		return Dynprop.getProperty("Search_box");
	}
	public String Click_Search_icon() {
		return Dynprop.getProperty("Search_icon");
	}
	public String doubleClick_CaserefNo() {
		return Dynprop.getProperty("CaseList_refNo");
	}
	
}
