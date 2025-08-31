package co.com.crediya.model.user;

import co.com.crediya.model.user.exception.ExceptionDuplicity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static co.com.crediya.model.user.ValidadorArgumento.validarRegex;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private String phone;
    private String email;
    private String baseSalary;

    public User(String firstName, String lastName, LocalDate birthDate, String address, String phone, String email, String baseSalary) {

        validarRegex(firstName, "^[A-Za-z]{1,100}$","El nombre no puede estar vacio, o superaste el limite, porfavor revisar el valor ingresado.");
        validarRegex(lastName, "^[A-Za-z]{1,100}$","El apellido no puede estar vacio, o superaste el limite, porfavor revisar el valor ingresado.");
        validarRegex(email, "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", "El correo no puede estar vacio, Y debe de tener un formato válido, porfavor revisar el valor ingresado.");
        validarRegex(baseSalary, "^(0|[1-9][0-9]{0,6}|1[0-4][0-9]{6}|15000000)$", "El salario no puede estar vacio, o superaste el limite, porfavor revisar el valor ingresado.");
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.baseSalary = baseSalary;
    }


    public void validarDuplicidadEmail(String emailExistente) {
        if (this.email.equals(emailExistente)) {
            throw new ExceptionDuplicity("El email ya existe en el sistema");
        }
    }

}
