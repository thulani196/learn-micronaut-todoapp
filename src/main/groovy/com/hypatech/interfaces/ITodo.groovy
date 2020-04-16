package com.hypatech.interfaces
import com.hypatech.domain.Todo

interface ITodo {
    Todo get(Serializable id)

    List<Todo> list(Map args)

    Long count()

    Todo save(Todo todo)

    List<Todo> findAllByIsCompleted(boolean isCompleted)

    Todo update(Long id, Todo todo)
}