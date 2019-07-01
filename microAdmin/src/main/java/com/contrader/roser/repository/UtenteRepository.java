package com.contrader.roser.repository;

import com.contrader.roser.domain.Utente;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Utente entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

}
