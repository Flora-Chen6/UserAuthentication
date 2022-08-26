package com.login.demo.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationService {

    private final ConfirmationRepository confirmationRepository;

    public void saveConfirmation(Confirmation token) {
        confirmationRepository.save(token);
    }
    public Optional<Confirmation> getToken(String token) {
        return confirmationRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
