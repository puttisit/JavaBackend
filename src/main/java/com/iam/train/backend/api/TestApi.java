package com.iam.train.backend.api;


import com.iam.train.backend.Exception.BaseException;
import com.iam.train.backend.business.TestBusiness;
import com.iam.train.backend.model.MRegisrRequest;
import com.iam.train.backend.model.TestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
/**  */
/** หน้านี้สอนการทำการหน้า API */
public class TestApi {
    // method : 1 field injection
    //@Autowired
    //private TestBusiness tb;
    // method : 2 Constuck Injection
    //เพิ่ม Model เพื่เอเรียกใช้งาน
    private final TestBusiness business;
    public TestApi(TestBusiness business) {
        this.business = business;
    }

    @GetMapping
    public TestResponse test(){
        TestResponse response = new TestResponse();
        response.setName("noom");
        response.setFood("KFC");
        return response;
    }

    @GetMapping("/2")
    public TestResponse test2(){
        TestResponse response = new TestResponse();
        response.setName("noom");
        response.setFood("MAC");
        return response;
    }

    /** ส่งค่าไปที่  business เพื่อให่ได้ข้อมูล */
    @PostMapping
    @RequestMapping("/register")/** เชีบยนมีการเช็คเงื่อนไขในการทำงาน */
    public ResponseEntity <String> register(@RequestBody MRegisrRequest request) throws BaseException { /** ต้องได้ค่าตาม MRegisrRequest */
        String response = null;
        response = business.register(request);
        return ResponseEntity.ok(response);
        /**return response;*/
        /** throws BaseException string จะเป็นผู้จัดการให้เราเอง*/
    }





}
