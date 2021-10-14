package Eli.ToDoApp;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    private final ToDoRepository repository;

    public ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    List<ToDo> getToDos() {
        return repository.findAll();
    }

    @PutMapping("/todos/{id}")
    ToDo updateToDo(@PathVariable Long id, @RequestBody ToDo newToDo) {
        return repository.findById(id)
                .map(todo -> {
                    todo.setCompleted(newToDo.getCompleted());
                    todo.setTask(newToDo.getTask());
                    return repository.save(todo);
                }).orElseGet(() -> {
                    newToDo.setId(id);
                    return repository.save(newToDo);
                });
    }

    @PostMapping("/todos/")
    ToDo addToDo(@RequestBody ToDo newToDo) {
        return repository.save(newToDo);
    }

    @Transactional
    @DeleteMapping("/todos/deleteCompleted")
    public void deleteCompleted() {
        repository.deleteByIsCompleted(true);
    }
}
