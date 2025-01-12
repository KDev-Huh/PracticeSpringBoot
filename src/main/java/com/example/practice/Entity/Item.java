package com.example.practice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int price;

    public void setPrice(int price) {
        if(price > 0 && price <= 100000000) {
            this.price = price;
        }
        else System.out.println("저장범위를 벗어났습니다.");
    }
    public void plusPrice() {
        this.price += 1000;
    }
}