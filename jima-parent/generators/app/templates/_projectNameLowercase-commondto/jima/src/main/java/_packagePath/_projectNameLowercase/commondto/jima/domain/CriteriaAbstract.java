package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.BaseCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class CriteriaAbstract extends BaseCriteriaAbstract<<%= idClassName %>> implements Criteria {

}