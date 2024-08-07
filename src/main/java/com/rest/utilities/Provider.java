package com.rest.utilities;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class Provider {
    @DataProvider(name="data")
    public static String[][] getData() throws IOException {
        String path=System.getProperty("user.dir")+"//excelData//user.xlsx";
        Utils excel=new Utils(path);
        int rowCount=excel.rowCount("Sheet1");
        int colCount=excel.cellCount("Sheet1",1);
        String[][] data = new String[rowCount][colCount];
        for(int i=1;i<=rowCount;i++){
            for(int j=0;j<colCount;j++){
                data[i-1][j]=excel.cellData("Sheet1",i,j);
            }
        }
        return data;
    }
    @DataProvider(name="user")
    public static String[] singleRow() throws IOException {
        String path=System.getProperty("user.dir")+"//excelData//user.xlsx";
        Utils excel=new Utils(path);
        int rowCount=excel.rowCount("Sheet1");
        String[] data=new String[rowCount];
        for (int i=1;i<=rowCount;i++){
            data[i-1]=excel.cellData("sheet1",i,1);
        }
        return data;
    }
}
