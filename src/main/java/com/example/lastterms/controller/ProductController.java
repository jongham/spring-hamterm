package com.example.lastterms.controller;

import com.example.lastterms.dto.ChangeProductDto;
import com.example.lastterms.dto.ProductDto;
import com.example.lastterms.dto.ProductResponseDto;
import com.example.lastterms.dto.SignUpResultDto;
import com.example.lastterms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/insert")
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody ProductDto productDto) throws Exception {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping("/change")
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductDto changeProductDto) throws Exception{
        ProductResponseDto productResponseDto = productService.changeProductName(changeProductDto.getNumber(), changeProductDto.getName());
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponseDto>> allProduct() {
        List<ProductResponseDto> productResponseDto = productService.productList();
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping("/listOrderByPrice")
    public ResponseEntity<List<ProductResponseDto>> OrderByPriceProduct() {
        List<ProductResponseDto> productResponseDto = productService.productListOrderByProduct();
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    //이름 검색 구현 x
    @GetMapping("/byName")
    public ResponseEntity<List<ProductResponseDto>> selectProductByName() {
        List<ProductResponseDto> productResponseDto = productService.productList();
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping("/")
    public ResponseEntity<ProductResponseDto> getProduct(Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

}