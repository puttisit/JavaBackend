package com.iam.train.backend.Exception;

public class FileException extends BaseException {
    public FileException(String code) {
        super("Product." + code);
    }
    public static FileException filenull(){
        return new FileException("Not founds");
    }
    public static FileException filemaxsize(){
        return new FileException("Not founds");
    }
    public static FileException unsupport(){
        return new FileException("Not founds");
    }
}
