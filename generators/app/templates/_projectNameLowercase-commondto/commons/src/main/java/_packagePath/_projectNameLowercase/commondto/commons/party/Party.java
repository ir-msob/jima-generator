package <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.party;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.party.name.Name;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.party.name.NameCriteria;
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

    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @ChildDomain(cdClass = ContactMedium.class, ccClass = ContactMediumCriteria.class)
    private SortedSet<ContactMedium> contactMediums = new TreeSet<>();

    @ChildDomain(cdClass = ObjectValidation.class, ccClass = ObjectValidationCriteria.class)
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();

    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    @ChildDomain(cdClass = Name.class, ccClass = NameCriteria.class)
    private SortedSet<Name> names = new TreeSet<>();

    public Party(String id, SortedSet<Characteristic> characteristics, SortedSet<ContactMedium> contactMediums, SortedSet<ObjectValidation> objectValidations, SortedSet<RelatedAction> relatedActions, SortedSet<Name> names) {
        super(id);
        this.characteristics = characteristics;
        this.contactMediums = contactMediums;
        this.objectValidations = objectValidations;
        this.relatedActions = relatedActions;
        this.names = names;
    }

    public enum FN {
        characteristics, contactMediums, objectValidations, relatedActions, names
    }
}