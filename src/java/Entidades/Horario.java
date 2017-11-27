/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Leite
 */
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "ID_Disc")
    public Disciplina disciplina;
    @OneToOne
    @JoinColumn(name = "ID_Turm")
    public Turma turma;
    @Column(length = 10, name = "DISC_1", nullable = true)
    private Disciplina disc1;
    @Column(length = 10, name = "DISC_2", nullable = true)
    private Disciplina disc2;
    @Column(length = 10, name = "DISC_3", nullable = true)
    private Disciplina disc3;
    @Column(length = 10, name = "DISC_4", nullable = true)
    private Disciplina disc4;
    @Column(length = 10, name = "DISC_5", nullable = true)
    private Disciplina disc5;
    @Column(length = 10, name = "DISC_6", nullable = true)
    private Disciplina disc6;
    @Column(length = 10, name = "DISC_7", nullable = true)
    private Disciplina disc7;
    @Column(length = 10, name = "DISC_8", nullable = true)
    private Disciplina disc8;

    public Horario() {
    }

    public Horario(Disciplina disc1, Disciplina disc2, Disciplina disc3, Disciplina disc4, Disciplina disc5, Disciplina disc6, Disciplina disc7, Disciplina disc8) {
        this.disc1 = disc1;
        this.disc2 = disc2;
        this.disc3 = disc3;
        this.disc4 = disc4;
        this.disc5 = disc5;
        this.disc6 = disc6;
        this.disc7 = disc7;
        this.disc8 = disc8;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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

    public Disciplina getDisc7() {
        return disc7;
    }

    public void setDisc7(Disciplina disc7) {
        this.disc7 = disc7;
    }

    public Disciplina getDisc8() {
        return disc8;
    }

    public void setDisc8(Disciplina disc8) {
        this.disc8 = disc8;
    }
    
    
    
}
