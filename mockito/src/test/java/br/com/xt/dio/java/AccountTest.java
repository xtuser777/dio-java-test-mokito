package br.com.xt.dio.java;

import br.com.xt.dio.java.entities.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountTest {
    
    @Spy
    private Account account = new Account(3000);
    
    @Test
    void verifyDebitCall() {
        account.payBankSlip(300);
        Mockito.verify(account).debit(300);
    }
    
    @Test
    void verifyNothingCall() {
        Mockito.verifyNoInteractions(account);
    }
    
    @Test
    void verifyCallOrder() {
        InOrder inOrder = Mockito.inOrder(account);
        account.payBankSlip(300);
        account.debit(300);
        account.sendCreditForEmitter(300);
        inOrder.verify(account).payBankSlip(300);
        inOrder.verify(account).debit(300);
        inOrder.verify(account).sendCreditForEmitter(300);
    }
    
    @Test
    void validateCallCount() {
        account.validateBalance(100);
        account.validateBalance(100);
        account.validateBalance(100);

        Mockito.verify(account, Mockito.times(3)).validateBalance(100);
    }
}
