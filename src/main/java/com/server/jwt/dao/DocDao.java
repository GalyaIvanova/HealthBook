
package com.server.jwt.dao;

        import com.server.jwt.entity.MedicalPractitioner;
        import com.server.jwt.entity.User;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

//        import java.util.Optional;

@Repository
public interface DocDao extends CrudRepository<MedicalPractitioner, Integer> { }
