package com.soojong.airline.plane.repository;

import com.soojong.airline.plane.entity.PlaneCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneCompanyRepository extends JpaRepository<PlaneCompany,Long> {
}
