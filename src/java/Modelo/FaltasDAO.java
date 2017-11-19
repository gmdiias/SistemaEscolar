/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Aluno;
import Entidades.Disciplina;
import Entidades.Faltas;
import Hibernate.HibernateUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Leite
 */
public class FaltasDAO {
    private Session sessao;
    private Transaction trans;
    private List<Faltas> faltas;
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;

public void addFaltas(Faltas faltas, int raAluno, int idDisc){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Aluno.class);
        cri.add(Restrictions.eq("id", raAluno));
        this.alunos = cri.list();    
        faltas.setAluno(alunos.get(0));
        
        Criteria cri2 = sessao.createCriteria(Disciplina.class);
        cri2.add(Restrictions.eq("id", idDisc));
        this.disciplinas = cri2.list();    
        faltas.setDisciplina(disciplinas.get(0));
        
        System.out.println("Salvando faltas");
        sessao.save(faltas);
        trans.commit();
        sessao.close();
    }
public boolean atualizaFaltas(Faltas a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        System.out.println("Atualizando faltas");
        sessao.update(a);
        trans.commit();
        sessao.close();
        return true;
    }
public boolean retornaFaltas(Faltas a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        //a.setStatus(1);
        
        sessao.update(a);
        trans.commit();
        sessao.close();
        return true;
    }
public List<Faltas> getFaltas() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Faltas.class);
        this.faltas = cri.list();
        System.out.println(faltas.size());
        sessao.close();
        return faltas;
    }
public List<Faltas> getFaltasAluno(int raAluno) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Faltas.class);
        cri.add(Restrictions.eq("aluno.id", raAluno));
        this.faltas = cri.list();
        System.out.println(faltas.size());
        sessao.close();
        return faltas;
    }
public boolean delFaltas(Faltas a) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        //a.setStatus(0);
        
        sessao.delete(a);
        trans.commit();
        sessao.close();
        return true;
    }

}
