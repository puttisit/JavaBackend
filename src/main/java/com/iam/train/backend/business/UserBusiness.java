package com.iam.train.backend.business;


import com.iam.train.backend.Exception.BaseException;
import com.iam.train.backend.Exception.FileException;
import com.iam.train.backend.Exception.UserException;
import com.iam.train.backend.entity.User;
import com.iam.train.backend.model.MRegisrRequest;
import com.iam.train.backend.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * ต่าที่ได้จะถูกส่งมาจัดการที่หน้านี้ เป็นกระบวนการ Process
 */
@Service
public class UserBusiness {
    /** Exception ด้วยตัวของ Java */
    /**
     * public String register(MRegisrRequest request) throws IOException {
     * if(request == null){
     * throw new IOException("null...request");
     * }
     * <p>
     * if( Objects.isNull(request.getEmail())){
     * throw new IOException("null...request");
     * }
     * return "";
     * }
     */
    private final UserService userService;

    public UserBusiness(UserService userService) {
        this.userService = userService;
    }

    public User register(MRegisrRequest request) throws BaseException {
        User user = userService.create(request.getEmail(), request.getPassword(), request.getName());
        //TODO MAPPER
        return user;

      /* if (request == null) {
            throw UserException.requestnull();
        }

        if (Objects.isNull(request.getEmail())) {
            throw UserException.emailnull();
        }
        return "test";*/
    }
    /** รับรูปภาพ */
    public String updalodProPicture (MultipartFile file) throws BaseException {
        //เช็คไฟล์ว่างมั้ย
        if (file == null){
            throw FileException.filenull();
        }
        //เช็คขนาด
        if (file.getSize() > 1048576 *2){
            throw FileException.filemaxsize();
        }

        //เช็คปรเเภทว่าเป็น Null
        String content = file.getContentType();  // สร้างตัวแปรขึ้นมารองรับ
        if (content == null){
            throw FileException.unsupport();
        }

        //เช็คประเภทของไฟล์รูป
        List<String> supportType = Arrays.asList("image/png","image/jpg");

        if (supportType.contains(content)){
            throw FileException.unsupport();
        }
        //TODO:upload file to Storage
        try {
            byte[] pytes = file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
