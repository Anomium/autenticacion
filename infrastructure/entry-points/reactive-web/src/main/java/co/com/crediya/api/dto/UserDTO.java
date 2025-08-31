package co.com.crediya.api.dto;

import java.time.LocalDate;

public record UserDTO(
        String firstName,
        String lastName,
        LocalDate birthDate,
        String address,
        String phone,
        String email,
        String baseSalary
) {

}
