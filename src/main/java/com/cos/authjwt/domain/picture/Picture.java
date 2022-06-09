package com.cos.authjwt.domain.picture;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer count; // 개수

    @Column(nullable = false)
    private Integer price; // 가격

    @Column(nullable = false)
    private String texture; // 재질

    @Column(nullable = false)
    private String size; // 사이즈

    @Column(nullable = false)
    private String productionTime; // 제작시기

    @Column(nullable = false)
    private String yearOfManufacture; // 제조년도

    @Column(nullable = false)
    private String country; // 국가

    @Column(nullable = false)
    private String signInfo; // 서명정보

    @Column(nullable = false)
    private boolean guarantee; // 보증서유무

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @CreatedDate
    private LocalDateTime created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @LastModifiedDate
    private LocalDateTime updated;
}
