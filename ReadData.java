package week5.day1;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static String[][] readData(String fileName) throws IOException {
		// TODO Auto-generated method stub
				XSSFWorkbook wb=new XSSFWorkbook("./data/"+ fileName +".xlsx");
				//get into sheet
				XSSFSheet ws = wb.getSheetAt(0);
				
				//get no.of rows(exclude header)
				int rowcount=ws.getLastRowNum();
				//get row count with header
				int totalrow = ws.getPhysicalNumberOfRows();
				
				//get no. of cells
				int cellcount = ws.getRow(0).getLastCellNum();
				
				String[][] data=new String[rowcount][cellcount];
				
				for(int i=1;i<=rowcount;i++) {
					XSSFRow row=ws.getRow(i);
					for(int j=0;j<cellcount;j++) {
						XSSFCell cell=row.getCell(j);
						String cellValue = cell.getStringCellValue();
						data[i-1][j]=cellValue;
					}
				}
				
				//close the workbook
				wb.close();
				return data;

	}

}