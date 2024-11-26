package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import ir.msob.jima.core.commons.operation.BaseBeforeAfterDomainOperation;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.CrudService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import <%= domainClassPath %>;
import <%= dtoClassPath %>;
import <%= criteriaClassPath %>;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class <%= domainClassName %>Service extends CrudService<<%= domainClassName %>, <%= dtoClassName %>, <%= criteriaClassName %>, <%= domainClassName %>Repository> {

    private final ModelMapper modelMapper;

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
