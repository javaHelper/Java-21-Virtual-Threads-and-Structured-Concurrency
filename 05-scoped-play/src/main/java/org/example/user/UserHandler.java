package org.example.user;

import org.example.ThreadLocalSimplePlay;

public class UserHandler {

    public void handle() {
        
        User requestUser = ThreadLocalSimplePlay.user.get();
        print("handle - User => " + requestUser);
        
        // handle user 'requestUser'
    }

    public static void print(String m) {
        ThreadLocalSimplePlay.print(m);
    }

}