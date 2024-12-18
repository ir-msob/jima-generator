package com.example.myproject.common.jima.crud.base.childdomain;

import com.example.myproject.commondto.jima.domain.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.service.childdomain.BaseChildDomainCrudService;

public interface ChildDomainCrudService<DTO extends Dto>
        extends BaseChildDomainCrudService<String, User, DTO> {

}