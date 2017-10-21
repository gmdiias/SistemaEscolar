/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Aluno;
import Entidades.Disciplina;
import Entidades.Funcionario;
import Entidades.Pessoa;
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
public class PerfilDAO {
    private Session sessao;
    private Transaction trans;
    private List<Pessoa> pessoas;
    private Pessoa pessoa;

    public Pessoa Login(String email, String senha) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Pessoa.class);
        cri.add(Restrictions.eq("email", email));
        cri.add(Restrictions.eq("senha", senha));
        this.pessoas = cri.list();
        sessao.close();
        if(pessoas.size() > 0){
            return pessoas.get(0);
        }
        return null;
    }    
    
}
