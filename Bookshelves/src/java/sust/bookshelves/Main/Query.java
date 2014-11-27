/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.bookshelves.Main;

import java.util.List;
import sust.bookshelves.entity.User;
import sust.bookshelves.exception.GenericBusinessException;
import sust.bookshelves.session.UserService;

/**
 *
 * @author Sm19
 */
public class Query {

    public static void main(String args[]) throws GenericBusinessException {
        
        UserService userService =new UserService();
        List<User> userList=userService.getUserList();
        
        for(int i=0;i<userList.size();i++) {
            
            System.out.println("Name: "+userList.get(i).getUsername());
        }
    }
}
