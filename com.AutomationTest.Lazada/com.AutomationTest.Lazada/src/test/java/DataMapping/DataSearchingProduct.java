package DataMapping;

import java.io.IOException;

import CustomizedLibs.ExcelUtility;

/**
 * This class is used for mapping data in the excel file data for testing and the sheet name is "DATASEARCHPRODUCT" 
 * @author Administrator
 *
 */
public class DataSearchingProduct {
	ExcelUtility execelObj;
	final static String SHEETNAME="DATASEARCHPRODUCT";
	
	public DataSearchingProduct(String fileName) throws IOException{
		execelObj=new ExcelUtility(fileName, SHEETNAME);
	}
	
	public String getTextSearch(){
		return execelObj.getValueAt(1, 1);
	}
	
	
	public String getTotalProductsFound(){
		String value= execelObj.getValueAt(2, 1);
		return value.substring(0,value.indexOf("."));
	}
	
}
