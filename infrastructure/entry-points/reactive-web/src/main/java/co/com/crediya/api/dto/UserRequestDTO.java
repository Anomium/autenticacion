package co.com.crediya.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;


@Schema(description = "Estructura de la petición para registrar un usuario")
public record UserRequestDTO (

    @Schema(description = "Nombre del usuario",
            minLength = 2,
            maxLength = 50,
            example = "Juan")
    String firstName,

    @Schema(description = "Apellido del usuario",
            minLength = 2,
            maxLength = 50,
            example = "Pérez")
    String lastName,

    @Schema(description = "Fecha de nacimiento en formato ISO 8601", example = "1990-05-15")
    LocalDate birthDate,

    @Schema(description = "Dirección de residencia", example = "Calle 123 #45-67, Bogotá")
    String address,

    @Schema(description = "Número de teléfono de contacto", example = "+57 3001234567")
    String phone,

    @Schema(description = "Correo electrónico único del usuario", example = "juan.perez@email.com")
    String email,

    @Schema(description = "Salario base en formato numérico", example = "2500.00")
    String baseSalary

) {}
