package Controle;

import Entidades.Aluno;
import Entidades.Turma;
import Modelo.TurmaDAO;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adriano Henrique Rezende
 */

public class GerenciarTurma {
    
    private Turma turma = new Turma();
    private TurmaDAO turmaDAO = new TurmaDAO();
    private List<Turma> turmas;
    
    public GerenciarTurma() {
    }
    
    public String addTurma(){        
        turmaDAO.addTurma(turma);
        return "Turma/consultaTurmas"; 
    }
    
    public List<Turma> listarTurma(){
        turmas = turmaDAO.getTurma();
        return turmas; 
    }
    
    public String atualizaTurma(Turma t){
        turmaDAO.atualizaTurma(t);
        return "consultaTurma";
    }
    
    public String carregarTurma(Turma t){
        turma = t;
        return "editarTurma";
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;        
    }

    public TurmaDAO getTurmaDAO() {        
        return turmaDAO;        
    }

    public void setTurmaDAO(TurmaDAO turmaDAO) {        
        this.turmaDAO = turmaDAO;    
    }
    
}
