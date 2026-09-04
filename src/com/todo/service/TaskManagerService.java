package com.todo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.todo.model.Task;
import com.todo.util.TaskUtilities;
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
	
	public boolean listTasks() {
		
		appView.print("\n-------- TAREFAS --------\n\n");
		
		if(tasks.isEmpty()) {
			appView.print("Sem tarefas cadastradas! ");
			return false;
		}

		for(Task task : tasks) {
			appView.print(task + "\n");
		}
		
		return true;
	}
	
	public void completeTask() {
		
		if(!listTasks())
			return;
		
		int id = appView.readTaskID();
		
		Task searchTask = TaskUtilities.searchByID(id, tasks);
		
		if(searchTask == null) {
			appView.print("\nTarefa nao encontrada! ");
			return;
		}
		
		if(searchTask.isCompleted()) {
			appView.print("Tarefa ja concluida");
			return;
		}
			
		searchTask.setCompleted(true);
		appView.print("\nTarefa concluida! ");
	}
	
	public void removeTask() {
		
		if(!listTasks())
			return;
		
		int id = appView.readTaskID();
		Task searchTask = TaskUtilities.searchByID(id, tasks);

		if(searchTask == null) {
			appView.print("\nTarefa nao encontrada! ");
			return;
		}
		
		tasks.remove(searchTask);
		appView.print("\nTarefa removida com sucesso! ");
	}
}
