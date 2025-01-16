package <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.sampledomain;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.shared.Microservices;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.characteristic.Characteristic;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.characteristic.CharacteristicCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.contactmedium.ContactMedium;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.contactmedium.ContactMediumCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.objectvalidation.ObjectValidation;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.relatedaction.RelatedAction;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.relatedaction.RelatedActionCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.DomainAbstract;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.ChildDomain;
import ir.msob.jima.core.commons.domain.DomainInfo;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.SortedSet;
import java.util.TreeSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = Organization.DOMAIN_NAME)
@DomainInfo(serviceName = Microservices.party, version = Microservices.VERSION_V1, domainName = Organization.DOMAIN_NAME_WITH_HYPHEN)
public class Organization extends Party {
    @Transient
    public static final String DOMAIN_NAME = "Organization";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "organization";

    @Builder
    public Organization(String id, String name, String description) {
        super(id, name, description);
    }
}