package com.cos.authjwt.web;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.authjwt.config.auth.LoginUser;
import com.cos.authjwt.domain.product.Product;
import com.cos.authjwt.domain.user.User;
import com.cos.authjwt.service.ProductService;
import com.cos.authjwt.web.dto.CMRespDto;
import com.cos.authjwt.web.dto.product.ProductWriteReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/product/{id}")
    public CMRespDto<?> productDetail(@PathVariable Integer id) {
        Product productEntity = productService.제품상세보기(id);
        return new CMRespDto<>(1, "작품정보확인완료", productEntity);
    }

    @GetMapping("/api/product")
    public CMRespDto<?> productList(Integer page) {
        Page<Product> products = productService.제품목록보기(page);
        return new CMRespDto<>(1, "작품목록확인완료", products);
    }

    @PostMapping("/s/product")
    public CMRespDto<?> wirteProduct(ProductWriteReqDto productWriteReqDto, @LoginUser User principal) {
        Product productEntity = productService.작품등록하기(productWriteReqDto, principal);
        return new CMRespDto<>(1, "작품등록확인완료", productEntity);
    }

    @DeleteMapping("/s/api/product/{id}")
    public CMRespDto<?> deletById(@PathVariable Integer id) {
        productService.작품삭제하기(id);
        return new CMRespDto<>(1, "작품삭제확인완료", null);
    }

}
