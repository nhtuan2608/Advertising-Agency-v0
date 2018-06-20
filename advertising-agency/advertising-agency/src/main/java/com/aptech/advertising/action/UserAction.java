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
@Action(value = "/alluser", results = { @Result(name = "success", location = "/WEB-INF/content/user.jsp"),
        @Result(name = "error", location = "/WEB-INF/content/login.jsp") })
public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private List<Users> userALL;
    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    public String execute() throws IOException {
        userALL = userServiceImpl.allUser();
        return SUCCESS;
    }

    public List<Users> getUserALL() {
        return userALL;
    }

    public void setUserALL(List<Users> userALL) {
        this.userALL = userALL;
    }

}
