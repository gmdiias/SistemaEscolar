/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Mendonça
 */
@Entity
@Table(name = "Funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT p FROM Funcionario p")
    , @NamedQuery(name = "Funcionario.findById", query = "SELECT p FROM Funcionario p WHERE p.id = :id")
})
public class Funcionario extends Pessoa{
    @Column(length = 20, name = "CARTEIRATRAB", nullable = true)
    private String carteiraTrabalho;
    @Column(length = 20, name = "DATAINI", nullable = true)
    private String dataInicioTrab;
    @Column(length = 20, name = "DATAFIM", nullable = true)
    private String dataFimTrab;
    @Column(name = "PERMISSAO", nullable = false)
    private int permissao;

    public Funcionario(String carteiraTrabalho, String dataInicioTrab, String dataFimTrab, int permissao, String nome, String dataNascimento, String cpf, String rg, String sexo, String endereco, String telefone) {
        super(nome, dataNascimento, cpf, rg, sexo, endereco, telefone);
        this.carteiraTrabalho = carteiraTrabalho;
        this.dataInicioTrab = dataInicioTrab;
        this.dataFimTrab = dataFimTrab;
        this.permissao = permissao;
    }

    public String getCarteiraTrabalho() {
        return carteiraTrabalho;
    }

    public void setCarteiraTrabalho(String carteiraTrabalho) {
        this.carteiraTrabalho = carteiraTrabalho;
    }

    public String getDataInicioTrab() {
        return dataInicioTrab;
    }

    public void setDataInicioTrab(String dataInicioTrab) {
        this.dataInicioTrab = dataInicioTrab;
    }

    public String getDataFimTrab() {
        return dataFimTrab;
    }

    public void setDataFimTrab(String dataFimTrab) {
        this.dataFimTrab = dataFimTrab;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
   
    
}
