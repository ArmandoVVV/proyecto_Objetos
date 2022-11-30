package test;

import proyecto.CSVmanipulation;
import proyecto.Columna;
import proyecto.DataFrame;

public class TestAplication {
	
	public static void main(String[] args){	
		Columna info_column = new Columna();
		Columna golesAfavor_column = new Columna();
		Columna golesEnContra_column = new Columna();
		Columna puntos_column = new Columna();
		
		Columna totalGoles = new Columna("Goles anotados en total");
		Columna promedioGoles = new Columna("Goles en promedio por equipo");
		Columna masGolesAnotados = new Columna("Mas goles que ha anotado un equipo");
		Columna menosGolesRecibidos = new Columna("Menos goles que ha recibido un equipo");
		Columna masPuntos = new Columna("Mas puntos que tiene un equipo");
		
		DataFrame input_frame = new DataFrame();
		DataFrame results_frame = new DataFrame();

		///////// GET CSV VALUES TO COLUMNS //////////////////
		info_column = CSVmanipulation.getColumnFromCsv();
		info_column.setName("Equipo");
		
		golesAfavor_column = CSVmanipulation.getColumnFromCsv();
		golesAfavor_column.setName("Goles a favor");
		
		golesEnContra_column = CSVmanipulation.getColumnFromCsv();
		golesEnContra_column.setName("Goles en contra");
		
		puntos_column = CSVmanipulation.getColumnFromCsv();
		puntos_column.setName("Puntos");
		///////////////////////////////////////////////////////
		
		// COLUMNS OPERATIONS /////////////////////////////////////////
		totalGoles.addData(golesAfavor_column.totalSum());
		promedioGoles.addData(golesAfavor_column.average());
		masGolesAnotados.addData(golesAfavor_column.maxData());
		menosGolesRecibidos.addData(golesEnContra_column.minData());
		masPuntos.addData(puntos_column.maxData());
		
		
		// ADD COLUMNS TO FRAMES //////////////////////////////
		
		input_frame.addColumna(info_column);
		input_frame.addColumna(golesAfavor_column);
		input_frame.addColumna(golesEnContra_column);
		input_frame.addColumna(puntos_column);
		
		results_frame.addColumna(totalGoles);
		results_frame.addColumna(promedioGoles);
		results_frame.addColumna(masGolesAnotados);
		results_frame.addColumna(menosGolesRecibidos);
		results_frame.addColumna(masPuntos);
		
		// CREATE CSV //////////////////////
		CSVmanipulation.generateCSV(input_frame);
		CSVmanipulation.generateCSV(results_frame);	

	} // main end
}// class end
