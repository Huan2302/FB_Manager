package com.FB.Excel;

import com.FB.Model.FBAccount;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class WriteExcel {
    public static final int COLUMN_INDEX_STT = 0;
    public static final int COLUMN_INDEX_NAME = 1;
    public static final int COLUMN_INDEX_UID = 2;
    public static final int COLUMN_INDEX_GENDER = 3;
    public static final int COLUMN_INDEX_BIRTHDAY = 4;
    public static final int COLUMN_INDEX_EMAIL = 5;
    public static final int COLUMN_INDEX_SDT = 6;
    public static final int COLUMN_INDEX_LOCATION = 7;
    private static CellStyle cellStyleFormatNumber = null;

    public void writeExcel(List<FBAccount> fbAccounts,String excelFilePath) throws IOException {
//        Create workbook
        Workbook workbook = getWorkBook(excelFilePath);

//        Create sheet
        Sheet sheet = workbook.createSheet("fbaccounts");

        int rowIndex = 0;

//        Write Header
        writeHeader(sheet,rowIndex);

//        Write Data
        rowIndex++;
        for (FBAccount fbAccount:fbAccounts){
//            Create row
            Row row = sheet.createRow(rowIndex);
//            Write data on row
            writeFB(fbAccount,row);
            rowIndex++;
        }

//        Auto size colum witdh
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet,numberOfColumn);

//        Create File Excel
        createOutputFile(workbook,excelFilePath);
        System.out.println("Dont!!!!");
    }

    private static Workbook getWorkBook(String excelFilePath){
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }

    private static void writeHeader(Sheet sheet,int rowIndex){
//        Create CellStyle

//        Create row
        Row row =sheet.createRow(rowIndex);

//        Create cell
        Cell cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellValue("STT");

        cell = row.createCell(COLUMN_INDEX_NAME);
        cell.setCellValue("Name");

        cell = row.createCell(COLUMN_INDEX_UID);
        cell.setCellValue("UID");

        cell = row.createCell(COLUMN_INDEX_GENDER);
        cell.setCellValue("Gender");

        cell = row.createCell(COLUMN_INDEX_BIRTHDAY);
        cell.setCellValue("Birthday");

        cell = row.createCell(COLUMN_INDEX_EMAIL);
        cell.setCellValue("Email");

        cell = row.createCell(COLUMN_INDEX_SDT);
        cell.setCellValue("SDT");

        cell = row.createCell(COLUMN_INDEX_LOCATION);
        cell.setCellValue("location");
    }

    private static void writeFB(FBAccount fbAccount,Row row){
        if (cellStyleFormatNumber == null){
//          Format number
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");

            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
        Cell cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellValue(fbAccount.getStt());

        cell = row.createCell(COLUMN_INDEX_NAME);
        cell.setCellValue(fbAccount.getName());

        cell = row.createCell(COLUMN_INDEX_UID);
        cell.setCellValue(fbAccount.getFacebook_id());

        cell = row.createCell(COLUMN_INDEX_GENDER);
        cell.setCellValue(fbAccount.getGender());

        cell = row.createCell(COLUMN_INDEX_BIRTHDAY);
        cell.setCellValue(fbAccount.getBirthday());

        cell = row.createCell(COLUMN_INDEX_EMAIL);
        cell.setCellValue(fbAccount.getEmail());

        cell = row.createCell(COLUMN_INDEX_SDT);
        cell.setCellValue(fbAccount.getPhone());

        cell = row.createCell(COLUMN_INDEX_LOCATION);
        cell.setCellValue(fbAccount.getLocation());
    }

    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    // Create output file
    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
}
