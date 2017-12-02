/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Aluno;
import Entidades.Disciplina;
import Entidades.Turma;
import Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Adriano Henrique Rezende
 */

public class TurmaDAO {

    private Session sessao;
    private Transaction trans;
    private List<Aluno> alunos;
    private List<Turma> turmas;
    private List<Disciplina> disciplinas;

    public void addTurma(Turma turma){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        System.out.println("Salvando turma");
        sessao.save(turma);
        trans.commit();
        sessao.close();
    }
    
    public boolean addTurma(String descricaoTurma, List<Aluno> alunos, List<Disciplina> disciplinas){            
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        //Turma turma = new Turma(descricaoTurma, alunos, disciplinas);
        
        //sessao.save(turma);
        trans.commit();
        sessao.close();
        
        return true;
    }
    
    public boolean atualizaTurma(Turma t){        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        sessao.save(t);
        trans.commit();
        sessao.close();
        return true;        
    }

    public List<Turma> getTurma() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Turma.class);
        this.turmas = cri.list();
        
        sessao.close();
        return turmas;
    }
    
}

