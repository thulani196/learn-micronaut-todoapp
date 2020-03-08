package com.hypatech.controller

import com.hypatech.domain.Todo
import com.hypatech.service.TodoService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.reactivex.Single

import javax.inject.Inject

@Controller("/todo")
class TodoController {

    @Inject TodoService todoService

    @Post("/save")
    Single<Todo> save(@Body Todo todo){
        Single.just(todoService.save(todo))
    }

}
