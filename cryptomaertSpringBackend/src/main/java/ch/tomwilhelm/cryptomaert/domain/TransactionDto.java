package ch.tomwilhelm.cryptomaert.domain;

import lombok.Data;


@Data
public class TransactionDto {
    double amountBTC;
    double amountCHF;
    String btcAddress;

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
