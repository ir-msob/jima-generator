package <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.base.domain;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
import ir.msob.jima.core.ral.mongo.commons.BaseMongoRepository;
import ir.msob.jima.crud.ral.mongo.commons.BaseDomainCrudMongoRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

public abstract class DomainCrudRepository<D extends Domain, C extends Criteria>
        implements BaseDomainCrud<%= databaseType %>Repository<<%= idClassName %>, User, D, C>
        , Base<%= databaseType %>Repository<<%= idClassName %>, User, D> {

    <%_ if (databaseType == 'Mongo') { _%>
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    protected DomainCrudRepository(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public ReactiveMongoTemplate getReactiveMongoTemplate() {
        return reactiveMongoTemplate;
    }
    <%_ } _%>
}