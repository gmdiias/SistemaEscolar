/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;

/**
 *
 * @author Gustavo Mendonça
 */
public class Turma {
    private int codigoTurma;
    private String descricaoTurma; 
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;

    public Turma(int codigoTurma, String descricaoTurma, List<Aluno> alunos, List<Disciplina> disciplinas) {
        this.codigoTurma = codigoTurma;
        this.descricaoTurma = descricaoTurma;
        this.alunos = alunos;
        this.disciplinas = disciplinas;
    }
    
    
}
