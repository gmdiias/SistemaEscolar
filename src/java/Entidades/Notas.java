/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Entidades.Aluno;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Leite
 */
@Entity
@Table(name = "Notas")
/*@NamedQueries({
    @NamedQuery(name = "Notas.findByNotas", query = "SELECT p FROM Notas p WHERE p.Notas = :Notas")
})*/

public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 2, name = "STATUS", nullable = true)
    private int status_n;
    @ManyToOne
    @JoinColumn(name = "ID_Aluno")
    public Aluno aluno;
    @OneToOne
    @JoinColumn(name = "ID_Disc")
    public Disciplina disciplina;
    @Column(length = 10, name = "NOTA_1", nullable = true)
    private Float nota1;
    @Column(length = 10, name = "NOTA_2", nullable = true)
    private Float nota2;
    @Column(length = 10, name = "NOTA_3", nullable = true)
    private Float nota3;
    @Column(length = 10, name = "NOTA_4", nullable = true)
    private Float nota4;

    public Notas(/*Aluno aluno, Disciplina disciplina,*/ Float nota1, Float nota2, Float nota3, Float nota4) {
       /* this.aluno = aluno;
        this.disciplina = disciplina;*/
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }
    public Notas(){
        setStatus(1);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public int getStatus() {
        return status_n;
    }

    public void setStatus(int status_n) {
        this.status_n = status_n;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Float getNota1() {
        return nota1;
    }

    public void setNota1(Float nota1) {
        this.nota1 = nota1;
    }

    public Float getNota2() {
        return nota2;
    }

    public void setNota2(Float nota2) {
        this.nota2 = nota2;
    }

    public Float getNota3() {
        return nota3;
    }

    public void setNota3(Float nota3) {
        this.nota3 = nota3;
    }

    public Float getNota4() {
        return nota4;
    }

    public void setNota4(Float nota4) {
        this.nota4 = nota4;
    }
    
    
    
}
