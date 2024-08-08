package com.project.sundo_project.dto.response;

import com.project.sundo_project.entity.Evaluation;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class EvaluationFind {

    private String title;
    private String registrantName;
    private String arImage;
    private int windVolume;
    private int noiseLevel;
    private int scenery;
    private int waterDepth;
    private int avg;

    public EvaluationFind(Evaluation foundId) {
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
