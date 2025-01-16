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
public class Party extends DomainAbstract {

    @NotBlank
    private String name;
    private String description;

    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @ChildDomain(cdClass = ContactMedium.class, ccClass = ContactMediumCriteria.class)
    private SortedSet<ContactMedium> contactMediums = new TreeSet<>();

    @ChildDomain(cdClass = ObjectValidation.class, ccClass = ObjectValidationCriteria.class)
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();

    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    @Builder
    public Party(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public enum FN {
        name, description
    }
}