package com.project.sundo_project.location.dto;

import com.project.sundo_project.location.entity.Location;
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

    private double latitude;
    private double longitude;

    private String registerName;

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
                .latitude(this.latitude)
                .longitude(this.longitude)
                .registrantName(this.registerName)
                .build();
    }
}

