package com.aptech.advertising.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.aptech.advertising.entity.Users;
import com.aptech.advertising.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@ResultPath(value = "/")
@Action(value = "/addUser", results = { @Result(name = "success", location = "/WEB-INF/content/user.jsp"),
        @Result(name = "error", location = "/WEB-INF/content/user.jsp") })
public class UserAddAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private String username;
    private String password;
    private String role;
    private String smg;
    private List<Users> userALL;

    public String execute() throws IOException {
        if (StringUtils.isBlank(username)) {
            smg = "Username is empty pls provide.";
        }
        else if (StringUtils.isBlank(password)) {
            smg = "Password is empty pls provide.";
        }
        else if (StringUtils.isBlank(role)) {
            smg = "Role is empty pls provide";
        } else {
            Users user = userServiceImpl.findUser(username, password);
            if (user.equals(null)) {
                if (userServiceImpl.add(username, password, role)) {
                    addActionMessage("Create User is successfully.");
                }
            } else {
                smg = "User already exsit.";
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
