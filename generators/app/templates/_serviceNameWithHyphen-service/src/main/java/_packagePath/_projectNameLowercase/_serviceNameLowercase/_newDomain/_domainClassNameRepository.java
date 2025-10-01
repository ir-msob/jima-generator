package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.crud.base.domain.DomainCrudRepository;
import <%= domainClassPath %>;
import <%= criteriaClassPath %>;
<%_ if (databaseType == 'Mongo') { _%>
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
<%_ } _%>
import org.springframework.stereotype.Repository;

@Repository
public class <%= domainClassName %>Repository extends DomainCrudRepository<<%= domainClassName %>, <%= criteriaClassName %>> {
    <%_ if (databaseType == 'Mongo') { _%>
    protected <%= domainClassName %>Repository(ReactiveMongoTemplate reactiveMongoTemplate) {
        super(reactiveMongoTemplate);
    }
    <%_ } _%>

    @Override
    public QueryBuilder criteria(QueryBuilder query, <%= criteriaClassName %> criteria, User user) {
        return super.criteria(query, criteria, user);
    }
}

