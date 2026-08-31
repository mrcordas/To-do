package com.todo.main;

import com.todo.controller.TaskController;

public class Main {
	public static void main(String[] args) {
		TaskController tsc = new TaskController();
		tsc.start();
	}
}
