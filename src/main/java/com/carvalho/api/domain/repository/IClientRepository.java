/**
 * 
 */
package com.carvalho.api.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvalho.api.domain.model.Clients;

/**
 * manoel.carvalho
 *
 */

@Repository
public interface IClientRepository extends JpaRepository<Clients, Long> {

		List<Clients> findByNome(String nome);
		List<Clients> findByNomeContaining(String nome);
		Optional<Clients> findByEmail(String email);
}
