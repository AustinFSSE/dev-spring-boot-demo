package dev.alm.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addSillyAccount() {
        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING A Membership ACCOUNT");
    }

}
