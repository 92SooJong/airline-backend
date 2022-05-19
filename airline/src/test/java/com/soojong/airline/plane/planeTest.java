package com.soojong.airline.plane;

import com.soojong.airline.plane.code.PlaneSizeTypeCode;
import com.soojong.airline.plane.entity.Plane;
import com.soojong.airline.plane.entity.PlaneCompany;
import com.soojong.airline.plane.repository.PlaneCompanyRepository;
import com.soojong.airline.plane.repository.PlaneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class planeTest {

    @Autowired PlaneCompanyRepository planeCompanyRepository;
    @Autowired PlaneRepository planeRepository;
    @Autowired EntityManager entityManager;

    @Test
    @DisplayName("OneToMany 관계의 One에서 전체조회를 수행하는 경우 N+1이 발생할 수 있다.")
    void testN1ProblemCase1(){


        // 항공사 등록
        PlaneCompany koreanAir = planeCompanyRepository.save(PlaneCompany.builder()
                .companyName("대한항공")
                .joinAt(LocalDateTime.now())
                .build());

        planeCompanyRepository.save(PlaneCompany.builder()
                .companyName("진에어")
                .joinAt(LocalDateTime.now())
                .build());

        planeCompanyRepository.save(PlaneCompany.builder()
                .companyName("티웨이")
                .joinAt(LocalDateTime.now())
                .build());
        // 비행기 등록
        planeRepository.save(Plane.builder()
                .planeCompany(koreanAir)
                .modelName("아주큰비행기")
                .planeSizeTypeCode(PlaneSizeTypeCode.BIG)
                .build());

        planeRepository.save(Plane.builder()
                .planeCompany(koreanAir)
                .modelName("보통크기비행기")
                .planeSizeTypeCode(PlaneSizeTypeCode.MIDDLE)
                .build());

        planeRepository.save(Plane.builder()
                .planeCompany(koreanAir)
                .modelName("작은비행기")
                .planeSizeTypeCode(PlaneSizeTypeCode.SMALL)
                .build());


        // N+1 문제 발생
        planeCompanyRepository.findAll();



    }



}
