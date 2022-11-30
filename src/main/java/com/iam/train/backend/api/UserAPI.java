package com.iam.train.backend.api;


import com.iam.train.backend.Exception.BaseException;
import com.iam.train.backend.business.UserBusiness;
import com.iam.train.backend.entity.User;
import com.iam.train.backend.model.MRegisrRequest;
import com.iam.train.backend.model.TestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
/**  */
/** หน้านี้สอนการทำการหน้า API */
public class UserAPI {
    // method : 1 field injection
    //@Autowired
    //private TestBusiness tb;
    // method : 2 Constuck Injection
    //เพิ่ม Model เพื่เอเรียกใช้งาน
    private final UserBusiness business;
    public UserAPI(UserBusiness business) {
        this.business = business;
    }

    @GetMapping
    public TestResponse test(){
        TestResponse response = new TestResponse();
        response.setName("noom");
        response.setFood("KFC");
        return response;
    }

    @GetMapping("/user")
    public TestResponse test2(){
        TestResponse response = new TestResponse();
        response.setName("noom");
        response.setFood("MAC");
        return response;
    }

    /** ส่งค่าไปที่  business เพื่อให่ได้ข้อมูล */
    @PostMapping
    @RequestMapping("/register")/** เชีบยนมีการเช็คเงื่อนไขในการทำงาน   เปลี่ยนจาก String >> User*/
    public ResponseEntity<User> register(@RequestBody MRegisrRequest request) throws BaseException { /** ต้องได้ค่าตาม MRegisrRequest */
        User response = business.register(request);
        return ResponseEntity.ok(response);
        /**throws BaseException string จะเป็นผู้จัดการให้เราเอง*/
    }
    /** การส่งไฟล์รุป */
    @PostMapping
    public ResponseEntity <String> updalodProPicture(@RequestPart MultipartFile file) throws BaseException {
        String response = business.updalodProPicture(file);
        return ResponseEntity.ok(response);
    }






}
