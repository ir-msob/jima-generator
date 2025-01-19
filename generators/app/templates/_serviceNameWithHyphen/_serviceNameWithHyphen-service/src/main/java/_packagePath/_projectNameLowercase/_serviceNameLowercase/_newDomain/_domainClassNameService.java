package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.base.childdomain.ChildDomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.base.domain.DomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.service.IdService;
import <%= criteriaClassPath %>;
import <%= domainClassPath %>;
import <%= dtoClassPath %>;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.commons.id.BaseIdService;
import ir.msob.jima.core.commons.operation.BaseBeforeAfterDomainOperation;
import ir.msob.jima.crud.service.domain.BeforeAfterComponent;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;

@Service
public class <%= domainClassName %>Service extends DomainCrudService<<%= domainClassName %>, <%= dtoClassName %>, <%= criteriaClassName %>, <%= domainClassName %>Repository>
        implements ChildDomainCrudService<<%= dtoClassName %>> {

    private final ModelMapper modelMapper;
    private final IdService idService;

    protected <%= domainClassName %>Service(BeforeAfterComponent beforeAfterComponent, ObjectMapper objectMapper, <%= domainClassName %>Repository repository, ModelMapper modelMapper, IdService idService) {
        super(beforeAfterComponent, objectMapper, repository);
        this.modelMapper = modelMapper;
        this.idService = idService;
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

    @Override
    public Mono<<%= dtoClassName %>> getDto(String id, User user) {
        return super.getOne(id, user);
    }

    @Override
    public Mono<<%= dtoClassName %>> updateDto(<%= idClassName %> id, @Valid <%= dtoClassName %> dto, User user) {
        return super.update(id, dto, user);
    }

    @Override
    public BaseIdService getIdService() {
        return idService;
    }
}
