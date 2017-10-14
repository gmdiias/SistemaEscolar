/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidades.Aluno;
import Entidades.Notas;
import Modelo.NotasDAO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Gustavo Leite
 */
@Named(value = "notasControl")
@SessionScoped
public class NotasControl implements Serializable{
    //private Disciplina disciplinas = new Disciplina();
    private Notas nota  = new Notas();
    private NotasDAO notas = new NotasDAO();
    private String raAluno;
    
    /*
    public Disciplina getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina disciplinas) {
        this.disciplinas = disciplinas;
    }*/

    public NotasDAO getNotas() {
        return notas;
    }

    public void setNotas(NotasDAO notas) {
        this.notas = notas;
    }
    
    
    /*public NotasControl(List<Disciplina> disciplinas) {
        this.disciplinas = (Disciplina) disciplinas;
    }
    
    public List<Disciplina> listarDisciplinas(){
        disciplinas = (Disciplina) nota.getDisciplinas();
        return (List<Disciplina>) disciplinas;
    }*/
    
    public String addNotas(){
        notas.addNotas(nota, Integer.valueOf(raAluno));
        return "consultaNotas";
        
    }

    public Notas getNota() {
        return nota;
    }

    public void setNota(Notas nota) {
        this.nota = nota;
    }
    
    public String getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(String raAluno) {
        this.raAluno = raAluno;
    }
    
    public String atualizaNotas(Notas a){
        notas.atualizaNotas(a);
        return "Notas Atualizadas";
    }
    public String delNotas(){
        notas.delNotas();
        resetaCampos();
        return "consultaNotas";
    }
    
    public void resetaCampos(){
        nota.setAluno(null);
        nota.setNota1(null);
        nota.setNota2(null);
        nota.setNota3(null);
        nota.setNota4(null);
        nota.setStatus(1);
    }

    
    
    
    
}