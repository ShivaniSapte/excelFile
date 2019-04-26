package Paytm_POM;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow rw;
	public static XSSFCell cl;
	
	public ExcelRead(String path,String sheetName) throws Exception 
	{
		FileInputStream fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(sheetName);
	}
	public String readData(int rownum,int colnum)
	{
		cl=sh.getRow(rownum).getCell(colnum);
		String data=cl.getStringCellValue();
		return data;
		
	}
	public double readNum(int rownum,int colnum)
	{
		cl=sh.getRow(rownum).getCell(colnum);
		double data=cl.getNumericCellValue();
		return data;
		
	}

}
