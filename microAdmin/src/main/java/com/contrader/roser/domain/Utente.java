package com.contrader.roser.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Utente.
 */
@Entity
@Table(name = "utente")
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "congome", nullable = false)
    private String congome;

    @NotNull
    @Column(name = "user_name", nullable = false)
    private String userName;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Utente nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCongome() {
        return congome;
    }

    public Utente congome(String congome) {
        this.congome = congome;
        return this;
    }

    public void setCongome(String congome) {
        this.congome = congome;
    }

    public String getUserName() {
        return userName;
    }

    public Utente userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Utente utente = (Utente) o;
        if (utente.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), utente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Utente{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", congome='" + getCongome() + "'" +
            ", userName='" + getUserName() + "'" +
            "}";
    }
}
