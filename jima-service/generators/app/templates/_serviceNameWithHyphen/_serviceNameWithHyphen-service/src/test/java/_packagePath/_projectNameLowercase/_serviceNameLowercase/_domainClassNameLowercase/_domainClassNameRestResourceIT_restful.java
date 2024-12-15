package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import com.example.myproject.common.jima.test.crud.base.domain.DomainCrudRestResourceTest;
import <%= criteriaClassPath %>;
import <%= domainClassPath %>;
import <%= dtoClassPath %>;
import com.example.myproject.commondto.jima.security.User;
import com.example.myproject.samplemicroservice.Application;
import ir.msob.jima.core.commons.resource.BaseResource;
import ir.msob.jima.core.ral.kafka.test.KafkaContainerConfiguration;
import ir.msob.jima.core.ral.mongo.test.configuration.MongoContainerConfiguration;
import ir.msob.jima.core.test.CoreTestData;
import ir.msob.jima.security.ral.keycloak.test.KeycloakContainerConfiguration;
import lombok.SneakyThrows;
import lombok.extern.apachecommons.CommonsLog;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

@AutoConfigureWebTestClient
@SpringBootTest(classes = {Application.class
        <%_ if (databaseType == 'Mongo') { _%>
        , MongoContainerConfiguration.class
        <%_ } _%>
        <%_ if (security == 'Keycloak') { _%>
        , KeycloakContainerConfiguration.class
        <%_ } _%>
        <%_ if (isKafka) { _%>
        , KafkaContainerConfiguration.class
        <%_ } _%>
        }
        , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@Testcontainers
@CommonsLog
public class <%= domainClassName %>RestResourceIT extends DomainCrudRestResourceTest<<%= domainClassName %>, <%= dtoClassName %>, <%= criteriaClassName %>, <%= domainClassName %>Repository, <%= domainClassName %>Service, <%= domainClassName %>DataProvider> {

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

    @Override
    public void assertMandatory(<%= dtoClassName %> before, <%= dtoClassName %> after) {
        // TODO: Assertions.assertThat(after.getDomainMandatoryField()).isEqualTo(before.getDomainMandatoryField());
    }

    @Override
    public void assertAll(<%= dtoClassName %> before, <%= dtoClassName %> after) {
        assertMandatory(before, after);
        // TODO: Assertions.assertThat(after.getDomainField()).isEqualTo(before.getDomainField());
    }
}
