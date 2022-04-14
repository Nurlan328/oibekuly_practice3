 package kz.nurlan.oibekuly.service;

import kz.nurlan.oibekuly.model.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    Account account = new Account();
    double balance = account.getBalance();

    public void transfer(double amount, Account from, Account to) {
        if(from.balance >= amount) {
            from.balance = from.balance - amount;
            to.balance = to.balance + amount;
            System.out.println("Successfully transfered.");
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public String makeWithdraw (double amount) {

        if (amount > balance) {
            return "You have insufficient funds.";
        } else {
            balance = balance - amount - (amount * 0.05);
            return "You have withdrawn " + amount + " tenge and incurred a fee of 5%" + "\n" +
                    "Your balance: " + balance + " tenge";
        }
    }

    public String accountDetails() {
        return "Account information: " +'\n' +
                "Account number: " + account.getAccountnumber() + '\n' +
                "Balance: " + account.getBalance() + '\n' +
                "Interest: " + account.getInterest() + '\n';
    }

}
