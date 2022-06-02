package co.edu.unbosque.digitalartmarketplace.jpa.repositories;

import co.edu.unbosque.digitalartmarketplace.jpa.entities.UserApp;

import jakarta.persistence.EntityManager;

import java.util.Optional;

public class UserAppRepositoryImpl implements UserAppRepository {

    private EntityManager entityManager;

    public UserAppRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<UserApp> findByEmail(String email) {
        UserApp userApp = entityManager.find(UserApp.class, email);
        return userApp != null ? Optional.of(userApp) : Optional.empty();
    }

    @Override
    public Optional<UserApp> save(UserApp userApp) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userApp);
            entityManager.getTransaction().commit();

            return Optional.of(userApp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
