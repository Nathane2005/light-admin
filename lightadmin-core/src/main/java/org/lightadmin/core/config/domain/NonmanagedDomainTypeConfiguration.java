package org.lightadmin.core.config.domain;

import java.io.Serializable;

import org.lightadmin.core.config.domain.configuration.EntityMetadataConfigurationUnit;
import org.lightadmin.core.persistence.metamodel.DomainTypeEntityMetadata;
import org.lightadmin.core.persistence.repository.DynamicJpaRepository;

public class NonmanagedDomainTypeConfiguration implements DomainTypeBasicConfiguration {

	private final EntityMetadataConfigurationUnit entityConfiguration;
	private final DomainTypeEntityMetadata entityMetadata;
	private final DynamicJpaRepository<?, ? extends Serializable> repository;

	public NonmanagedDomainTypeConfiguration(EntityMetadataConfigurationUnit entityConfiguration, DomainTypeEntityMetadata entityMetadata,
			DynamicJpaRepository<?, ? extends Serializable> repository) {
		this.entityConfiguration = entityConfiguration;
		this.entityMetadata = entityMetadata;
		this.repository = repository;
	}

	@Override
	public String getConfigurationName() {
		return entityConfiguration.getDomainType().getSimpleName();
	}

	@Override
	public Class<?> getDomainType() {
		return entityConfiguration.getDomainType();
	}

	@Override
	public String getDomainTypeName() {
		return entityMetadata.getEntityName();
	}

	@Override
	public DomainTypeEntityMetadata getDomainTypeEntityMetadata() {
		return entityMetadata;
	}

	@Override
	public DynamicJpaRepository<?, ?> getRepository() {
		return repository;
	}

	@Override
	public EntityMetadataConfigurationUnit getEntityConfiguration() {
		return entityConfiguration;
	}

}