package <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.party;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.CriteriaAbstract;
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
public class OrganizationCriteria extends PartyCriteria {
    @Serial
    private static final long serialVersionUID = -8938843863555450000L;
}