package com.todo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.todo.model.Task;
import com.todo.view.AppView;

public class TaskManagerService {
	
	List<Task> tasks;
	AppView appView;
	
	public TaskManagerService(AppView appView) {
		
		tasks = new ArrayList<>();
		this.appView = appView;
	}
	
	public void addTask() {
		
		String description = appView.readTaskDescription();
		
		if (description.isBlank())
			throw new IllegalArgumentException("Tarefa não pode ser vazia! ");
		
		int id = 0;
		
		if(!tasks.isEmpty()) {
			id = tasks.stream().map(task -> task.getId())
		
						   .max(Comparator.naturalOrder())
						   .get() + 1;
		}
		//Optional<Task> max = tasks.stream().max(
		//		                 (task1, task2) -> Integer.compare(task1.getId(), task2.getId())
		//		             );
		

		tasks.add(new Task(id, description));
		
		appView.print("\nTarefa adicionada com sucesso! ");
	}
	
	public void listTasks() {
		
		appView.print("\n-------- TAREFAS --------\n\n");
		
		if(tasks.isEmpty()) {
			appView.print("Sem tarefas cadastradas! ");
			return;
		}

		for(Task task : tasks) {
			appView.print(task + "\n");
		}
		
	}
	
	public void completeTask() {
		
		if(tasks.isEmpty()) {
			appView.print("Sem tarefas cadastradas! ");
			return;
		}
		
		boolean anyNoCompleted = tasks.stream().anyMatch(task -> task.isCompleted() == false);
		
		if(!anyNoCompleted) {
			appView.print("Sem tarefas Para comcluir! ");
			return;
		}
		
		int id = appView.readTaskChangeStatus();
		Optional<Task> optTask = tasks.stream().filter(task -> task.getId() == id)
					  .findFirst();
		
		Task searchTask = optTask.orElse(null);
		
		if(searchTask == null) {
			appView.print("\nTarefa nao encontrada! ");
			return;
		}
			
		searchTask.setCompleted(true);
		appView.print("\nTarefa concluida! ");
	}
	
}
