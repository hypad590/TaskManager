package com.taskManager.tasks.Repository;

import com.taskManager.tasks.model.UsersTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersTaskRepository extends MongoRepository<UsersTask,String> {
    UsersTask findByTask(String task);
}
