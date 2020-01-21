package ch.tomwilhelm.cryptomaert.bootstrap;

import ch.tomwilhelm.cryptomaert.domain.Transaction;
import ch.tomwilhelm.cryptomaert.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("localDev")
@Component
public class Initial implements CommandLineRunner {

    private final TransactionRepository transactionRepository;

    @Autowired // Optional
    public Initial(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
         Transaction transaction1 = new Transaction(0.356D, 253.254D, "3546354gsdfgsdfg234521245555");
         Transaction transaction2 = new Transaction(0.356D, 253.254D, "3546354gsdfgsdfg234521245555");
         transactionRepository.save(transaction1);
         transactionRepository.save(transaction2);

    }
}
