package com.example.medicare.api.shared.mapping;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.stream.Collectors;

public class EnhancedModelMapper extends ModelMapper {

    @PostConstruct
    public void setup(){
        this.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    public EnhancedModelMapper(){
        super();
    }

    public <S, T> List<T> mapList(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream().map(item -> this.map(item, targetClass)).collect(Collectors.toList());
    }

}
