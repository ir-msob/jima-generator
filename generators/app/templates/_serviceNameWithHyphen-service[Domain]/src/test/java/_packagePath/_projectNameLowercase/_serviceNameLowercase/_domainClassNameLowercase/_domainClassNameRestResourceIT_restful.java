package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import ir.msob.jima.core.commons.resource.BaseResource;
import ir.msob.jima.core.test.CoreTestData;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.core.test.jima.crud.restful.domain.DomainCrudRestResourceTest;
import <%= domainClassPath %>;
import <%= criteriaClassPath %>;
import <%= dtoClassPath %>;
import <%= typeReferenceClassPath %>;
import <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.Application;
import <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.ContainerConfiguration;
import lombok.SneakyThrows;
import lombok.extern.apachecommons.CommonsLog;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@AutoConfigureWebTestClient
@SpringBootTest(classes = {Application.class, ContainerConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@CommonsLog
public class <%= domainClassName %>RestResourceIT
        extends DomainCrudRestResourceTest<<%= domainClassName %>, <%= dtoClassName %>, <%= criteriaClassName %>, <%= domainClassName %>Repository, <%= domainClassName %>Service, <%= domainClassName %>DataProvider>
        implements <%= domainClassName %>TypeReference {

    @SneakyThrows
    @BeforeAll
    public static void beforeAll() {
        <%_ if (databaseType == 'Mongo') { _%>
        CoreTestData.init(new ObjectId(), new ObjectId());
        <%_ } _%>
    }

    @SneakyThrows
    @BeforeEach
    public void beforeEach() {
        getDataProvider().cleanups();
        <%= domainClassName %>DataProvider.createMandatoryNewDto();
        <%= domainClassName %>DataProvider.createNewDto();
    }


    @Override
    public String getBaseUri() {
        return <%= domainClassName %>RestResource.BASE_URI;
    }

    @Override
    public Class<? extends BaseResource<<%= idClassName %>, User>> getResourceClass() {
        return <%= domainClassName %>RestResource.class;
    }

}
