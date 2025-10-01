package <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.security.keycloak;

import ir.msob.jima.core.commons.security.BaseClaimKey;

public class ClaimKey extends BaseClaimKey {
    public static final String REALM_ACCESS = "realm_access";
    public static final String KEYCLOAK_ROLES = "roles";

    private ClaimKey() {
        super();
    }

}
