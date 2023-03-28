package com.jerry.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CoffeeResponseDto {
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;

    public CoffeeResponseDto(long coffeeId, String korName, String engName, int price) {
        this.coffeeId = coffeeId;
        this.korName = korName;
        this.engName = engName;
        this.price = price;
    }
}