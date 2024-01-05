package com.taskManager.tasks.Controller;

import com.taskManager.tasks.Repository.UsersTaskRepository;
import com.taskManager.tasks.model.UsersTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class Controller {
    @Autowired
    private UsersTaskRepository repos;
    private static List<UsersTask> tasks = new ArrayList<>();

    @PostMapping("/add")
    public ModelAndView addTask(@RequestParam String task){
        UsersTask user = new UsersTask(task);
        tasks.add(user);
        repos.saveAll(tasks);

        return new ModelAndView("redirect:/") ;
    }

    @GetMapping
    public ModelAndView tasks(ModelAndView modelAndView){
            modelAndView.setViewName("tasks");
            modelAndView.addObject("tasks",repos.findAll());
            return modelAndView;
    }
}
