package <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.service;

import ir.msob.jima.core.commons.id.BaseIdService;
import org.springframework.stereotype.Component;

@Component
public class IdService implements BaseIdService {

    @Override
    public <%= idClassName %> newId() {
        // TODO
        return null;
    }

    @Override
    public <%= idClassName %> of(String id) {
        // TODO
        return null;
    }
}
