package com.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.base.TestBase;

/**
 * @author Vaishali.Chaudhari
 * @date 10 November 2019
 * @purpose Excel read write operations
 */

public class ExcelOperationsUtil extends TestBase {
	String TestDataExcelPath = prop.getProperty("testdata_path");

	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public ExcelOperationsUtil() {

		System.out.println("TestDataExcelPath:- " + TestDataExcelPath);
		try {
			fis = new FileInputStream(TestDataExcelPath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * This method find whether sheets exists
	 * </p>
	 * 
	 * @param sheetName - Provide the sheet Name.
	 * @return boolean value true if sheet is exist
	 **/
	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	/**
	 * <p>
	 * This method returns number of columns in a sheet
	 * </p>
	 * 
	 * @param sheetName - Provide the sheet Name.
	 * @return number of columns in a sheet
	 **/

	public int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}

	/**
	 * <p>
	 * This method returns row number
	 * </p>
	 * 
	 * @param sheetName  - Provide the sheet Name.
	 * @param ColumnName - Provide the Column Name.
	 * @param CellValue  - Provide the Cell Value.
	 * @return row number
	 **/

	public int getRowNumber(String sheetName, String ColumnName, String CellValue) {
		
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(0);
		int col_Num = -1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(ColumnName.trim()))
			{
				col_Num = i;
			}
			
		}

		// to find row number so we can search through that specific column
		int gotRow = 0;
		for (int j = 0; j < getRowCount(sheetName); j++){
			String valueCell = getCellData(sheetName,col_Num,j);
			
			if (valueCell.trim().equalsIgnoreCase(CellValue)) {
				gotRow = j;
			}
			
		}
		return gotRow;

	}

	/**
	 * <p>
	 * This method get row count from sheet in the excel
	 * </p>
	 * 
	 * @param sheetName - Provide the sheet Name.
	 * @return the row count in a sheet
	 **/
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}
	}

	/**
	 * <p>
	 * This method get Cell Data from sheet in the excel as per column number, row
	 * number
	 * </p>
	 * 
	 * @param sheetName - Provide the sheet Name.
	 * @param colNum    - Provide the column Number.
	 * @param rowNum    - Provide row number.
	 * @param data      - data to set in the cell
	 * @return the data from a cell Values for Celltype are: _NONE(-1), NUMERIC(0),
	 *         STRING(1), FORMULA(2), BLANK(3), BOOLEAN(4), ERROR(5);
	 **/

	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == 1)
				return cell.getStringCellValue();
			else if (cell.getCellType() == 0 || cell.getCellType() == 2) {

				String cellText = String.valueOf((int) cell.getNumericCellValue());

				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();
					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
				}
				return cellText;
			} else if (cell.getCellType() == 3)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}

	/**
	 * <p>
	 * This method get Cell Data from sheet in the excel as per column name, row
	 * number
	 * </p>
	 * 
	 * @param sheetName - Provide the sheet Name.
	 * @param colName   - Provide the column Name.
	 * @param rowNum    - Provide row number.
	 * @param data      - data to set in the cell
	 * @return the data from a cell
	 **/

	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(col_Num);

			if (cell == null)
				return "";
			// System.out.println(cell.getCellType());
			if (cell.getCellType() == 1)
				return cell.getStringCellValue();
			else if (cell.getCellType() == 0 || cell.getCellType() == 2) {

				String cellText = String.valueOf((int) cell.getNumericCellValue());

				// System.out.println(HSSFDateUtil.isCellDateFormatted(cell));
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
				}
				return cellText;
			} else if (cell.getCellType() == 3)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	/**
	 * <p>
	 * This method set Cell Data from sheet in the excel as per column name, row
	 * number
	 * </p>
	 * 
	 * @param sheetName - Provide the sheet Name.
	 * @param colName   - Provide the column Name.
	 * @param rowNum    - Provide row number.
	 * @param data      - data to set in the cell
	 * @return boolean value true if data is set successfully else false
	 **/
	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(TestDataExcelPath);
			workbook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			// cell style
			// CellStyle cs = workbook.createCellStyle();
			// cs.setWrapText(true);
			// cell.setCellStyle(cs);
			cell.setCellValue(data);

			fileOut = new FileOutputStream(TestDataExcelPath);

			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
