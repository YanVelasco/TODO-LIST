package todo.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import todo.api.dto.TodoDTO;
import todo.api.entity.TodoEntity;
import todo.api.exceptions.TodoNotFound;
import todo.api.repository.TodoRepository;

public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntity> create(TodoDTO todoDTO) {
        var todoCreate = TodoEntity.builder()
                .name(todoDTO.name())
                .description(todoDTO.description())
                .priority(todoDTO.priority())
                .build();
        todoRepository.save(todoCreate);
        return list();
    }

    public List<TodoEntity> list() {
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }

    public List<TodoEntity> update(TodoDTO todoDTO) {
        var todoCheck = todoRepository.findById(todoDTO.id());
        if (todoCheck.isPresent()) {
            var todoUpdate = todoCheck.get();
            todoUpdate.setName(todoDTO.name());
            todoUpdate.setDescription(todoDTO.description());
            todoUpdate.setPriority(todoDTO.priority());
            todoUpdate.setRealized(todoDTO.realized());
            return list();
        } else {
            throw new TodoNotFound("Todo Not Found");
        }
    }

    public List<TodoEntity> delete(UUID id) {
        var todoDelete = todoRepository.findById(id);
        if (todoDelete.isPresent()) {
            todoRepository.deleteById(id);
            return list();
        } else {
            throw new TodoNotFound("Todo Not Found to delete");
        }
    }
}
