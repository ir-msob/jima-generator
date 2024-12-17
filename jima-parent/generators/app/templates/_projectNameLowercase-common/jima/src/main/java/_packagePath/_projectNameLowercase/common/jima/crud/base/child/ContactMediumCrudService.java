package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child;

import com.example.myproject.commondto.jima.child.contactmedium.ContactMedium;
import com.example.myproject.commondto.jima.child.contactmedium.ContactMediumContainer;
import com.example.myproject.commondto.jima.child.contactmedium.ContactMediumCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.service.child.contactmedium.BaseContactMediumCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ContactMediumCrudService<DTO extends Dto & ContactMediumContainer>
        extends BaseContactMediumCrudService<
        <%= idClassName %>
        , User
        , ContactMedium
        , ContactMediumCriteria
        , ContactMediumContainer
        , DTO
        > {

}