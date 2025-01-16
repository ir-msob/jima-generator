package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.base.domain.DomainCrudRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
import <%= domainClassPath %>;
import <%= criteriaClassPath %>;
import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
<%_ if (databaseType == 'Mongo') { _%>
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
<%_ } _%>
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationRepository extends PartyRepository<Organization, OrganizationCriteria> {
    <%_ if (databaseType == 'Mongo') { _%>
    protected OrganizationRepository(ReactiveMongoTemplate reactiveMongoTemplate) {
        super(reactiveMongoTemplate);
    }
    <%_ } _%>

    @Override
    public QueryBuilder criteria(QueryBuilder query, OrganizationCriteria criteria, User user) {
        return super.criteria(query, criteria, user);
    }
}

