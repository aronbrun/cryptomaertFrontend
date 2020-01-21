package ch.tomwilhelm.cryptomaert.controller.api.v1;

import ch.tomwilhelm.cryptomaert.domain.Transaction;
import ch.tomwilhelm.cryptomaert.domain.TransactionDto;
import ch.tomwilhelm.cryptomaert.repositories.TransactionRepository;
import ch.tomwilhelm.cryptomaert.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionController(TransactionService transactionService, TransactionRepository transactionRepository) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public Iterable<Transaction> findAll(){
        return transactionService.findAll();
    }

    @RequestMapping("/getAll")
    private Iterable<Transaction> getAll()
    {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction findById(@PathVariable long id){
        return transactionService.getById(id);
    }


    @ResponseBody
    @RequestMapping(value="/addTransaction", consumes = "application/json")
    public Transaction addTransaction(@RequestBody TransactionDto transactionDto)
    {
        Transaction transaction = new Transaction(transactionDto.getAmountBTC(), transactionDto.getAmountCHF(), transactionDto.getBtcAddress());
        return this.transactionRepository.save(transaction);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction addTask(@RequestBody Transaction task){
        return transactionService.create(task);
    }
}
