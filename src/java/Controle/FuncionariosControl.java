/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidades.Aluno;
import Entidades.Funcionario;
import Modelo.AlunoDAO;
import Modelo.FuncionarioDAO;
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
@Named(value = "funcionariosControl")
@SessionScoped
public class FuncionariosControl implements Serializable {
    private Funcionario funcionario = new Funcionario();
    private FuncionarioDAO modelo = new FuncionarioDAO();
    private List<Funcionario> funcionarios;
    private ValidaControl valida = new ValidaControl();
    
    public FuncionariosControl() {
    }
    
    public String addFuncionario(){
        if(valida.cpfValida(funcionario.getCpf())){
            modelo.addFuncionario(funcionario);
            resetaCampos();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Funcionário Adicionado",  "Sucesso") );
            return "consultaFuncionarios";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "CPF inválido!"));
        }
        return "";
    }
    
    public List<Funcionario> listarFuncionarios(){
        funcionarios = modelo.getFuncionarios();
        return funcionarios;
    }
    
    public List<Funcionario> listarFuncionariosDel(){
        funcionarios = modelo.getFuncionariosDel();
        return funcionarios;
    }
    
    public String updateFuncionario(){
        if(valida.cpfValida(funcionario.getCpf())){
            modelo.atualizaFuncionario(funcionario);
            resetaCampos();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Funcionário Atualizado",  "Sucesso") );
            return "consultaFuncionarios";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "CPF inválido!"));
        }
        return "";
    }
    
    public String deleteFuncionario(){
        modelo.deleteFuncionario(funcionario);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Funcionário Deletado",  "Sucesso") );
        return "consultaFuncionarios";
    }
    
    public String retornaFuncionario(Funcionario a){
        modelo.retornaFuncionario(a);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Funcionário Reativado",  "Sucesso") );
        return "consultaFuncionarios";
    }
    
    public String carregarFuncionario(Funcionario a){
        funcionario = a;
        return "editarFuncionario";
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public void resetaCampos(){
        funcionario.setNome(null);
        funcionario.setDataNascimento(null);
        funcionario.setCpf(null);
        funcionario.setRg(null);
        funcionario.setSexo(null);
        funcionario.setTelefone(null);
        funcionario.setEndereco(null);
        funcionario.setEmail(null);
        funcionario.setSenha(null);
        funcionario.setFuncao(null);
    }
    
}
