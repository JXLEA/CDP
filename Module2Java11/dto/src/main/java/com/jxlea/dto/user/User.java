package com.jxlea.dto.user;

import lombok.Data;

import java.time.LocalDate;

public record User(String name, String surname, LocalDate birthday) {
}
