package com.cos.authjwt.web.dto.product;

import java.time.LocalDateTime;

import com.cos.authjwt.config.auth.LoginUser;
import com.cos.authjwt.domain.product.Product;
import com.cos.authjwt.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductUpdateReqDto {

    private Integer type;
    private String title;
    private String picture;
    private Integer count; // 개수
    private Integer price; // 가격
    private String texture; // 재질
    private String size; // 사이즈
    private LocalDateTime productionDate; // 제작시기
    private String yearOfManufacture; // 제조년도
    private String country; // 국가
    private String signInfo; // 서명정보
    private boolean guarantee; // 보증서유무

    public Product toEntity(@LoginUser User principal) {
        Product product = new Product();
        product.setType(type);
        product.setTitle(title);
        product.setPicture(picture);
        product.setCount(count);
        product.setPrice(price);
        product.setTexture(texture);
        product.setSize(size);
        product.setProductionDate(productionDate);
        product.setYearOfManufacture(yearOfManufacture);
        product.setCountry(country);
        product.setSignInfo(signInfo);
        product.setGuarantee(guarantee);
        product.setUser(principal);
        return product;
    }

}
