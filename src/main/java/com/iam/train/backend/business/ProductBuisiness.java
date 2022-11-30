package com.iam.train.backend.business;

import com.iam.train.backend.Exception.BaseException;
import com.iam.train.backend.Exception.ProductException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
/** ต่าที่ได้จะถูกส่งมาจัดการที่หน้านี้ เป็นกระบวนการ Process */
public class ProductBuisiness {


    public  String getProductbyId(String id) throws BaseException {
        //Todo: get data from database
        if (Objects.equals("1234" ,id)){
            throw ProductException.notfound();
        }
        return id;
    }
}
