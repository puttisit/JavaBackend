package com.iam.train.backend.business;


import com.iam.train.backend.Exception.BaseException;
import com.iam.train.backend.Exception.UserException;
import com.iam.train.backend.model.MRegisrRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * ต่าที่ได้จะถูกส่งมาจัดการที่หน้านี้ เป็นกระบวนการ Process
 */
@Service
public class TestBusiness {
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

    public String register(MRegisrRequest request) throws BaseException {
        if (request == null) {
            throw UserException.requestnull();
        }

        if (Objects.isNull(request.getEmail())) {
            throw UserException.emailnull();
        }
        return "";
    }
}
