
package com.server.jwt.models.supporting;

        import com.server.jwt.service.UserService;

        import javax.persistence.*;
        import java.util.Set;


public class Identifier {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
