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
     //private Horario horario = new Horario();
     private List<Horario> horario;
     private List<Disciplina> disciplinas;
     private List<Turma> turmas;
     
     
     public void addHorario(Horario horario, int idTurm, int idDisc){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Turma.class);
        cri.add(Restrictions.eq("id", idTurm));
        this.disciplinas = cri.list();    
        horario.setTurma((turmas.get(0)));
        
        Criteria cri2 = sessao.createCriteria(Disciplina.class);
        cri2.add(Restrictions.eq("id", idDisc));
        this.disciplinas = cri2.list();    
        horario.setDisciplina((disciplinas.get(0)));
       
        System.out.println("Salvando horario");
        sessao.save(horario);
        trans.commit();
        sessao.close();
    }
     
    public boolean atualizaHorario(Horario a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        System.out.println("Atualizando notas");
        sessao.update(a);
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
}
