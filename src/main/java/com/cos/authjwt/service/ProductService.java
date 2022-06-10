package com.cos.authjwt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.authjwt.config.auth.LoginUser;
import com.cos.authjwt.domain.product.Product;
import com.cos.authjwt.domain.product.ProductRepository;
import com.cos.authjwt.domain.user.User;
import com.cos.authjwt.handler.ex.CustomApiException;
import com.cos.authjwt.web.dto.product.ProductWriteReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product 제품상세보기(Integer id) {
        return productRepository.findById(id).orElseThrow(
                () -> new CustomApiException("해당 " + id + "는 존재하지 않습니다."));
    }

    @Transactional
    public Page<Product> 제품목록보기(Integer page) {
        PageRequest pr = PageRequest.of(page, 20, Sort.by(Direction.DESC, "id"));
        return productRepository.findAll(pr);
    }

    @Transactional
    public Product 작품등록하기(ProductWriteReqDto productWriteReqDto, @LoginUser User principal) {
        return productRepository.save(productWriteReqDto.toEntity(principal));
    }

    @Transactional
    public void 작품삭제하기(Integer id) {
        productRepository.deleteById(id);
    }
}
