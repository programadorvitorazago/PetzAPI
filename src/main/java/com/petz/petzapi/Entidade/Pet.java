/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petz.petzapi.Entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vitor
 */
@Entity
@Table(name = "pet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pet.findAll", query = "SELECT p FROM Pet p"),
    @NamedQuery(name = "Pet.findById", query = "SELECT p FROM Pet p WHERE p.id = :id"),
    @NamedQuery(name = "Pet.findByNome", query = "SELECT p FROM Pet p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pet.findByTipo", query = "SELECT p FROM Pet p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Pet.findByRaca", query = "SELECT p FROM Pet p WHERE p.raca = :raca"),
    @NamedQuery(name = "Pet.findByDataNascimento", query = "SELECT p FROM Pet p WHERE p.dataNascimento = :dataNascimento")})
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "Tipo")
    private String tipo;
    @Size(max = 100)
    @Column(name = "Raca")
    private String raca;
    @Size(max = 255)
    @Column(name = "DataNascimento")
    private String dataNascimento;

    public Pet() {
    }

    public Pet(Integer id) {
        this.id = id;
    }

    public Pet(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pet)) {
            return false;
        }
        Pet other = (Pet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.petz.petzapi.Entidade.Pet[ id=" + id + " ]";
    }
    
}
