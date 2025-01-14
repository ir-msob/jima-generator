package com.example.myproject.samplemicroservice.sampledomain;

import com.example.myproject.common.commons.jima.test.crud.base.childdomain.characteristic.BaseCharacteristicCrudDataProvider;
import <%= dtoClassPath %>;
import org.springframework.stereotype.Component;

@Component
public class <%= domainClassName %>CharacteristicCrudDataProvider extends BaseCharacteristicCrudDataProvider<SampleDto, <%= domainClassName %>Service> {
    public <%= domainClassName %>CharacteristicCrudDataProvider(<%= domainClassName %>Service childService) {
        super(childService);
    }
}
