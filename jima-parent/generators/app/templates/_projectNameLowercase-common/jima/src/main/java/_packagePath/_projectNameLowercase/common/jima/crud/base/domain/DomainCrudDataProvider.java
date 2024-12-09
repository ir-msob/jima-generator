package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.commons.id.BaseIdService;
import ir.msob.jima.core.ral.<%= databaseTypeLowercase %>.commons.query.QueryBuilder;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria.Criteria;
import ir.msob.jima.crud.test.BaseDomainCrudDataProvider;

import java.util.Collections;
import java.util.TreeSet;

public abstract class DomainCrudDataProvider<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>,
        S extends DomainCrudService<D, DTO, C, R>>
        implements BaseDomainCrudDataProvider<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S> {

    private final ObjectMapper objectMapper;
    private final S service;
    private final User SAMPLE_USER;

    protected DomainCrudDataProvider(BaseIdService idService, ObjectMapper objectMapper, S service) {
        this.objectMapper = objectMapper;
        this.service = service;
        SAMPLE_USER = User.builder()
                .id(idService.newId().toString())
                .sessionId(idService.newId().toString())
                .username("user")
                .audience("web")
                .roles(new TreeSet<>(Collections.singleton("USER"))) // TODO: Replace with real role
                .build();
    }

    @Override
    public User getSampleUser() {
        return SAMPLE_USER;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    @Override
    public S getService() {
        return service;
    }
}
