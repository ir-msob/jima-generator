package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import ir.msob.jima.core.ral.mongo.commons.query.MongoQueryBuilder;
import <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.crud.base.domain.DomainCrudRepository;
import <%= domainClassPath %>;
import <%= criteriaClassPath %>;
<%_ if (databaseType == 'Mongo') { _%>
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
<%_ } _%>
import org.springframework.stereotype.Repository;

@Repository
public class <%= domainClassName %>Repository extends DomainCrudRepository<<%= domainClassName %>> {
    <%_ if (databaseType == 'Mongo') { _%>
    protected <%= domainClassName %>Repository(MongoQueryBuilder queryBuilder, ReactiveMongoTemplate reactiveMongoTemplate) {
        super(queryBuilder, reactiveMongoTemplate);
    }
    <%_ } _%>
}

