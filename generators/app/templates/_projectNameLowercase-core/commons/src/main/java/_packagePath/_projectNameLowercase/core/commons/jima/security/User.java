package <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.security.BaseUser;
import lombok.*;

import java.util.SortedSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseUser {
    @Builder
    public User(String id, String sessionId, String name, String username, SortedSet<String> roles, String audience) {
        super(id, sessionId, name, username, roles, audience);
    }
}