package com.jxlea.dto.user;


import java.time.LocalDate;

public record User(String name, String surname, LocalDate birthday) {
}
