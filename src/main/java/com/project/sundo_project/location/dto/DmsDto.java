package com.project.sundo_project.location.dto;

import com.project.sundo_project.location.entity.Dms;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DmsDto {

    private double latitudeDegrees;
    private double latitudeMinutes;
    private double latitudeSeconds;
    private String latitudeDirection;
    private double longitudeDegrees;
    private double longitudeMinutes;
    private double longitudeSeconds;
    private String longitudeDirection;

    public Dms toEntity(){
        return Dms.builder()
                .latitudeDegrees(this.latitudeDegrees)
                .latitudeMinutes(this.latitudeMinutes)
                .latitudeSeconds(this.latitudeSeconds)
                .latitudeDirection(this.latitudeDirection)
                .longitudeDegrees(this.longitudeDegrees)
                .longitudeMinutes(this.longitudeMinutes)
                .longitudeSeconds(this.longitudeSeconds)
                .longitudeDirection(this.longitudeDirection)
                .build();
    }
}

