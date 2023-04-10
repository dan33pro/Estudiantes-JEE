/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.session;

import co.edu.unipiloto.estudiante.entity.Matricula;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ducar
 */
@Local
public interface MatriculaFacadeLocal {

    void create(Matricula matricula);

    void edit(Matricula matricula);

    void remove(Matricula matricula);

    Matricula find(Object id);

    List<Matricula> findAll();

    List<Matricula> findRange(int[] range);

    int count();
    
}
