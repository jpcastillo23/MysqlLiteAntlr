import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.io.*;
import java.util.*;



	//   /Users/josecastillo/Netbeans/Mi_Sql_pequeño/src/PRUEBAS_ANTLR_MISQLGRAMMAR
public class DatoFila implements Comparable<Misqlobject>, java.io.Serializable{
	    private Vector<Misqlobject> lista;
	    public static final DatoFila NULL = new DatoFila();
	    public static final DatoFila VOID = new DatoFila();
	    private int index;
	    protected String type;   //habitual es el tipo de objeto
	    protected Object value;  // este es mi objeto (variable)
	    private boolean fue_exitoso ;

	    protected DatoFila() {
	        // private constructor: only used for NULL and VOID
	        value = null;
	        fue_exitoso = false;
	    }

	    public DatoFila(String tipo , Object v) {
	        if(v == null) {
	      	 }
	        this.type = tipo;
	        this.value = v;
	        // only accept boolean, list, number or string types
	        if(!(isNull() || isBoolean() || isList() || isNumber() || isString()  || isDate() || isCalendar() )) {
	            throw new RuntimeException("invalid data type: " + v + " (" + v.getClass() + ")");
	        }
	    }
	    public String retornoTipoObjeto(){
	    		if(isBoolean()){
	    			return "boolean";
	    		}else if(isList()){
	    			return "list";
	    		}else if(isInteger()){
	    			return "integer";
	    		}else if(isFloat()){
	    			return "float";
	    		}else if(isDate()){
	    			return "date";
	    		}else if(isCalendar()){
	    			return "calendar";
	    		}else if(isString()){
	    			return "string";
	    		}else if(isNull()){
	    			return "null";
	    		}
	    		else{
	    			return "null";
	    		}
	    }
	    
	    public Object getValue(){
	    		return this.value;
	    }
	    public void setValue(Object nuevovalue){
	    		this.value = nuevovalue;
	    }
	    public String getTypeValue(){
	    		return this.type;
	    }
	    public void setTypeValue(String newtype){
	    		this.type = newtype;
	    }
	    public Boolean asBoolean() {
	        return (Boolean)value;
	    }

	    public Double asDouble() {
	        return ((Number)value).doubleValue();
	    }


	    @SuppressWarnings("unchecked")
	    public List<Misqlobject> asList() {
	        return (List<Misqlobject>)value;
	    }

	    public String asString() {
	        return (String)value;
	    }
	    
	    public Float asFloat() {
	        return (Float)value;
	    }
	    
	    public Integer asInteger() {
	        return (Integer)value;
	    }
	    public Date asDate() {
	        return (Date)value;
	    }

	    @Override
	    public int compareTo(Misqlobject that) {
	        if(this.isNumber() && that.isNumber() || this.isFloat() && that.isFloat() || this.isInteger() && that.isInteger() ) {
	            if(this.equals(that)) {
	                return 0;
	            }
	            else {
	                return this.asDouble().compareTo(that.asDouble());
	            }
	        }
	        else if(this.isString() && that.isString()) {
	            return this.asString().compareTo(that.asString());
	        }
	        else if(this.isDate() && that.isDate()) {
	            return this.asDate().compareTo(that.asDate());
	        }
	        
	        else {
	            throw new RuntimeException("illegal expression: can't compare `" + this + "` to `" + that + "`");
	        }
	    }

	    @Override
	    public boolean equals(Object o) {
	        if(this == VOID || o == VOID) {
	            throw new RuntimeException("can't use VOID: " + this + " ==/!= " + o);
	        }
	        if(this == o) {
	            return true;
	        }
	        if(o == null || this.getClass() != o.getClass()) {
	            return false;
	        }
	        DatoFila that = (DatoFila)o;
	        if(this.isNumber() && that.isNumber()) {
	            double diff = Math.abs(this.asDouble() - that.asDouble());
	            return diff < 0.00000000001;
	        }
	        else {
	            return this.value.equals(that.value);
	        }
	    }


	    public boolean isCalendar() {
	        return value instanceof Calendar;
	    }
	    public boolean isDate(){
	    		return value instanceof Date;
	    }
	    
	    public boolean isBoolean() {
	        return value instanceof Boolean;
	    }
	    

	    public boolean isNumber() {
	        return value instanceof Number;
	    }

	    public boolean isList() {
	        return value instanceof List<?>;
	    }


	    public boolean isVoid() {
	        return this == null;
	    }

	    public boolean isString() {
	        return value instanceof String;
	    }
	    
	    public boolean isNull() {
	        return (this == NULL) ? true : false;
	    }
	    
	    public boolean isInteger() {
	        return value instanceof Integer;
	    }
	    
	    public boolean isFloat() {
	        return value instanceof Float;
	    }

	    @Override
	    public String toString() {
	    	//return TYPE + " - " + VALUE
	    		String Retorno = value.toString();
	        return type + "-" + (isNull() ? "null" : isVoid() ? "void" : Retorno);
	    }



	}


