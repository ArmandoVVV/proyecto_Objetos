package proyecto;

import java.util.Collections;
import java.util.Vector;
import java.lang.Math;


public class Columna {
/////////////////////////// atributos ///////////////////////////
	protected String name;
	protected Vector<String> columna;
	
	
/////////////////////////// metodo constructor ///////////////////
	public Columna(String name) {
		this.name = name;
		this.columna = new Vector<>();
	}
	
	public Columna() {
		this.name = "<Columna>";
		this.columna = new Vector<>();
	}
	
/////////////////////////// setters y getters ////////////////////
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Vector<String> getColumna() {
		return columna;
	}

	public void setColumna(Vector<String> columna) {
		this.columna = columna;
	}

/////////////////////////// metodos ///////////////////////////////
	public void addData(String data) {
		columna.add(data);
	}
	
	public void deleteAllData() {
		columna.removeAllElements();
	}
	
	public String maxData() {
		Vector<Double> IntVector = new Vector<>();
		
		for (int index = 0; index < columna.size() ; index++) {
			IntVector.add(Double.parseDouble(columna.get(index)));
		}
		
		return Collections.max(IntVector) + "";
	}
	
	public String minData() {
		Vector<Double> IntVector = new Vector<>();
		
		for (int index = 0; index < columna.size() ; index++) {
			IntVector.add(Double.parseDouble(columna.get(index)));
		}
		
		return Collections.min(IntVector) + "";
	}
	
	public String totalSum() {
		double suma = 0;
		String s_suma;
		
		for (int index = 0; index < columna.size() ; index++) {
			suma += Double.parseDouble(columna.get(index));
		}
		
		s_suma = suma + "";
		
		return s_suma;
	}
	
	public String average() {
		double average = 0;
		String s_average;
		
		average = ( Double.parseDouble(totalSum()) / columna.size() );
		
		s_average = average + "";
		return s_average;
	}
	
	public String standardDeviation() {
		double average = 0;
		double squareSum = 0;
		double standarDeviation = 0;
		
		average = ( Double.parseDouble(totalSum()) / columna.size() );
		
		for (int index = 0; index < columna.size() ; index++) {
			squareSum += Math.pow( (Double.parseDouble(columna.get(index)) - average), 2);
		}
		
		standarDeviation = squareSum / columna.size();
		standarDeviation = Math.sqrt(standarDeviation);
		
		return standarDeviation + "";
	}
	
	@Override
	public String toString() {
		String mensaje;
		
		mensaje = getName() + "\n";
		
		for (int index = 0; index < columna.size() ; index++) {
			mensaje = mensaje + columna.get(index);
			mensaje = mensaje + "\n";
		}
		
		return mensaje;
	}
	
	
}// class end
