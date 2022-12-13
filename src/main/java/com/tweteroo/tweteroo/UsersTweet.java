package com.tweteroo.tweteroo;

public class UsersTweet {
  private String username;
  private String avatar;
  private String tweet;

  public UsersTweet(String username, String avatar, String tweet) {
    this.tweet = tweet;
    this.avatar = avatar;
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public String getAvatar() {
    return avatar;
  }

  public String getTweet() {
    return tweet;
  }
}
