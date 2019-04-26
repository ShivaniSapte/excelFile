package excelPrograms;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FB_Excel_Read {
	public static XSSFWorkbook excelWb;
	public static XSSFSheet excelSh;
	public static XSSFCell excelCell;
	public static XSSFRow excelRow;
	
	public FB_Excel_Read(String Path,String SheetName) throws Exception
	{
		FileInputStream fis=new FileInputStream(Path);
		excelWb= new XSSFWorkbook(fis);
		excelSh = excelWb.getSheet(SheetName);
	}
	public String getCellData(int rowNum,int colNum)
	{
		excelCell=excelSh.getRow(rowNum).getCell(colNum);
		String cellData= excelCell.getStringCellValue();
		return cellData;
	}


}
