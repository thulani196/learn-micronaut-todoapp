package com.hypatech.services

import com.hypatech.models.Todo
import grails.gorm.services.Service
import groovy.transform.CompileStatic

import javax.validation.constraints.NotNull

@CompileStatic
@Service(Todo)
abstract class TodoService {
    abstract int count()
    abstract List<Todo> findAll()
    abstract List<Todo> findAll(Map args)
    abstract Todo find(@NotNull Long id)
    abstract Todo save(Todo todo)
    abstract Todo delete(@NotNull Long id)
}
