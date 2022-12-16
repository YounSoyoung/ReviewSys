package com.example.demo.review.api;

import com.example.demo.review.dto.FindAllDTO;
import com.example.demo.review.dto.ReviewDTO;
import com.example.demo.review.entity.Category;
import com.example.demo.review.entity.Review;
import com.example.demo.review.service.CategoryService;
import com.example.demo.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Repository;
        import org.springframework.stereotype.Service;
        import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/reviews", produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
@CrossOrigin
public class ReviewApiController {
    private final ReviewService service;
    private final CategoryService categoryService;

    //리뷰 목록 전체 조회 요청
    @GetMapping
    public FindAllDTO reviews(){
        log.info("/api/reviews/ GET request!");

        return service.findAllServ();
    }

    //리뷰 작성 페이지를 들어가면 먼저 지역 목록들을 보여준다
    @GetMapping("/new")
    public List<Category> areas(){
        log.info("/api/reviews/new GET category request");

        return categoryService.findAreaServ();
    }

    //선택한 지역값을 반환
    @PostMapping(value = "/new/{area}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> area(@PathVariable String area){
        log.info("/api/reviews/new/{} GET request", area);
        if(area == null) return ResponseEntity.badRequest().build();

        Category selectedArea = categoryService.showAreaServ(area);
        if(selectedArea == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(selectedArea);
    }
//
////    //지역 하나를 선택하면 해당하는 주소(구)들을 보여준다.
    @GetMapping(value = "/new/{area}", produces = "application/json; charset=UTF-8")
    public List<Category> addresses(@PathVariable String area){
        log.info("/api/reviews/new/{} GET request", area);

        return categoryService.findAddressServ(area);
    }

//    //주소를 선택하면 주소와 categoryID값을 가진 Category가 반환된다.
    @GetMapping(value = "/new/{area}/{address}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> category(@PathVariable String area, @PathVariable String address){
        log.info("/api/reviews/new/{}/{} POST request", area, address);
        if(area == null) return ResponseEntity.badRequest().build();

        Category fullCategory = categoryService.findCategoryServ(address);
        if(fullCategory == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(fullCategory);
    }


    //리뷰 등록 요청
    @PostMapping(value = "/new/{area}/{address}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> create(@PathVariable String area, @PathVariable String address, @RequestBody Review newReview){

        log.info("/api/reviews/{}/{} POST request!", area, address);

        newReview.setUserId("noname");

        try{
            FindAllDTO dto = service.createServ(newReview, address);

            if(dto == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        }
    }

//    //리뷰 개별 조회 요청
    @GetMapping("/{postId}")
    public ResponseEntity<?> review(@PathVariable String postId){
        log.info("api/reviews/{} GET request", postId);

        if(postId == null) return ResponseEntity.badRequest().build();

        ReviewDTO dto = service.findOneServ(postId);
        if(dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

//    //리뷰 삭제 요청
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> delete(@PathVariable String postId){
        log.info("/api/reviews/{} DELETE request", postId);

        try{
            FindAllDTO dtos = service.deleteServ(postId);
            return ResponseEntity.ok().body(dtos);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
//
//    //리뷰 수정 요청
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Review review){
        log.info("/api/reviews PUT request! - {}", review);

        try{
            FindAllDTO dtos = service.update(review);
            return ResponseEntity.ok().body(dtos);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
