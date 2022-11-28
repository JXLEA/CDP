package com.jxlea.dto.bank.card;

import com.jxlea.dto.user.User;

public abstract class AbstractBankCard implements BankCard {
    private String number;
    private User user;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public String getNumber() {
        return number;
    }
}
