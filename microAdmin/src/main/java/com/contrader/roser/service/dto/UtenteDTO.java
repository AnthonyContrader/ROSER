package com.contrader.roser.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Utente entity.
 */
public class UtenteDTO implements Serializable {

    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String congome;

    @NotNull
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCongome() {
        return congome;
    }

    public void setCongome(String congome) {
        this.congome = congome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UtenteDTO utenteDTO = (UtenteDTO) o;
        if (utenteDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), utenteDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UtenteDTO{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", congome='" + getCongome() + "'" +
            ", userName='" + getUserName() + "'" +
            "}";
    }
}
