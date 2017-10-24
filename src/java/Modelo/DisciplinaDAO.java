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

public class DisciplinaDAO {

    private Session sessao;
    private Transaction trans;
    private List<Aluno> alunos;
    private List<Turma> turma;
    private List<Disciplina> disciplinas;

    public void addDisciplina(Disciplina disciplina){        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        System.out.println("Salvando disciplina");
        sessao.save(disciplina);
        trans.commit();
        sessao.close();    
    }
    
    public boolean atualizaDisciplina(Disciplina d){        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        sessao.save(d);
        trans.commit();
        sessao.close();
        return true;        
    }

    public List<Disciplina> getDisciplina() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Disciplina.class);
        this.alunos = cri.list();
        
        sessao.close();
        return disciplinas;
    }
    
}