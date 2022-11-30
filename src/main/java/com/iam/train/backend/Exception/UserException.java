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

    //create
    public  static  UserException createemailnull(){
        return  new UserException("create.email.null");
    }
    public  static  UserException createemailduplicate(){
        return  new UserException("create.email.duplicate");
    }
    public  static  UserException createpasswordnull(){
        return  new UserException("create.password.null");
    }
    public  static  UserException createnamenull(){
        return  new UserException("create.name.null");
    }
}
