package com.sinav.utils;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class MapperUtils {

    @Autowired
    private ModelMapper modelMapper;

    public <D, T> D map(final T source, Class<D> outClass) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setFieldMatchingEnabled(true);

        modelMapper.map(source, outClass);
        return modelMapper.map(source, outClass);
    }

    public <D, T> List<D> mapAll(final Collection<T> sourceList, Class<D> outCLass) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setFieldMatchingEnabled(true);

        return sourceList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
    }

    public <S, T> List<T> mapAll(Iterable<S> sourceIterable, Class<T> outCLass) {
        return StreamSupport.stream(sourceIterable.spliterator(), false).map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

    public <D, T> Page<D> mapAllToPage(Page<T> entities, Class<D> outCLass) {
        return entities.map(entity -> modelMapper.map(entity, outCLass));
    }

    public <D, T> void mapToExistObject(final T source, D existClass) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(source, existClass);
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
