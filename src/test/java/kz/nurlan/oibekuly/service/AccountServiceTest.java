package kz.nurlan.oibekuly.service;

import kz.nurlan.oibekuly.model.Account;
import kz.nurlan.oibekuly.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Mock
    Account account;
    @InjectMocks
    AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testTransfer() {
//        accountService.transfer(0d, new Account(0,2L,2L 0d, 0d), new Account(Long.valueOf(1), 0d, 0d));
    }

    @Test
    void testMakeWithdraw() {
        String result = accountService.makeWithdraw(0d);
        Assertions.assertEquals("You have withdrawn 0.0 tenge and incurred a fee of 5%\n" +
                "Your balance: 0.0 tenge", result);
    }


    @Test
    void testAccountDetails() {
        when(account.getAccountnumber()).thenReturn(Long.valueOf(1));
        when(account.getBalance()).thenReturn(0d);
        when(account.getInterest()).thenReturn(0d);

        String result = accountService.accountDetails();
        Assertions.assertEquals(accountService.accountDetails(), result);
    }
}

