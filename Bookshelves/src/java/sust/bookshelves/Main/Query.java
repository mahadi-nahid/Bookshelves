package sust.bookshelves.Main;

import java.util.List;
import sust.bookshelves.entity.User;
import sust.bookshelves.exception.GenericBusinessException;
import sust.bookshelves.session.UserService;

/**
 *
 * @author Sm19 & MahadiHasanNahid
 */
public class Query {

    public static void main(String args[]) throws GenericBusinessException {

        UserService userService = new UserService(); // because we want user list..
        List<User> userLists = userService.getUserList(); // userService.getUserList() returns the user list

        for (User user : userLists) {
            System.out.println("Name: " + user.getUsername()); // user.getUsername()) will return the name of the user. 
            System.out.println("Address : " +user.getAddress());
            System.out.println("Email : "+user.getEmail());
        }
    }
}
