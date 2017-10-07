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
        
        sessao.save(aluno);
        trans.commit();
        sessao.close();
    }
    public void mostraAlunos(ArrayList<Aluno> aluno){
        System.out.println("--- LISTA DE ALUNOS ---");
        System.out.println("ID - Nome | RA");
        for(int i=0; i < aluno.size(); i++){
         //   System.out.println(i + " - " + aluno.get(i).getNome() + " | " + aluno.get(i).getRaAluno()); // TESTE
        }
    }
    
    public void lancaNota(ArrayList<Aluno> aluno, ArrayList<Disciplina> disciplinas){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Scanner leitura = new Scanner(System.in);
        Professor professor = new Professor();
        Disciplina disciplina = new Disciplina();
        int aux;
        mostraAlunos(aluno);
        System.out.print("Digite o ID do aluno desejado: ");
        aux = leitura.nextInt();
        if(aux > aluno.size()){          
            System.out.println("Aluno inválido!!");
            return;
        }
       // mostraAlunos(aluno.get(aux));
        System.out.println("Deseja lançar novas notas? (0-Não/1-Sim)");
        if(leitura.nextInt() == 1){
            System.out.println("Digite o ID do aluno: ");
            leitura.nextLine();
            System.out.println("Informe a Disciplina: ");
            leitura.nextLine();
          //aluno.get(ID).get(id_disc).setNota(leitura.nextLine()); //Ainda não definido
          
            sessao.save(aluno);
            trans.commit();
            sessao.close();
    }
    }
}
