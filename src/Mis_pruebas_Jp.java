import java.awt.List;
import java.util.*;
import java.io.*;
import java.util.*;


public class Mis_pruebas_Jp {

	private static Mitable adios,prueb;
	public static String hola ;//= new String();
	public static Misqlobject hehe;

	public static void main(String[] args)  {
		/**String hola2="null";
		hehe = new Misqlobject(hola);
		System.out.println( hehe.isString() );
		// 
		
		/**
		 String donde = "/Users/josecastillo/Netbeans/Mi_Sql_pequeño/MyDB/db_registry.txt";
		 
		File nuevo = new File(donde);
		DLL_manager manejador = new DLL_manager();
		manejador.Anadir_fila_fichero(donde, "que cancha");  // */
		
		/**
		 * prueba de  guardado de objetos
		 * */
		
		/**
		Mitable mi = new Mitable("fucker");
		try{
		 FileOutputStream out = new FileOutputStream("/Users/josecastillo/Netbeans/Mi_Sql_pequeño/prueba2.obj");
         ObjectOutputStream oos = new ObjectOutputStream (out);
         oos.writeObject(mi);
         oos.flush();
		}catch (Exception e){
			e.printStackTrace();
		}     //  
		*/
		
		/**
		 * PRUEBA DE LECTURA
		 * */
		/**
		Mitable mi = new Mitable("HELLO");
		try{
		 FileInputStream in = new FileInputStream("/Users/josecastillo/Netbeans/Mi_Sql_pequeño/prueba.obj");
         ObjectInputStream ios = new ObjectInputStream (in);
         mi = (Mitable)ios.readObject();
         in.close();
         ios.close();
         System.out.println(mi);
		}catch (Exception e){
			e.printStackTrace();
		}     //  */

		//DatosFila nuevo = new DatosFila("integer", 13);
		//System.out.println(nuevo.getTypeValue() + nuevo.toString() + nuevo.retornoTipoObjeto() );
		
	}

}
