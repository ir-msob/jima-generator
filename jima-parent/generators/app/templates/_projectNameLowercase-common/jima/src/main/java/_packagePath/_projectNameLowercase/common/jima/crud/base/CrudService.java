package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.ral.<%= databaseTypeLowercase %>.commons.query.QueryBuilder;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria.Criteria;
import ir.msob.jima.crud.service.domain.BaseCrudService;
import ir.msob.jima.crud.service.domain.BeforeAfterComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class CrudService<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends CrudRepository<D, C>
        >
        implements BaseCrudService<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R> {

    @Autowired
    private BeforeAfterComponent beforeAfterComponent;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private R repository;

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
