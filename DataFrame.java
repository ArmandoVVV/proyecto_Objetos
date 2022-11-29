package proyecto;

import java.util.Vector;

public class DataFrame {
/////////////////////////// atributos ///////////////////////////
	protected Vector<Columna> columnas;
	
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
	
	@Override
	public String toString() {
		String mensaje = "";
		
		for (int index = 0; index < columnas.size() ; index++) {
			mensaje = mensaje + columnas.get(index);
		}
		
		return mensaje;
	}

}// class end
