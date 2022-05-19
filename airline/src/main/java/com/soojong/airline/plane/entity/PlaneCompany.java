package com.soojong.airline.plane.entity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class PlaneCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private LocalDateTime joinAt;

    @OneToMany(mappedBy = "planeCompany", fetch = FetchType.EAGER)
    private Set<Plane> planes = new LinkedHashSet<>();

    @Builder
    public PlaneCompany(Long id, String companyName, LocalDateTime joinAt) {
        this.id = id;
        this.companyName = companyName;
        this.joinAt = joinAt;
    }

}
