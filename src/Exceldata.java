import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//How to read excel files using Apache POI
public class Exceldata{	

	public String geturl() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\AAACTV\\Onboad_data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String v = cell.getStringCellValue().toString();	
		return v;

	}


	public String getusername() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\AAACTV\\Onboad_data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String v = cell.getStringCellValue().toString();	
		return v;

	}
	public String getpassword() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\AAACTV\\Onboad_data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		String v = cell.getStringCellValue().toString();	
		return v;

	}
	public String ProposalType() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\AAACTV\\Onboad_data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(3);
		String v = cell.getStringCellValue().toString();	
		return v;

	}

	public void cc() throws IOException{
		// TODO Auto-generated method stub
		File src=new File("C:\\AAACTV\\Onboad_data.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet shit=wb.getSheetAt(0);
		XSSFRow row=shit.getRow(2);
		XSSFCell cell=row.getCell(2);
		cell.setCellValue("hurrah");
		FileOutputStream fos=new FileOutputStream(src);
		wb.write(fos);
	}
}

