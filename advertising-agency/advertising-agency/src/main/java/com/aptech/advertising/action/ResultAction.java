package com.aptech.advertising.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.aptech.advertising.actionfrom.LoginActionForm;
import com.aptech.advertising.entity.Users;
import com.aptech.advertising.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@ResultPath(value = "/")
@Action(value = "/result", results = { @Result(name = "success", location = "/WEB-INF/content/user.jsp"),
        @Result(name = "error", location = "/WEB-INF/content/login.jsp") })

public class ResultAction extends ActionSupport {
    private String userName;
    private String password;
    private String messageErr;
    private static final long serialVersionUID = 1L;
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private LoginActionForm form = new LoginActionForm();
    List<Users> userALL;
    Users users;

    public String execute() throws IOException {
        users = userServiceImpl.findUser(userName, password);
        if (users == null) {
            messageErr = "In validate username and password.";
            return ERROR;
        } else {
            userALL = userServiceImpl.allUser();
            return SUCCESS;
        }

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessageErr() {
        return messageErr;
    }

    public void setMessageErr(String messageErr) {
        this.messageErr = messageErr;
    }

    public LoginActionForm getLoginActionForm() {
        return form;
    }

    public LoginActionForm getForm() {
        return form;
    }

    public void setForm(LoginActionForm form) {
        this.form = form;
    }

    public List<Users> getUserALL() {
        return userALL;
    }

    public void setUserALL(List<Users> userALL) {
        this.userALL = userALL;
    }

}
