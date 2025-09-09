package co.com.crediya.api.factory;

import co.com.crediya.api.dto.UserDTO;
import co.com.crediya.api.dto.UserRequestDTO;
import co.com.crediya.api.dto.UserResponseDTO;
import co.com.crediya.model.user.User;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserFactory {

    public static final String USUARIO_REGISTRADO_CORRECTAMENTE = "Usuario registrado correctamente.";

    public User createUserRequestDtoToUser(UserRequestDTO userRequestDTO) {
        return new User(
                userRequestDTO.firstName(),
                userRequestDTO.lastName(),
                userRequestDTO.birthDate(),
                userRequestDTO.address(),
                userRequestDTO.phone(),
                userRequestDTO.email(),
                userRequestDTO.baseSalary()
        );
    }

    public UserResponseDTO<UserDTO> createUserToUserDTO(User user) {
        var userDto = new UserDTO(user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getAddress(),
                user.getPhone(),
                user.getEmail(),
                user.getBaseSalary());

        return new UserResponseDTO<>(
                HttpStatus.OK.toString(),
                USUARIO_REGISTRADO_CORRECTAMENTE,
                LocalDateTime.now(),
                "",
                userDto
        );
    }

}
