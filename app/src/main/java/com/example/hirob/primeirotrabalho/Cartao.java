package com.example.hirob.primeirotrabalho;

/**
 * Created by hirob on 08/10/2017.
 */

public class Cartao {
    private String bandeira;
    private String limite;
    private String vencimento;
    private String nome;

    static final String TABLE_NAME = "cartao";
    static final String COLUMN_NAME_NAME ="name";
    static final String COLUMN_NAME_LIMITE = "limite";
    static final String COLUMN_NAME_BANDEIRA = "bandeira";
    static final String COLUMN_NAME_VENCIMENTO = "vencimento";

    Cartao(String nome, String vencimento, String limite, String bandeira){
        setNome(nome);
        setVencimento(vencimento);
        setLimite(limite);
        setBandeira(bandeira);
    }

    public Cartao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getLimite() {
        return limite;
    }

    public void setLimite(String limite) {
        this.limite = limite;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }
}
