package com.taskManager.tasks.Service;

import com.taskManager.tasks.Repository.UsersTaskRepository;
import com.taskManager.tasks.model.UsersTask;

@org.springframework.stereotype.Service
public class Service {
    private final UsersTaskRepository repos;
    public Service(UsersTaskRepository repos){
        this.repos = repos;
    }
    public UsersTask findByTasksName(String task){
        return repos.findByTask(task);
    }
}
