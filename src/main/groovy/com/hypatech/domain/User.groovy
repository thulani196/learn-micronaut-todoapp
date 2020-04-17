package com.hypatech.domain

import grails.gorm.annotation.Entity
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Entity
class User {
    @Id
    @GeneratedValue
    Long id
    String username;
    private String password;

    @Builder.Default
    private String role = "VIEW";
}
