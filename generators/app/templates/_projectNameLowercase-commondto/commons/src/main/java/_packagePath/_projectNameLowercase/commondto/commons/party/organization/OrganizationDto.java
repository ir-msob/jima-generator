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
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.SortedSet;
import java.util.TreeSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationDto extends Organization implements Dto {

    @Builder
    public OrganizationDto(String id, SortedSet<Characteristic> characteristics, SortedSet<ContactMedium> contactMediums, SortedSet<ObjectValidation> objectValidations, SortedSet<RelatedAction> relatedActions, SortedSet<Name> names) {
        super(id, characteristics, contactMediums, objectValidations, relatedActions, names);
    }
}