package com.hypatech.interfaces

import com.hypatech.domain.Branch
import io.micronaut.data.annotation.Join

import javax.validation.constraints.NotNull

interface IBranch {

    List<Branch> findAll()

    Branch save(Branch branch)
}