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
    private ValidaControl valida = new ValidaControl();
    private String raAlunoBusca;
    
    public AlunosControl() {
    }
    
    public String addAluno(){
        if(valida.cpfValida(aluno.getCpf())){
            modelo.addAluno(aluno);
            resetaCampos();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Aluno Adicionado",  "Sucesso") );
            return "consultaAlunos";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "CPF inválido!"));
        }
        return "";
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
        if(valida.cpfValida(aluno.getCpf())){
            modelo.atualizaAluno(aluno);
            resetaCampos();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Aluno Atualizado",  "Sucesso") );
            return "consultaAlunos";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "CPF inválido!"));
        }
        return "";
    }
    
    public String buscarAluno(){
        int ra;
        ra = Integer.valueOf(raAlunoBusca);
        resetaCampos();
        aluno = modelo.getAlunoBusca(ra);
        System.out.println("Pessoa buscada");
        if(aluno == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ID não encontrado!", "ID não encontrado!"));
            aluno = new Aluno();
            return "consultaAlunos";
        }
        return "editarAluno";
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

    public String getRaAlunoBusca() {
        return raAlunoBusca;
    }

    public void setRaAlunoBusca(String raAlunoBusca) {
        this.raAlunoBusca = raAlunoBusca;
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
        raAlunoBusca = null;
    }
}
