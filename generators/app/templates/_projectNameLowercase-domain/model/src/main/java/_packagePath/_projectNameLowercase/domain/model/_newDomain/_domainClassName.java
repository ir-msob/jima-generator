package <%= packagePath %>.<%= projectNameLowercase %>.domain.model.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.characteristic.Characteristic;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.characteristic.CharacteristicCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.contactmedium.ContactMedium;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.contactmedium.ContactMediumCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.objectvalidation.ObjectValidation;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.relatedaction.RelatedAction;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.relatedaction.RelatedActionCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.DomainAbstract;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.ChildDomain;
import ir.msob.jima.core.commons.domain.DomainInfo;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.util.SortedSet;
import java.util.TreeSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = <%= domainClassName %>.DOMAIN_NAME)
@DomainInfo(serviceName = <%= domainClassName %>.DOMAIN_NAME_WITH_HYPHEN, version = "v1", domainName = <%= domainClassName %>.DOMAIN_NAME_WITH_HYPHEN)
public class <%= domainClassName %> extends DomainAbstract {
    @Serial
    private static final long serialVersionUID = <%= domainSerialVersionUID %>;
    
    @Transient
    public static final String DOMAIN_NAME = "<%= domainClassName %>";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "<%= domainClassNameWithHyphen %>";

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

    public <%= domainClassName %>(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public enum FN {
        name, description
    }
}