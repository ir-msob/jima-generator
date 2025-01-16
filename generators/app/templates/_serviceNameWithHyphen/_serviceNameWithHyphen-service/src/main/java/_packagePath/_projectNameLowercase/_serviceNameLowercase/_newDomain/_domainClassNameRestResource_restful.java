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

@RestController
@RequestMapping(<%= domainClassName %>RestResource.BASE_URI)
@ConditionalOnOperation(operations = {SAVE, UPDATE_BY_ID, DELETE_BY_ID, EDIT_BY_ID, GET_BY_ID, GET_PAGE})
@Resource(value = <%= domainClassName %>.DOMAIN_NAME_WITH_HYPHEN, type = ResourceType.RESTFUL)
public class <%= domainClassName %>RestResource extends DomainCrudRestResource<<%= domainClassName %>, <%= dtoClassName %>, <%= criteriaClassName %>, <%= domainClassName %>Repository, <%= domainClassName %>Service> {
    public static final String BASE_URI = "/api/v1/" +<%= domainClassName %>.DOMAIN_NAME_WITH_HYPHEN;

    protected <%= domainClassName %>RestResource(UserService userService, <%= domainClassName %>Service service) {
        super(userService, service);
    }
}
