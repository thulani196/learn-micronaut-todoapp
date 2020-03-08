package com.hypatech.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import grails.gorm.annotation.Entity
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id


@Entity
class Branch {
    @Id
    Long id


    String name
    Date created_at
    Date updated_at

    static constraints = {
        name nullable: false
    }

    static mapping = {
        autoTimestamp true
        table 'branches'
    }
}
