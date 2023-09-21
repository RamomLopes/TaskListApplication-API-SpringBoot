package com.example.ramomlopes.todosimple.services;

import com.example.ramomlopes.todosimple.models.Task;
import com.example.ramomlopes.todosimple.models.User;
import com.example.ramomlopes.todosimple.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;

    public Task findById(Long id){
        Task task = this.taskRepository.findById(id).get();
        return task;
    }

    @Transactional
    public Task create(Task obj){
        User user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.taskRepository.save(obj);
        return obj;
    }

    @Transactional
    public Task update(Task obj){
        Task newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.taskRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Não é possível excluir");
        }
    }
}