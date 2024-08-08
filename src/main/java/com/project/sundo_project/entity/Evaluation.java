package com.project.sundo_project.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EvaluationID")
    private int evaluationID;

    @Column(name = "ProjectId")
    private int projectID;

    @Column(name = "Title")
    private String title;

    @Column(name = "RegistrantName")
    private String registrantName;

    @Column(name = "PriRegistrationDate")
    private LocalDateTime priRegistrationDate;

    @Column(name = "ArImage")
    private String arImage;

    @Column(name = "GeneratorId")
    private int generatorID;

    @Column(name = "LocationId")
    private int locationID;

    @Column(name = "WindVolume")
    private int windVolume;

    @Column(name = "NoiseLevel")
    private int noiseLevel;

    @Column(name = "Scenery")
    private int scenery;

    @Column(name = "WaterDepth")
    private int waterDepth;

    @Column(name = "AverageRating")
    private int averageRating;
}
