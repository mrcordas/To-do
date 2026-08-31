package com.todo.controller;

import java.util.Scanner;

import com.todo.view.AppView;

public class TaskController {
	
	public void start() {
		
		Scanner sc = new Scanner(System.in);

		AppView appView = new AppView(sc);
		int option = -1;
		while(true) {
			AppView.clear();
			try {
				option = appView.menu();
				switch (option) {
					case 1: 
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break; 	
					default:
						throw new IllegalArgumentException("Opção invalida!");
				}
			}catch (NumberFormatException e) {
				System.out.print("Error: Campo permite somente numero!");
		
			}catch (IllegalArgumentException e) {
				System.out.print(e.getMessage());
			}
			
			if(option == 5)
				break;
			
			appView.pause();
		}
		

		sc.close();
	}
}
