package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelWithApachiPOI {

    String path = "ExcelPracticeApachiPOI.xlsx";
    XSSFWorkbook wb;
    XSSFSheet sheet;

    @Test
    public void excel_write() throws IOException {
        FileInputStream fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("Employees");

        //Now we add some stuff
        XSSFCell salaryCell = sheet.getRow(0).createCell(3); // 3.sutuna bir yer actik
        salaryCell.setCellValue("Salary");//Degeri verdik baslik olarak

        //diger yerleri de teker teker veririz.
        XSSFCell salary1 = sheet.getRow(1).createCell(3); //
        salary1.setCellValue(110000);

        XSSFCell salary2 = sheet.getRow(2).createCell(3); //
        salary2.setCellValue(115000);

        XSSFCell salary3 = sheet.getRow(3).createCell(3); //
        salary3.setCellValue(116000);

        XSSFCell salary4 = sheet.getRow(4).createCell(3); //
        salary4.setCellValue(120000);

        // Herhangi bir islem yapilacaksa artik yine bu bolgede yapilmasi gerekir.

        // TODO: Change the Linda's lastname as Jones

        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){ //once Linda bulunur, sonra lastname hanesi degistirilir
                sheet.getRow(rowNum).getCell(1).setCellValue("Jones");

            }
        }



        //Islemler tamamlandiktan sonra kayit edip, dosyalari kapatmak gerekir.
        //FileInputStream -> reading
        //FileOutputStream -> writing

        FileOutputStream fos = new FileOutputStream(path);
        //save/write the changes into the wb
        wb.write(fos);
        //close stuff
        fos.close();
        wb.close();
        fis.close();

        //Tum islemler tamamlanmis oldu.
        //Dosyayi kontrol ediniz.
        // PASSED!

    }
}
