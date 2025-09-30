package <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.crud.kafka.domain.service.write;

import <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.crud.base.domain.DomainCrudRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.crud.base.domain.DomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.channel.ChannelTypeReference;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.domain.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.security.User;
import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
import ir.msob.jima.crud.api.kafka.service.domain.write.BaseDeleteManyDomainCrudKafkaListener;

public interface DeleteManyDomainCrudKafkaListener<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>,
        S extends DomainCrudService<D, DTO, C, R>
        > extends BaseDeleteManyDomainCrudKafkaListener<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S>
        , ChannelTypeReference<DTO, C> {

}