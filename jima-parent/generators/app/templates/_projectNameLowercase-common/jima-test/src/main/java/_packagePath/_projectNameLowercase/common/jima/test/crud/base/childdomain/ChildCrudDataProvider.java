package com.example.myproject.common.jima.test.crud.base.childdomain;

import com.example.myproject.commondto.jima.childdomain.characteristic.Characteristic;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.core.commons.domain.BaseDto;
import ir.msob.jima.crud.service.childdomain.BaseChildDomainCrudService;
import ir.msob.jima.crud.test.childdomain.BaseChildCrudDataProvider;

public abstract class ChildCrudDataProvider<DTO extends BaseDto<String>, CS extends BaseChildDomainCrudService<String, User, DTO>>
        implements BaseChildCrudDataProvider<String, User, Characteristic, DTO, CS> {
}
