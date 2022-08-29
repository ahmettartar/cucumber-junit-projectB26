package com.cydeo.tests;

import com.cydeo.pages.VyTrackDashboardPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;

public class VyTrackLoginDDTTest {

    VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
    VyTrackDashboardPage vyTrackDashboardPage = new VyTrackDashboardPage();

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }



    @Test
    public void loginDDTTest() throws IOException {
        String path = "VyTrackApachiPOI.xlsx";
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("data");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            //once biri icin bilgileri alalim
            String userName = sheet.getRow(i).getCell(0).toString(); //username
            String password = sheet.getRow(i).getCell(1).toString();
            String firstName = sheet.getRow(i).getCell(2).toString();
            String lastName = sheet.getRow(i).getCell(3).toString();

            //sonra bu kisi login yapsin
            vyTrackLoginPage.login(userName, password);

            //Arada login bar icin wait kullanalim.
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
            //wait.until(ExpectedConditions.visibilityOf(vyTrackDashboardPage.fullName));
            WebElement loadMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loadMask));

            String actualFullname = vyTrackDashboardPage.fullName.getText();
            XSSFCell resultCell = sheet.getRow(i).getCell(4);
            if(actualFullname.contains(firstName) && actualFullname.contains(lastName)){
                System.out.println("PASS");
                resultCell.setCellValue("PASS");//Bu sonucu excele de yaziyoruz
            }else {
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");
            }

            vyTrackDashboardPage.logout();//isimiz bitince logout yapiyoruz.

        } //For loop sonu

        //Sonuclari excele yazdiralim
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);

        fis.close();
        fos.close();
        wb.close();
    }
}
