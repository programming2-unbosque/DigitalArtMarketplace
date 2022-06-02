package co.edu.unbosque.digitalartmarketplace.jpa.repositories;

import co.edu.unbosque.digitalartmarketplace.jpa.entities.WalletHistory;

import java.util.Optional;

public interface WalletHistoryRepository {

    Optional<WalletHistory> save(WalletHistory walletHistory);

}
