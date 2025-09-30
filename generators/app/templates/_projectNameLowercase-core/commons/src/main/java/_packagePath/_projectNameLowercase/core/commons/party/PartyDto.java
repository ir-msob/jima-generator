package <%= packagePath %>.<%= projectNameLowercase %>.core.commons.party;

import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.party.name.Name;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.party.name.NameCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.characteristic.Characteristic;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.characteristic.CharacteristicCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.contactmedium.ContactMedium;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.contactmedium.ContactMediumCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.objectvalidation.ObjectValidation;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.relatedaction.RelatedAction;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.relatedaction.RelatedActionCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.domain.DomainAbstract;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.SortedSet;
import java.util.TreeSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyDto extends Party implements Dto {

    public PartyDto(String id, SortedSet<Characteristic> characteristics, SortedSet<ContactMedium> contactMediums, SortedSet<ObjectValidation> objectValidations, SortedSet<RelatedAction> relatedActions, SortedSet<Name> names) {
        super(id, characteristics, contactMediums, objectValidations, relatedActions, names);
    }
}