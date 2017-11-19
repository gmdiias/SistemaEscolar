/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidades.Faltas;
import Modelo.FaltasDAO;
import static com.sun.faces.facelets.util.Path.context;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Leite
 */
@Named(value = "faltasControl")
@SessionScoped
public class FaltasControl implements Serializable {
    private List<Faltas> faltas;
    private Faltas falta  = new Faltas();
    private FaltasDAO faltasDao = new FaltasDAO();
    private String raAluno;
    private String idDisc;

    public List<Faltas> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Faltas> faltas) {
        this.faltas = faltas;
    }

    public Faltas getFalta() {
        return falta;
    }

    public void setFalta(Faltas falta) {
        this.falta = falta;
    }

    public FaltasDAO getFaltasDao() {
        return faltasDao;
    }

    public void setFaltasDao(FaltasDAO faltasDao) {
        this.faltasDao = faltasDao;
    }

    public String getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(String raAluno) {
        this.raAluno = raAluno;
    }

    public String getIdDisc() {
        return idDisc;
    }

    public void setIdDisc(String idDisc) {
        this.idDisc = idDisc;
    }
    
    
    public String addFaltas(){
        faltasDao.addFaltas(falta, Integer.valueOf(raAluno), Integer.valueOf(idDisc));
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Falta Adicionada!"));
        return "consultaFaltas";
        
    }
    
    public String atualizaFaltas(){
        faltasDao.atualizaFaltas(falta);
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Faltas Atualizadas"));
        return "consultaFaltas";
    }
    public String delFaltas(){
        faltasDao.delFaltas(falta);
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Faltas Deletadas") );
        return "consultaFaltas";
    }
    public String carregarFaltas(Faltas a){
        falta = a;
        return "atualizarFaltas";
    }
    public List<Faltas> listarFaltas(){
        faltas = faltasDao.getFaltas();
        resetaCampos();
        return faltas;
    }
    
    public List<Faltas> listarFaltasAluno(){
        faltas = faltasDao.getFaltasAluno(Integer.valueOf(raAluno));
        resetaCampos();
        return faltas;
    }
    public void resetaCampos(){
        setIdDisc(null);
        setRaAluno(null);
        falta.setFalta(null);
        
    }
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
    

    
