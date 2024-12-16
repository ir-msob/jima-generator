package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service;

import com.example.myproject.common.jima.crud.base.child.ObjectValidationCrudService;
import com.example.myproject.commondto.jima.child.objectvalidation.ObjectValidation;
import com.example.myproject.commondto.jima.child.objectvalidation.ObjectValidationContainer;
import com.example.myproject.commondto.jima.child.objectvalidation.ObjectValidationCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.objectvalidation.BaseObjectValidationCrudRestResource;

public interface ObjectValidationCrudRestResource<DTO extends Dto & ObjectValidationContainer, S extends ObjectValidationCrudService<DTO>>
        extends BaseObjectValidationCrudRestResource<
        <%= idClassName %>
        , User
        , ObjectValidation
        , ObjectValidationCriteria
        , ObjectValidationContainer
        , DTO
        , S> {

}