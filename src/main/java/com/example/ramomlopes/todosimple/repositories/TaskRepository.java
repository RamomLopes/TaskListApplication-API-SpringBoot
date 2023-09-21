package com.example.ramomlopes.todosimple.repositories;

import com.example.ramomlopes.todosimple.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
