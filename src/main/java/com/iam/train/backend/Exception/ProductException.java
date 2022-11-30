package com.iam.train.backend.Exception;

public class ProductException extends BaseException {
    public ProductException(String code) {
        super("Product." + code);
    }
    public static ProductException notfound(){
        return new ProductException("Not founds");
    }
}
