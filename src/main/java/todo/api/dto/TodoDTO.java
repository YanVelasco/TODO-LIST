package todo.api.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record TodoDTO(
        UUID id,
        @NotBlank
        String name,
        @NotBlank
        String description,
        Boolean realized,
        @NotBlank
        Integer priority) {
}