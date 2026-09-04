package com.todo.util;

import java.util.List;
import java.util.Optional;

import com.todo.model.Task;

public final class TaskUtilities {

	public static Task searchByID(int id, List<Task> tasks) {
		
		Optional<Task> optTask = tasks.stream().filter(task -> task.getId() == id)
				.findFirst();

		return optTask.orElse(null);
	
	}
}
