package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil 
{
	public String  getDataFromExcel(String Sheetname,int Rownum,int Colnum) throws EncryptedDocumentException, IOException
	{
		//Step 1 : Create the object of FileInputStream class & in FileInputStream constructor enter the location of external file.
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Organization.xlsx");
		
		//Step 2 : Call a class from Apache POI family WorkBookFactory & call method create(InputStream).
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3 : Call getSheet(String name) & enter sheet name.To get the control of the sheet.
		Sheet sh=wb.getSheet(Sheetname);
		
		//Step 4 : Call getRow(int rowum) & enter the row number.
		Row rw=sh.getRow(Rownum);
				
		//Step 5 : Call getCell(int column) & enter the column number.
		Cell cl=rw.getCell(Colnum);
				
		//Step 6 : Call getStringCellValue()
		String value = cl.getStringCellValue();
		return value;
	}
}


