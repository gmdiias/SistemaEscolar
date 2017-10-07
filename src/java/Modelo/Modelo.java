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
import java.util.Scanner;
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
        Professor prof = new Professor("UEM", "", "", "", "Janice Quadros", "25/08/1956", "00548751200", "658458699", "Feminino", "Rua Sela 174", "44875487454");
        
        sessao.save(aluno);
        sessao.save(prof);
        trans.commit();
        sessao.close();
    }
}
