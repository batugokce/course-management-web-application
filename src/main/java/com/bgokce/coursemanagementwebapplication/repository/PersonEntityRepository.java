package com.bgokce.coursemanagementwebapplication.repository;

import com.bgokce.coursemanagementwebapplication.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity, Long> {

    PersonEntity findByUsername(String username);

    @Query("select p from PersonEntity p left join fetch p.authorities where p.username = :username")
    PersonEntity findByUserNameWithAuthorities(String username);
}
