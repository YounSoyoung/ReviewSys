//package com.example.demo.review.repository;
//
//import com.example.demo.review.entity.Category;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class CategoryRepositoryImpl implements CategoryRepository{
//    private static final Map<Long, Category> categoryMap = new HashMap<>();
//
//    static {
//        categoryMap.put(1L, new Category(1L, "서울", "마포구"));
//        categoryMap.put(2L, new Category(2L, "서울", "용산구"));
//        categoryMap.put(3L, new Category(3L, "부산", "해운대"));
//    }
//
//    @Override
//    public boolean createC(Category category) {
//        return false;
//    }
//
//    @Override
//    public List<String> findAreaList(){
//        List<String> areaList = new ArrayList<>();
//
//        for (long categoryId : categoryMap.keySet()){
//            Category category = categoryMap.get(categoryId);
//            if(!areaList.contains(category.getArea())){
//                areaList.add(category.getArea());
//            }
//        }
//        return areaList;
//    }
//
//    @Override
//    public List<String> findAddressList(String area) {
//        List<String> addList = new ArrayList<>();
//
//        for(long categoryId : categoryMap.keySet()){
//            Category category = categoryMap.get(categoryId);
//            if(category.getArea() == area){
//                addList.add(category.getAddress());
//            }
//        }
//        return addList;
//    }
//
//    @Override
//    public Category findOneC(Category category) {
//        return null;
//    }
//
//    @Override
//    public boolean removeC(long categoryId) {
//        return false;
//    }
//}
