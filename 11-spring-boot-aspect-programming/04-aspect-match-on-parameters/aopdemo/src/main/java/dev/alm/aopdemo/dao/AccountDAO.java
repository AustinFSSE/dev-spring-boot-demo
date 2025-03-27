package dev.alm.aopdemo.dao;

import dev.alm.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);
}
