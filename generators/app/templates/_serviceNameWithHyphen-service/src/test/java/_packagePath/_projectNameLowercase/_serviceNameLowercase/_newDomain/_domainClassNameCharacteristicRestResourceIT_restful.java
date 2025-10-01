package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.resource.BaseResource;
import ir.msob.jima.core.commons.shared.PageResponse;
import ir.msob.jima.core.ral.kafka.test.KafkaContainerConfiguration;
import ir.msob.jima.core.ral.mongo.test.configuration.MongoContainerConfiguration;
import ir.msob.jima.core.test.CoreTestData;
import ir.msob.jima.security.ral.keycloak.test.KeycloakContainerConfiguration;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.core.test.jima.crud.base.childdomain.characteristic.BaseCharacteristicCrudRestResourceTest;
import <%= packagePath %>.<%= projectNameLowercase %>.dms.Application;
import <%= domainClassPath %>;
import <%= criteriaClassPath %>;
import <%= dtoClassPath %>;
import lombok.SneakyThrows;
import lombok.extern.apachecommons.CommonsLog;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.lang.reflect.Type;

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
public class <%= domainClassName %>CharacteristicRestResourceIT extends BaseCharacteristicCrudRestResourceTest<<%= domainClassName %>, <%= dtoClassName %>, <%= criteriaClassName %>, <%= domainClassName %>Repository, <%= domainClassName %>Service, <%= domainClassName %>DataProvider, <%= domainClassName %>Service, <%= domainClassName %>CharacteristicCrudDataProvider> {

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
        <%= domainClassName %>CharacteristicCrudDataProvider.createNewChild();
    }


    @Override
    public String getBaseUri() {
        return <%= domainClassName %>RestResource.BASE_URI;
    }

    @Override
    public Class<? extends BaseResource<String, User>> getResourceClass() {
        return <%= domainClassName %>CharacteristicRestResource.class;
    }
}
