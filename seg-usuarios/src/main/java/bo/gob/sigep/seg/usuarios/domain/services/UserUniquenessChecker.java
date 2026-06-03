package bo.gob.sigep.seg.usuarios.domain.services;

import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.Email;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;

public class UserUniquenessChecker {

    private final UserRepository repository;

    public UserUniquenessChecker(UserRepository repository) {
        this.repository = repository;
    }

    public void ensureEmailIsUnique(Email email) {
        if(repository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email ya registrado");
        }
    }

}
