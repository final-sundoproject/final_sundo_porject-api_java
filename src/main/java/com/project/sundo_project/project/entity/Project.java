package com.project.sundo_project.project.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId; // Long 타입으로 변경

    @Column
    private String projectName;

    @Column
    private Long companyCode; // Long 타입으로 변경

    @Column
    private LocalDateTime registrationDate;
}
