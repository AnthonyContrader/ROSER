package com.contrader.roser.service.mapper;

import com.contrader.roser.domain.*;
import com.contrader.roser.service.dto.UtenteDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Utente and its DTO UtenteDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UtenteMapper extends EntityMapper<UtenteDTO, Utente> {



    default Utente fromId(Long id) {
        if (id == null) {
            return null;
        }
        Utente utente = new Utente();
        utente.setId(id);
        return utente;
    }
}
