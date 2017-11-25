/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Turma")
@NamedQueries({
    @NamedQuery(name = "Turma.findAll", query = "SELECT p FROM Turma p")
    , @NamedQuery(name = "Turma.findById", query = "SELECT p FROM Turma p WHERE p.id = :id")
})
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 50, name = "DESCRICAO", nullable = false)
    private String descricaoTurma; 
    @OneToMany
    @JoinColumn(name = "ID_ALUNO")
    private List<Aluno> alunos;
    @OneToMany
    @JoinColumn(name = "ID_DISC")
    private List<Disciplina> disciplinas;

    public Turma(String descricaoTurma) {
        this.descricaoTurma = descricaoTurma;
    }
    
    public Turma(){
        
    }

    public int getCodigoTurma() {
        return id;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.id = codigoTurma;
    }

    public String getDescricaoTurma() {
        return descricaoTurma;
    }

    public void setDescricaoTurma(String descricaoTurma) {
        this.descricaoTurma = descricaoTurma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    
    
}
