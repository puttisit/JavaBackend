package com.iam.train.backend.api;

import com.iam.train.backend.Exception.BaseException;
import com.iam.train.backend.business.ProductBuisiness;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductAPI {
    //เพิ่ม Model เพื่เอเรียกใช้งาน
    private final ProductBuisiness productBuisiness;

    public ProductAPI(ProductBuisiness productBuisiness) {
        this.productBuisiness = productBuisiness;
    }
    //เพิ่ม Model เพื่เอเรียกใช้งาน

    @GetMapping(path ="/{id}")
    public ResponseEntity <String> Products (@PathVariable("id") String id) throws BaseException {
        String response = productBuisiness.getProductbyId(id);
        return  ResponseEntity.ok(response);
    }



}
