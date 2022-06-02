package co.edu.unbosque.digitalartmarketplace.services;

import co.edu.unbosque.digitalartmarketplace.jpa.entities.Collection;
import co.edu.unbosque.digitalartmarketplace.jpa.entities.UserApp;
import co.edu.unbosque.digitalartmarketplace.jpa.repositories.*;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;

@Stateless
public class CollectionService {

    UserAppRepository userAppRepository;
    CollectionRepository collectionRepository;

    public Optional<Collection> save(String email, String name, String description, String category) throws Exception {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("digitalart");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        collectionRepository = new CollectionRepositoryImpl(entityManager);
        userAppRepository = new UserAppRepositoryImpl(entityManager);

        Optional<UserApp> userApp = userAppRepository.findByEmail(email);

        if (userApp.isPresent()) {

            Collection collection = new Collection(name, description, category, userApp.get());
            Optional<Collection> persistedCollection = collectionRepository.save(collection);

            entityManager.close();
            entityManagerFactory.close();

            return persistedCollection;

        } else {
            throw new Exception("User not found");
        }
    }
}
