package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.ral.<%= databaseTypeLowercase %>.commons.query.QueryBuilder;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria.Criteria;
import ir.msob.jima.crud.service.domain.BaseDomainCrudService;
import ir.msob.jima.crud.service.domain.BeforeAfterComponent;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class DomainCrudService<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>>
        implements BaseDomainCrudService<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R> {

    private final BeforeAfterComponent beforeAfterComponent;
    private final ObjectMapper objectMapper;
    private final R repository;

    protected DomainCrudService(BeforeAfterComponent beforeAfterComponent, ObjectMapper objectMapper, R repository) {
        this.beforeAfterComponent = beforeAfterComponent;
        this.objectMapper = objectMapper;
        this.repository = repository;
    }

    @Override
    public BeforeAfterComponent getBeforeAfterComponent() {
        return beforeAfterComponent;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    @Override
    public R getRepository() {
        return repository;
    }
}
