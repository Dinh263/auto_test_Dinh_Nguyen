package CustomizedLibs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	public ExcelUtility(){
		
	}
	public ExcelUtility(String fileNameWithPath, String sheetName) throws IOException{
		File fileData=new File(fileNameWithPath);
		FileInputStream inputStr=new FileInputStream(fileData);
		wb=new XSSFWorkbook(inputStr);
		sheet=wb.getSheet(sheetName);
		
	}
	
	

    /**
     * This function is used for getting the value in the excel at the row index and the column index
     * @param row the index of row (the first row should be 0 not 1)
     * @param column the index of column (the first column should be 0 not 1)
     * @return the value at row index and column column which are provided. in case there is no value in the cell, then empty string value will return.
     */
	public String getValueAt(int rowNumber, int columnNumber){
		String value=" ";
		try{
		Row row=sheet.getRow(rowNumber);
		Cell cell=row.getCell(columnNumber);
		FormulaEvaluator evaluator=wb.getCreationHelper().createFormulaEvaluator();
		CellValue cellValue=evaluator.evaluate(cell);
		
		switch (cellValue.getCellType()){
			case Cell.CELL_TYPE_STRING:
				value=cellValue.getStringValue();
				break;
			case Cell.CELL_TYPE_BLANK:
				value=" ";
				break;
			case Cell.CELL_TYPE_NUMERIC:
				value=Double.toString(cellValue.getNumberValue());
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				value=Boolean.toString(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				break;
		}
			return value;
		}
		catch(Exception ex){
			return ex.getMessage();
		}
		
	}
	
	
	/**
     * This function is used for getting the total row in the sheet of file excel
     * @return the total row of a sheet in file excel
     */
	public int getTotalRows(){
		try{
			return sheet.getLastRowNum()-sheet.getFirstRowNum();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return -1;
		}
	}

}
