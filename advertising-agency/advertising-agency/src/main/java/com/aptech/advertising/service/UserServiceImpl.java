package com.aptech.advertising.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.aptech.advertising.dao.UserDaoImpl;
import com.aptech.advertising.entity.Users;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDAO = new UserDaoImpl();

    /**
     * This method to check Username ,password exsit or not.
     * 
     * @author son.nguyen
     * @date 2018/05/11
     * @param userName
     * @param password
     * @return
     */
    public Users findUser(String userName, String password) throws IOException {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            return null;
        }
        return userDAO.findUser(userName, password);
    }

    /**
     * This method to get ALL user.
     * 
     * @author sonpc
     * @date 2018/05/18
     * @return
     * @throws IOException
     */
    public List<Users> allUser() throws IOException {
        return userDAO.allUser();
    }

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
    public boolean add(String username, String password, String role) throws IOException {
        return userDAO.add(username, password, role);
    }

    /**
     * This method to delete user
     * 
     * @author sonpc
     * @date 2018/05/22
     * @param userId
     * @return
     */
    public Integer deleteUser(String userId) throws IOException {
        return userDAO.deleteUser(userId);
    }

    /**
     * This method to find user by id.
     * 
     * @author son.nguyen
     * @date 2018/05/11
     * @param userName
     * @param password
     * @return
     */
    public Users findUserById(int userId) throws IOException {
        return userDAO.findUserById(userId);
    }

    /**
     * This method to update user.
     * 
     * @author sonpc
     * @date 2018/23/05
     * @param user
     * @return
     */
    public boolean updateUser(Users user) throws IOException {
        return userDAO.updateUser(user);
    }

}
