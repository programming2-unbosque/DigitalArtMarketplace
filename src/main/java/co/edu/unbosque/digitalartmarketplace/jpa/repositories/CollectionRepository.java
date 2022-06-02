package co.edu.unbosque.digitalartmarketplace.jpa.repositories;

import co.edu.unbosque.digitalartmarketplace.jpa.entities.Collection;

import java.util.Optional;

public interface CollectionRepository {

    Optional<Collection> save(Collection collection);

}
