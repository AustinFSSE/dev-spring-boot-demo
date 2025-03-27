package dev.alm.aopdemo.dao;

import dev.alm.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addSillyAccount() {
        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING A Membership ACCOUNT");
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass().getSimpleName() + ": Member is going to sleep");
    }

}
