
package com.server.jwt.entity;

        import com.server.jwt.service.UserService;

        import javax.persistence.*;
        import java.util.Set;

@Entity
public class Identifier {

    @Id
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
