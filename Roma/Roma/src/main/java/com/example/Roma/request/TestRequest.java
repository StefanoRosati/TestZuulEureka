package com.example.Roma.request;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TestRequest {
    private Integer id;
    private String name;
}