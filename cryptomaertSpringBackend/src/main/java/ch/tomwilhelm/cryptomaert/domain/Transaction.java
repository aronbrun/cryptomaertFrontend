package ch.tomwilhelm.cryptomaert.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    double amountBTC;
    double amountCHF;
    String btcAddress;

    public Transaction(){ }
    public Transaction(double amountBTC, double amountCHF, String btcAddress){
        this.amountBTC = amountBTC;
        this.amountCHF = amountCHF;
        this.btcAddress= btcAddress;
    }
    public double getAmountBTC(){
        return this.amountBTC;
    }
    public double getAmountCHF(){
        return this.amountCHF;
    }
    public String getBtcAddress(){
        return this.btcAddress;
    }



}
