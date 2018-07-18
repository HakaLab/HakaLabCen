package cl.cencosud.publicsite.automation.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import cl.cencosud.publicsite.automation.constants.Constants;

public class ManagementMicrosoftService {
	static String excelFilePath;
	
	public static void createNewFileExcel() throws Exception {
	    Workbook libro = new HSSFWorkbook();
	    Calendar calendario = new GregorianCalendar();
	    Integer hora =calendario.get(Calendar.HOUR_OF_DAY);
	    Integer minutos = calendario.get(Calendar.MINUTE);
	    excelFilePath = Constants.excelPath+Constants.nombreReportExcell+"_"+hora+"-"+minutos+".xls";
	    FileOutputStream archivo = new FileOutputStream(excelFilePath);
	    libro.write(archivo);
	    libro.close();
	    archivo.close();
	  }
	
	public static void deleteLastRow(String nombreHoja) throws Exception {
		 FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         Workbook libro = WorkbookFactory.create(inputStream);
         Sheet hoja = libro.getSheet(nombreHoja);    
         Row row = hoja.getRow(hoja.getLastRowNum());
         hoja.removeRow(row);
         inputStream.close();
         FileOutputStream outputStream = new FileOutputStream(excelFilePath);
         libro.write(outputStream);
         libro.close();
         outputStream.close();
	}
	
	public static void WriteSheetExcel(String nombreHoja,List<String> datos) throws Exception{
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook libro = WorkbookFactory.create(inputStream);
//            Sheet hoja = workbook.getSheetAt(0);
            Sheet hoja = libro.getSheet(nombreHoja);    
            Cell celda;
            int rowCount = hoja.getLastRowNum();
            Row fila = hoja.createRow(++rowCount);
            for (int i = 0; i < datos.size(); i++) {
            	celda = fila.createCell(i);
            	celda.setCellValue(datos.get(i).toString());
            	hoja.autoSizeColumn(i);
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            libro.write(outputStream);
            libro.close();
            outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public static void createNewSheet(String nombreHoja) throws Exception{
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook libro = WorkbookFactory.create(inputStream);
		Sheet hoja = libro.createSheet(nombreHoja);
		Cell celda;
        Row filaCabecera = hoja.createRow(0);
	    CellStyle style = CreateStyleOfSheet(libro);
//	    List<String> cabecera = Arrays.asList("NOMBRE_CASO_PRUEBA","TIPO_LOGIN","TIPO_PRODUCTO","SKU", "DESPACHO", "TIPO_DESPACHO","METODO_PAGO","NUMERO_TARJETA","NUMERO_OC");
	    List<String> cabecera = CreateCabecera();
	    for(int x = 0; x < cabecera.size(); x++){
	    	celda = filaCabecera.createCell(x);
	    	celda.setCellStyle(style);
	    	celda.setCellValue(cabecera.get(x));
//	    	hoja.autoSizeColumn(x);
	    }
	    inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        libro.write(outputStream);
        libro.close();
        outputStream.close();
	}
	
	private static List<String> CreateCabecera(){
		List<String> cabecera =  new ArrayList<String>();//Arrays.asList("ORDER ID","User", "Type of order", "Product", "Type of delivery","subtype of delivery","payment method","Card  number","Nª OC", "Total de la Compra", "Dispositivo", "Browser");
		cabecera.add("Order id");
		cabecera.add("User");
		cabecera.add("Type of order");
		cabecera.add("Product");
		cabecera.add("Type of delivery");
		cabecera.add("Subtype of delivery");
		cabecera.add("Payment method");
		cabecera.add("Card  number");
//		cabecera.add("Total de la Compra");
//		cabecera.add("Dispositivo");
//		cabecera.add("Browser");	
		return cabecera;
	}
	public static void WriteNumeroOCToExcelFile(String nombreHoja,Integer rowNum,String numOC) throws Exception {
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet hoja = workbook.getSheet(nombreHoja);
        int rowCount = hoja.getLastRowNum();
        Row fila = hoja.getRow(rowCount);
		Cell celda = fila.createCell(rowNum);
		celda.setCellValue(numOC);
		hoja.autoSizeColumn(rowNum);
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
	}
	
	private static CellStyle CreateStyleOfSheet(Workbook libro) {
		CellStyle style = libro.createCellStyle();
        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
	}
}
