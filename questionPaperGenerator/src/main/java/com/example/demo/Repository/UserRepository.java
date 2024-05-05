package com.example.demo.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.UserEntity;

@Repository
public interface UserRepository extends  CrudRepository<UserEntity, Integer> {

	@Query("SELECT userentitylist FROM UserEntity userentitylist WHERE useridpk in (:userid)")
	UserEntity getUserByID(Integer userid);
	
	@Query("SELECT userentitylist FROM UserEntity userentitylist WHERE userrollid in (:userrollid)")
	List<UserEntity> getUserByRollID(String userrollid);
	
	@Query("SELECT userentitylist FROM UserEntity userentitylist")
	List<UserEntity> getUserlist();
}
