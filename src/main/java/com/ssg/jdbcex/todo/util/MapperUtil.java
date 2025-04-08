package com.ssg.jdbcex.todo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
    INSTANCE;
    private ModelMapper modelMapper;
    MapperUtil() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMethodAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
