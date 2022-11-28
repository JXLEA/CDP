package com.jxlea.dto.bank.card;

import com.jxlea.dto.bank.card.type.BackCardType;
import com.jxlea.dto.user.User;

public interface BankCard {

    BackCardType getType();

    User getUser();

    String getNumber();

}
