package com.tweteroo.tweteroo;

public class User {
  private String username;
  private String avatar;

  public User(String username, String avatar) {
    this.username = username;
    this.avatar = avatar;
  }

  public String getUsername() {
    return username;
  }

  public String getAvatar() {
    return avatar;
  }

}
