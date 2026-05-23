package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

    private static final String RESULT_FILE_PATH = "C:\\Users\\2389209\\Downloads\\StudentsInsuranceAutomation\\StudentsInsuranceAutomation\\TestResult\\Result data.xlsx";
//    private static final String DATA_FILE_PATH = "C:\\path\\to\\Insurance_data.xlsx";

    // Method to write data to an Excel file
    public static void writeData(String data, int r, int c) throws IOException {
        try (FileInputStream fileIn = new FileInputStream(RESULT_FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fileIn);
             FileOutputStream fileOut = new FileOutputStream(RESULT_FILE_PATH)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            if (sheet == null) {
                sheet = workbook.createSheet("Sheet1");
            }

            XSSFRow row = sheet.getRow(r);
            if (row == null) {
                row = sheet.createRow(r);
            }

            row.createCell(c).setCellValue(data);
            workbook.write(fileOut);
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    }
	
	public static String searchtext(int r,int c) throws IOException
    {	
		DataFormatter format= new DataFormatter();
		FileInputStream file= new FileInputStream("C:\\Users\\2389209\\Downloads\\StudentsInsuranceAutomation\\StudentsInsuranceAutomation\\Data\\Insurance_data.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(r);
		String cell= format.formatCellValue(row.getCell(c));
		workbook.close();
		return cell;
    }

}
