package com.example.demo.review.dto;

import com.example.demo.review.entity.Category;
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class AreaDTO {
    private String area;

    public AreaDTO(Category category){
        this.area = category.getArea();
    }
}
