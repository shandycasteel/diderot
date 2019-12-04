package com.shandycasteel.diderot.service;

public interface SecurityService {
  String findLoggedInUsername();

  void autoLogin(String username, String password);
}
