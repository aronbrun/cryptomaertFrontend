package ch.tomwilhelm.cryptomaert.repositories;

import ch.tomwilhelm.cryptomaert.domain.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
