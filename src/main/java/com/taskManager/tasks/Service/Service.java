package com.taskManager.tasks.Service;

import com.taskManager.tasks.Repository.UsersTaskRepository;
import com.taskManager.tasks.model.UsersTask;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    private final UsersTaskRepository repos;
    @Autowired
    public Service(UsersTaskRepository repos){
        this.repos = repos;
    }
    public UsersTask findByTasksName(String task){
        return repos.findByTask(task);
    }
}
