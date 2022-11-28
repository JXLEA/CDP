package com.jxlea.cloud.bank.strategy;

import com.jxlea.cloud.bank.factory.CardFactory;
import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.bank.card.type.BackCardType;

public class DefaultCardCreationStrategy implements CardCreationStrategy {

    @Override
    public BankCard create(BackCardType cardType) {
        return switch (cardType) {
            case DEBIT -> CardFactory.createDebit();
            case CREDIT -> CardFactory.createCredit();
        };
    }
}
