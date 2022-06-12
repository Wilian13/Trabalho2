package br.edu.univas.main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

public class StartApp {
	
	 
	
	
	public static void main(String[] args) {
		 Scanner leitura = new Scanner(System.in);
		String varAmb = System.getenv("CSV_FILE");
		ArrayList<String>Materias = new ArrayList();
		
		readFile(varAmb, Materias);
		 int escolha = readInt (leitura);
		bufWriter(leitura, escolha, Materias);
		dataClass();

	}
	
	public static void readFile(String var, ArrayList<String> materias) {
		try (BufferedReader br = new BufferedReader(new FileReader(var))) {

			String chamada = "-- CHAMADA -- \n";
			String line = br.readLine();
			while (line != null) {
				chamada += line + "\n";
				materias.add(line);
				line = br.readLine();
			}	
			chamada += "Sair";
			System.out.println(chamada);
			
	}
			catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	public static int readInt(Scanner leitura) {
		int aux = leitura.nextInt();
		leitura.nextLine();
		return aux;
	}
	
	public static String selectMat(int escolha, ArrayList<String>materia ) {
		String nomeDaMateria = "";
		for(int i = 1; i <= materia.size(); i++ ) {
			if (i == escolha) {
				nomeDaMateria+= materia.get(i-1);
				
			}
			
		}
		return nomeDaMateria.toLowerCase();
	}
	 
	public static void bufWriter(Scanner leitura,int escolha, ArrayList<String>materia ) {
		try {
			int cont = 0;
			  File file = new File("C:\\Users\\Wilian\\OneDrive\\Área de Trabalho\\CSV\\"+ selectMat(escolha, materia) +"_"+ dataClass() +".txt" );
			  file.createNewFile();
			  FileWriter fileWriter = new FileWriter(file, true);
			  PrintWriter printWriter = new PrintWriter (fileWriter);
			  BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
			while( cont != 2 ) {
				System.out.println("Deseja dar presença a mais algum aluno");
				System.out.println("1- SIM");
				System.out.println("2- NÃO");
				cont = leitura.nextInt();
				if (cont == 2) {
					bufferedWriter.close();
					break;
					
				}
				leitura.nextLine();
				String nome = leitura.nextLine();
				bufferedWriter.write(nome);
				bufferedWriter.newLine();
				
				
				
			}
			  
			  	  
		  }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	public static String dataClass() {
		
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd_MM_yyyy");
	
		
		return formatador.format(data);
		
	}
	
	
}
