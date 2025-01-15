package <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.kafka.domain.service.write;

import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.base.domain.DomainCrudRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.base.domain.DomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.channel.ChannelTypeReference;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
import ir.msob.jima.crud.api.kafka.service.domain.write.BaseEditDomainCrudKafkaListener;

public interface EditDomainCrudKafkaListener<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>,
        S extends DomainCrudService<D, DTO, C, R>
        > extends BaseEditDomainCrudKafkaListener<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S>
        , ChannelTypeReference<DTO, C> {

}