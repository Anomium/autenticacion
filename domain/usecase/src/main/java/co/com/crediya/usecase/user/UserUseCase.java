package co.com.crediya.usecase.user;

import co.com.crediya.model.user.User;
import co.com.crediya.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;

    public Mono<User> saveUser(User user){
        return userRepository.findByEmail(user.getEmail())
                .flatMap(userFound -> Mono.fromCallable(() ->{
                    user.validarDuplicidadEmail(userFound.getEmail());
                    return user;
                }))
                .switchIfEmpty(userRepository.save(user));

    }

}
