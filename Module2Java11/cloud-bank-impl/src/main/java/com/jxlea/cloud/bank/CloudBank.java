package com.jxlea.cloud.bank;

import com.jxlea.bank.Bank;
import com.jxlea.cloud.bank.strategy.CardCreationStrategy;
import com.jxlea.cloud.bank.strategy.DefaultCardCreationStrategy;
import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.bank.card.type.BankCardType;
import com.jxlea.dto.user.User;

public class CloudBank implements Bank {

    private final CardCreationStrategy cardCreationStrategy;

    public CloudBank() {
        cardCreationStrategy = new DefaultCardCreationStrategy();
    }

    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        return cardCreationStrategy.create(user, bankCardType);
    }
}

