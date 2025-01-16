package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.restful.domain.service.DomainCrudRestResource;
import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.security.UserService;
import <%= domainClassPath %>;
import <%= criteriaClassPath %>;
import <%= dtoClassPath %>;
import ir.msob.jima.core.commons.operation.ConditionalOnOperation;
import ir.msob.jima.core.commons.resource.Resource;
import ir.msob.jima.core.commons.shared.ResourceType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ir.msob.jima.core.commons.operation.Operations.*;

public class PartyRestResource<P extends Party, PDTO extends PartyDto, PC extends PartyCriteria, PR extends PartyRepository, PS extends PartyService> extends DomainCrudRestResource<P, PDTO, PC, PR, PS> {

    protected PartyRestResource(UserService userService, PS service) {
        super(userService, service);
    }
}
