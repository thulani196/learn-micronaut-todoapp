package com.hypatech.domain
import grails.gorm.annotation.Entity

@Entity
class Branch {
    String name

    static mapping = {
        table "branch"
    }
}
