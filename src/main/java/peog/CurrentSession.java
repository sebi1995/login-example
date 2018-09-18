package peog;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import peog.entities.User;

public class CurrentSession {


    private static final CurrentSession session = new CurrentSession();
    private static Authentication auth;
    private static User user;

    private CurrentSession() {
        auth = SecurityContextHolder.getContext().getAuthentication();
        user = (User) auth.getPrincipal();
    }

    public void refreshSession() {
        auth = SecurityContextHolder.getContext().getAuthentication();
        user = (User) auth.getPrincipal();
    }

    public static User getUser(){
        return CurrentSession.user;
    }
}
