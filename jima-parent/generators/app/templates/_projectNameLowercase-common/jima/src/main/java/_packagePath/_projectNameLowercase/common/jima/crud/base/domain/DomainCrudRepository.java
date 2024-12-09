package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain;


import ir.msob.jima.core.ral.<%= databaseTypeLowercase %>.commons.Base<%= databaseType %>Repository;
import ir.msob.jima.crud.ral.<%= databaseTypeLowercase %>.commons.BaseDomainCrud<%= databaseType %>Repository;

<%_ if (databaseType == 'Mongo') { _%>
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
<%_ } _%>
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
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