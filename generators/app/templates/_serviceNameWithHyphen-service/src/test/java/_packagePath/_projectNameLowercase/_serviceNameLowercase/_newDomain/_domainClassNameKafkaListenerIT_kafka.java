package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.resource.BaseResource;
import ir.msob.jima.core.commons.shared.PageResponse;
import ir.msob.jima.core.ral.kafka.test.KafkaContainerConfiguration;
import ir.msob.jima.core.ral.mongo.test.configuration.MongoContainerConfiguration;
import ir.msob.jima.core.test.CoreTestData;
import ir.msob.jima.security.ral.keycloak.test.KeycloakContainerConfiguration;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.core.test.jima.crud.base.domain.DomainCrudKafkaListenerTest;
import <%= packagePath %>.<%= projectNameLowercase %>.dms.Application;
import <%= domainClassPath %>;
import <%= criteriaClassPath %>;
import <%= dtoClassPath %>;
import lombok.SneakyThrows;
import lombok.extern.apachecommons.CommonsLog;
import org.assertj.core.api.Assertions;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.lang.reflect.Type;

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
public class <%= domainClassName %>KafkaListenerIT extends DomainCrudKafkaListenerTest<<%= domainClassName %>, <%= dtoClassName %>, <%= criteriaClassName %>, <%= domainClassName %>Repository, <%= domainClassName %>Service, <%= domainClassName %>DataProvider> {

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
    public Class<? extends BaseResource<<%= idClassName %>, User>> getResourceClass() {
        return <%= domainClassName %>KafkaListener.class;
    }

    @Override
    public void assertMandatory(<%= dtoClassName %> before, <%= dtoClassName %> after) {
        Assertions.assertThat(after.getName()).isEqualTo(before.getName());
    }

    @Override
    public void assertAll(<%= dtoClassName %> before, <%= dtoClassName %> after) {
        assertMandatory(before, after);
        Assertions.assertThat(after.getDescription()).isEqualTo(before.getDescription());
    }

    @Override
    public String getBaseUri() {
        return <%= domainClassName %>KafkaListener.BASE_URI;
    }

    @Override
    public TypeReference<ChannelMessage<User, CriteriaMessage<String, <%= criteriaClassName %>>>> getCriteriaReferenceType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public TypeReference<ChannelMessage<User, PageableMessage<String, <%= criteriaClassName %>>>> getCriteriaPageReferenceType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public TypeReference<ChannelMessage<User, PageMessage<String, <%= dtoClassName %>>>> getPageReferenceType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public TypeReference<ChannelMessage<User, JsonPatchMessage<String, <%= criteriaClassName %>>>> getEditReferenceType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public TypeReference<ChannelMessage<User, DtoMessage<String, <%= dtoClassName %>>>> getDtoReferenceType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public TypeReference<ChannelMessage<User, DtosMessage<String, <%= dtoClassName %>>>> getDtosReferenceType() {
        return new TypeReference<>() {
        };
    }
}
