/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Aluno;
import Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gustavo Mendonça
 */
public class Modelo {
    private Session sessao;
    private Transaction trans;
    
    public void addAluno(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Aluno aluno = new Aluno("Helena Marques", "01/04/1971", "08745898658", "Gustavo Mendonça", "10/10/1996", "07512554875", "00548721547", "Masculino", "Av. Gastão", "44998249570");
        
        sessao.save(aluno);
        trans.commit();
        sessao.close();
    }
}
