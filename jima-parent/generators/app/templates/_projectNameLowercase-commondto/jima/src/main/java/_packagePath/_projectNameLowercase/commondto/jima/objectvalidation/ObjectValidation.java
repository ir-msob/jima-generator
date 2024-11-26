package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.objectvalidation;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.objectvalidation.ObjectValidationAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectValidation extends ObjectValidationAbstract<<%= idClassName %>> {
}