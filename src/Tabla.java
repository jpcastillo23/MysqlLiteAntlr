import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

/**
 * clase TABLA cuya estructura interna poseera lo siguiente:
 * Variable Name : nombre de la tabla
 * Objeto json
 * 		-List<Columnas>
 * 			Columnas: <Nombre_Columna, tipo_variable>
 * 		-List<FIlas>
 * 			Fila<Lista_elementos>
 * 				Elemento: < Nombre_Columna, DatoFila>
 * 					DatoFila: <String tipo, Object Value>
 * 
 * 
 * 		|columna 1|	columna 2 |	columna 3 | Columna 4 | ..|
 * fila1|col1,ele1| col2,ele2 | col3, ele3 | Col4, ele4| ..|		
 * fila2|col1,ele1| col2,ele2 | col3, ele3 | Col4, ele4| ..|	
 * fila3|col1,ele1| col2,ele2 | col3, ele3 | Col4, ele4| ..|	
 *   .
 *   .
 *   .	
 * filan|col1,ele1| col2,ele2 | col3, ele3 | Col4, ele4| ..|	  
 *  
 * 		-List<Definitions>
 * */

public class Tabla  implements java.io.Serializable{
	/**
	 * Lista que maneja las filas con datos
	 * */
	private List<Fila> arreglo_filas = new ArrayList<Fila>();
	/**
	 * Lista que maneja las columnas (nuestra sintaxis de tabla)
	 * */
	private List<NewConstrain> columnas_tabla = new ArrayList<NewConstrain>();
	/**
	 * siempre es necesari mantener referencia a como se llama este objeto
	 * */
	private static String nombre_table;
	/**
	 * Constructor de nuestros archivos JSon
	 * */
	private Gson gson = new Gson();
	
	public Tabla(){
		nombre_table=null;
		arreglo_filas=null;
	}
	public Tabla(String nombre){
		nombre_table=nombre;
		arreglo_filas=null;
	}
	
	public String getNombre(){
		return this.nombre_table;
	}
	
	public void setNombre(String nuevo_nombre){
		this.nombre_table = nuevo_nombre;
	}
		
	public static void saveTable( Tabla tabla, String where){
		
		//primero salva guarto los archivos .json y sus ubicaciones
		/***
		 * revisa esto Carlos Barrios.  
		 * PD: si no miras esto significa que ni siquiera lo abriste para revisar.
		 * mañana entregamos y no tenemos ni el 30% del programa hecho. 
		 * Favor ayudame a completar. ya me canse de estar en este progarma. 
		 * Echale ganas por favor. Gracias. 
		 * 
		 * PD:  Contesta tu celular por favor, me da la impresion que obvias 
		 * contestarme, y lo unico que quiero es que al menos esta cochinada 
		 * haga algo.
		saveJsonObjectsColumnas();
		saveJsonObjectsFilas();
		  //  */
		
		//luego salvaguardo mi objeto tabla para abrirlo despues
		try{
			 FileOutputStream out = new FileOutputStream(where+".table");
	         ObjectOutputStream oos = new ObjectOutputStream (out);
	         oos.writeObject( tabla  );
	         oos.flush();
			}catch (Exception e){
				e.printStackTrace();
			} 
	}
	public static Tabla restoreTable (String where){
		Tabla retorno = null;
		try{
			 FileInputStream in = new FileInputStream(where+".table");
	         ObjectInputStream ios = new ObjectInputStream (in);
	         retorno = (Tabla) ios.readObject();
	         ios.close();
	         in.close();	         
			}catch (Exception e){
				e.printStackTrace();
			}
		return retorno; 
		
	}
	/**
	 * 
	 * METODOS PARA MANEJO DE JSON DENTRO DE NUESTRA TABLA 
	 * 
	 *   ------------------     JSON    ---------------------
	 *        
	 *        SALVAR EL OBJETO TIPO JSON  DE LAS FILAS
	 * what could be:
	 * 	-column   ->   "<table_name>column.json"	   COLUMAS
	 *  -filadata ->   "<table_name>data.json"      FILAS
	 *  -restric	  ->	   "<table_name>restric.json"
	 * */
	
	//	private List<Fila> arreglo_filas = new ArrayList<Fila>();
	public static void saveJsonObjectsFilas( String where, List<Fila> arreglo_filas_ext){
		Writer writer = null;
		Type tipoListaFilas = new TypeToken<List<Fila>>(){}.getType();
		try {
			writer = new OutputStreamWriter( 
					 new FileOutputStream(where + File.separator +nombre_table+"filas.json") ,
					"UTF-8");
		}catch(Exception f){
			f.printStackTrace();
		}
	        Gson gson = new GsonBuilder().create();
	        gson.toJson(arreglo_filas_ext, tipoListaFilas);
	        try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
	
	public static void saveJsonObjectsColumnas(String where,String what, List<NewConstrain> arreglo_filas_ext){
		Writer writer = null;
		Type tipoListaColumnas = new TypeToken<List<NewConstrain>>(){}.getType();
		try {
			writer = new OutputStreamWriter( 
					 new FileOutputStream(where + File.separator +nombre_table+"filas.json") ,
					"UTF-8");
		}catch(Exception f){
			f.printStackTrace();
		}
	        Gson gson = new GsonBuilder().create();
	        gson.toJson(arreglo_filas_ext, tipoListaColumnas);
	        try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}

