/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidades.Disciplina;
import Entidades.Horario;
import Entidades.Turma;
import Modelo.HorarioDAO;
import java.util.List;

/**
 *
 * @author Leite
 */
public class HorarioControl {
    private Horario horario  = new Horario();
    private HorarioDAO horarioDao = new HorarioDAO();
    private String idDisc;
    private List<Disciplina> disciplinas;
    private String idTurm;
    private List<Turma> turmas;

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public HorarioDAO getHorarioDao() {
        return horarioDao;
    }

    public void setHorarioDao(HorarioDAO horarioDao) {
        this.horarioDao = horarioDao;
    }

    public String getIdDisc() {
        return idDisc;
    }

    public void setIdDisc(String idDisc) {
        this.idDisc = idDisc;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public String getIdTurm() {
        return idTurm;
    }

    public void setIdTurm(String idTurm) {
        this.idTurm = idTurm;
    }
    
    
    
}
