package dev.alm.aopdemo.dao;

import dev.alm.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;
    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass().getSimpleName() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass().getSimpleName() + ": "+ name);
        return name;
    }
    public void setName(String name) {
        this.name = name;
        System.out.println(getClass().getSimpleName() + ": "+ name);
    }
    public String getServiceCode() {
        System.out.println(getClass().getSimpleName() + ": "+ serviceCode);
        return serviceCode;
    }
    public void setServiceCode(String serviceCode) {

        this.serviceCode = serviceCode;
        System.out.println(getClass().getSimpleName() + ": "+ serviceCode);
    }
}
