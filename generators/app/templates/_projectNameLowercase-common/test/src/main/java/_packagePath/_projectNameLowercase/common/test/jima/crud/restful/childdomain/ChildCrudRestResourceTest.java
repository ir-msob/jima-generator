package <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.test.crud.base.childdomain;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.characteristic.Characteristic;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.characteristic.CharacteristicCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.beans.properties.JimaProperties;
import ir.msob.jima.core.commons.domain.BaseCriteria;
import ir.msob.jima.core.commons.domain.BaseDomain;
import ir.msob.jima.core.commons.domain.BaseDto;
import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
import ir.msob.jima.crud.api.restful.test.childdomain.BaseParentChildCrudRestResourceTest;
import ir.msob.jima.crud.commons.domain.BaseDomainCrudRepository;
import ir.msob.jima.crud.service.childdomain.BaseChildDomainCrudService;
import ir.msob.jima.crud.service.domain.BaseDomainCrudService;
import ir.msob.jima.crud.test.childdomain.BaseChildCrudDataProvider;
import ir.msob.jima.crud.test.domain.BaseDomainCrudDataProvider;
import ir.msob.jima.security.commons.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public abstract class ChildCrudRestResourceTest<
        D extends BaseDomain<String>,
        DTO extends BaseDto<String>,
        C extends BaseCriteria<String>,
        R extends BaseDomainCrudRepository<String, User, D, C, QueryBuilder>,
        S extends BaseDomainCrudService<String, User, D, DTO, C, QueryBuilder, R>,
        DP extends BaseDomainCrudDataProvider<String, User, D, DTO, C, QueryBuilder, R, S>,

        CS extends BaseChildDomainCrudService<String, User, DTO>,
        CDP extends BaseChildCrudDataProvider<String, User, Characteristic, DTO, CS>>
        implements BaseParentChildCrudRestResourceTest<String, User, Characteristic, CharacteristicCriteria, D, DTO, C, QueryBuilder, R, S, DP, CS, CDP> {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private DP dataProvider;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private JimaProperties jimaProperties;
    @Autowired
    private CS childService;
    @Autowired
    private CDP childDataProvider;
    @Autowired
    private S domainService;

    @Override
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    @Override
    public DP getDataProvider() {
        return dataProvider;
    }

    @Override
    public CDP getChildDataProvider() {
        return childDataProvider;
    }

    @Override
    public CS getChildService() {
        return childService;
    }

    @Override
    public S getDomainService() {
        return domainService;
    }

    @Override
    public JimaProperties getJimaProperties() {
        return jimaProperties;
    }

    @Override
    public WebTestClient getWebTestClient() {
        return webTestClient;
    }

    @Override
    public TokenService getTokenService() {
        return tokenService;
    }

    public User getSampleUser() {
        return this.getDataProvider().getSampleUser();
    }
}