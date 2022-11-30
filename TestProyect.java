package test;

import proyecto.CSVmanipulation;
import proyecto.Columna;
import proyecto.ColumnsOperations;
import proyecto.DataFrame;

public class TestProyect {

	public static void main(String[] args){	
		final int totalColumns = 20;
		
		Columna average_column = new Columna("Promedio");
		Columna maxValue_column = new Columna("Valor maximo");
		Columna minValue_column = new Columna("Valor minimo");
		Columna suma_column = new Columna("Suma");
		Columna desviacionStandar_column = new Columna("Desviacion Standar");
		Columna info_column = new Columna("Numero de columna");
		
		DataFrame results_frame = new DataFrame();
		DataFrame operations_frame = new DataFrame();

		///////// GET CSV VALUES TO COLUMNS //////////////////
		DataFrame inputFrame = CSVmanipulation.getDataFrameFromCSV(totalColumns);
		///////////////////////////////////////////////////////
		
		// COLUMNS OPERATIONS /////////////////////////////////////////
		
		for(int i = 0 ; i < inputFrame.getColumnas().size();  i++) {
			average_column.addData(inputFrame.getAverageFromColumnIndex(i));
			maxValue_column.addData(inputFrame.getMaxDataFromColumnIndex(i));
			minValue_column.addData(inputFrame.getMinDataFromColumnIndex(i));
			suma_column.addData(inputFrame.getSumFromColumnIndex(i));
			desviacionStandar_column.addData(inputFrame.getStandardDeviationFromColumnIndex(i));
			info_column.addData("Columna " + i);
		}
		
		results_frame.addColumna(info_column);
		results_frame.addColumna(average_column);
		results_frame.addColumna(maxValue_column);
		results_frame.addColumna(minValue_column);
		results_frame.addColumna(suma_column);
		results_frame.addColumna(desviacionStandar_column);
		
		// DATA FRAME OPERATIONS /////////////////////////////////////////
		operations_frame.addColumna(inputFrame.combineColumn(0, 1, ColumnsOperations.SUMA));
		operations_frame.addColumna(inputFrame.combineColumn(0, 1, ColumnsOperations.RESTA));
		operations_frame.addColumna(inputFrame.combineColumn(0, 1, ColumnsOperations.CONCATENACION));
		operations_frame.addColumna(inputFrame.combineColumn(0, 1, ColumnsOperations.DIVISION));
		operations_frame.addColumna(inputFrame.combineColumn(0, 1, ColumnsOperations.MULTIPLICACION));

		// CREATE CSV //////////////////////
		CSVmanipulation.generateCSV(inputFrame);
		CSVmanipulation.generateCSV(results_frame);
		CSVmanipulation.generateCSV(operations_frame);		

	} // main end
} // class end
