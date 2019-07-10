package Resources;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
    XSSFWorkbook wb;
    XSSFSheet sheet;
  
    public ExcelDataConfig(String excelpath)
    {
        try {
            File src=new File(excelpath);
            FileInputStream fis=new FileInputStream(src);
             wb=new XSSFWorkbook(fis);
        }

        catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public String getData(int sheetNumber,int row,int column)
    {
        DataFormatter formatter = new DataFormatter();

        sheet=wb.getSheetAt(sheetNumber);
        String data1 = formatter.formatCellValue(sheet.getRow(row).getCell(column));
        return data1;

    }
    public int getRowCount(int sheetIndex)
	{
		int row=wb.getSheetAt(sheetIndex).getLastRowNum();
		//row=row+1;
		return row;
	}


}
