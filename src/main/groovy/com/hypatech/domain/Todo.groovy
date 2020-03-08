package com.hypatech.domain

import grails.gorm.annotation.Entity
import org.hibernate.dialect.Dialect

@Entity
class Todo {
    Long id
    String title
    String description
    Boolean isCompleted = false

    static constraints = {
        id unique: true
        title nullable: false
        description nullable: false
        isCompleted nullable: false
    }

    static mapping = {
        autoTimeStamp true
        table "todo"
    }
}
