package com.hypatech.controller

import com.hypatech.domain.Todo
import com.hypatech.service.TodoService
import groovy.transform.CompileStatic
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.hateoas.JsonError
import io.micronaut.security.annotation.Secured
import io.reactivex.Single
import javax.inject.Inject

@Secured("isAuthenticated()")
@Controller("/todo")
class TodoController {

    @Inject TodoService _todoService

    @Post("/")
    Single<Todo> save(@Body Todo todo){
        Single.just(_todoService.save(todo)).onErrorReturn({
            throwable -> new JsonError(throwable.message)
        })
    }

    @Get("/")
    Single<HttpResponse<?>> list(){
        Single.just(_todoService.list()).map({result ->
            HttpResponse.ok(result)
        })onErrorReturn({ throwable ->
            new JsonError(throwable.message)
        })
    }

    @Get("/{id}")
    Single<Todo> getById(Long id){
        Single.just(_todoService.get(id))
                .onErrorReturn({error -> new JsonError(error.message)})
    }

    @Get("/completed/{status}")
    Single<HttpResponse<?>> findAllByIsCompleted(boolean status) {
        Single.just(_todoService.findAllByIsCompleted(status))
                .map({results -> HttpResponse.ok(results)})
                .onErrorReturn({error -> new JsonError(error.message)})
    }

    @Put("/update/{id}")
    Single<Todo> update(Long id, @Body Todo todo) {
        Single.just(_todoService.update(id, todo))
                .onErrorReturn({error -> new JsonError(error.message)})
    }

}
