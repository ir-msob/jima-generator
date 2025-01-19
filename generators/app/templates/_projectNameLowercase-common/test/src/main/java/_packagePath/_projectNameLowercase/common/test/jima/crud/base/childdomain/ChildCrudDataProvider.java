package <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.test.crud.base.childdomain;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.characteristic.Characteristic;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
import ir.msob.jima.core.commons.domain.BaseDto;
import ir.msob.jima.crud.service.childdomain.BaseChildDomainCrudService;
import ir.msob.jima.crud.test.childdomain.BaseChildCrudDataProvider;

public abstract class ChildCrudDataProvider<DTO extends BaseDto<String>, CS extends BaseChildDomainCrudService<String, User, DTO>>
        implements BaseChildCrudDataProvider<String, User, Characteristic, DTO, CS> {
}
