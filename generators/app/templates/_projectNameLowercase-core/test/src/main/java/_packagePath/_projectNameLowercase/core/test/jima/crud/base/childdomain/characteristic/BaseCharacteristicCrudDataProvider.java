package <%= packagePath %>.<%= projectNameLowercase %>.core.test.jima.crud.base.childdomain.characteristic;

import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.characteristic.Characteristic;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import ir.msob.jima.core.commons.domain.BaseDto;
import ir.msob.jima.crud.service.childdomain.BaseChildDomainCrudService;
import ir.msob.jima.crud.test.childdomain.BaseChildCrudDataProvider;

import static ir.msob.jima.core.test.CoreTestData.DEFAULT_STRING;
import static ir.msob.jima.core.test.CoreTestData.UPDATED_STRING;

public abstract class BaseCharacteristicCrudDataProvider<DTO extends BaseDto<String>, CS extends BaseChildDomainCrudService<String, User, DTO>>
        implements BaseChildCrudDataProvider<String, User, Characteristic, DTO, CS> {

    private static Characteristic characteristic;
    private final CS childService;

    public BaseCharacteristicCrudDataProvider(CS childService) {
        this.childService = childService;
    }

    public static void createNewChild() {
        characteristic = Characteristic.builder()
                .key(DEFAULT_STRING)
                .value(DEFAULT_STRING)
                .dataType(DEFAULT_STRING)
                .build();
    }

    @Override
    public Characteristic getNewChild() {
        return characteristic;
    }

    @Override
    public void updateChild(Characteristic characteristic) {
        characteristic.setKey(UPDATED_STRING);
        characteristic.setValue(UPDATED_STRING);
        characteristic.setDataType(UPDATED_STRING);
    }

    @Override
    public CS getChildService() {
        return childService;
    }
}

