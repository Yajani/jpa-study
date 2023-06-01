package com.study.jpa.chap05_practice.entity;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@ToString(exclude = {"hashTags"})
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private Long id;
    @Column(nullable = false) //not null
    private String writer; //작성자
    private String content; //내용
    @CreationTimestamp
    @Column(updatable = false) //수정불가
    private LocalDateTime createDate; //작성시간

    @UpdateTimestamp
    private LocalDateTime updateDate; //수정시간

    @OneToMany(mappedBy = "post") //상대편 매핑의 이름 //post 1: hsshtag many
    private List<HashTag> hashTags = new ArrayList<>(); //게시물에 담긴 해시태그 목록




}
