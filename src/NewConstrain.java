
public class NewConstrain extends DatoFila implements java.io.Serializable{
	
	public NewConstrain(){
		//tipo=type, columna=value
		super();
	}
	public NewConstrain(String columna, String tipo){
		super(tipo, columna);
	}
	// ES NOMBRE DE COL
	public String getColumna(){
		return this.value.toString();
	}
	//retorna el tipo de la columna
	public String getTipo(){
		return this.type;
	}
	public void setColumna(String nombre_columna){
		this.value = nombre_columna;
	}
	//seteo columna
	public void setTipo(String value){
		this.type = new String(value);
	}
	
	public String toString(){
		return getColumna()+"-"+getTipo();
	}
	

}
