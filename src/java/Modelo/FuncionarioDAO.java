/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Aluno;
import Entidades.Disciplina;
import Entidades.Funcionario;
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
public class FuncionarioDAO {
    private Session sessao;
    private Transaction trans;
    private List<Funcionario> funcionarios;
    
    public void addFuncionario(Funcionario funcionario){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        System.out.println("Salvando pessoa");
        sessao.save(funcionario);
        trans.commit();
        sessao.close();
    }
    
    public boolean deleteFuncionario(Funcionario a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        a.setStatus(0);
        
        sessao.update(a);
        trans.commit();
        sessao.close();
        return true;
    }
    
    public boolean retornaFuncionario(Funcionario a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        a.setStatus(1);
        
        sessao.update(a);
        trans.commit();
        sessao.close();
        return true;
    }
    
    public boolean atualizaFuncionario(Funcionario a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        sessao.update(a);
        
        trans.commit();
        sessao.close();
        return true;
    }

    public List<Funcionario> getFuncionarios() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Funcionario.class);
        cri.add(Restrictions.eq("status", 1));
        this.funcionarios = cri.list();
        
        sessao.close();
        return funcionarios;
    }
    
    public List<Funcionario> getFuncionariosDel() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Funcionario.class);
        cri.add(Restrictions.eq("status", 0));
        this.funcionarios = cri.list();
        
        sessao.close();
        return funcionarios;
    }
    
    public Funcionario getFuncionarioBusca(int idFuncionario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Funcionario.class);
        cri.add(Restrictions.eq("id", idFuncionario));
        this.funcionarios = cri.list();
        
        sessao.close();
        
        if(funcionarios.size() > 0){
            return funcionarios.get(0);
        }
        System.out.println("Funcionario nao encontrado");
        return null;
    }
    
    
}
