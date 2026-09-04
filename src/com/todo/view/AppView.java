package com.todo.view;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class AppView {
	
	private Scanner sc;
	
	public AppView(Scanner sc) {
		this.sc = sc;
	}
	
	public void print(Object obj) {
		System.out.print(obj);
	}
	
	public static String logo() {
		return "================================\n"+
			   "         MINHAS TAREFAS         \n"+
			   "================================\n";
	}
	
	
	public void menu() {
		System.out.println(logo());
		System.out.println( "1 - Adicionar tarefa\n"
						  + "2 - Listar tarefas\n"
						  + "3 - Concluir tarefa\n"
						  + "4 - Remover tarefa\n"
						  + "5 - Sair\n");
	}
	
	public int readOptionMenu() {
		System.out.print("Escolha: ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public String readTaskDescription() {
		
		System.out.print("Digite a tarefa: ");
		String taskDescription = sc.nextLine();
		
		return taskDescription;
	}
	
	public int readTaskID() {

		System.out.print("\nDigite o ID da tarefa: ");
		int id = Integer.parseInt(sc.nextLine());

		return id;
	}
	
	public static void screenClear() {
		String so = System.getProperty("os.name").toLowerCase();
		String[] command = {"cmd", "/c", "cls"};
		Map<String, String> env = System.getenv();
		
		if(!so.contains("windows") || env.containsKey("MSYSTEM"))
			command = new String[] {"clear"};		
		
		try {
			ProcessBuilder pb = new ProcessBuilder(command).inheritIO();
			pb.start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void pause() {
		sc.nextLine();
	}
}
