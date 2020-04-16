package com.hypatech.service

import com.hypatech.domain.Branch
import com.hypatech.interfaces.IBranch
import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Service(Branch)
abstract class BranchService implements IBranch {

    @Transactional
    List<Branch> findAll(){
        return Branch.findAll()
    }

    @Transactional
    Branch save(Branch branch) {
        branch.save()
    }

}
