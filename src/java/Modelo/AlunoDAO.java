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
    
    public boolean addAluno(String nomeCompResp, String dataNascResp, String cpfResp, String nome, String dataNascimento, String cpf, String rg, String sexo, String endereco, String telefone){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Aluno aluno = new Aluno(nomeCompResp, dataNascResp, cpfResp, nome, dataNascimento, cpf, rg, sexo, endereco, telefone);
        
        sessao.save(aluno);
        trans.commit();
        sessao.close();
        return true;
    }
    
    public boolean atualizaAluno(Aluno a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
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
    
    
}
