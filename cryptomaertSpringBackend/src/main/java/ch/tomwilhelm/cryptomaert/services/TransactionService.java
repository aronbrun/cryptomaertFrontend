package ch.tomwilhelm.cryptomaert.services;

import ch.tomwilhelm.cryptomaert.domain.Transaction;
import ch.tomwilhelm.cryptomaert.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Iterable<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    public Iterable<Transaction> getAllTransactions()
    {
        return this.transactionRepository.findAll();
    }

    public Transaction create(Transaction transaction){
        return  transactionRepository.save(transaction);
    }

    public Transaction getById(long id){
        Optional<Transaction> transaction = transactionRepository.findById(id);

        if(transaction.isPresent()){
            return transaction.get();
        }
        throw new RuntimeException("Id not existing");
    }
}
