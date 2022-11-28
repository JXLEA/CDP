package com.jxlea.dto.bank.card.impl;

import com.jxlea.dto.bank.card.AbstractBankCard;
import com.jxlea.dto.bank.card.type.BankCardType;
import com.jxlea.dto.user.User;

public class CreditBankCard extends AbstractBankCard {

    public CreditBankCard(User user) {
        super(user);
    }

    @Override
    public BankCardType getType() {
        return BankCardType.CREDIT;
    }
}
