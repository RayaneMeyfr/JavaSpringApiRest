package org.example.exo5.service;

import org.example.exo5.dto.RegisterRequestDto;
import org.example.exo5.entity.UserApp;
import org.example.exo5.exception.UserAlreadyExistException;
import org.example.exo5.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAppService {

    private final UserAppRepository userAppRepository;
    public UserAppService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    public UserApp enregistrerUtilisateur(RegisterRequestDto registerRequestDto) throws UserAlreadyExistException {
        Optional<UserApp> userAppOptional = userAppRepository.findByEmail(registerRequestDto.getEmail());
        // public UserApp(String firstName, String lastName, String email, String phone, String password, int role)
        if(userAppOptional.isEmpty()){
            // L'email n'est pas deja presente en bdd j'enregistre ce nouvelle user
            UserApp userApp = new UserApp(
                    registerRequestDto.getEmail(),
                    registerRequestDto.getPassword(),
                    registerRequestDto.getRole());
            return userAppRepository.save(userApp);
        }
        // email present en bdd je ne peux enregistrer ce nouvelle utilisateur
        throw new UserAlreadyExistException();
    }
}
