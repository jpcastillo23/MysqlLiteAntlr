
public class Elemento  extends DatoFila {
	private static Elemento VOID = new Elemento();
	private String columna_representada = null;
	
	// el valor ingresado por lo regular es un datofila
	private Elemento(){
		super(null, null);
		this.columna_representada=null;

	}
	public Elemento(String columna, String tipo, Object value){
		//columna = new variable, tipo=type, value=value
		super(tipo,value);
		this.columna_representada = columna;
	}
	public Elemento(String columna, DatoFila valor_ingresado){
		super(valor_ingresado.getTypeValue(), valor_ingresado.getValue() );
		this.columna_representada = columna;
	}
	
	public String getColumna(){
		return this.columna_representada;
	}
	
	public void setColumna(String nuewcolumna){
		this.columna_representada = nuewcolumna; 
	}
	
	public String toString(){
		return (columna_representada +"-"+ getTypeValue() +"-"+ getValue().toString() );
	}
	
	public boolean equals( Object o) {
		boolean uno, dos, tres;
        if(this == VOID || o == VOID) {
            throw new RuntimeException("can't use VOID: " + this + " ==/!= " + o);
        }
		if( o instanceof Elemento){
			uno = this.columna_representada.equals(((Elemento)o).getColumna());
			dos = this.type.equals(((Elemento)o).getTypeValue());
			tres = this.value.equals(((Elemento)o).getValue());
			if(uno && dos && tres){
				return true;
			}
		}
		else{
			return false;
		}
		return false;

    }

	
}
