package testNG_Data_Provider;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	public static XSSFWorkbook excelWb;
	public XSSFSheet excelSh;
	public static XSSFCell excelCell;
	public static XSSFRow excelRow;

	public TestUtil(String Path,String SheetName) throws Exception
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

		/**Object[][] data=new Object[excelSh.getLastRowNum()][excelSh.getRow(0).getLastCellNum()];
		for(int i=0;i < excelSh.getLastRowNum();i++){
			for(int j=0; j<excelSh.getRow(0).getLastCellNum();j++){
				data[i][j] =excelSh.getRow(i+1).getCell(j).toString();
			}
		}
		return data;**/
	}



