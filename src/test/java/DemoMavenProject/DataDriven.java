package DemoMavenProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testCaseName) throws IOException {
		ArrayList<String> al = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("D:/DDDData/DemoData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int sheets = wb.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase("testData")) {
				XSSFSheet sh = wb.getSheetAt(i);
				// Identifying TestCase Column by Scanning the entire 1St Row
				Iterator<Row> rows = sh.iterator();// sheet is collection of Row
				Row firstRow = rows.next();
				Iterator<Cell> cel = firstRow.cellIterator();// Cell is a
																// collection of
																// Cells
				int k = 0;
				int colNum = 0;
				while (cel.hasNext()) {
					Cell value = cel.next();
					if (value.getStringCellValue()
							.equalsIgnoreCase("TestCases")) {
						colNum = k;
					}
					k++;
				}
				System.out.println(colNum);

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(colNum).getStringCellValue()
							.equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {

							Cell c = cv.next();

							if (c.getCellTypeEnum() == CellType.STRING) {
								al.add(c.getStringCellValue());
							} else {
								al.add(NumberToTextConverter.toText(c
										.getNumericCellValue()));

							}
						}
					}

				}

			}
		}

		return al;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}

}
