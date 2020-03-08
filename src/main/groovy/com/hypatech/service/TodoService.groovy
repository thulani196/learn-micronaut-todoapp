package com.hypatech.service

import com.hypatech.domain.Todo
import grails.gorm.services.Service
import groovy.transform.CompileStatic

@Service(Todo)
@CompileStatic
interface TodoService {
    Todo get(Serializable id)

    List<Todo> list(Map args)

    Long count()

    Todo save(Todo todo)
}
