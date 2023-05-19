package com.ssafy.enjoytrip.util.encrypt;

public interface Encrypt {
    public String encrypt(String data) throws Exception;

    public String decrypt(String encryted) throws Exception;
}
