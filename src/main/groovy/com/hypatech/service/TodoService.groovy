package com.hypatech.service

import com.hypatech.domain.Todo
import com.hypatech.interfaces.ITodo
import grails.gorm.services.Service
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic

@Service(Todo)
abstract class TodoService implements ITodo {

    @Override
    @Transactional
    List<Todo> findAllByIsCompleted(boolean isCompleted) {
        def todos = Todo.where { isCompleted == isCompleted}
        def results  = todos.list {
            order ('title', 'desc')
        }
        return results
    }

    @Override
    @Transactional
    Todo update(Long id, Todo todo){
        def thisTodo = Todo.findById(id)

        thisTodo.title = todo.title
        thisTodo.description = todo.description
        thisTodo.isCompleted = todo.isCompleted
        thisTodo.branch = todo.branch

        thisTodo.save(flush: true)
    }

}
