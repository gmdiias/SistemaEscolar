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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Mendonça
 */

@Entity
@Table(name = "Pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
    , @NamedQuery(name = "Pessoa.findById", query = "SELECT p FROM Pessoa p WHERE p.id = :id")
})
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 50, name = "NOME", nullable = false)
    private String nome;
    @Column(length = 20, name = "DATANASC", nullable = false)
    private String dataNascimento;
    @Column(length = 20, name = "CPF", nullable = false)
    private String cpf;
    @Column(length = 20, name = "RG", nullable = false)
    private String rg;
    @Column(length = 10, name = "SEXO", nullable = false)
    private String sexo;
    @Column(length = 50, name = "ENDERECO", nullable = false)
    private String endereco;
    @Column(length = 20, name = "TELEFONE", nullable = false)
    private String telefone;

    public Pessoa(String nome, String dataNascimento, String cpf, String rg, String sexo, String endereco, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Pessoa(){
        
    }
}
