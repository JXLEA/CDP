package com.jxlea.dto.bank.card;

import com.jxlea.dto.user.User;
import lombok.Data;

@Data
public abstract class AbstractBankCard implements BankCard {
    private String number;
    private User user;
}
