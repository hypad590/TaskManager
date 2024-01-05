package com.taskManager.tasks;

import com.taskManager.tasks.Repository.UsersTaskRepository;
import com.taskManager.tasks.model.UsersTask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TasksApplicationTests {

	@Test
	public void Test() {
		test t = new test();
		ResponseEntity<String> res = t.addTask("Cook");

		assertEquals(HttpStatus.OK, res.getStatusCode());

		assertEquals("Task added successfully!",res.getBody());
	}

}
class test{
	private UsersTaskRepository repos;
	private static List<UsersTask> tasks = new ArrayList<>();

	@PostMapping("/tasks")
	public ResponseEntity<String> addTask(@RequestParam(value = "task", defaultValue = "NoTasks") String task){
		UsersTask user = new UsersTask(task);
		tasks.add(user);
		return ResponseEntity.ok("Task added successfully!");
	}

}
