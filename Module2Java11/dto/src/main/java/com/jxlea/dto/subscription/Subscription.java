package com.jxlea.dto.subscription;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Subscription {
    private String bankcard;
    private LocalDate startDate;
}
