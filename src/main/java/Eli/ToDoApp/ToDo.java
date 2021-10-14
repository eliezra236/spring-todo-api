package Eli.ToDoApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ToDo {
    private @Id @GeneratedValue Long Id;
    private String task;
    private Boolean isCompleted;

    public ToDo(String task) {
        this.task = task;
        this.isCompleted = false;
    }

    public ToDo() {}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDo)) return false;
        ToDo toDo = (ToDo) o;
        return Objects.equals(Id, toDo.Id) && Objects.equals(task, toDo.task) && Objects.equals(isCompleted, toDo.isCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, task, isCompleted);
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "Id=" + Id +
                ", task='" + task + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
