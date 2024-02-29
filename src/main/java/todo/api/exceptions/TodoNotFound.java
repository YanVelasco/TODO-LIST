package todo.api.exceptions;

public class TodoNotFound extends RuntimeException {
    public TodoNotFound(String message) {
        super(message);
    }
}
