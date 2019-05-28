package com.hAIbooks.qa.ExcelReader;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	XSSFWorkbook wb;
	XSSFSheet Mysheet;
	XSSFRow row;
	XSSFCell cell;
	XSSFSheet sh=null;
	
	public ExcelReader(String ExcelPath)
	{
		try
		{
			File src = new File(ExcelPath);
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	}
	public int getRowCount(int SheetIndex)
	{
		int row=wb.getSheetAt(SheetIndex).getLastRowNum();
		row=row+1;
		return row;	
	}
	
	public int GetColumnCount(int SheetIndex)
	{
		Mysheet=wb.getSheetAt(SheetIndex);
		row = Mysheet.getRow(0);
		int colCount=row.getLastCellNum();
		return colCount;
		
	}
	
	public String getCellData(int SheetIndex, int colNum, int rowNum)
	{
		
		
		sh = wb.getSheetAt(SheetIndex);
		row=sh.getRow(rowNum);
		cell=row.getCell(colNum);
		
		if(cell.getCellType()==CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			return String.valueOf(cell.getNumericCellValue());
			
		}
		else if(cell.getCellType()==CellType.BOOLEAN)
		{
			return String.valueOf(cell.getBooleanCellValue());
			
		}
		
		else
		{
			return "";
		}		
	}
	
	public String getCellData(int SheetIndex, int RowNum, String ColName)
	{
		int ColNum=-1;
		sh=wb.getSheetAt(SheetIndex);
		row= sh.getRow(0);
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(ColName.trim()))
			{
				ColNum=i;
			}
		}
		
		row=sh.getRow(RowNum);
		
		cell=row.getCell(ColNum);
		
		if(cell.getCellType()==CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			return String.valueOf(cell.getNumericCellValue());
			
		}
		else if(cell.getCellType()==CellType.BOOLEAN)
		{
			return String.valueOf(cell.getBooleanCellValue());
			
		}
		
		else
		{
			return "";
		}		
		
	}

}
