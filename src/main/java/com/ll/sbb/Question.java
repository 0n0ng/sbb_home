package com.ll.sbb;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id
    // 데이터 저장할 때 자동으로 1씩 증가하여 저장 id++
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    //cascade = CascadeType.REMOVE : 질문이 삭제되면 답변도 삭제
    // mappedBy = "참조 속성 명" Question엔티티의 참조속성인 question 전달.
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}