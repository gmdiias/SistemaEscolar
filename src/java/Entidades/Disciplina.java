/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Mendonça
 */

@Entity
@Table(name = "Disciplina")
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT p FROM Disciplina p")
    , @NamedQuery(name = "Disciplina.findById", query = "SELECT p FROM Disciplina p WHERE p.id = :id")
})
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "ID_PROF")
    private Funcionario func;
    @OneToOne
    @JoinColumn(name = "ID_TURMA")
    private Turma turma;

    public Disciplina() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    
    
    
}

