package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.resource.BaseResource;
import ir.msob.jima.core.commons.shared.PageResponse;
import ir.msob.jima.core.test.CoreTestData;
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
import org.testcontainers.junit.jupiter.Testcontainers;

import java.lang.reflect.Type;

@SpringBootTest(classes = {Application.class, ContainerConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
