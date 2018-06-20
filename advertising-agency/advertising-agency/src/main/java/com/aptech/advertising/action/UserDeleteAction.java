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
@Action(value = "/deleteUser", results = { @Result(name = "success", location = "/WEB-INF/content/user.jsp"),
        @Result(name = "error", location = "/WEB-INF/content/user.jsp") })
public class UserDeleteAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private String userId;
    private List<Users> userALL;

    public String execute() throws IOException {
        if (userServiceImpl.deleteUser(userId) > 0) {
            addActionMessage("Delete successfully.");
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

    public List<Users> getUserALL() {
        return userALL;
    }

    public void setUserALL(List<Users> userALL) {
        this.userALL = userALL;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
