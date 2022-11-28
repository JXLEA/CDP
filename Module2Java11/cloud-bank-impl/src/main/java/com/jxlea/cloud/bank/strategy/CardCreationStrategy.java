package com.jxlea.cloud.bank.strategy;

import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.bank.card.type.BankCardType;
import com.jxlea.dto.user.User;

public interface CardCreationStrategy {

    BankCard create(User user, BankCardType cardType);
}
