package com.project.sundo_project.kbm.generator.dto;

import com.project.sundo_project.kbm.generator.entity.Generator;
import com.project.sundo_project.kbm.generator.entity.Value.GeneratorType;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneratorDto {

    private double directionAngle;
    private GeneratorType generatorName;

    public Generator toEntity(){
        return Generator.builder()
                .directionAngle(this.directionAngle)
                .generatorName(this.generatorName.getGeneratorType())
                .build();
    }
}
