import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import net.sf.json.*;

public class Mitable implements java.io.Serializable {
	
	private String name = null;
	
	public Mitable(String nombre){
		this.name = nombre;
	}
	public String toString(){
		return name;
		
	}

}
