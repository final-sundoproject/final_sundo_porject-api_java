package com.project.sundo_project.location.location.dto;

import com.project.sundo_project.location.location.entity.Location;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDto {

    private double latitudeDegrees;
    private double latitudeMinutes;
    private double latitudeSeconds;
    private String latitudeDirection;
    private double longitudeDegrees;
    private double longitudeMinutes;
    private double longitudeSeconds;
    private String longitudeDirection;

    public Location toEntity(){
        return Location.builder()
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

