package com.cos.authjwt.domain.love;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cos.authjwt.domain.product.Product;
import com.cos.authjwt.domain.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Love {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    @JoinColumn(name = "productId")
    @ManyToOne
    private Product product;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @CreatedDate
    private LocalDateTime created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    @LastModifiedDate
    private LocalDateTime updated;
}
