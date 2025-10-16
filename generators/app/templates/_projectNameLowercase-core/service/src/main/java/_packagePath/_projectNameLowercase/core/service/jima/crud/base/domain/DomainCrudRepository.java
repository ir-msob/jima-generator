package <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.crud.base.domain;

import ir.msob.jima.core.commons.repository.BaseQueryBuilder;
import ir.msob.jima.core.ral.mongo.commons.query.MongoQueryBuilder;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import ir.msob.jima.core.ral.mongo.commons.BaseMongoRepository;
import ir.msob.jima.crud.ral.mongo.commons.BaseDomainCrudMongoRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

public abstract class DomainCrudRepository<D extends Domain>
        implements BaseDomainCrud<%= databaseType %>Repository<<%= idClassName %>, User, D>
        , Base<%= databaseType %>Repository<<%= idClassName %>, User, D> {

    <%_ if (databaseType == 'Mongo') { _%>
    private final MongoQueryBuilder queryBuilder;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    protected DomainCrudRepository(MongoQueryBuilder queryBuilder, ReactiveMongoTemplate reactiveMongoTemplate) {
        this.queryBuilder = queryBuilder;
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public ReactiveMongoTemplate getReactiveMongoTemplate() {
        return reactiveMongoTemplate;
    }
    <%_ } _%>

    @Override
    public BaseQueryBuilder getQueryBuilder() {
        return queryBuilder;
    }
}