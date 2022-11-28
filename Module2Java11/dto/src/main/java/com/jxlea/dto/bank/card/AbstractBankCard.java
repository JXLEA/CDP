package com.jxlea.dto.bank.card;

import com.jxlea.dto.user.User;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractBankCard implements BankCard {
    private final String number;
    private final User user;

    public AbstractBankCard(User user) {
        this.number = generateCardNumber();
        this.user = user;
    }

    private String generateCardNumber() {
        return String.format("%S %S %S %S", generateQuarter(), generateQuarter(), generateQuarter(), generateQuarter());
    }

    private Integer generateQuarter() {
        return ThreadLocalRandom.current().nextInt(1000, 9999);
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public String getNumber() {
        return number;
    }
}
