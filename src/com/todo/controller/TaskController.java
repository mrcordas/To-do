package com.todo.controller;

import java.util.Scanner;

import com.todo.service.TaskManagerService;
import com.todo.view.AppView;

public class TaskController {
	
	public void start() {
		
		Scanner sc = new Scanner(System.in);

		AppView appView = new AppView(sc);
		
		TaskManagerService tms = new TaskManagerService(appView);
		
		Integer option = -1;
		boolean optionError = false; //controlar pula menu
		
		while(true) { 
			AppView.screenClear();
			try {
				
				appView.menu();
		
				if (!optionError || option == -1)
					option = appView.readOptionMenu();
				else
					appView.print("Escolha selecionada: " + option + "\n");
				
				switch (option) {
					case 1:
						tms.addTask();
						break;
					case 2:
						tms.listTasks();
						break;
					case 3:
						tms.completeTask();
						break;
					case 4:
						break;
					case 5:
						break; 	
					default:
						appView.print("\nOpção invalida!");
						break;
				}
				
				if(option == 5) {
					AppView.screenClear();
					break;				
				}
				
				option = -1; //reinicia as menu opções
				
			}catch (NumberFormatException e) {
				optionError = true;
				appView.print("\nError: Campo permite somente numero! ");
			}catch (IllegalArgumentException e) {
				appView.print("\n" + e.getMessage());
				optionError = true;
			}
			
			appView.pause();
		}
		

		sc.close();
	}
}
