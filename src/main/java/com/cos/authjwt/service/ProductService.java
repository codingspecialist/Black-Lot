package com.cos.authjwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.authjwt.config.auth.LoginUser;
import com.cos.authjwt.domain.product.Product;
import com.cos.authjwt.domain.product.ProductRepository;
import com.cos.authjwt.domain.user.User;
import com.cos.authjwt.handler.ex.CustomApiException;
import com.cos.authjwt.web.dto.product.ProductUpdateReqDto;
import com.cos.authjwt.web.dto.product.ProductWriteReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product 작품상세보기(Integer id) {
        return productRepository.findById(id).orElseThrow(
                () -> new CustomApiException("해당 " + id + "는 존재하지 않습니다."));
    }

    @Transactional
    public Page<Product> 작품목록보기(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Transactional
    public Product 작품등록하기(ProductWriteReqDto productWriteReqDto, @LoginUser User principal) {

        return productRepository.save(productWriteReqDto.toEntity(principal));
    }

    @Transactional
    public void 작품삭제하기(Integer id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public Optional<Product> 작품수정하기(ProductUpdateReqDto productUpdateReqDto, Integer id, @LoginUser User principal) {
        Optional<Product> productOp = productRepository.findById(id);
        if (productOp.isPresent()) {
            Product productEntity = productOp.get();
            productEntity.setType(productUpdateReqDto.getType());
            productEntity.setTitle(productUpdateReqDto.getTitle());
            productEntity.setCount(productUpdateReqDto.getCount());
            productEntity.setPrice(productUpdateReqDto.getPrice());
            productEntity.setTexture(productUpdateReqDto.getTexture());
            productEntity.setSize(productUpdateReqDto.getSize());
            productEntity.setProductionDate(productUpdateReqDto.getProductionDate());
            productEntity.setYearOfManufacture(productUpdateReqDto.getYearOfManufacture());
            productEntity.setCountry(productUpdateReqDto.getCountry());
            productEntity.setSignInfo(productUpdateReqDto.getSignInfo());
            productEntity.setGuarantee(productUpdateReqDto.isGuarantee());
        }
        return productOp;
    }
}
