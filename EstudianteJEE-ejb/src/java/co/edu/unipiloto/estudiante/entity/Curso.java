/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCodCurso", query = "SELECT c FROM Curso c WHERE c.codCurso = :codCurso"),
    @NamedQuery(name = "Curso.findByNombreCurso", query = "SELECT c FROM Curso c WHERE c.nombreCurso = :nombreCurso"),
    @NamedQuery(name = "Curso.findByNumCreditosCurso", query = "SELECT c FROM Curso c WHERE c.numCreditosCurso = :numCreditosCurso"),
    @NamedQuery(name = "Curso.findBySemestreCurso", query = "SELECT c FROM Curso c WHERE c.semestreCurso = :semestreCurso"),
    @NamedQuery(name = "Curso.findByNumEstudAdmitidosCurso", query = "SELECT c FROM Curso c WHERE c.numEstudAdmitidosCurso = :numEstudAdmitidosCurso"),
    @NamedQuery(name = "Curso.findByPrecioCurso", query = "SELECT c FROM Curso c WHERE c.precioCurso = :precioCurso")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_CURSO")
    private String codCurso;
    @Size(max = 20)
    @Column(name = "NOMBRE_CURSO")
    private String nombreCurso;
    @Column(name = "NUM_CREDITOS_CURSO")
    private Integer numCreditosCurso;
    @Column(name = "SEMESTRE_CURSO")
    private Integer semestreCurso;
    @Column(name = "NUM_ESTUD_ADMITIDOS_CURSO")
    private Integer numEstudAdmitidosCurso;
    @Column(name = "PRECIO_CURSO")
    private BigInteger precioCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<Matricula> matriculaCollection;

    public Curso() {
    }

    public Curso(String codCurso) {
        this.codCurso = codCurso;
    }

    public Curso(String codCurso, String nombreCurso, Integer numCreditosCurso, Integer semestreCurso, Integer numEstudAdmitidosCurso, BigInteger precioCurso) {
        this.codCurso = codCurso;
        this.nombreCurso = nombreCurso;
        this.numCreditosCurso = numCreditosCurso;
        this.semestreCurso = semestreCurso;
        this.numEstudAdmitidosCurso = numEstudAdmitidosCurso;
        this.precioCurso = precioCurso;
    }
    
    

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getNumCreditosCurso() {
        return numCreditosCurso;
    }

    public void setNumCreditosCurso(Integer numCreditosCurso) {
        this.numCreditosCurso = numCreditosCurso;
    }

    public Integer getSemestreCurso() {
        return semestreCurso;
    }

    public void setSemestreCurso(Integer semestreCurso) {
        this.semestreCurso = semestreCurso;
    }

    public Integer getNumEstudAdmitidosCurso() {
        return numEstudAdmitidosCurso;
    }

    public void setNumEstudAdmitidosCurso(Integer numEstudAdmitidosCurso) {
        this.numEstudAdmitidosCurso = numEstudAdmitidosCurso;
    }

    public BigInteger getPrecioCurso() {
        return precioCurso;
    }

    public void setPrecioCurso(BigInteger precioCurso) {
        this.precioCurso = precioCurso;
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
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.estudiante.entity.Curso[ codCurso=" + codCurso + " ]";
    }
    
}
