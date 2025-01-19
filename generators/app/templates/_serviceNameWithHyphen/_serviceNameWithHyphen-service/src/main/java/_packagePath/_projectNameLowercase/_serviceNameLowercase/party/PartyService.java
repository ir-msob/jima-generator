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

public class PartyService<P extends Party, PDTO extends PartyDto, PC extends PartyCriteria, PR extends PartyRepository>
        extends DomainCrudService<P, PDTO, PC, PR>
        implements ChildDomainCrudService<PDTO> {

    private final ModelMapper modelMapper;
    private final IdService idService;

    protected PartyService(BeforeAfterComponent beforeAfterComponent, ObjectMapper objectMapper, PR repository, ModelMapper modelMapper, IdService idService) {
        super(beforeAfterComponent, objectMapper, repository);
        this.modelMapper = modelMapper;
        this.idService = idService;
    }

    @Override
    public PDTO toDto(P domain, User user) {
        return modelMapper.map(domain, getDtoClass());
    }

    @Override
    public P toDomain(PDTO dto, User user) {
        return dto;
    }

    @Override
    public Collection<BaseBeforeAfterDomainOperation<<%= idClassName %>, User, PDTO, PC>> getBeforeAfterDomainOperations() {
        return Collections.emptyList();
    }

    @Override
    public Mono<PDTO> getDto(String id, User user) {
        return super.getOne(id, user);
    }

    @Override
    public Mono<PDTO> updateDto(<%= idClassName %> id, @Valid PDTO dto, User user) {
        return super.update(id, dto, user);
    }

    @Override
    public BaseIdService getIdService() {
        return idService;
    }
}
