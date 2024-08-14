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
    private Long projectId;

    @Column
    private String projectName;

    @Column
    private Long companyCode;

    @Column
    private LocalDateTime registrationDate;
}
