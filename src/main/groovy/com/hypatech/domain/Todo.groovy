package com.hypatech.domain
import grails.gorm.annotation.Entity

@Entity
class Todo {
    Long id
    String title
    String description
    Boolean isCompleted = false

    static belongsTo = [branch: Branch]

    static constraints = {
        id unique: true
        title nullable: false, unique: true
        description nullable: false
        isCompleted nullable: false
    }

    static mapping = {
        autoTimeStamp true
        table "todo"
        branch lazy: false
    }
}
