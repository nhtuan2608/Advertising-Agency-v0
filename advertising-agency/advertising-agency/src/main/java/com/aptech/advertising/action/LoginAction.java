package com.aptech.advertising.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Action("/login")
@ResultPath(value = "/")
@Result(name = "success", location = "/WEB-INF/content/login.jsp")
@ParentPackage("struts-default")
public class LoginAction extends ActionSupport {
    public String execute() {
        return SUCCESS;
    }

}
