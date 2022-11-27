package com.jxlea.dto.subscription;

import lombok.Data;

import java.time.LocalDate;
public record Subscription(String bankcard, LocalDate startDate){}
