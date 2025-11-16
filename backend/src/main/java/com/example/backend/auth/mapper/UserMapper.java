package com.example.backend.auth.mapper;

import org.springframework.stereotype.Component;

import com.example.backend.common.mapper.ModelMapperService;

@Component
public class UserMapper {

	private final ModelMapperService mapperService;

	// Correct constructor
	public UserMapper(ModelMapperService mapperService) {
		this.mapperService = mapperService;
	}

	public <D> D toDto(Object entity, Class<D> dtoClass) {
		return mapperService.mapTo(entity, dtoClass);
	}

	// Convert DTO -> Entity (any type)
	public <E> E toEntity(Object dto, Class<E> entityClass) {
		return mapperService.mapTo(dto, entityClass);
	}
}
