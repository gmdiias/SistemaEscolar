/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidades.Aluno;
import Entidades.Funcionario;
import Entidades.Pessoa;
import Modelo.PerfilDAO;
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
@Named(value = "perfilControl")
@SessionScoped
public class PerfilControl implements Serializable {
    private String email;
    private String senha;
    private Pessoa pessoa;
    private Funcionario funcionario;
    private Aluno aluno;
    private PerfilDAO modelo = new PerfilDAO();
    
    public PerfilControl() {
    }
    
    public String realizaLogin(){
        pessoa = modelo.Login(email, senha);
        if(pessoa == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Email ou senha inseridos estão incorretos!"));
            return "index";
        }
        else if(pessoa.getStatus() == 0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Este email e senha estão desativados no sistema!"));
            return "index";
        }
        else if(pessoa.getClass() == Aluno.class){
            aluno = (Aluno) pessoa;
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Aluno logado com sucesso",  "Sucesso") );
            return "Alunos/index";
        }
        else if(pessoa.getClass() == Funcionario.class){
            funcionario = (Funcionario) pessoa;
            FacesContext context = FacesContext.getCurrentInstance();
            if(funcionario.getPermissao() == 1){
                System.out.println("Logado como Professor");
                context.addMessage(null, new FacesMessage(funcionario.getFuncao() + " logado com sucesso",  "Sucesso") );
                return "Professor/index";
            }
            else if((funcionario.getPermissao() == 2) || (funcionario.getPermissao() == 3)){
                System.out.println("Logado como Secretária");
                context.addMessage(null, new FacesMessage(funcionario.getFuncao() + " logado com sucesso",  "Sucesso") );
                return "Administracao/index";
            }
            else{
                System.out.println("Funcionario logado");
                context.addMessage(null, new FacesMessage(funcionario.getFuncao() + " logado com sucesso",  "Sucesso") );
                return "Funcionario/index";
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Email ou senha inseridos estão incorretos!"));
        return "index";
    }
    
    public String esqueciSenha(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Esqueceu sua senha?", "Para recuperar sua senha entre em contato com a"
                + " secretaria da escola com seus dados para cadastrar uma nova!"));
        return "index";
    }
    
    public String carregarAluno(){
        return "login";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
    
}
