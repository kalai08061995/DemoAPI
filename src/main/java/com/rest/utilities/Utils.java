package com.rest.utilities;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import com.rest.payload.UserPayload;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils{
    public FileInputStream fileRead;
    public FileOutputStream fileWrite;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    String path;
    public Utils(String path){
        this.path=path;
    }
    public static UserPayload userData=new UserPayload();
//    @BeforeClass
    public static UserPayload setupByFaker(){
        Faker fakeData=new Faker();
        userData.setId(fakeData.idNumber().hashCode());
        userData.setUsername(fakeData.name().username());
        userData.setFirstName(fakeData.name().firstName());
        userData.setLastName(fakeData.name().lastName());
        userData.setEmail(fakeData.internet().safeEmailAddress());
        userData.setPassword(fakeData.internet().password(8,10));
        userData.setPhone(fakeData.phoneNumber().cellPhone());
        return userData;
    }

    public int rowCount(String sheetName) throws IOException {
        fileRead=new FileInputStream(path);
        workbook=new XSSFWorkbook(fileRead);
        sheet=workbook.getSheet(sheetName);
        int row_count=sheet.getLastRowNum();
        workbook.close();
        fileRead.close();
        return row_count;
    }
    public int cellCount(String sheetName,int row_count) throws IOException {
        fileRead=new FileInputStream(path);
        workbook=new XSSFWorkbook(fileRead);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(row_count);
        int cell_count=row.getLastCellNum();
        workbook.close();
        fileRead.close();
        return cell_count;
    }
    public String cellData(String sheetName,int row_count,int column) throws IOException {
        fileRead=new FileInputStream(path);
        workbook=new XSSFWorkbook(fileRead);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(row_count);
        cell=row.getCell(column);
        DataFormatter format=new DataFormatter();
        String cellData;
        try {
            cellData = format.formatCellValue(cell);
        }
        catch (Exception e){
            cellData="";
        }
        workbook.close();
        fileRead.close();
        return cellData;
    }


}
