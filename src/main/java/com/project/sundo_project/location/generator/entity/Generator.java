package com.project.sundo_project.location.generator.entity;


import com.project.sundo_project.location.location.entity.Location;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Builder

@Entity
@Table(name = "Generator")
public class Generator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GeneratorID")
    private Long generatorId;

    @Column(name = "GeneratorName", nullable = false)
    private String generatorName;

    @Builder.Default
    @Column(name = "DirectionAngle")
    private Double directionAngle = 0.0;

    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location locationId;

    // 생성자
    public Generator(Double directionAngle) {
        this.directionAngle = (directionAngle != null) ? directionAngle : 0.0;
    }

}
