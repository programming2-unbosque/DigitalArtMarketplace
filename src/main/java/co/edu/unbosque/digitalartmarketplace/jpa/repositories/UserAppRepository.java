package co.edu.unbosque.digitalartmarketplace.jpa.repositories;

import co.edu.unbosque.digitalartmarketplace.jpa.entities.UserApp;

import java.util.Optional;

public interface UserAppRepository {

    Optional<UserApp> findByEmail(String email);

    Optional<UserApp> save(UserApp userApp);

}
