/*

 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package org.superbiz.struts;

import org.springframework.stereotype.Component;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.List;
import java.util.Properties;

@Component
public class ListAllUsers {

    private UserService userService;

    public ListAllUsers(UserService userService) {
        this.userService = userService;
    }

    private int id;
    private String errorMessage;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String execute() {
        try {
            /*UserService service = null;
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.openejb.core.LocalInitialContextFactory");
            Context ctx = new InitialContext(props);
            service = (UserService) ctx.lookup("UserServiceImplLocal");
            this.users = service.findAll();*/
            this.users = userService.findAll();
        } catch (Exception e) {
            this.errorMessage = e.getMessage();
            return "failure";
        }
        return "success";
    }
}
