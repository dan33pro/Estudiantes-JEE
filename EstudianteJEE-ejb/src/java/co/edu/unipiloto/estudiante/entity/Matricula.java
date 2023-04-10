/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ducar
 */
@Entity
@Table(name = "MATRICULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByCodigoCurso", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "Matricula.findByEstudianteId", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.estudianteId = :estudianteId"),
    @NamedQuery(name = "Matricula.findByMatFecha", query = "SELECT m FROM Matricula m WHERE m.matFecha = :matFecha")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculaPK matriculaPK;
    @Column(name = "MAT_FECHA")
    @Temporal(TemporalType.DATE)
    private Date matFecha;
    @JoinColumn(name = "CODIGO_CURSO", referencedColumnName = "COD_CURSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "ESTUDIANTE_ID", referencedColumnName = "ESTUDIANTE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;

    public Matricula() {
    }

    public Matricula(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public Matricula(String codigoCurso, int estudianteId) {
        this.matriculaPK = new MatriculaPK(codigoCurso, estudianteId);
        this.matFecha = new Date();
    }
    
    

    public MatriculaPK getMatriculaPK() {
        return matriculaPK;
    }

    public void setMatriculaPK(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public Date getMatFecha() {
        return matFecha;
    }

    public void setMatFecha(Date matFecha) {
        this.matFecha = matFecha;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaPK != null ? matriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.matriculaPK == null && other.matriculaPK != null) || (this.matriculaPK != null && !this.matriculaPK.equals(other.matriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.estudiante.entity.Matricula[ matriculaPK=" + matriculaPK + " ]";
    }
    
}
