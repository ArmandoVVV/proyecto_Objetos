package proyecto;

public class TestProyect {

	public static void main(String[] args){	
		Columna average_column = new Columna("Promedio");
		Columna maxValue_column = new Columna("Valor maximo");
		Columna minValue_column = new Columna("Valor minimo");
		Columna suma = new Columna("Suma");
		Columna desviacionStandar = new Columna("Desviacion Standar");
		Columna info_column = new Columna("Numero de columna");
		
		DataFrame frame1 = new DataFrame();
		DataFrame results_frame = new DataFrame();

		///////// GET CSV VALUES TO COLUMNS //////////////////
		Columna columna1 = CSVmanipulation.getColumnFromCsv();
		Columna columna2 = CSVmanipulation.getColumnFromCsv();
		Columna columna3 = CSVmanipulation.getColumnFromCsv();
		Columna columna4 = CSVmanipulation.getColumnFromCsv();
		Columna columna5 = CSVmanipulation.getColumnFromCsv();
		Columna columna6 = CSVmanipulation.getColumnFromCsv();
		///////////////////////////////////////////////////////
			
		average_column.addData(columna1.average());
		average_column.addData(columna2.average());
		average_column.addData(columna3.average());
		average_column.addData(columna4.average());
		average_column.addData(columna5.average());
		average_column.addData(columna6.average());
		
		maxValue_column.addData(columna1.maxData());
		maxValue_column.addData(columna2.maxData());
		maxValue_column.addData(columna3.maxData());
		maxValue_column.addData(columna4.maxData());
		maxValue_column.addData(columna5.maxData());
		maxValue_column.addData(columna6.maxData());
		
		minValue_column.addData(columna1.minData());
		minValue_column.addData(columna2.minData());
		minValue_column.addData(columna3.minData());
		minValue_column.addData(columna4.minData());
		minValue_column.addData(columna5.minData());
		minValue_column.addData(columna6.minData());
			
		suma.addData(columna1.totalSum());
		suma.addData(columna2.totalSum());
		suma.addData(columna3.totalSum());
		suma.addData(columna4.totalSum());
		suma.addData(columna5.totalSum());
		suma.addData(columna6.totalSum());
		
		desviacionStandar.addData(columna1.standardDeviation());
		desviacionStandar.addData(columna2.standardDeviation());
		desviacionStandar.addData(columna3.standardDeviation());
		desviacionStandar.addData(columna4.standardDeviation());
		desviacionStandar.addData(columna5.standardDeviation());
		desviacionStandar.addData(columna6.standardDeviation());
		
		info_column.addData("Columna 0");
		info_column.addData("Columna 1");
		info_column.addData("Columna 2");
		info_column.addData("Columna 3");
		info_column.addData("Columna 4");
		info_column.addData("Columna 5");
		
			
		frame1.addColumna(columna1);
		frame1.addColumna(columna2);
		frame1.addColumna(columna3);
		frame1.addColumna(columna4);
		frame1.addColumna(columna5);
		frame1.addColumna(columna6);
			
		frame1.deleteColumna(3);
		
		results_frame.addColumna(info_column);
		results_frame.addColumna(average_column);
		results_frame.addColumna(suma);
		results_frame.addColumna(desviacionStandar);
		results_frame.addColumna(minValue_column);
		results_frame.addColumna(maxValue_column);
			
		
		// CREATE CSV //////////////////////
		CSVmanipulation.generateCSV(frame1);
		CSVmanipulation.generateCSV(results_frame);
		

	} // main end
} // class end
