package com.project.sundo_project.location.dto;

import com.project.sundo_project.location.entity.Generator;
import com.project.sundo_project.location.entity.Value.GeneratorType;
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
