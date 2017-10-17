/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.PerfilDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
    private PerfilDAO modelo = new PerfilDAO();
    
    public PerfilControl() {
    }
    
    public String realizaLogin(){
        if(modelo.Login(email, senha) == 1){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Aluno logado com sucesso",  "Sucesso") );
            return "Administracao/index";
        }
        else if(modelo.Login(email, senha) == 2){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Funcionário logado com sucesso",  "Sucesso") );
            return "Administracao/index";
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
    
    
}
