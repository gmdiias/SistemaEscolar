/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import Entidades.Disciplina;
import Modelo.DisciplinaDAO;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Adriano Henrique Rezende
 */
@Named(value = "disciplinaControl")
@SessionScoped
public class DisciplinaControl implements Serializable {
    
    private Disciplina disciplina = new Disciplina();
    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    private List<Disciplina> disciplinas;   
    private String idTurma;
    
    public DisciplinaControl() {
    }
    
    public String addDisciplina(){
        disciplinaDAO.addDisciplina(disciplina, Integer.valueOf(idTurma));
        return "Disciplina/consultaDisciplina";
    }
    
    public List<Disciplina> listarDisciplina(){
        disciplinas = disciplinaDAO.getDisciplina();
        return disciplinas;
    }
    
    public String atualizaDisciplina(Disciplina d){
        disciplinaDAO.atualizaDisciplina(d);
        return "consultaDisciplina";
    }
    
    public String carregarDisciplina(Disciplina d){
        disciplina = d;
        return "editarDisciplina";
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public DisciplinaDAO getDisciplinaDAO() {
        return disciplinaDAO;
    }

    public void setDisciplinaDAO(DisciplinaDAO disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
    }
    
    
       
}
