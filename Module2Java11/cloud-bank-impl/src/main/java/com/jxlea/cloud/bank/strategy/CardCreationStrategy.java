package com.jxlea.cloud.bank.strategy;

import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.bank.card.type.BackCardType;

public interface CardCreationStrategy {

    BankCard create(BackCardType cardType);
}
