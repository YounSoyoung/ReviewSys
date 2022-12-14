package com.example.demo.review.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryImplTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @DisplayName("areaList에 서울과 부산 값이 들어가야 한다.")
    void findAreaListTest() {
        // given

        // when
        List<String> areaList = categoryRepository.findAreaList();

        // then
        assertEquals(2, areaList.size());
        assertEquals("서울", areaList.get(0));
        assertEquals("부산", areaList.get(1));

    }

    @Test
    @DisplayName("서울을 입력했을 때 addressList가 마포구와 용산구여야 한다.")
    void findAddressListTest() {
        //given
        String area = "서울";

        //when
        List<String> addList = categoryRepository.findAddressList(area);

        //then
        assertEquals("마포구", addList.get(0));
        assertEquals("용산구", addList.get(1));
    }

}