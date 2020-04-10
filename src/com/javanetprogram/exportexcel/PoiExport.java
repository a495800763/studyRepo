package com.javanetprogram.exportexcel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.crypto.spec.OAEPParameterSpec;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: JavaNetProgram
 * @author: liumq
 * @create: 2020-04-10 13:16
 **/


public class PoiExport {


    private static final String PATH = "D:\\电子书";


    public static void main(String[] args) {
        try {
            PoiExport poiExport = new PoiExport();
            poiExport.exportToExcel();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private static List<String> getFile(String path) {
        List<String> nameList = new ArrayList<>();
        // get file list where the path has
        File file = new File(path);
        // get the folder list
        File[] array = file.listFiles();

        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                String name = array[i].getName();
                String[] nameArray = name.split("\\.");
                if (nameArray[1].equals("pdf")) {
                    nameList.add(name);
                }
            } else if (array[i].isDirectory()) {
                nameList.addAll(getFile(array[i].getPath()));
            }
        }

        return nameList;
    }


    public void exportToExcel () throws IOException {
        List<String> bookNameList =getFile(PATH);

        HSSFWorkbook workbook=new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("书单");
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("书名");
        titleRow.createCell(1).setCellValue("单价");

        for(int i =0;i<bookNameList.size();i++)
        {
            HSSFRow currentRow = sheet.createRow(i + 1);
            currentRow.createCell(0).setCellValue(bookNameList.get(i));
        }

        FileOutputStream out = new FileOutputStream(PATH + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() +".xls");
        workbook.write(out);
        out.close();

    }


}
