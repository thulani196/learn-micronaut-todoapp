package com.hypatech.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import grails.gorm.annotation.Entity
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Entity
class User {
    @Id
    @GeneratedValue
    Long id
    String username

    String fullname

    @JsonIgnore
    private String password

    @Builder.Default
    @JsonIgnore
    private String role = "VIEW"

    static constraints = {
        username unique: true
    }
}
