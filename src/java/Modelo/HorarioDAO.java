/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Disciplina;
import Entidades.Horario;
import Entidades.Turma;
import Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Leite
 */
public class HorarioDAO {
     private Session sessao;
     private Transaction trans;
     private Horario hora;
     private List<Horario> horario;
     private List<Disciplina> disciplinas;
     private List<Turma> turmas;
     
     
     public void addHorario(Horario horario, int idTurm, String dia, int idDisc1,int idDisc2,int idDisc3,int idDisc4,int idDisc5,int idDisc6){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Turma.class);
        cri.add(Restrictions.eq("id", idTurm));
        this.turmas = cri.list();    
        horario.setTurma((turmas.get(0)));
        
        Criteria cri2 = sessao.createCriteria(Disciplina.class);
        cri2.add(Restrictions.eq("id", idDisc1));
        this.disciplinas = cri2.list();    
        horario.setDisc1((disciplinas.get(0)));
        
        Criteria cri3 = sessao.createCriteria(Disciplina.class);
        cri3.add(Restrictions.eq("id", idDisc2));
        this.disciplinas = cri3.list();    
        horario.setDisc2((disciplinas.get(0)));
        
        Criteria cri4 = sessao.createCriteria(Disciplina.class);
        cri4.add(Restrictions.eq("id", idDisc3));
        this.disciplinas = cri4.list();    
        horario.setDisc3((disciplinas.get(0)));
        
        Criteria cri5 = sessao.createCriteria(Disciplina.class);
        cri5.add(Restrictions.eq("id", idDisc4));
        this.disciplinas = cri5.list();    
        horario.setDisc4((disciplinas.get(0)));
        
        Criteria cri6 = sessao.createCriteria(Disciplina.class);
        cri6.add(Restrictions.eq("id", idDisc5));
        this.disciplinas = cri6.list();    
        horario.setDisc5((disciplinas.get(0)));
        
        Criteria cri7 = sessao.createCriteria(Disciplina.class);
        cri7.add(Restrictions.eq("id", idDisc6));
        this.disciplinas = cri7.list();    
        horario.setDisc6((disciplinas.get(0)));
        
        horario.setDia(dia);
       
        System.out.println("Salvando horario");
        sessao.save(horario);
        trans.commit();
        sessao.close();
    }
     
    public boolean atualizaHorario(Horario horario, int idTurm, String dia, int idDisc1,int idDisc2,int idDisc3,int idDisc4,int idDisc5,int idDisc6){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Turma.class);
        cri.add(Restrictions.eq("id", idTurm));
        this.turmas = cri.list();    
        horario.setTurma((turmas.get(0)));
        
        Criteria cri2 = sessao.createCriteria(Disciplina.class);
        cri2.add(Restrictions.eq("id", idDisc1));
        this.disciplinas = cri2.list();    
        horario.setDisc1((disciplinas.get(0)));
        
        Criteria cri3 = sessao.createCriteria(Disciplina.class);
        cri3.add(Restrictions.eq("id", idDisc2));
        this.disciplinas = cri3.list();    
        horario.setDisc2((disciplinas.get(0)));
        
        Criteria cri4 = sessao.createCriteria(Disciplina.class);
        cri4.add(Restrictions.eq("id", idDisc3));
        this.disciplinas = cri4.list();    
        horario.setDisc3((disciplinas.get(0)));
        
        Criteria cri5 = sessao.createCriteria(Disciplina.class);
        cri5.add(Restrictions.eq("id", idDisc4));
        this.disciplinas = cri5.list();    
        horario.setDisc4((disciplinas.get(0)));
        
        Criteria cri6 = sessao.createCriteria(Disciplina.class);
        cri6.add(Restrictions.eq("id", idDisc5));
        this.disciplinas = cri6.list();    
        horario.setDisc5((disciplinas.get(0)));
        
        Criteria cri7 = sessao.createCriteria(Disciplina.class);
        cri7.add(Restrictions.eq("id", idDisc6));
        this.disciplinas = cri7.list();    
        horario.setDisc6((disciplinas.get(0)));
        
        horario.setDia(dia);
        
        System.out.println("Atualizando Horario");
        sessao.update(horario);
        trans.commit();
        sessao.close();
        return true;
    } 
    
    public boolean retornaHorario(Horario a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.update(a);
        trans.commit();
        sessao.close();
        return true;
    }
    
    public boolean delHorario(Horario a) {
       sessao = HibernateUtil.getSessionFactory().openSession();
       trans = sessao.beginTransaction();
       sessao.delete(a);
       trans.commit();
       sessao.close();
       return true;
    }
    
    public List<Horario> getDisc(int idDisc) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        System.out.println("Buscando Disc ID " + idDisc);
        Criteria cri = sessao.createCriteria(Disciplina.class);
        cri.add(Restrictions.eq("disciplina.id", idDisc));
        this.horario = cri.list();
        System.out.println(horario.size());
        sessao.close();
        return horario;
    }
    
    public List<Horario> getTurm(int idTurm) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        System.out.println("Buscando Turma ID " + idTurm);
        Criteria cri = sessao.createCriteria(Disciplina.class);
        cri.add(Restrictions.eq("turma.id", idTurm));
        this.horario = cri.list();
        System.out.println(horario.size());
        sessao.close();
        return horario;
    }
    public List<Horario> listarHorario(int idTurm, String dia) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        System.out.println("Buscando Horario " +idTurm);
        Criteria cri = sessao.createCriteria(Horario.class);
        cri.add(Restrictions.eq("turma.id", idTurm));
        //cri.add(Restrictions.eq("dia", dia));
        this.horario = cri.list();
        System.out.println(horario.size());
        sessao.close();
        return horario;
    }
}
