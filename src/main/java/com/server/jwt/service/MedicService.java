

package com.server.jwt.service;

        import com.server.jwt.dao.DocDao;
        import com.server.jwt.dao.RoleDao;
        import com.server.jwt.dao.UserDao;
        import com.server.jwt.entity.MedicalPractitioner;
        import com.server.jwt.entity.Role;
        import com.server.jwt.entity.User;
        import com.server.jwt.models.supporting.Identifier;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.sql.SQLIntegrityConstraintViolationException;
        import java.util.HashSet;
        import java.util.List;
        import java.util.Set;

@Service
public class MedicService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private DocDao docDao;


    public String addRoleDoctorToExistingUser(MedicalPractitioner mp) throws SQLIntegrityConstraintViolationException {

        //TODO make user_Id be unique
        if (userDao.existsById(mp.getMedicUsername().getUserName())) {
            User user = userDao.findById(mp.getMedicUsername().getUserName()).get();
            Role role = roleDao.findById(2).get();
            Role roleSecond = roleDao.findById(1).get();
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(role);
            userRoles.add(roleSecond);
            user.setRole(userRoles);
            userDao.save(user);

            mp.setMedicUsername(user);

        } else {
            return "User does not exist";
        }

        try {
            docDao.save(mp);
        } catch (Exception e) {
            return "Already exist";
        }
        return "Successful";
    }

    public String editPatientDoctorSet(Integer doctor, Set<Identifier> patients) throws SQLIntegrityConstraintViolationException {

        if (docDao.existsById(doctor)){
            MedicalPractitioner medic = docDao.findById(doctor).get();

            Set<User> userPatients = new HashSet<>();
            try {
                for (Identifier patient : patients) {
                    if(userDao.existsById(patient.getUserName())){
                        User userPatient = userDao.findById(patient.getUserName()).get();
                        userPatients.add(userPatient);
                    }else{
                        continue;
                    }
                }
                medic.setUsers(userPatients);
                docDao.save(medic);
            } catch (Exception e) {
                return "Something wrong with the record";
            }
        }else {
            return "Medic does not exist";
        }
        return "Successful";

    }
}