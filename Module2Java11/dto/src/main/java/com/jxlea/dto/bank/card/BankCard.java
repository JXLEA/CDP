package com.jxlea.dto.bank.card;

import com.jxlea.dto.bank.card.type.BankCardType;
import com.jxlea.dto.user.User;

public interface BankCard {

    BankCardType getType();

    User getUser();

    String getNumber();

}
