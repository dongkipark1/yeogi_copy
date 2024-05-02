package com.example.final_project.stay;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class StayRepositoryTest {
    @Autowired
    StayRepository stayRepository;

    @Test
    public void findByCompanyId_test() {
        // given
        Integer companyId = 1;

        // when
        List<Stay> stayList = stayRepository.findByCompanyId(companyId);

        // eye
        System.out.println("findByCompanyIdWithOptionsAndRooms_test size : " + stayList.size());

        // then
        Assertions.assertThat(stayList.getFirst().getName()).isEqualTo("호텔 블루 하버");
    }

//    // 검색 이름 쿼리 테스트
//    @Test
//    public void findByStayName_test() {
//        // given
//        String nameTest1 = "호텔";
//        String nameTest2 = "미라클";
//
//        // when
//        Optional<List<Stay>> staysHotel = stayRepository.findByStayName(nameTest1);
//        Optional<List<Stay>> staysMiracle = stayRepository.findByStayName(nameTest2);
//
//        // eye
//        for (Stay stay : staysHotel.get()) {
//            System.out.println("findByStayName_test/hotel/name : " + stay.getName());
//        }
//
//        for (Stay stay : staysMiracle.get()) {
//            System.out.println("findByStayName_test/miracle/name : " + stay.getName());
//        }
//
//        // then
//    }
//
//    // 검색 지역 쿼리 테스트
//    @Test
//    public void findByStayArea_test() {
//        // given
//        String areaTest1 = "서울";
//        String areaTest2 = "부산";
//
//        // when
//        Optional<List<Stay>> staysSeoul = stayRepository.findByStayArea(areaTest1);
//        Optional<List<Stay>> staysBusan = stayRepository.findByStayArea(areaTest2);
//
//        // eye
//        for (Stay stay : staysSeoul.get()) {
//            System.out.println("findByStayName_test/seoul/name : " + stay.getAddress());
//        }
//
//        for (Stay stay : staysBusan.get()) {
//            System.out.println("findByStayName_test/busan/name : " + stay.getAddress());
//        }
//
//        // then
//    }
}
