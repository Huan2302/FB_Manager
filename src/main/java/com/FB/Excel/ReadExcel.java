package com.FB.Excel;

import com.FB.Model.FBAccount;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcel {
    public static final int COLUMN_INDEX_STT = 0;
    public static final int COLUMN_INDEX_NAME = 1;
    public static final int COLUMN_INDEX_UID = 2;
    public static final int COLUMN_INDEX_GENDER = 3;
    public static final int COLUMN_INDEX_BIRTHDAY = 4;
    public static final int COLUMN_INDEX_EMAIL = 5;
    public static final int COLUMN_INDEX_SDT = 6;
    public static final int COLUMN_INDEX_LOCATION = 7;
//
//    public static void main(String[] args) throws IOException {
//        final String excelFilePath = "/Users/admin/Downloads/Book2.xlsx";
//        List<FBAccount> list = readExcel(excelFilePath);
//        for (FBAccount item:list){
//            System.out.println(item);
//        }
//    }

    public List<FBAccount> readExcel(String excelFilePath) throws IOException {
        List<FBAccount> list = new ArrayList<>();

//        get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

//        get workbook
        Workbook workbook = getWorkbook(inputStream,excelFilePath);

//        get sheet
        Sheet sheet = workbook.getSheetAt(0);

//        get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()){
            Row nextRow = iterator.next();
            if (nextRow.getRowNum()==0){
//                Bỏ qua tiêu đề
                continue;
            }

//            get all cells
            Iterator<Cell> cellIterator =   nextRow.cellIterator();

//            read cell and set value for facebook object
            FBAccount fbAccount = new FBAccount();
            while (cellIterator.hasNext()){
//                Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()){
                    continue;
                }
//                set value for facebook object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex){
                    case COLUMN_INDEX_STT:
                        fbAccount.setStt(new BigDecimal((Double) cellValue).intValue());
                        break;
                    case COLUMN_INDEX_NAME:
                        fbAccount.setName((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_UID:
                        fbAccount.setFacebook_id((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_GENDER:
                        fbAccount.setGender((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_BIRTHDAY:
                        fbAccount.setBirthday((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_EMAIL:
                        fbAccount.setEmail((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_SDT:
                        fbAccount.setPhone((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_LOCATION:
                        fbAccount.setLocation((String) getCellValue(cell));
                        break;
                    default:
                        break;
                }
            }
            if (fbAccount.getFacebook_id()!=null){
                list.add(fbAccount);
            }
        }
        workbook.close();
        inputStream.close();
        return list;
    }

    private static Workbook getWorkbook(InputStream inputStream,String excelFilePath) throws IOException {
        Workbook workbook = null;
        if(excelFilePath.endsWith("xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        }else if (excelFilePath.endsWith("xls")){
            workbook = new HSSFWorkbook(inputStream);
        }else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }

    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }

        return cellValue;
    }
}
