package todo.api.dto;

import jakarta.validation.constraints.NotBlank;

public record TodoDTO(
        @NotBlank
        String name,
        @NotBlank
        String description,
        Boolean realized,
        @NotBlank
        Integer priority) {
}