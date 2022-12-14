package com.example.demo.review.api;

import com.example.demo.review.dto.FindAllDTO;
import com.example.demo.review.dto.ReviewDTO;
import com.example.demo.review.entity.Review;
import com.example.demo.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Repository;
        import org.springframework.stereotype.Service;
        import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@CrossOrigin
public class ReviewApiController {
    private final ReviewService service;

    //리뷰 목록 전체 조회 요청
    @GetMapping
    public FindAllDTO reviews(){
        log.info("/api/reviews/ GET request!");

        return service.findAllServ();
    }

    //리뷰 등록 요청
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Review newReview){
        newReview.setUserId("noname");
        log.info("/api/reviews POST request! - {}", newReview);

        try{
            FindAllDTO dto = service.createServ(newReview);

            if(dto == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        }
    }

    //리뷰 개별 조회 요청
    @GetMapping("/{reviewId}")
    public ResponseEntity<?> review(@PathVariable long reviewId){
        log.info("api/reviews/{} GET request", reviewId);

        if(reviewId == 0) return ResponseEntity.badRequest().build();

        ReviewDTO dto = service.findOneServ(reviewId);
        if(dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    //리뷰 삭제 요청
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> delete(@PathVariable long reviewId){
        log.info("/api/reviews/{} DELETE request", reviewId);

        try{
            FindAllDTO dtos = service.deleteServ(reviewId);
            return ResponseEntity.ok().body(dtos);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    //리뷰 수정 요청
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
