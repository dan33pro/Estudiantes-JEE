/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ducar
 */
@Entity
@Table(name = "ESTUDIANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByEstudianteId", query = "SELECT e FROM Estudiante e WHERE e.estudianteId = :estudianteId"),
    @NamedQuery(name = "Estudiante.findByFirstName", query = "SELECT e FROM Estudiante e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Estudiante.findByLastName", query = "SELECT e FROM Estudiante e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Estudiante.findByYearLevel", query = "SELECT e FROM Estudiante e WHERE e.yearLevel = :yearLevel")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTUDIANTE_ID")
    private Integer estudianteId;
    @Size(max = 50)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "YEAR_LEVEL")
    private Integer yearLevel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private Collection<Matricula> matriculaCollection;

    public Estudiante() {
    }

    public Estudiante(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Estudiante(Integer estudianteId, String firstName, String lastName, Integer yearLevel) {
        this.estudianteId = estudianteId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearLevel = yearLevel;
    }

    
    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(Integer yearLevel) {
        this.yearLevel = yearLevel;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteId != null ? estudianteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estudianteId == null && other.estudianteId != null) || (this.estudianteId != null && !this.estudianteId.equals(other.estudianteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.estudiante.entity.Estudiante[ estudianteId=" + estudianteId + " ]";
    }
    
}
