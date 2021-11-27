package com.server.jwt.service;

import com.server.jwt.dao.RoleDao;
import com.server.jwt.dao.UserDao;
import com.server.jwt.entity.Identifier;
import com.server.jwt.entity.Role;
import com.server.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

//        Role adminRole = new Role();
//        adminRole.setRoleId(0);
//        adminRole.setRoleDescription("Admin role");
//        roleDao.save(adminRole);
//
//        Role userRole = new Role();
//        userRole.setRoleName("User");
//        userRole.setRoleDescription("Default role for newly created record");
//        roleDao.save(userRole);

//        User adminUser = new User();
//        adminUser.setUserName("admin123");
//        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
//        adminUser.setUserFirstName("admin");
//        adminUser.setUserLastName("admin");
//        Set<Role> adminRoles = new HashSet<>();
//        adminRoles.add(adminRole);
//        adminUser.setRole(adminRoles);
//        userDao.save(adminUser);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById(2).get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public String addRoleToExistingUser(Identifier userNameId){

        if( userDao.existsById(userNameId.getUserName()) ){
            User user=userDao.findById(userNameId.getUserName()).get();
            Role role= roleDao.findById(2).get();
            Role roleSecond = roleDao.findById(1).get();
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(role);
            userRoles.add(roleSecond);
            user.setRole(userRoles);
            userDao.save(user);
            return  "User's role changed successfully";
        }else{
            return  "User is not found";
        }
    }


//    public static String encryptThisString(String input) {
//        try {
//            // getInstance() method is called with algorithm SHA-512
//            MessageDigest md = MessageDigest.getInstance("SHA-512");
//
//            // digest() method is called
//            // to calculate message digest of the input string
//            // returned as array of byte
//            byte[] messageDigest = md.digest(input.getBytes());
//
//            // Convert byte array into signum representation
//            BigInteger no = new BigInteger(1, messageDigest);
//
//            // Convert message digest into hex value
//            String hashtext = no.toString(16);
//
//            // Add preceding 0s to make it 32 bit
//            while (hashtext.length() < 32) {
//                hashtext = "0" + hashtext;
//            }
//
//            // return the HashText
//            return hashtext;
//        }
//
//        // For specifying wrong message digest algorithms
//        catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public String getEncodedPassword(String password) {
//        return encryptThisString(password);
        return passwordEncoder.encode(password);
    }
}
