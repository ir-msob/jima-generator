package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service;

import com.example.myproject.common.jima.crud.base.child.ContactMediumCrudService;
import com.example.myproject.commondto.jima.child.contactmedium.ContactMedium;
import com.example.myproject.commondto.jima.child.contactmedium.ContactMediumContainer;
import com.example.myproject.commondto.jima.child.contactmedium.ContactMediumCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.contactmedium.BaseContactMediumCrudRestResource;

public interface ContactMediumCrudRestResource<DTO extends Dto & ContactMediumContainer, S extends ContactMediumCrudService<DTO>>
        extends BaseContactMediumCrudRestResource<
        <%= idClassName %>
        , User
        , ContactMedium
        , ContactMediumCriteria
        , ContactMediumContainer
        , DTO
        , S> {

}