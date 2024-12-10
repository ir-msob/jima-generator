package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.auditdomain;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedparty.RelatedParty;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.child.auditdomain.AuditDomainAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuditDomain extends AuditDomainAbstract<<%= idClassName %>, RelatedParty> {

}