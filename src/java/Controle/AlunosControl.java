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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gustavo Mendonça
 */
@Named(value = "alunosControl")
@SessionScoped
public class AlunosControl implements Serializable {
    private Aluno aluno = new Aluno();
    private AlunoDAO modelo = new AlunoDAO();
    private List<Aluno> alunos;
    
    public AlunosControl() {
    }
    
    public String addAluno(){
        modelo.addAluno(aluno);
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Aluno Adicionado",  "Sucesso") );
        return "consultaAlunos";
    }
    
    public List<Aluno> listarAlunos(){
        alunos = modelo.getAlunos();
        resetaCampos();
        return alunos;
    }
    
    public List<Aluno> listarAlunosDel(){
        alunos = modelo.getAlunosDel();
        resetaCampos();
        return alunos;
    }
    
    public String updateAluno(){
        modelo.atualizaAluno(aluno);
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Aluno Atualizado",  "Sucesso") );
        return "consultaAlunos";
    }
    
    public String deleteAluno(){
        modelo.deleteAluno(aluno);
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Aluno Deletado",  "Sucesso") );
        return "consultaAlunos";
    }
    
    public String carregarAluno(Aluno a){
        aluno = a;
        return "editarAluno";
    }
    
    public String retornaAluno(Aluno a){
        modelo.retornaAluno(a);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Aluno Reativado",  "Sucesso") );
        resetaCampos();
        return "consultaAlunos";
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AlunoDAO getModelo() {
        return modelo;
    }

    public void setModelo(AlunoDAO modelo) {
        this.modelo = modelo;
    }
    
    public void resetaCampos(){
        aluno.setNome(null);
        aluno.setDataNascimento(null);
        aluno.setCpf(null);
        aluno.setRg(null);
        aluno.setSexo(null);
        aluno.setTelefone(null);
        aluno.setEndereco(null);
        aluno.setEmail(null);
        aluno.setSenha(null);
        aluno.setCpfResp(null);
        aluno.setNomeCompResp(null);
        aluno.setTelefoneResp(null);
        aluno.setDataNascResp(null);
    }
}
