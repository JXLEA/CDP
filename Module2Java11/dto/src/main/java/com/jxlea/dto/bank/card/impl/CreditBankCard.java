package com.jxlea.dto.bank.card.impl;

import com.jxlea.dto.bank.card.AbstractBankCard;
import com.jxlea.dto.bank.card.type.BackCardType;

public class CreditBankCard extends AbstractBankCard {
    @Override
    public BackCardType getType() {
        return BackCardType.CREDIT;
    }
}
