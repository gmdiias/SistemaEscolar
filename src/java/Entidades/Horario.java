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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Leite
 */

@Entity
@Table(name = "Horario")
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT p FROM Horario p")
    , @NamedQuery(name = "Horario.findById", query = "SELECT p FROM Horario p WHERE p.id = :id")
})

public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "ID_Turma")
    public Turma turma;
    @ManyToOne
    @JoinColumn(name = "DISC_1")
    private Disciplina disc1;
    @ManyToOne
    @JoinColumn(name = "DISC_2")
    private Disciplina disc2;
    @ManyToOne
    @JoinColumn(name = "DISC_3")
    private Disciplina disc3;
    @ManyToOne
    @JoinColumn(name = "DISC_4")
    private Disciplina disc4;
    @ManyToOne
    @JoinColumn(name = "DISC_5")
    private Disciplina disc5;
    @ManyToOne
    @JoinColumn(name = "DISC_6")
    private Disciplina disc6;
    @Column(name = "DIA")
    private String dia;
   

    public Horario() {
    }

    public Horario(Disciplina disc1, Disciplina disc2, Disciplina disc3, Disciplina disc4, Disciplina disc5, Disciplina disc6, String dia) {
        this.disc1 = disc1;
        this.disc2 = disc2;
        this.disc3 = disc3;
        this.disc4 = disc4;
        this.disc5 = disc5;
        this.disc6 = disc6;
        this.dia = dia;
        
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getDisc1() {
        return disc1;
    }

    public void setDisc1(Disciplina disc1) {
        this.disc1 = disc1;
    }

    public Disciplina getDisc2() {
        return disc2;
    }

    public void setDisc2(Disciplina disc2) {
        this.disc2 = disc2;
    }

    public Disciplina getDisc3() {
        return disc3;
    }

    public void setDisc3(Disciplina disc3) {
        this.disc3 = disc3;
    }

    public Disciplina getDisc4() {
        return disc4;
    }

    public void setDisc4(Disciplina disc4) {
        this.disc4 = disc4;
    }

    public Disciplina getDisc5() {
        return disc5;
    }

    public void setDisc5(Disciplina disc5) {
        this.disc5 = disc5;
    }

    public Disciplina getDisc6() {
        return disc6;
    }

    public void setDisc6(Disciplina disc6) {
        this.disc6 = disc6;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

  
    
}
