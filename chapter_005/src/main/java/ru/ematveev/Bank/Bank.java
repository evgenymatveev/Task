package ru.ematveev.Bank;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Class for work the operations of user.
 */
public class Bank {
    private Map<User, List<Account>> map = new HashMap<>();

    public Map<User, List<Account>> getMap() {
        return map;
    }

    /**
     * Method add new user in the Map.
     *
     * @param user new user.
     */
    public void addUser(User user) {
        if (user != null) {
            map.put(user, new ArrayList<>());
        }
    }

    /**
     * Method removes the user from Map.
     *
     * @param user user for remove.
     */
    public void deleteUser(User user) {
        if (map.containsKey(user)) {
            map.remove(user);
        }
    }

    /**
     * Method for add new account for user.
     *
     * @param user    user.
     * @param account account for add.
     */
    public void addAccountToUser(User user, Account account) {
        if (map.containsKey(user)) {
            map.get(user).add(account);
        }
    }

    /**
     * Method for remove account from user.
     *
     * @param user    user.
     * @param account account for remove.
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> list = map.get(user);
        ListIterator<Account> it = list.listIterator();
        while (it.hasNext()) {
            Account item = it.next();
            if (item.equals(account)) {
                it.remove();
            }
        }
    }

    /**
     * Method for get all accaunts of user.
     *
     * @param user user.
     * @return list of accaunt.
     */
    public List<Account> getUserAccounts(User user) {
        List<Account> list = new ArrayList<>();
            if (map.containsKey(user)) {
                list = map.get(user);
            }
        return list;
    }

    /**
     * Method transfer money between accounts.
     *
     * @param srcUser    user from whose account you need to transfer money.
     * @param srcAccount account from which you need to transfer money.
     * @param dstUser    user who needs to transfer money.
     * @param dstAccount account to transfer money to.
     * @param amount     the amount that needs to be transported.
     * @return true if the amount turned out to be transferred and false if no.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser,
                                 Account dstAccount, double amount) {
        List<Account> list = map.get(srcUser);
        List<Account> list2 = map.get(dstUser);
        for (Account acc : list) {
            if (acc.equals(srcAccount) && acc.getValue() > amount) {
                for (Account acc2 : list2) {
                    if (acc2.equals(dstAccount)) {
                        int newValueSrcUser = (int) (acc.getValue() - amount);
                        acc.setValue(newValueSrcUser);
                        int newValueDstUser = (int) (acc2.getValue() - amount);
                        acc2.setValue(newValueDstUser);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
