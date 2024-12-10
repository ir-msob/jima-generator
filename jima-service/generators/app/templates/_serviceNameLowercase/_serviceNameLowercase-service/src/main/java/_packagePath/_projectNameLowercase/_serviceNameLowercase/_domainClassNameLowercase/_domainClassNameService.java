package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.DomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= domainClassPath %>;
import <%= dtoClassPath %>;
import <%= criteriaClassPath %>;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.commons.operation.BaseBeforeAfterDomainOperation;
import ir.msob.jima.crud.service.domain.BeforeAfterComponent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class <%= domainClassName %>Service extends DomainCrudService<<%= domainClassName %>, <%= dtoClassName %>, <%= criteriaClassName %>, <%= domainClassName %>Repository> {

    private final ModelMapper modelMapper;

    protected OrderService(BeforeAfterComponent beforeAfterComponent, ObjectMapper objectMapper, <%= domainClassName %>Repository repository, ModelMapper modelMapper) {
        super(beforeAfterComponent, objectMapper, repository);
        this.modelMapper = modelMapper;
    }

    @Override
    public <%= dtoClassName %> toDto(<%= domainClassName %> domain, User user) {
        return modelMapper.map(domain, <%= dtoClassName %>.class);
    }

    @Override
    public <%= domainClassName %> toDomain(<%= dtoClassName %> dto, User user) {
        return dto;
    }

    @Override
    public Collection<BaseBeforeAfterDomainOperation<<%= idClassName %>, User, <%= dtoClassName %>, <%= criteriaClassName %>>> getBeforeAfterDomainOperations() {
        return Collections.emptyList();
    }

}
