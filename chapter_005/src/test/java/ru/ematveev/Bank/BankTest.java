package ru.ematveev.Bank;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class test the methods of class the Bank.
 */
public class BankTest {
    private Bank bank;
    private User user1;
    private User user2;
    private Account account1;
    private Account account2;

    /**
     * Method for start the parametres for tests.
     * @throws Exception Exception.
     */
    @Before
        public void setUp() throws Exception {
        bank = new Bank();
        user1 = new User("evgen", "111");
        user2 = new User("slava", "222");
        account1 = new Account(100, 444444);
        account2 = new Account(200, 555555);
        }

    /**
     * Method tests the addition of new Users.
     * @throws Exception Exception.
     */
    @Test
    public void testAddUser() throws Exception {
        bank.addUser(user1);
        assertTrue(bank.getMap().containsKey(user1));
    }
    /**
     * Method tests the removes of Users.
     * @throws Exception Exception.
     */
    @Test
    public void testDeleteUser() throws Exception {
        bank.addUser(user1);
        bank.deleteUser(user1);
        assertFalse(bank.getMap().containsKey(user1));

    }

    /**
     * Method tests the addition User account.
     * @throws Exception Exception.
     */
    @Test
    public void testAddAccountToUser() throws Exception {
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user1, account2);
        List<Account> actualvalue = bank.getMap().get(user1);
        List<Account> expectedvalue = new ArrayList<>(Arrays.asList(account1, account2));
        assertThat(actualvalue, is(expectedvalue));
    }
    /**
     * Method tests the remove User account.
     * @throws Exception Exception.
     */
    @Test
    public void testDeleteAccountFromUser() throws Exception {
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user1, account2);
        bank.deleteAccountFromUser(user1, account2);
        List<Account> actualvalue = bank.getUserAccounts(user1);
        List<Account> expectedvalue = new ArrayList<>(Arrays.asList(account1));
        assertThat(actualvalue, is(expectedvalue));
    }

    /**
     * Method get all the User account.
     * @throws Exception Exception.
     */
    @Test
    public void testGetUserAccounts() throws Exception {
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user1, account2);
        List<Account> actualvalue = bank.getUserAccounts(user1);
        List<Account> expectedvalue = new ArrayList<>(Arrays.asList(account1, account2));
        assertThat(actualvalue, is(expectedvalue));
    }

    /**
     * Method check move the money between accounts when the Users account value more than amount.
     * @throws Exception Exception.
     */
    @Test
    public void testTransferMoneyWhenGetValueAccountMoreAmount() throws Exception {
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user2, account2);
        boolean actualvalue = bank.transferMoney(user1, account1, user2, account2, 10.0);
        assertTrue(actualvalue);
    }
    /**
     * Method check move the money between accounts when the Users account value less than amount.
     * @throws Exception Exception.
     */
    @Test
    public void testTransferMoneyWhenGetValueAccountLessAmount() throws Exception {
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user2, account2);
        boolean actualvalue = bank.transferMoney(user1, account1, user2, account2, 150.0);
        assertFalse(actualvalue);
    }

}