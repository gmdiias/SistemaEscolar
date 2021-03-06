/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Aluno;
import Entidades.Disciplina;
import Entidades.Professor;
import Entidades.Turma;
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
    private List<Turma> turma;
    //private Turma tur = new Turma("Teste"); // Remover
    
    public void addAluno(Aluno aluno){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        System.out.println("Salvando pessoa");
        sessao.save(aluno);
        trans.commit();
        sessao.close();
    }
     public boolean matriculaAluno(Aluno a, int idTurma){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        //sessao.save(tur);
        if(idTurma == 0){
            a.setTurma(null);
        }
        else {
            Criteria cri = sessao.createCriteria(Turma.class);
            cri.add(Restrictions.eq("id", idTurma));
            this.turma = cri.list(); 
            a.setTurma(turma.get(0));
        }
        
        sessao.update(a);
        
        trans.commit();
        sessao.close();
        return true;
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
    
    public Aluno getAlunoBusca(int raAluno) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Aluno.class);
        cri.add(Restrictions.eq("id", raAluno));
        this.alunos = cri.list();
        
        sessao.close();
        
        if(alunos.size() > 0){
            return alunos.get(0);
        }
        System.out.println("Aluno nao encontrado");
        return null;
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
