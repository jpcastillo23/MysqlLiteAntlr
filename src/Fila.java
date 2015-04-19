import java.util.*;


public class Fila implements java.io.Serializable{
	List<Elemento> mi_fila = new ArrayList<Elemento>();
	
	public Fila(){
		mi_fila = new ArrayList<Elemento>();
	}
	//creacion de arreglo de componentes (constrains)
	//asumo que vienen extendidos de DATAFILA pero del 
	//tipo CONSTRAIN
	public Fila( List<DatoFila> archivos){
		for( DatoFila elemento : archivos){
			this.mi_fila.add( new Elemento(elemento.getValue().toString(), elemento.getTypeValue(),null) );
		}
	}
	public void addFilaElement(Elemento mi_dato){
		mi_fila.add((Elemento)mi_dato);
	}
	//asumo que es element
	public void changeColumnElementat(int numero,String columna){
		((Elemento)mi_fila.get(numero)).setColumna(columna);
	}
	public void changeTipoElementat(int numero,String tipo){
		((Elemento)mi_fila.get(numero)).setTypeValue(tipo); 
	}
	public void changeValueElementat(int numero, Object value){
		((Elemento)mi_fila.get(numero)).setValue(value);
	}
	public void changeValueasStringElementat(int numero, Object value){
		((Elemento)mi_fila.get(numero)).setValue(value.toString());
	}
	public String getColumnElementat(int numero){
		return ((Elemento)mi_fila.get(numero)).getColumna();
	}
	public String getTipoElementat(int numero){
		return ((Elemento)mi_fila.get(numero)).getTypeValue();
	}
	
	public Object getValueasObjectElementat(int numero){
		return ((Elemento)mi_fila.get(numero)).getValue();
	}
	public String getValueasStringElementat(int numero){
		return ((Elemento)mi_fila.get(numero)).getValue().toString();
	}
	public int getSize(){
		return mi_fila.size();
	}
	public int searchWhereisColumnElement(String columna_name){
		int count=0;
		for( Elemento columna : mi_fila){
			if(columna.getColumna().equals(columna_name) ){
				count=count+1;
			}
		}
		return count;
	}
	/**
	 * @return: integer de donde se encuentra
	 * */
	public int searchWhereisValueElement(Object value){
		int count=0;
		for( Elemento columna : mi_fila){
			if(columna.getValue().equals(value) ){
				count=count+1;
			}
		}
		return count;
	}
	public Object returnObjectValueWhereColumnis(String column){
		int count=0;
		for( Elemento columna : mi_fila){
			if(columna.getColumna().equals(column) ){
				return columna.getValue();
			}
		}
		
		return new String("no existe");
	}
	public String returnStringValueWhereColumnis(String column){
		int count=0;
		for( Elemento columna : mi_fila){
			if(columna.getColumna().equals(column) ){
				return columna.asString() ;
			}
		}
		return new String("no existe");
	}
	

}
