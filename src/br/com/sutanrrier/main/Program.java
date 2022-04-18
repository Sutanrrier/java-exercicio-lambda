package br.com.sutanrrier.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.sutanrrier.entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		List<Funcionario> listaFuncionarios = new ArrayList<>();
		
		System.out.print("Informe o caminho do arquivo .csv de empregados: ");
		String path = sc.nextLine();
		
		//Abrindo um arquivo .csv e criando uma lista de empregados a partir dela
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String linha = br.readLine();
			while(linha != null) {
				String[] fields = linha.split(",");
				listaFuncionarios.add(new Funcionario(fields[0], fields[1], Double.parseDouble(fields[2])));
				
				linha = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		System.out.print("Infome o salário de corte: ");
		double salarioCorte = sc.nextDouble();	
		//Filtra a lista e gera uma nova 
		List<String> funcionariosRicos = listaFuncionarios.stream()
				.filter(f -> f.getSalarioFunc() > salarioCorte)
				.map(f -> f.getEmailFunc())
				.sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
				.collect(Collectors.toList());
		System.out.println("\nEmail dos funcionários que ganham mais de $2000:");
		funcionariosRicos.forEach(System.out::println);
		
		//Calcular soma de salários de funcionários cujo nome começa com 'M'	
		double somaSalarios = listaFuncionarios.stream()
				.filter(f -> f.getNomeFunc().charAt(0) == 'M')
				.map(f -> f.getSalarioFunc())
				.reduce(0.0, (x, y) -> x + y);
		System.out.println("\nSoma de salários dos funcionários cujo nome começa com 'M': " + somaSalarios);
		System.out.println("\nFim do Programa!");
		sc.close();
	}

}
