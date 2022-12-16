package com.example.demo.review.service;

import com.example.demo.review.entity.Category;
import com.example.demo.review.entity.Review;
import com.example.demo.review.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    //지역 목록 조회 중간처리
    public List<Category> findAreaServ(){
        return categoryRepository.findAreaList();
    }

    //선택한 지역 또는 주소 보여주기
    public Category showAreaServ(String area){
        return categoryRepository.showArea(area);
    }

    //지역에 해당하는 주소 목록 조회 중간처리
    public List<Category> findAddressServ(String area){
        return categoryRepository.findAddressList(area);
    }

    //선택한 주소 보여주기 -> cID까지 들어있는 Category 타입을 받는다. 프론트에서는 json.address
    //입력받은 지역과 주소를 바탕으로 완전한 카테고리 객체를 불러온다(findOne과 유사)
    public Category findCategoryServ(String address){
        Category category = categoryRepository.findCategory(address);
//        String cID = category.getCategoryId();
        //createServ 안에서 findAllServ를 실행하듯이
        return category;
    }

}
