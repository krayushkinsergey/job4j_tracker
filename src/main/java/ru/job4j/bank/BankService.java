package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Банковский сервис
 * Хранит всех пользователей, с его счетами
 * @author Краюшкин Сергей
 * @version 1.0
 */
public class BankService {
    /**
     * Map пользователей со счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавить пользователя, с пустыми счетами
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удалить пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавить счет пользователю
     * @param passport паспортные данные пользователя
     * @param account Счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> listAccounts = users.get(user);
            if (!listAccounts.contains(account)) {
                listAccounts.add(account);
            }
        }
    }

    /**
     * Найти пользователя по паспорту
     * @param passport паспортные данные пользователя
     * @return Найденный пользователь
     */
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

    /**
     * Найти счет пользователя
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты счета
     * @return Найденный счет
     */
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

    /**
     * Перевести деньги с одного счета пользователя на другой счет другого пользователя
     * @param srcPassport паспортные данные пользователя с которого будем переводить
     * @param srcRequisite реквизиты счета пользователя с которого будем переводить
     * @param destPassport паспортные данные пользователя кому переводим
     * @param destRequisite реквизиты счета пользователя кому переводим
     * @param amount сколько переводим
     * @return Успешно или нет
     */
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

    /**
     * Получить список счетов пользователя
     * @param user пользователь
     * @return список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
