package com.xfactor.generics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;


/**
 * 
 * @author manas.gupta
 *
 */
public class FileUtils {
	private FileInputStream fis;
	private Properties p;

	public String getCommonInfo(String key) throws IOException {
		fis = new FileInputStream("./testdata/common_info.properties");
		p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}

	public String getPropertiesFileData(String path , String key) throws IOException
	{
		fis = new FileInputStream(path);
		p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
	public String getExcelData(String SheetName, int rowNum, int cellNum, String filePath)
			throws EncryptedDocumentException, IOException {
		String value = null;
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row rw = sh.getRow(rowNum);
		Cell cl = rw.getCell(cellNum);
		switch (cl.getCellType()) {
		case STRING:
			// STRING is Global Constant in CellType<Enum>(return type of
			// getCellType())
			value = cl.getStringCellValue();
			break;
		case BOOLEAN:
			value = Boolean.toString(cl.getBooleanCellValue());
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cl)) {
				Date dateValue = cl.getDateCellValue();
				String format = "YYYY-MM-dd";
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				value = sdf.format(dateValue);
			} else {
				long longValue = (long) cl.getNumericCellValue();
				value = Long.toString(longValue);
			}
			break;

		default:

			break;
		}
		wb.close();// closing the excel sheet because it get crashed if it is
					// open more times
		return value;
	}

	public File[] getListOfilesInDownloadDirectory() {
		String path = System.getProperty("user.dir") + File.separator + "resources";
		File file = new File(path);
		if (file.isDirectory()) {
			return file.listFiles();
		} else {
			throw new NotADirectoryException();
		}
	}

	public int getRowCount(String sheetName, String filePath) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowIndex = sh.getLastRowNum();
		fis.close();
		wb.close();
		return rowIndex;
	}

	public List<String> getRowHeaders(String sheetName, String filePath)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int physicalNoOfCells = sh.getRow(0).getPhysicalNumberOfCells();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < physicalNoOfCells; i++) {
			list.add(sh.getRow(0).getCell(i).getStringCellValue());

		}
		fis.close();
		wb.close();
		return list;
	}

	public void updateExcelData(String sheetName, int rowNum, int colNum, String filePath, String data)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row rw = sheet.getRow(rowNum);
		Cell cell = rw.getCell(colNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			cell = rw.createCell(colNum, CellType.STRING);
			cell.setCellValue(data);
		} else {
			cell.setCellValue(data);
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		fos.close();

	}
	
	public void createTextFile(String fileName,String path, String text) throws IOException
	{
		FileWriter out = new FileWriter("user.dir"+File.separator+"resources"+fileName+".txt");
		BufferedWriter bOut = new BufferedWriter(out);
		
		
	}
	

}
