package com.project.sundo_project.evaluation.dto.response;

import com.project.sundo_project.evaluation.entity.Evaluation;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class EvaluationFindDto {

    private String title;
    private String registrantName;
    private String arImage;
    private int windVolume;
    private int noiseLevel;
    private int scenery;
    private int waterDepth;
    private int avg;

    public EvaluationFindDto(Evaluation foundId) {
        this.title = foundId.getTitle();
        this.registrantName = foundId.getRegistrantName();
        this.arImage = foundId.getArImage();
        this.windVolume = foundId.getWindVolume();
        this.noiseLevel = foundId.getNoiseLevel();
        this.scenery = foundId.getWaterDepth();
        this.waterDepth = foundId.getWaterDepth();
        this.avg = foundId.getAverageRating();
    }
}
