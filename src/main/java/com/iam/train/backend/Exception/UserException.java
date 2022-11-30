package com.iam.train.backend.Exception;

public class UserException extends BaseException {
    public UserException(String code) {
        super("user." + code);
    }

    public  static  UserException requestnull(){
        return  new UserException("register.request.null");
    }
    //user.register.email.null
    public  static  UserException emailnull(){
        return  new UserException("register.email.null");
    }
}
