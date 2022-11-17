/**
 * 
 */
package com.carvalho.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvalho.api.domain.model.Agenda;

/**
 * manoel.carvalho
 *
 */
@Repository
public interface IAgendaRepository extends JpaRepository<Agenda, Long>{

}
