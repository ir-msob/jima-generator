package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.test.crud.base.domain;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.DomainCrudRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.DomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.commons.id.BaseIdService;
import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
import ir.msob.jima.crud.test.domain.BaseDomainCrudDataProvider;
import lombok.Getter;

import java.util.Collections;
import java.util.TreeSet;

@Getter
public abstract class DomainCrudDataProvider<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>,
        S extends DomainCrudService<D, DTO, C, R>>
        implements BaseDomainCrudDataProvider<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S> {

    private final ObjectMapper objectMapper;
    private final S service;
    private final User sampleUser;

    protected DomainCrudDataProvider(BaseIdService idService, ObjectMapper objectMapper, S service) {
        this.objectMapper = objectMapper;
        this.service = service;
        sampleUser = User.builder()
                .id(idService.<<%= idClassName %>>newId())
                .sessionId(idService.<<%= idClassName %>>newId())
                .username("user")
                .audience("web")
                .roles(new TreeSet<String>(Collections.singleton("USER"))) // TODO: Replace with real role
                .build();
    }
}