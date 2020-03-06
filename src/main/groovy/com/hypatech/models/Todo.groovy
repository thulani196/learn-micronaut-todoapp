package com.hypatech.models

import grails.gorm.annotation.Entity
import groovy.transform.CompileStatic

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@CompileStatic
@Entity
class Todo {
    @NotNull
    @Size(min=5, max=50)
    String title

    @NotNull
    @Size(min=5, max=256)
    String description

    @NotNull
    Boolean isCompleted = false
}
