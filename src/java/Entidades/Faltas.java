/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Leite
 */
    @Entity
    @Table(name = "Faltas")
public class Faltas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 2, name = "STATUS_F", nullable = true)
    private int status_f;
    @ManyToOne
    @JoinColumn(name = "ID_Aluno")
    public Aluno aluno;
    @OneToOne
    @JoinColumn(name = "ID_Disc")
    public Disciplina disciplina;
    @Column(length = 5, name = "Faltas", nullable = true)
    private int falta;

    public Faltas() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus_f() {
        return status_f;
    }

    public void setStatus_f(int status_f) {
        this.status_f = status_f;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getFalta() {
        return falta;
    }

    public void setFalta(int falta) {
        this.falta = falta;
    }

    
}
