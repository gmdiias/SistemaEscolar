/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidades.Aluno;
import Modelo.Modelo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gustavo Mendonça
 */
@Named(value = "alunosControl")
@SessionScoped
public class AlunosControl implements Serializable {
    private Aluno aluno = new Aluno();
    private Modelo modelo = new Modelo();
    private List<Aluno> alunos;
    
    public AlunosControl() {
    }
    
    public String addAluno(){
        modelo.addAluno(aluno);
        return "Aluno/consultaAlunos";
    }
    
    public List<Aluno> listarAlunos(){
        alunos = modelo.getAlunos();
        return alunos;
    }
    
    public String atualizaAluno(Aluno a){
        modelo.atualizaAluno(a);
        return "consultaAlunos";
    }
    
    public String carregarAluno(Aluno a){
        aluno = a;
        return "editarAluno";
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
}
