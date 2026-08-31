package com.todo.view;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class AppView {
	
	private Scanner sc;
	
	public AppView(Scanner sc) {
		this.sc = sc;
	}
	
	public static String logo() {
		return "================================\n"+
			   "         MINHAS TAREFAS         \n"+
			   "================================\n";
	}
	
	
	public int menu() {
		System.out.println(logo());
		System.out.println("1 - Adicionar tarefa\n"
						+ "2 - Listar tarefas\n"
						+ "3 - Concluir tarefa\n"
						+ "4 - Remover tarefa\n"
						+ "5 - Sair\n");
		System.out.print("Escolha: ");
		
		return Integer.parseInt(sc.nextLine());
		
	}
	
	public static void clear() {
		String so = System.getProperty("os.name").toLowerCase();
		String[] command = {"cmd", "/c", "cls"};
		Map<String, String> env = System.getenv();
		
		if(!so.contains("windows") || env.containsKey("MSYSTEM"))
			command = new String[] {"clear"};		
		
		try {
			new ProcessBuilder(command).inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void pause() {
		sc.nextLine();
	}
}
