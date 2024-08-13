package com.project.sundo_project.location.generator.entity.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum GeneratorType {
    // 두산중공업 풍력 발전기, 유니슨 풍력 발전기
    DOOSAN("두산"),
    UNISON("유니슨");

    private final String generatorType;

}