/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
public class Professor extends Pessoa{
    private String graduação;
    private String posgraduação;
    private String mestrado;
    private String doutorado;
    @OneToMany
    @JoinColumn(name = "ID_DISC")
    private List<Disciplina> disciplinas;

    public Professor(String graduação, String posgraduação, String mestrado, String doutorado, String nome, String dataNascimento, String cpf, String rg, String sexo, String endereco, String telefone) {
        super(nome, dataNascimento, cpf, rg, sexo, endereco, telefone);
        this.graduação = graduação;
        this.posgraduação = posgraduação;
        this.mestrado = mestrado;
        this.doutorado = doutorado;
    }   

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

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    
    
}
