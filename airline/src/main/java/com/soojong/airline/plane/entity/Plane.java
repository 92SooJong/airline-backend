package com.soojong.airline.plane.entity;

import com.soojong.airline.plane.code.PlaneSizeTypeCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;

    private PlaneSizeTypeCode planeSizeTypeCode;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private PlaneCompany planeCompany;

    @Builder
    public Plane(Long id, String modelName, PlaneSizeTypeCode planeSizeTypeCode, PlaneCompany planeCompany) {
        this.id = id;
        this.modelName = modelName;
        this.planeSizeTypeCode = planeSizeTypeCode;
        this.planeCompany = planeCompany;
    }
}
