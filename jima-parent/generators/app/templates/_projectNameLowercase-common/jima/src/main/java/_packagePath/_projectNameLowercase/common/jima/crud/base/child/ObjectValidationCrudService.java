package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child;

import com.example.myproject.commondto.jima.child.objectvalidation.ObjectValidation;
import com.example.myproject.commondto.jima.child.objectvalidation.ObjectValidationContainer;
import com.example.myproject.commondto.jima.child.objectvalidation.ObjectValidationCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.service.child.objectvalidation.BaseObjectValidationCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class ObjectValidationCrudService<DTO extends Dto & ObjectValidationContainer>
        implements BaseObjectValidationCrudService<
        <%= idClassName %>
        , User
        , ObjectValidation
        , ObjectValidationCriteria
        , ObjectValidationContainer
        , DTO
        > {

}