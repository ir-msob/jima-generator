package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.core.test.jima.crud.base.childdomain.characteristic.BaseCharacteristicCrudDataProvider;
import <%= dtoClassPath %>;
import org.springframework.stereotype.Component;

@Component
public class <%= domainClassName %>CharacteristicCrudDataProvider extends BaseCharacteristicCrudDataProvider<<%= dtoClassName %>, <%= domainClassName %>Service> {
    public <%= domainClassName %>CharacteristicCrudDataProvider(<%= domainClassName %>Service childService) {
        super(childService);
    }
}
