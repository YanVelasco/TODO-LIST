package todo.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import todo.api.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, UUID> {
}
