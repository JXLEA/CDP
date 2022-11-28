package com.jxlea.bank;

import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.bank.card.type.BankCardType;
import com.jxlea.dto.user.User;

public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);
}
