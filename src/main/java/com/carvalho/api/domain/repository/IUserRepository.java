/**
 * 
 */
package com.carvalho.api.domain.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.carvalho.api.domain.model.Users;

/**
 * manoel.carvalho
 *
 */
@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmail(String email);

	

}
