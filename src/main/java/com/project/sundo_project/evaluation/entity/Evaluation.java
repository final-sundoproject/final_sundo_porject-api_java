package com.project.sundo_project.evaluation.entity;

import com.project.sundo_project.evaluation.dto.request.EvaluationSaveDto;
import com.project.sundo_project.project.entity.Project;
import com.project.sundo_project.location.entity.Location;
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
    private Long evaluationID;

    @Column(name = "Title")
    private String title;

    @Column(name = "RegistrantName")
    private String registrantName;

    @Column(name = "PriRegistrationDate")
    private LocalDateTime priRegistrationDate;

    @Column(name = "ArImage")
    private String arImage;

    @ManyToOne
    @JoinColumn(name = "ProjectId")
    private Project project;

    @OneToOne
    @JoinColumn(name = "LocationId")
    private Location location;

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

    @Column(name = "CompanyCode")
    private long companyCode;

    public void modifyEvaluation(EvaluationSaveDto dto) {
        this.title = dto.getTitle();
        this.priRegistrationDate = LocalDateTime.now();
        this.windVolume = dto.getWindVolume();
        this.noiseLevel = dto.getNoiseLevel();
        this.scenery = dto.getScenery();
        this.waterDepth = dto.getWaterDepth();
        this.averageRating = (dto.getWindVolume() + dto.getNoiseLevel()
                + dto.getScenery() + dto.getWaterDepth()) / 4;
        this.companyCode = dto.getCompanyCode();
    }
}
