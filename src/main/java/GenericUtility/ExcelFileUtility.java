package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import GenericUtility.ConstantUtility;

public class ExcelFileUtility {
	
	public String readDataFromExcelSheet(String sheet,int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise=new FileInputStream(ConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		String value = c.getStringCellValue();
		wb.close();
		return value;
	
	}
	
	/**
	 * This method helps to get the last row count value
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise=new FileInputStream(ConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet(sheet);
		int lastrow = sh.getLastRowNum();
		return lastrow;
		
	}

	/**
	 * This method will helps to write the data into excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataintoExcelSheet(String sheet, int row, int cell, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise=new FileInputStream(ConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(ConstantUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
		
	}

/**
 * This method is used to execute a test script with multiple set of data.
 * Hence it will return 2 dimensional object[][]. so that it directly used to data provider.
 * @param sheetname
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public Object[][] readMUltipleDataFromExcelSheet(String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fise=new FileInputStream(ConstantUtility.ExcelFilePath);
	Workbook wb = WorkbookFactory.create(fise);
	Sheet sh = wb.getSheet(sheetname);
	int lastrow = sh.getLastRowNum();
	int lastcell = sh.getRow(0).getLastCellNum();
	
	Object[][] data=new Object[lastrow][lastcell];
	for(int i=0;i<lastrow;i++)
	{
		for(int j=0;j<lastcell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
		
	}
	return data;
}

}
