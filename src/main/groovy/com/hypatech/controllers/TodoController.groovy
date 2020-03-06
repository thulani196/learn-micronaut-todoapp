package com.hypatech.controllers

import groovy.transform.CompileStatic
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@CompileStatic
@Controller("/todo")
class TodoController {

    @Get("/")
    HttpStatus index(){
        return HttpStatus.OK
    }
}