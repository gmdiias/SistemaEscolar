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
    
    public FuncionariosControl() {
    }
    
    public String addFuncionario(){
        modelo.addFuncionario(funcionario);
        return "consultaFuncionarios";
    }
    
    public List<Funcionario> listarFuncionarios(){
        funcionarios = modelo.getFuncionarios();
        return funcionarios;
    }
    
    public String updateFuncionario(){
        modelo.atualizaFuncionario(funcionario);
        return "consultaFuncionarios";
    }
    
    public String deleteAluno(){
        modelo.deleteFuncionario(funcionario);
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
    

    
}
