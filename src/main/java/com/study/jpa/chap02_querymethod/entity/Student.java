package com.study.jpa.chap02_querymethod.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter // 실무적 측면에서 setter는 신중히 만들것
@Getter
@ToString
@EqualsAndHashCode(of = {"id"}) //id만 같으면 같은 객체라고 판단한다.{id,name}이것도 가능
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_student")
public class Student {

    @Id
    @Column(name = "stu_id")
    @GeneratedValue(generator = "uid")
    @GenericGenerator(strategy = "uuid", name = "uid") //uuid로 지정하면 db에 암호화해서 보여주는듯
    private String id;

    @Column(name = "stu_name", nullable = false)
    private String name;

    private String city;
    private String major;
}