package com.aptech.advertising.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.aptech.advertising.entity.Users;
import com.aptech.advertising.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@ResultPath(value = "/")
@Action(value = "/editUser", results = { @Result(name = "success", location = "/WEB-INF/content/user.jsp"),
        @Result(name = "error", location = "/WEB-INF/content/user.jsp") })
public class UserEditAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private String username;
    private String password;
    private String role;
    private String smg;
    private int userId;
    private List<Users> userALL;

    public String execute() throws IOException {
        Users user = userServiceImpl.findUserById(userId);
        if (!user.equals(null)) {
            username = user.getUserName();
            password = user.getPassword();
            role = user.getRole();
            if(userServiceImpl.updateUser(user)) {
                addActionMessage("Update successfully.");
            }
            
        }
        userALL = userServiceImpl.allUser();
        return SUCCESS;
    }

    public UserServiceImpl getUserServiceImpl() {
        return userServiceImpl;
    }

    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSmg() {
        return smg;
    }

    public void setSmg(String smg) {
        this.smg = smg;
    }

    public List<Users> getUserALL() {
        return userALL;
    }

    public void setUserALL(List<Users> userALL) {
        this.userALL = userALL;
    }

}
