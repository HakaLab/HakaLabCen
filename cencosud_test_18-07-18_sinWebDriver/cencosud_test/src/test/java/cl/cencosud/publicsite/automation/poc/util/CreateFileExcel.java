package cl.cencosud.publicsite.automation.poc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import cl.cencosud.publicsite.automation.constants.Constants;

public class CreateFileExcel {

static String excelFilePath;
	
	public static void createFileExcel(String nombreArchivo,String nombreHoja) throws IOException {
	    Workbook libro = new HSSFWorkbook();
	    excelFilePath = Constants.excelPath+nombreArchivo+".xls";
	    FileOutputStream archivo = new FileOutputStream(excelFilePath);
	    Sheet hoja = libro.createSheet(nombreHoja);
	    Row fila = hoja.createRow(0);
	    Cell celda;
	    CellStyle style = libro.createCellStyle();
        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        style.setShrinkToFit(true);
	    List<String> cabecera = Arrays.asList("Nombre Caso Prueba","Tipo Usuario", "Rut Cliente", "SKU", "Despacho", 
	    		"Tipo de Despacho","Metodo de Pago","Nª Tarjeta","Nª OC", "Total de la Compra", "Dispositivo",	"Browser");
	    for(int x = 0; x < cabecera.size(); x++){
	    	celda = fila.createCell(x);
	    	celda.setCellStyle(style);
	    	celda.setCellValue(cabecera.get(x));
	    }
	    libro.write(archivo);
	    archivo.close();
	  }
	
	public static void WriteFileExcel(List<String> datos) throws Exception{
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet hoja = workbook.getSheetAt(0);
            int rowCount = hoja.getLastRowNum();
            Row fila = hoja.createRow(++rowCount);
            for (int i = 0; i < datos.size(); i++) {
	    	  Cell celda = fila.createCell(i);
	    	  celda.setCellValue(datos.get(i).toString());
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
             
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public static void WriteNumeroOCToExcelFile(Integer rowNum,String numOC) throws Exception {
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet hoja = workbook.getSheetAt(0);
        int rowCount = hoja.getLastRowNum();
        Row fila = hoja.getRow(rowCount);
		Cell celda = fila.createCell(rowNum);
		celda.setCellValue(numOC);
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
	}
}
