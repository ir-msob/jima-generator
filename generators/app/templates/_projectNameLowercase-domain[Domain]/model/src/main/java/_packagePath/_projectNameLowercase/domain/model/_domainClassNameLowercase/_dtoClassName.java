package <%= packagePath %>.<%= projectNameLowercase %>.domain.model.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class <%= dtoClassName %> extends <%= domainClassName %> implements Dto {
    @Serial
    private static final long serialVersionUID = <%= dtoSerialVersionUID %>;

    @Builder
    public <%= dtoClassName %>(String id, String name, String description) {
        super(id, name, description);
    }

}