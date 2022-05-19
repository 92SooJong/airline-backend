package com.soojong.airline.plane.repository;

import com.soojong.airline.plane.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane,Long> {

}
