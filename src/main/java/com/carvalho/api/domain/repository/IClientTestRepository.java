/**
 * 
 */
package com.carvalho.api.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvalho.api.domain.model.ClientTest;

/**
 * manoel.carvalho
 *
 */
@Repository
public interface IClientTestRepository extends JpaRepository<ClientTest, Long> {
	
	List<ClientTest> findByNome(String nome);
	List<ClientTest> findByNomeContaining(String nome);
	Optional<ClientTest> findByEmail(String email);
	

}
