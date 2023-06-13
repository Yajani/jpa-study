package com.study.jpa.chap03_pagination.repository;

import com.study.jpa.chap02_querymethod.entity.Student;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentPageRepository
        extends JpaRepository<Student, String> { //실제로는 두개 만들필요없고 화면에다가 한꺼번에 다 하면된다.


    // 학생 조건없이 전체조회 페이징 (기본기능 - 안만들어도됨)
    Page<Student> findAll(Pageable pageable);

    // 학생의 이름에 특정단어가 포함된걸 조회 + 페이징
    Page<Student> findByNameContaining(String name, Pageable pageable);



}