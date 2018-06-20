<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="main">
        <div id="rightContent">
           <h3>User</h3>
           <div class="sukses">
                <span style="color:red;"><s:property value="smg"/></span>
                <s:if test="hasActionMessages()">
                      <s:actionmessage/>
                </s:if>
                <br><br>
               <s:form action="addUser" method="post"  style="align:center">
                    <table>
                        <tr>
                            <th><b>UserName:        </b><input type="text" name="username" value='<s:property value="username"/>'></th><br>
                            <th><b>Password:        </b><input type="password"  name="password" value='<s:property value="password"/>'></th>
                            <th><b>Role:            </b><input type="text" name="role" value='<s:property value="role"/>'></th>
                        </tr>
                        <tr>
                            <th>
                                 <button name="submitType" value="addUser" type="submit">Add</button>
                                 <button name="submitType" value="editUser" type="submit">Update</button>
                            </th>
                        </tr>
                     </table>
               </s:form> 
               <div>
                   <table class="data">
                         <tr class="data">
                              <th class="data" width="30px">No</th>
                              <th class="data">Username</th>
                              <th class="data">Password</th>
                              <th class="data">Role</th>
                              <th class="data">Action</th>
                          </tr>
                          <s:iterator var="user" value="userALL">
                              <tr>
                              <th width="30px"><s:property value="#user.userId"/></th>
                              <th><s:property value="#user.userName"/></th>
                              <th><s:property value="#user.password"/></th>
                              <th><s:property value="#user.role"/></th>
                              <th>
                              <a href="editUser.action?userId=<s:property value="#user.userId"/>">
                                    <button style="background-color: #008CBA;color: white;">Edit</button>
                              </a>
                              <a href="deleteUser.action?userId=<s:property value="#user.userId"/>" onClick="return confirm('Do you want to delete this user?');">
                                    <button style="background-color: red;color: white;">Delete</button>
                              </a>
                              </th>
                              </tr>
                          </s:iterator>
                   </table>
               </div>
           </div>
        </div>
        
    </tiles:putAttribute>
</tiles:insertDefinition>