package <%= packagePath %>.<%= projectNameLowercase %>.core.commons.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.domain.CriteriaAbstract;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.filter.Filter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class <%= criteriaClassName %> extends CriteriaAbstract {
    @Serial
    private static final long serialVersionUID = -8938843863555450000L;
    private Filter<String> name;
    private Filter<String> description;
}