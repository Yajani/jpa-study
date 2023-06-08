package com.study.jpa.chap01_basic.repository;

import com.study.jpa.chap01_basic.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
//    <,이 부분에는 entity에서 pk타입이 무엇인지 보고 쓴다 ’”>

}
