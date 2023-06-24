package com.example.demo.helper;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ProductEntity;


public class MyExcelHelper {
	
	//check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }
    //convert excel to list of products

    public static List<ProductEntity> convertExcelToListOfProduct(InputStream is) {
        List<ProductEntity> list = new ArrayList<>();

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("product_info");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                ProductEntity p = new ProductEntity();

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                  
                    switch (cid) {
                    
                    case 1:
                    	 p.setProduct_name(cell.getStringCellValue());
                       
                        break;
                    case 2:
                    	
                        p.setInvoice_no((long)cell.getNumericCellValue());
                        break;
                    case 3:
                        p.setQuantity((long)cell.getNumericCellValue());
                        break;
                    case 4:
                        p.setRate((long)cell.getNumericCellValue());
                        break;
                    case 5:
                        p.setTotal((long)cell.getNumericCellValue());
                        break;
                    case 6:
                    	 p.setProduct_pre(cell.getStringCellValue());
                        break;
                    default:
                        break;
                    }
                    cid++;

                }

                list.add(p);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

}
