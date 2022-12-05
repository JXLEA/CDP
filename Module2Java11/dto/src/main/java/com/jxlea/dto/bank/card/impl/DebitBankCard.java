package com.jxlea.dto.bank.card.impl;

import com.jxlea.dto.bank.card.type.BankCardType;
import com.jxlea.dto.user.User;

public class DebitBankCard extends AbstractBankCard {

    public DebitBankCard(User user) {
        super(user);
    }

    @Override
    public BankCardType getType() {
        return BankCardType.DEBIT;
    }
}
