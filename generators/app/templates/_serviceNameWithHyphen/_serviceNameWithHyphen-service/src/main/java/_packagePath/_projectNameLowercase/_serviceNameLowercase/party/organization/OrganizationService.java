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
public class OrganizationService extends OrganizationService<Organization, OrganizationDto, OrganizationCriteria, OrganizationRepository> {

    private final ModelMapper modelMapper;
    private final IdService idService;

    protected OrganizationService(BeforeAfterComponent beforeAfterComponent, ObjectMapper objectMapper, OrganizationRepository repository, ModelMapper modelMapper, IdService idService) {
        super(beforeAfterComponent, objectMapper, repository);
        this.modelMapper = modelMapper;
        this.idService = idService;
    }

    @Override
    public OrganizationDto toDto(Organization domain, User user) {
        return modelMapper.map(domain, OrganizationDto.class);
    }

    @Override
    public Organization toDomain(OrganizationDto dto, User user) {
        return dto;
    }

    @Override
    public Collection<BaseBeforeAfterDomainOperation<<%= idClassName %>, User, OrganizationDto, OrganizationCriteria>> getBeforeAfterDomainOperations() {
        return Collections.emptyList();
    }

    @Override
    public Mono<OrganizationDto> getDto(String id, User user) {
        return super.getOne(id, user);
    }

    @Override
    public Mono<OrganizationDto> updateDto(<%= idClassName %> id, @Valid OrganizationDto dto, User user) {
        return super.update(id, dto, user);
    }

    @Override
    public BaseIdService getIdService() {
        return idService;
    }
}
