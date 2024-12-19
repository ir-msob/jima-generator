package com.example.myproject.samplemicroservice.sampledomain;

import com.example.myproject.common.jima.crud.restful.childdomain.service.CharacteristicCrudRestResource;
import com.example.myproject.common.jima.security.UserService;
import <%= domainClassPath %>;
import <%= dtoClassPath %>;
import ir.msob.jima.core.commons.operation.ConditionalOnOperation;
import ir.msob.jima.core.commons.resource.Resource;
import ir.msob.jima.core.commons.shared.ResourceType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ir.msob.jima.core.commons.operation.Operations.*;

@RestController
@RequestMapping(<%= domainClassName %>RestResource.BASE_URI)
@ConditionalOnOperation(operations = {SAVE, UPDATE_BY_ID, DELETE_BY_ID, EDIT_BY_ID, GET_BY_ID, GET_PAGE})
@Resource(value = <%= domainClassName %>.DOMAIN_NAME_WITH_HYPHEN, type = ResourceType.RESTFUL)
public class <%= domainClassName %>CharacteristicRestResource extends CharacteristicCrudRestResource<<%= dtoClassName %>, <%= domainClassName %>Service> {

    public <%= domainClassName %>CharacteristicRestResource(<%= domainClassName %>Service childService, UserService userService) {
        super(childService, userService);
    }
}
