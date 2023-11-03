package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> listAccounts = users.get(user);
            if (!listAccounts.contains(account)) {
                listAccounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User userfind = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                userfind = user;
                break;
            }
        }
        return userfind;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account accountFind = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> listAccounts = users.get(user);
            for (Account account : listAccounts) {
                if (account.getRequisite().equals(requisite)) {
                    accountFind = account;
                    break;
                }
            }
        }
        return accountFind;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
