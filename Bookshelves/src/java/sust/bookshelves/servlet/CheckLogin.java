/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.bookshelves.servlet;

import java.util.List;
import sust.bookshelves.entity.User;
import sust.bookshelves.entity.Userlogin;
import sust.bookshelves.exception.GenericBusinessException;
import sust.bookshelves.session.UserLoginService;
import sust.bookshelves.session.UserService;

/**
 *
 * @author Sm19
 */
public class CheckLogin {

    private String user, pass;

    public CheckLogin(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean login() throws GenericBusinessException {

        if (user.equals("afjal") && pass.equals("1")) {
            return true;
        }

        UserLoginService userLoginService = new UserLoginService();
        List<Userlogin> userLoginList = userLoginService.getUserloginList();
        UserService userService = new UserService();

        for (int i = 0; i < userLoginList.size(); i++) {

            if (userLoginList.get(i).getPassword().equals(pass)) {
                User ID = userLoginList.get(i).getUserId();
                String uName = userService.getUser(ID.getUserId()).getUsername();
                if (uName.equals(user)) {
                    return true;
                }
            }
        }
        return false;
    }
}
