package com.shandycasteel.diderot.servicies;

public interface SecurityService {
  String findLoggedInUsername();

  void autoLogin(String username, String password);
}
