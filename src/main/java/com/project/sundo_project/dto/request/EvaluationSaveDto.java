package com.project.sundo_project.dto.request;

import com.project.sundo_project.entity.Evaluation;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class EvaluationSaveDto {

    private String title;
    private String registrantName;
    private int windVolume;
    private int noiseLevel;
    private int scenery;
    private int waterDepth;

    public Evaluation toEntity() {
        return Evaluation.builder()
                .title(this.title)
                .registrantName(this.registrantName)
                .windVolume(this.windVolume)
                .noiseLevel(this.noiseLevel)
                .scenery(this.scenery)
                .waterDepth(this.waterDepth)
                .build();
    }
}
