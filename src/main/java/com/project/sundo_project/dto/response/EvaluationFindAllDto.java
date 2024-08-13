package com.project.sundo_project.dto.response;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationFindAllDto {

    private String title;
    private String registrantName;
    private LocalDateTime priRegistrationDate;
    private String arImage;
    private int windVolume;
    private int noiseLevel;
    private int waterDepth;
    private int scenery;
    private int averageRating;

}
