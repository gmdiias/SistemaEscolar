/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Mendonça
 */

@Entity
@Table(name = "Professor")
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")
    , @NamedQuery(name = "Professor.findById", query = "SELECT p FROM Professor p WHERE p.id = :id")
})
public class Professor extends Funcionario{
    @Column(length = 50, name = "GRADUACAO", nullable = true)
    private String graduação;
    @Column(length = 50, name = "POSGRAD", nullable = true)
    private String posgraduação;
    @Column(length = 50, name = "MESTRADO", nullable = true)
    private String mestrado;
    @Column(length = 50, name = "DOUTORADO", nullable = true)
    private String doutorado;
    
    public String getGraduação() {
        return graduação;
    }

    public void setGraduação(String graduação) {
        this.graduação = graduação;
    }

    public String getPosgraduação() {
        return posgraduação;
    }

    public void setPosgraduação(String posgraduação) {
        this.posgraduação = posgraduação;
    }

    public String getMestrado() {
        return mestrado;
    }

    public void setMestrado(String mestrado) {
        this.mestrado = mestrado;
    }

    public String getDoutorado() {
        return doutorado;
    }

    public void setDoutorado(String doutorado) {
        this.doutorado = doutorado;
    }
    
    
}
