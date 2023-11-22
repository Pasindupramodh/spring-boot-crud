package com.example.first.repo;

import com.example.first.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user WHERE id=?1",nativeQuery = true)
    User getUserByUserId(String userId);

    @Query(value = "SELECT * FROM user WHERE id=?1 AND address=?2",nativeQuery = true)
    User getUserByIdAndAddress(String id,String address);

    //@Modifying for update query
}
