package <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.sampledomain;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SampleDto extends SampleDomain implements Dto {

    public SampleDto(String id, String name, String description) {
        super(id, name, description);
    }

}