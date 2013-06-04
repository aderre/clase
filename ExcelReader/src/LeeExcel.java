import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class LeeExcel {

    /**
     * @param args
     */
    public static void main(String[] args) {
	//Ubicación del archivo XLS
        String archivo="prueba.xls";
 
        //Creamos un Workbook para cargar el XLS en memoria 
        Workbook workbook = null;
	try {
	    workbook = Workbook.getWorkbook(new File(archivo));
	} catch (BiffException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
        //Elegimos la primera hoja
        Sheet sheet = workbook.getSheet(0);
        //inicializo el objeto que leerá el valor de la celda
        Cell celdaCurso = null;
        //Este String guardará el valor de la celda
        String valorCeldaCurso=null;
 
        //Obtengo el número de filas ocupadas en la hoja
        int rows=sheet.getRows();
        //Obtengo el número de columnas ocupadas en la hoja
        int cols=sheet.getColumns();
 
        //Para efectos de ejemplo recorremos las columnas de cada fila
        for(int x=0;x<rows;x++){
            for(int y=0; y<cols; y++){
                //Obtenemos el valor de la celda de la columna Y y fila X
                celdaCurso= sheet.getCell(y,x);
                //Obtenemos el valor de la celda
                 valorCeldaCurso= celdaCurso.getContents();
                 System.out.print(valorCeldaCurso+"|");
            }
            System.out.println("");
 
        }
 
        workbook.close();
    }

    
    
    public LeeExcel(){
	
    }

}
