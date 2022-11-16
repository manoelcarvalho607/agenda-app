/**
 * 
 */
package com.carvalho.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvalho.api.domain.model.Users;

/**
 * manoel.carvalho
 *
 */
@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {

}
