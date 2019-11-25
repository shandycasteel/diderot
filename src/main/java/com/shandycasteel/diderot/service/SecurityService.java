package com.shandycasteel.diderot.service;

public interface SecurityService {
    String findLoggedInEmail();

    void autoLogin(String email, String password);
}
