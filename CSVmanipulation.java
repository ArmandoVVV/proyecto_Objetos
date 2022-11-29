package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVmanipulation {
	// Atributos ////////////////////////////
	protected static int totalColumnas = 0;
	protected static int totalCSVarchives = 0;
	
	// SETTERS Y GETTERES ////////////////////
	public static int getTotalColumnas() {
		return totalColumnas;
	}


	public static void setTotalColumnas(int _totalColumnas) {
		totalColumnas = _totalColumnas;
	}
	
	public static int getTotalCSVarchives() {
		return totalCSVarchives;
	}

	public static void setTotalCSVarchives(int totalCSVarchives) {
		CSVmanipulation.totalCSVarchives = totalCSVarchives;
	}

	// METODOS ///////////////////////////////////
	public static Columna getColumnFromCsv() {
		String path = "java_input.csv";
		String line = "";
		String ColumnaName = "Columna " + getTotalColumnas();
		
		
		Columna columna = new Columna(ColumnaName);
		
		try {
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				while((line = br.readLine()) != null) {
					String[] values = line.split(",");
					
					columna.addData(values[getTotalColumnas()]);
				}
			}
			
			setTotalColumnas(getTotalColumnas() + 1);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return columna;
	}
	
	public static DataFrame getDataFrameFromCSV(int numberOfColumns) {
		DataFrame dataFrame = new DataFrame();
		
		for(int index = 0; index < numberOfColumns; index++) {
			dataFrame.addColumna(getColumnFromCsv());;
		}
		
		return dataFrame;
	}
	
	public static void generateCSV(DataFrame dataFrame) {
		String path_output = "java_output";
		path_output += getTotalCSVarchives() + ".csv";
		
		setTotalCSVarchives(getTotalCSVarchives() + 1);
		
		try {
			PrintWriter pw = new PrintWriter(new File(path_output));

			
			pw.write(dataFrame.getRawCsv().toString());
			pw.close();
			System.out.println("CSV archive created");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}// class end
