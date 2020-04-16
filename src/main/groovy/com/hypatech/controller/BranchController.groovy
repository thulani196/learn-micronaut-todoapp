package com.hypatech.controller

import com.hypatech.domain.Branch
import com.hypatech.service.BranchService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import org.springframework.transaction.annotation.Transactional

import javax.inject.Inject
import javax.validation.constraints.NotNull

@Controller("/branch")
class BranchController {

    @Inject BranchService branchService

    @Get("/")
    List<Branch> findAll() {
        branchService.findAll()
    }

    @Post("/")
    Branch save(@Body @NotNull Branch branch) {
        branchService.save(branch)
    }
}
