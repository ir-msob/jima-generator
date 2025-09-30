package <%= packagePath %>.<%= projectNameLowercase %>.core.commons.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class <%= dtoClassName %> extends <%= domainClassName %> implements Dto {

    @Builder
    public <%= dtoClassName %>(String id, String name, String description) {
        super(id, name, description);
    }

}