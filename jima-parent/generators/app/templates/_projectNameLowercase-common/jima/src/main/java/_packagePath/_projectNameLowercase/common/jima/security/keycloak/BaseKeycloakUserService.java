package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.keycloak;

import com.google.common.collect.Sets;
import ir.msob.jima.core.commons.security.BaseClaimKey;
import ir.msob.jima.core.commons.security.BaseClaimKeyValue;
import ir.msob.jima.core.commons.security.BaseUser;
import ir.msob.jima.core.commons.security.BaseUserService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.Roles;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;

import java.util.*;

public interface BaseKeycloakUserService extends BaseUserService {
    User SYSTEM_USER = User.builder()
            .id("00000000-0000-0000-0000-000000000000")
            .sessionId("00000000-0000-0000-0000-000000000000")
            .username("system")
            .roles(Sets.newTreeSet(Collections.singleton(Roles.ADMIN)))
            .audience(BaseClaimKeyValue.AUDIENCE_WEB)
            .build();

    @Override
    default <USER extends BaseUser> USER getUser(Map<String, Object> claims) {
        SortedSet<String> roles = new TreeSet<>((List<String>) ((Map<String, Map<String, List<String>>>) claims.get(ClaimKey.REALM_ACCESS)).get(ClaimKey.KEYCLOAK_ROLES));
        return (USER) User.builder()
                .id(String.valueOf(claims.get(BaseClaimKey.ID)))
                .sessionId(String.valueOf(claims.get(BaseClaimKey.SESSION_ID)))
                .username(String.valueOf(claims.get(BaseClaimKey.SUBJECT)))
                .audience(String.valueOf(claims.get(BaseClaimKey.AUDIENCE)))
                .roles(roles)
                .build();
    }


    @Override
    default <USER extends BaseUser> USER getSystemUser() {
        return (USER) SYSTEM_USER;
    }
}
