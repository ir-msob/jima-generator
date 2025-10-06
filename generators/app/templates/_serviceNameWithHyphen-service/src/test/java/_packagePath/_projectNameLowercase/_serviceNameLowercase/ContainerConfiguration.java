package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>;

import dasniko.testcontainers.keycloak.KeycloakContainer;
import ir.msob.jima.core.beans.properties.JimaProperties;
<%_ if (isKafka) { _%>
import ir.msob.jima.core.ral.kafka.test.KafkaContainerConfiguration;
<%_ } _%>
<%_ if (security == 'Keycloak') { _%>
import ir.msob.jima.security.ral.keycloak.test.KeycloakContainerConfiguration;
<%_ } _%>
<%_ if (databaseType == 'Mongo') { _%>
import ir.msob.jima.core.ral.mongo.test.configuration.MongoContainerConfiguration;
<%_ } _%>
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.kafka.KafkaContainer;

@TestConfiguration
public class ContainerConfiguration {
    @Bean
    public DynamicPropertyRegistrar dynamicPropertyRegistrar(JimaProperties jimaProperties
            <%_ if (databaseType == 'Mongo') { _%>
            , MongoDBContainer mongoDBContainer
            <%_ } _%>
            <%_ if (security == 'Keycloak') { _%>
            , KeycloakContainer keycloakContainer
            <%_ } _%>
            <%_ if (isKafka) { _%>
            , KafkaContainer kafkaContainer
            <%_ } _%>
            ) {
        return registry -> {
            <%_ if (databaseType == 'Mongo') { _%>
            MongoContainerConfiguration.registry(registry, mongoDBContainer);
            <%_ } _%>
            <%_ if (security == 'Keycloak') { _%>
            KeycloakContainerConfiguration.registry(registry, keycloakContainer, jimaProperties);
            <%_ } _%>
            <%_ if (isKafka) { _%>
            KafkaContainerConfiguration.registry(registry, kafkaContainer);
            <%_ } _%>
        };
    }
}
