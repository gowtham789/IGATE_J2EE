package com.igate.lesson20.mock;

public interface UserDAO {
User loadByUserNameAndPassword(String username, String password);
}
