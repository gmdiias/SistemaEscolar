/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Aluno;
import Entidades.Disciplina;
import Entidades.Notas;
import Entidades.Professor;
import Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Gustavo Leite
 */
public class NotasDAO {

    private Session sessao;
    private Transaction trans;
    private Notas nota;
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    
    public void addNotas(Notas nota, int raAluno){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Aluno.class);
        cri.add(Restrictions.eq("id", raAluno));
        this.alunos = cri.list();    
        
        nota.setAluno(alunos.get(0));
        
        System.out.println("Salvando notas");
        sessao.save(nota);
        trans.commit();
        sessao.close();
    }
    
    public boolean atualizaNotas(Notas a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        System.out.println("Atualizando notas");
        sessao.save(a);
        trans.commit();
        sessao.close();
        return true;
    }

    public List<Aluno> getAlunos() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Aluno.class);
        this.alunos = cri.list();
        
        sessao.close();
        return alunos;
    }
    
    public Notas delNotas() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        nota.setStatus(0);  
        
        sessao.close();
        return nota;
    }
    
    /*public List<Disciplina> getDisciplinas(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Disciplina.class);
        this.disciplinas = cri.list();
        
        sessao.close();
        return disciplinas;
    }*/
    
 


}
