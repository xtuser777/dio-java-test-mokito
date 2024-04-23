package br.com.xt.dio.java.entities;

public class Account {

    private Integer balance;

    public Account(Integer balance) {
        this.balance = balance;
    }

    public void payBankSlip(int amount) {
        validateBalance(amount);
        debit(amount);
        sendCreditForEmitter(amount);
    }

    public void validateBalance(int amount) {
        if(amount > balance) {
            throw new IllegalStateException("Saldo insuficiente");
        }
    }

    public void debit(int amount) {
        this.balance = this.balance - amount;
    }

    public void sendCreditForEmitter(int amount) {
        //envia valor para emissor do boleto

    }
}
