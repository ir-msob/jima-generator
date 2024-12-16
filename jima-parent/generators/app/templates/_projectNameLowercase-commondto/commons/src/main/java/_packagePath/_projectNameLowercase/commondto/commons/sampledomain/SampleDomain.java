package <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.sampledomain;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.shared.Microservices;
import com.example.myproject.commondto.jima.child.characteristic.Characteristic;
import com.example.myproject.commondto.jima.child.characteristic.CharacteristicContainer;
import com.example.myproject.commondto.jima.child.contactmedium.ContactMedium;
import com.example.myproject.commondto.jima.child.contactmedium.ContactMediumContainer;
import com.example.myproject.commondto.jima.child.objectvalidation.ObjectValidation;
import com.example.myproject.commondto.jima.child.objectvalidation.ObjectValidationContainer;
import com.example.myproject.commondto.jima.child.relatedaction.RelatedAction;
import com.example.myproject.commondto.jima.child.relatedaction.RelatedActionContainer;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.DomainAbstract;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.DomainInfo;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.SortedSet;
import java.util.TreeSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = SampleDomain.DOMAIN_NAME)
@DomainInfo(serviceName = Microservices.SAMPLE_MICROSERVICE, version = Microservices.VERSION_V1, domainName = SampleDomain.DOMAIN_NAME_WITH_HYPHEN)
public class SampleDomain extends DomainAbstract implements CharacteristicContainer, ContactMediumContainer, ObjectValidationContainer, RelatedActionContainer {
    @Transient
    public static final String DOMAIN_NAME = "SampleDomain";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "sample-domain";

    @NotBlank
    private String name;
    private String description;

    private SortedSet<Characteristic> characteristics = new TreeSet<>();
    private SortedSet<ContactMedium> contactMediums = new TreeSet<>();
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    @Builder
    public SampleDomain(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public enum FN {
        name, description
    }
}