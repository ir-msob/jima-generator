package <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.objectvalidation;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.objectvalidation.ObjectValidationCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectValidationCriteria extends ObjectValidationCriteriaAbstract<<%= idClassName %>, ObjectValidation> {

}