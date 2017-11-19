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
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Gustavo Leite
 */
@Named(value = "notasControl")
@SessionScoped
public class NotasControl implements Serializable{
    //private Disciplina disciplinas = new Disciplina();
    private List<Notas> notas;
    private Notas nota  = new Notas();
    private NotasDAO notasDao = new NotasDAO();
    private String raAluno;
    private String idDisc;

    public String getIdDisc() {
        return idDisc;
    }

    public void setIdDisc(String idDisc) {
        this.idDisc = idDisc;
    }

    public NotasDAO getNotas() {
        return notasDao;
    }

    public void setNotas(NotasDAO notas) {
        this.notasDao = notasDao;
    }
    
    
    /*public NotasControl(List<Disciplina> disciplinas) {
        this.disciplinas = (Disciplina) disciplinas;
    }
    
    public List<Disciplina> listarDisciplinas(){
        disciplinas = (Disciplina) nota.getDisciplinas();
        return (List<Disciplina>) disciplinas;
    }*/
    
    public String addNotas(){
        notasDao.addNotas(nota, Integer.valueOf(raAluno), Integer.valueOf(idDisc));
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nota Adicionada!"));
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
    
    public String atualizaNotas(){
        notasDao.atualizaNotas(nota);
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Notas Atualizadas"));
        return "consultaNotas";
    }
    public String delNotas(){
        notasDao.delNotas(nota);
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Notas Deletadas") );
        return "consultaNotas";
    }
    public String carregarNotas(Notas a){
        nota = a;
        return "atualizarNotas";
    }
    public List<Notas> listarNotas(){
        notas = notasDao.getNotas();
        resetaCampos();
        return notas;
    }
    
    public List<Notas> listarNotasAluno(){
        notas = notasDao.getNotasAluno(Integer.valueOf(raAluno));
        resetaCampos();
        return notas;
    }
    
    
    public void resetaCampos(){
        setIdDisc(null);
        setRaAluno(null);
        nota.setNota1(null);
        nota.setNota2(null);
        nota.setNota3(null);
        nota.setNota4(null);
    }
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    
    
    
    
}