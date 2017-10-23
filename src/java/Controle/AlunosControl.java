/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidades.Aluno;
import Modelo.AlunoDAO;
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
    private AlunoDAO alunoDAO = new AlunoDAO();
    private List<Aluno> alunos;
    
    public AlunosControl() {
    }
    
    public String addAluno(){
        alunoDAO.addAluno(aluno);
        return "Aluno/consultaAlunos";
    }
    
    public List<Aluno> listarAlunos(){
        alunos = alunoDAO.getAlunos();
        return alunos;
    }
    
    public String atualizaAluno(Aluno a){
        alunoDAO.atualizaAluno(a);
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

    public AlunoDAO getModelo() {
        return alunoDAO;
    }

    public void setModelo(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }
    
}
