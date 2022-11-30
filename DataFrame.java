package proyecto;

import java.util.Vector;

public class DataFrame {
/////////////////////////// atributos ///////////////////////////
	protected Vector<Columna> columnas;
	
	////////////// SETTERS Y GETTERS //////////////////////////////
	public Vector<Columna> getColumnas() {
		return columnas;
	}

	/////////////////////////// metodo constructor ///////////////////
	public DataFrame() {
			this.columnas = new Vector<>();
	}
	
/////////////////////////// metodos ///////////////////////////////
	public void addColumna(Columna columna) {
		columnas.add(columna);
	}
	
	public void deleteColumna(int index) {
		columnas.remove(index);
	}
	
	public Columna combineColumn(int index_column1, int index_column2, ColumnsOperations operation) {
		Columna resultColumn = new Columna();
		String columnName = "";
		
		Columna columna1 = columnas.get(index_column1);
		Columna columna2 = columnas.get(index_column2);
		
		
		switch(operation) {
			case SUMA:
				for(int index = 0; index < columna1.getColumna().size() ; index++) {
					double current_sum = Double.parseDouble(columna1.getColumna().get(index)) + Double.parseDouble(columna2.getColumna().get(index));
					resultColumn.addData(current_sum + "");
				}
				columnName = "Suma entre " + columna1.getName() + " y " + columna2.getName();
				break;
				
			case CONCATENACION:
				for(int index = 0; index < columna1.getColumna().size() ; index++) {
					String current_sum = columna1.getColumna().get(index) + columna2.getColumna().get(index);
					resultColumn.addData(current_sum);
				}
				
				columnName = "Concatenacion entre " + columna1.getName() + " y " + columna2.getName();
				break;
			
			case RESTA:
				for(int index = 0; index < columna1.getColumna().size() ; index++) {
					double current_sub = Double.parseDouble(columna1.getColumna().get(index)) - Double.parseDouble(columna2.getColumna().get(index));
					resultColumn.addData(current_sub + "");
				}
				
				columnName = "Resta entre " + columna1.getName() + " y " + columna2.getName();
				break;
				
			case MULTIPLICACION:
				for(int index = 0; index < columna1.getColumna().size() ; index++) {
					double current_mult = Double.parseDouble(columna1.getColumna().get(index)) * Double.parseDouble(columna2.getColumna().get(index));
					resultColumn.addData(current_mult + "");
				}
				
				columnName = "Multiplicacion entre " + columna1.getName() + " y " + columna2.getName();
				break;
				
			case DIVISION:
				for(int index = 0; index < columna1.getColumna().size() ; index++) {
					double current_div = Double.parseDouble(columna1.getColumna().get(index)) / Double.parseDouble(columna2.getColumna().get(index));
					resultColumn.addData(current_div + "");
				}
				
				columnName = "Division entre " + columna1.getName() + " y " + columna2.getName();
				break;
		}
		
		resultColumn.setName(columnName);
		
		return resultColumn;
	}
	
	public StringBuilder getRawCsv() {
		StringBuilder rawCsv = new StringBuilder();
		for(int index_0 = 0; index_0 < columnas.size() ; index_0++) {
			rawCsv.append(columnas.get(index_0).getName());
			rawCsv.append(",");
		}
		rawCsv.append("\n");
		
		for (int index_x = 0; index_x < columnas.get(0).getColumna().size() ; index_x++) {
			for(int index_y = 0; index_y < columnas.size() ; index_y++) {
				rawCsv.append(columnas.get(index_y).getColumna().get(index_x));
				rawCsv.append(",");
			}
			rawCsv.append("\n");
		}
		
		return rawCsv;
	}
	
	public String getAverageFromColumnIndex(int index) {
		return getColumnas().get(index).average();
	}
	
	public String getSumFromColumnIndex(int index) {
		return getColumnas().get(index).totalSum();
	}
	
	public String getMinDataFromColumnIndex(int index) {
		return getColumnas().get(index).minData();
	}
	
	public String getMaxDataFromColumnIndex(int index) {
		return getColumnas().get(index).maxData();
	}
	
	public String getStandardDeviationFromColumnIndex(int index) {
		return getColumnas().get(index).standardDeviation();
	}
	
	@Override
	public String toString() {
		String mensaje = "";
		
		for (int index = 0; index < columnas.size() ; index++) {
			mensaje = mensaje + columnas.get(index);
		}
		
		return mensaje;
	}

}// class end
