/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Mendonça
 */

@Entity
@Table(name = "Aluno")
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT p FROM Aluno p")
    , @NamedQuery(name = "Aluno.findById", query = "SELECT p FROM Aluno p WHERE p.id = :id")
})

public class Aluno extends Pessoa{
    @Column(length = 50, name = "NOMERESP", nullable = true)
    private String nomeCompResp;
    @Column(length = 20, name = "DATANASCRESP", nullable = true)
    private String dataNascResp;
    @Column(length = 20, name = "CPFRESP", nullable = true)
    private String cpfResp;
    @ManyToOne
    @JoinColumn(name = "ID_TURMA")
    private Turma turma; 

    public Aluno(String nomeCompResp, String dataNascResp, String cpfResp, String nome, String dataNascimento, String cpf, String rg, String sexo, String endereco, String telefone) {
        super(nome, dataNascimento, cpf, rg, sexo, endereco, telefone);
        this.nomeCompResp = nomeCompResp;
        this.dataNascResp = dataNascResp;
        this.cpfResp = cpfResp;
    }
    
    public Aluno(){
        
    }

    public String getNomeCompResp() {
        return nomeCompResp;
    }

    public void setNomeCompResp(String nomeCompResp) {
        this.nomeCompResp = nomeCompResp;
    }

    public String getDataNascResp() {
        return dataNascResp;
    }

    public void setDataNascResp(String dataNascResp) {
        this.dataNascResp = dataNascResp;
    }

    public String getCpfResp() {
        return cpfResp;
    }

    public void setCpfResp(String cpfResp) {
        this.cpfResp = cpfResp;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    
    
}
