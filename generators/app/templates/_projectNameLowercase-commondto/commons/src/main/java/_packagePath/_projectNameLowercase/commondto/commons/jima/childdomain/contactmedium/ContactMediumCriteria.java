package <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.contactmedium;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.contactmedium.ContactMediumCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactMediumCriteria extends ContactMediumCriteriaAbstract<<%= idClassName %>,ContactMedium> {

}