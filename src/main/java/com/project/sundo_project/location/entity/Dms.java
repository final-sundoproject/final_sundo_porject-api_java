package com.project.sundo_project.location.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "location")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dms {

    @Id
    @Column(name = "locationId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationID;

    @Column(name = "ProjectId")
    private double projectId;

    @Column(name = "RegistrantName")
    private String registrantName;

    @Column(name = "RegistrationDate", nullable = false)
    private LocalDateTime registrationDate;

    @Column(name = "Latitude", precision = 9, scale = 6)
    private double latitude;

    @Column(name = "Longitude", precision = 9, scale = 6)
    private double longitude;

    @Column(name = "LatitudeDegrees")
    private double latitudeDegrees;

    @Column(name = "LatitudeMinutes")
    private double latitudeMinutes;

    @Column(name = "LatitudeSeconds", precision = 9, scale = 6)
    private double latitudeSeconds;

    @Column(name = "LatitudeDirection", length = 1)
    private String latitudeDirection;

    @Column(name = "LongitudeDegrees")
    private double longitudeDegrees;

    @Column(name = "LongitudeMinutes")
    private double longitudeMinutes;

    @Column(name = "LongitudeSeconds", precision = 9, scale = 6)
    private double longitudeSeconds;

    @Column(name = "LongitudeDirection", length = 1)
    private String longitudeDirection;
}
