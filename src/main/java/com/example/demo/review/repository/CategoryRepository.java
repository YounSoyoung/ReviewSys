package com.example.demo.review.repository;

import com.example.demo.review.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface CategoryRepository {
    //새로운 카테고리를 생성하는 기능
    boolean createC(Category category); //리뷰를 새로 작성할 때 카테고리도 새로 작성된다.

    //지역들을 보여주는 기능
    List<Category> findAreaList();

    //지역을 선택했을 때 해당하는 구를 보여주는 기능
    List<Category> findAddressList(String area);

    //카테고리 개별 조회 기능
    Category findCategory(String area, String address);

    //카테고리 삭제 기능
    boolean removeC(long categoryId);

}
