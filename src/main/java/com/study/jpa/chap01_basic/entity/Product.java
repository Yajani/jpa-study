package com.study.jpa.chap01_basic.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product") //테이블명
public class Product {

    @Id //pk지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mariadb 나 mysql에서 쓴다.
    // db에서 쓰고싶은 컬럼명
    @Column(name = "prod_id")
    private long id;

    //unique제약조건 unique = true
    @Column(name = "prod_nm", nullable = false, length = 30) // notnull ,varchar(30)
    private String name;

    @Builder.Default //빌더를 쓰면 붙여줘야 한다
    private int price = 0; //기본값 설정

    @Enumerated(EnumType.STRING)  //db에 저장될때 스트링타입으로 저장된다
    private Category category;

    @CreationTimestamp
    @Column(updatable = false) //수정불가 옵션
    private LocalDateTime createdDate;

    @UpdateTimestamp // 자동으로 시간이 저장된다.
     private LocalDateTime updatedDate;


    public enum Category {
        FOOD, FASHION, ELECTRONIC
    }
}