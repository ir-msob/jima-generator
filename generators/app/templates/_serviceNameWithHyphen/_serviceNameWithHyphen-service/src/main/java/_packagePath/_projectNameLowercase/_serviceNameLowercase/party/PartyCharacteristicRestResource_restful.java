package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.restful.childdomain.service.CharacteristicCrudRestResource;
import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.security.UserService;
import <%= domainClassPath %>;
import <%= dtoClassPath %>;


public class PartyCharacteristicRestResource<PDTO extends PartyDto, PS extends PartyService> extends CharacteristicCrudRestResource<PDTO, PS> {

    public PartyCharacteristicRestResource(PS partyService, UserService userService) {
        super(partyService, userService);
    }
}
