package com.aptech.advertising.service;

import java.io.IOException;
import java.util.List;

import com.aptech.advertising.entity.Users;

public interface UserService {
    /**
     * This method to check Username ,password exsit or not.
     * 
     * @author son.nguyen
     * @date 2018/05/11
     * @param userName
     * @param password
     * @return
     */
    Users findUser(String userName, String password) throws IOException;

    /**
     * This method to get ALL user.
     * 
     * @author sonpc
     * @date 2018/05/18
     * @return
     * @throws IOException
     */
    List<Users> allUser() throws IOException;

    /**
     * This method to check status insert.
     * 
     * @author sonpc
     * @date 2018/05/20
     * @param username
     * @param password
     * @param role
     * @return
     */

    boolean add(String username, String password, String role) throws IOException;

    /**
     * This method to delete user
     * 
     * @author sonpc
     * @date 2018/05/22
     * @param userId
     * @return
     */
    Integer deleteUser(String userId) throws IOException;

    /**
     * This method to find user by id.
     * 
     * @author son.nguyen
     * @date 2018/05/11
     * @param userName
     * @param password
     * @return
     */
    Users findUserById(int userId) throws IOException;

    /**
     * This method to update user.
     * 
     * @author sonpc
     * @date 2018/23/05
     * @param user
     * @return
     */
    boolean updateUser(Users user) throws IOException;

}
