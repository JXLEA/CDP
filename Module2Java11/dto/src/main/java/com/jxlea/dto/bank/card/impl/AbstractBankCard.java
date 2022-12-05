package com.jxlea.dto.bank.card.impl;

import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.user.User;
import lombok.ToString;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToString
public abstract class AbstractBankCard implements BankCard {
    private final String number;
    private final User user;

    public AbstractBankCard(User user) {
        this.number = generateCardNumber();
        this.user = user;
    }

    private String generateCardNumber() {
        return String.format("%S", generateQuarter());
    }

    private String generateQuarter() {
        return Stream.generate(() -> ThreadLocalRandom.current().nextInt(1000, 9999))
                .limit(4)
                .map(Objects::toString)
                .collect(Collectors.joining(" "));
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
