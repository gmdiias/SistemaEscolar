/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Aluno;
import Entidades.Disciplina;
import Entidades.Professor;
import Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Gustavo Mendonça
 */
public class AlunoDAO {
    private Session sessao;
    private Transaction trans;
    private List<Aluno> alunos;
    
    public void addAluno(Aluno aluno){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        System.out.println("Salvando pessoa");
        sessao.save(aluno);
        trans.commit();
        sessao.close();
    }
    
    public boolean deleteAluno(Aluno a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        a.setStatus(0);
        
        sessao.update(a);
        trans.commit();
        sessao.close();
        return true;
    }
    
    public boolean retornaAluno(Aluno a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        a.setStatus(1);
        
        sessao.update(a);
        trans.commit();
        sessao.close();
        return true;
    }
    
    public boolean atualizaAluno(Aluno a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        sessao.update(a);
        
        trans.commit();
        sessao.close();
        return true;
    }

    public List<Aluno> getAlunos() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Aluno.class);
        cri.add(Restrictions.eq("status", 1));
        this.alunos = cri.list();
        
        sessao.close();
        return alunos;
    }
    
    public List<Aluno> getAlunosDel() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Aluno.class);
        cri.add(Restrictions.eq("status", 0));
        this.alunos = cri.list();
        
        sessao.close();
        return alunos;
    }
    
    
}
