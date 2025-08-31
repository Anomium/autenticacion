package co.com.crediya.api.dto;

import java.time.LocalDateTime;

public record UserResponseDTO<T>(
        String status,
        String message,
        LocalDateTime timestamp,
        String path,
        T userDTO
) {
}
