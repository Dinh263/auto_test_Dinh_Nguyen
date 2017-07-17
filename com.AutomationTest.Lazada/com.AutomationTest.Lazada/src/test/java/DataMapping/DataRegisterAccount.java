package DataMapping;

import java.io.IOException;

import CustomizedLibs.ExcelUtility;

/**
 * This class is used for mapping data in the excel file data for testing and the sheet name is "DATAREGISTERACCOUNT" 
 * @author Administrator
 *
 */

public class DataRegisterAccount {
	ExcelUtility execelObj;
	final static String SHEETNAME="DATAREGISTERACCOUNT";
	
	public DataRegisterAccount(String fileName) throws IOException{
		execelObj=new ExcelUtility(fileName, SHEETNAME);
	}
	
	public String getRegisterType(){
		return execelObj.getValueAt(1, 1);
	}
	
	public String getGender(){
		String value=execelObj.getValueAt(2, 1);
		if(value==null){
			value=" ";
		}
		return value;
	}
	
	public String getEmail(){
		return execelObj.getValueAt(3, 1);
	}
	
	public String getName(){
		return execelObj.getValueAt(4, 1);
	}
	
	public String getDayOfBirth(){
		String value=execelObj.getValueAt(5, 1);
		if(value!=" " && value != null){
			value=value.substring(0,value.indexOf('.'));
			if(value.length()==1){
				value="0"+value;
			}
		}
		else if (value ==null){
			value=" ";
		}
		
		return value;
	
	}
	
	public String getMonthOfBirth(){
		String value = execelObj.getValueAt(6, 1);
		if(value!=" " && value!=null){
			value=value.substring(0,value.indexOf('.'));
		}
		else if(value==null){
			value=" ";
		}
		
		return value;
	}
	
	public String getYearOfBirth(){
		String value= execelObj.getValueAt(7, 1);
		if(value!=" " && value!=null){
			value=value.substring(0,value.indexOf('.'));
		}
		else if(value==null){
			value=" ";
		}
		return value;
	}
	
	public String getPassword(){
		return execelObj.getValueAt(8, 1);
	}
	
	public String getSubscriber(){
		return execelObj.getValueAt(9, 1);
	}
	
}
