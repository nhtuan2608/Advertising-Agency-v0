package com.aptech.advertising.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aptech.advertising.entity.Users;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class UserDaoImpl implements UserDAO {

    /**
     * This method to check Username ,password exsit or not.
     * 
     * @author son.nguyen
     * @date 2018/05/11
     * @param userName
     * @param password
     * @return
     * @throws IOException
     */
    public Users findUser(String userName, String password) throws IOException {
        Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

        Users user = null;
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userName", userName);
        paramMap.put("password", password);
        try {
            user = (Users) smc.queryForObject("Users.getUserByUserNamePassword", paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * This method to get ALL user.
     * 
     * @author sonpc
     * @date 2018/05/18
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public List<Users> allUser() throws IOException {
        Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
        List<Users> userList = null;
        try {
            userList = (List<Users>) smc.queryForList("Users.getALLUser");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
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
        Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        paramMap.put("role", role);
        try {
            smc.insert("Users.addUser", paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
        Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
        Integer ret = 0;
        try {
            ret = (Integer) smc.delete("Users.deleteUser", userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
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
        Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

        Users user = null;
        Map<String, Integer> paramMap = new HashMap<String, Integer>();
        paramMap.put("userId", userId);
        try {
            user = (Users) smc.queryForObject("Users.getUserById", paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
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
        Boolean ret = true;
        Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userId", user.getUserId());
        paramMap.put("username", user.getUserName());
        paramMap.put("password", user.getPassword());
        paramMap.put("role", user.getRole());
        try {
            smc.update("Users.updateUser", paramMap);
            ret = true;
        } catch (SQLException e) {
            e.printStackTrace();
            ret = false;
        }
        return ret;
    }

}
