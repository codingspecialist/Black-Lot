package com.cos.authjwt.web;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.authjwt.config.auth.LoginUser;
import com.cos.authjwt.domain.product.Product;
import com.cos.authjwt.domain.user.User;
import com.cos.authjwt.service.ProductService;
import com.cos.authjwt.web.dto.CMRespDto;
import com.cos.authjwt.web.dto.product.ProductUpdateReqDto;
import com.cos.authjwt.web.dto.product.ProductWriteReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/product/{id}")
    public ResponseEntity<?> productDetail(@PathVariable Integer id) {
        Product productEntity = productService.작품상세보기(id);
        return new ResponseEntity<>(new CMRespDto<>(1, "작품정보확인완료", productEntity), HttpStatus.OK);
    }

    @GetMapping("/api/product")
    public ResponseEntity<?> productList(
            @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Product> products = productService.작품목록보기(pageable);
        return new ResponseEntity<>(new CMRespDto<>(1, "작품목록확인완료", products), HttpStatus.OK);
    }

    @PostMapping("/s/product")
    public ResponseEntity<?> wirteProduct(@RequestBody ProductWriteReqDto productWriteReqDto,
            @LoginUser User principal) {

        Product productEntity = productService.작품등록하기(productWriteReqDto, principal);
        return new ResponseEntity<>(new CMRespDto<>(1, "작품등록확인완료", productEntity), HttpStatus.OK);
    }

    @DeleteMapping("/s/api/product/{id}")
    public ResponseEntity<?> deletById(@PathVariable Integer id) {
        productService.작품삭제하기(id);
        return new ResponseEntity<>(new CMRespDto<>(1, "작품삭제확인완료", null), HttpStatus.OK);
    }

    @PutMapping("/s/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductUpdateReqDto productUpdateReqDto,
            @PathVariable Integer id, @LoginUser User principal) {

        Optional<Product> productEntity = productService.작품수정하기(productUpdateReqDto, id, principal);
        return new ResponseEntity<>(new CMRespDto<>(1, "작품수정확인완료", productEntity), HttpStatus.OK);
    }
}
