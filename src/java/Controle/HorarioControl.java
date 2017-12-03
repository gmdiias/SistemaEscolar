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
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Leite
 */
@Named(value = "horarioControl")
@SessionScoped
public class HorarioControl implements Serializable {
    private Horario horario  = new Horario();
    private HorarioDAO horarioDao = new HorarioDAO();
    private String idDisc1;
    private String idDisc2;
    private String idDisc3;
    private String idDisc4;
    private String idDisc5;
    private String idDisc6;
    private String dia;
    private List<Disciplina> disciplinas;
    private String idTurm;
    private List<Turma> turmas;
    private List<Horario> horarios;

    public Horario getHorario() {
        return horario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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

    public String getIdDisc1() {
        return idDisc1;
    }

    public void setIdDisc1(String idDisc1) {
        this.idDisc1 = idDisc1;
    }

    public String getIdDisc2() {
        return idDisc2;
    }

    public void setIdDisc2(String idDisc2) {
        this.idDisc2 = idDisc2;
    }

    public String getIdDisc3() {
        return idDisc3;
    }

    public void setIdDisc3(String idDisc3) {
        this.idDisc3 = idDisc3;
    }

    public String getIdDisc4() {
        return idDisc4;
    }

    public void setIdDisc4(String idDisc4) {
        this.idDisc4 = idDisc4;
    }

    public String getIdDisc5() {
        return idDisc5;
    }

    public void setIdDisc5(String idDisc5) {
        this.idDisc5 = idDisc5;
    }

    public String getIdDisc6() {
        return idDisc6;
    }

    public void setIdDisc6(String idDisc6) {
        this.idDisc6 = idDisc6;
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
    
    public String addHorario(){
        horarioDao.addHorario(horario,Integer.parseInt(idTurm),dia,Integer.parseInt(idDisc1),Integer.parseInt(idDisc2),Integer.parseInt(idDisc3),Integer.parseInt(idDisc4),Integer.parseInt(idDisc5),Integer.parseInt(idDisc6));
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Horario Adicionado!"));
        return "consultaHorario";
        
    }
    
    public String buscarHorario(){
        return "listaHorario";
    }
   
    public List<Horario> listarHorario(){
        horarios = horarioDao.listarHorario(Integer.parseInt(idTurm), dia);
        return horarios;
    }
    
    public String carregarHorario(Horario a){
        horario = a;
        dia = horario.getDia();
        idTurm = Integer.toString(horario.getTurma().getId());
        idDisc1 = Integer.toString(horario.getDisc1().getId());
        idDisc2 = Integer.toString(horario.getDisc2().getId());
        idDisc3 = Integer.toString(horario.getDisc3().getId());
        idDisc4 = Integer.toString(horario.getDisc4().getId());
        idDisc5 = Integer.toString(horario.getDisc5().getId());
        idDisc6 = Integer.toString(horario.getDisc6().getId());
        
        return "atualizarHorario";
    }
    public String atualizaHorario(){
        horarioDao.atualizaHorario(horario,Integer.parseInt(idTurm),dia,Integer.parseInt(idDisc1),Integer.parseInt(idDisc2),Integer.parseInt(idDisc3),Integer.parseInt(idDisc4),Integer.parseInt(idDisc5),Integer.parseInt(idDisc6));
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Horario Atualizado"));
        return "consultaHorario";
    }

    public String delHorario(){
        horarioDao.delHorario(horario);
        resetaCampos();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Horario Deletado"));
        return "consultaHorario";
    }
    public void resetaCampos(){
        setDia(null);
        setIdTurm(null);
        setIdDisc1(null);
        setIdDisc2(null);
        setIdDisc3(null);
        setIdDisc4(null);
        setIdDisc5(null);
        setIdDisc6(null);
 
    }
    
}
