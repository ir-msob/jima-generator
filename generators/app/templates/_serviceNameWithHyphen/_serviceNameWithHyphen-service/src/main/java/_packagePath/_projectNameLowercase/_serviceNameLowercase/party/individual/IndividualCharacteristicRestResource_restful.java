package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.restful.childdomain.service.CharacteristicCrudRestResource;
import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.security.UserService;
import <%= domainClassPath %>;
import <%= dtoClassPath %>;
import ir.msob.jima.core.commons.operation.ConditionalOnOperation;
import ir.msob.jima.core.commons.resource.Resource;
import ir.msob.jima.core.commons.shared.ResourceType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ir.msob.jima.core.commons.operation.Operations.*;

@RestController
@RequestMapping(IndividualRestResource.BASE_URI)
@ConditionalOnOperation(operations = {SAVE, UPDATE_BY_ID, DELETE_BY_ID, EDIT_BY_ID, GET_BY_ID, GET_PAGE})
@Resource(value = Individual.DOMAIN_NAME_WITH_HYPHEN, type = ResourceType.RESTFUL)
public class IndividualCharacteristicRestResource extends PartyCharacteristicRestResource<IndividualDto, IndividualService> {

    public IndividualCharacteristicRestResource(IndividualService childService, UserService userService) {
        super(childService, userService);
    }
}
