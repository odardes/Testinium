package com.testinium.objects;

import com.testinium.objects.User;

public class UserPool {

    public static User buyer() {
        return new User("senaguventurk@hotmail.com", "123456A");
    }

    public static User buyerWithIncorrectPassword() {
        return new User("senaguventurk@hotmail.com", "dasdas");
    }

    public static User buyerWithIncorrectEmail() {
        return new User("senaguventurk@gmail.com", "123456A");
    }
    
    //Many users can set here easily
}
