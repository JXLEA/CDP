package com.jxlea.cloud.bank.strategy;

import com.jxlea.cloud.bank.factory.CardFactory;
import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.bank.card.type.BankCardType;
import com.jxlea.dto.user.User;

public class DefaultCardCreationStrategy implements CardCreationStrategy {

    @Override
    public BankCard create(User user, BankCardType cardType) {
        return switch (cardType) {
            case DEBIT -> CardFactory.createDebit(user);
            case CREDIT -> CardFactory.createCredit(user);
        };
    }
}
