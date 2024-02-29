package todo.api.exceptions;

public class TodoAlreadyExists extends RuntimeException{
    public TodoAlreadyExists(String message) {
        super(message);
    }
}
