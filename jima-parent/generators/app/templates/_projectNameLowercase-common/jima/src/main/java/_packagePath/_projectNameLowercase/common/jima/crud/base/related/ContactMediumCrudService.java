package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.contactmedium.ContactMedium;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.contactmedium.ContactMediumCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import ir.msob.jima.crud.service.related.contactmedium.BaseContactMediumCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class ContactMediumCrudService<DTO extends Dto>
        implements BaseContactMediumCrudService<
            <%= idClassName %>
            , User
            , DTO
            , ContactMedium
            , ContactMediumCriteria> {

}
