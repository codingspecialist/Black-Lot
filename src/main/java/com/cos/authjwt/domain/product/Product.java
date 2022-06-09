package com.cos.authjwt.domain.product;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cos.authjwt.domain.picture.Picture;
import com.cos.authjwt.domain.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer type;

    @JoinColumn(name = "pictureId")
    @OneToOne
    private Picture Picture;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @CreatedDate
    private LocalDateTime created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @LastModifiedDate
    private LocalDateTime updated;
}
