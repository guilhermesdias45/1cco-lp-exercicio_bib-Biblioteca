package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public Biblioteca(String nome, Double multaDiaria){
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        this.qtdLivros = 0;
        this.ativa = true;
    }

    public String getNome() {
        return nome;
    }

    public Double getMultaDiaria() {
        return multaDiaria;
    }

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void registrarLivro(Integer quantidade){
        if (quantidade != null && quantidade > 0 && this.ativa == true){
            this.qtdLivros += quantidade;
        }
    }

    public Integer emprestar(Integer quantidade){
        if (quantidade != null && this.ativa == true && quantidade > 0 && quantidade <= this.qtdLivros){
            this.qtdLivros -= quantidade;
            return quantidade;
        } else{
            return null;
        }
    }
    public Integer devolver(Integer quantidade){
        if (quantidade != null && quantidade > 0 && this.ativa == true) {
            this.qtdLivros += quantidade;
            return quantidade;
        } else{
            return null;
        }
    }
    public Integer desativar(){
        if (this.ativa == false){
            return null;
        } else{
            this.ativa = false;
            Integer qtdLivrosAnterior = this.qtdLivros;
            this.qtdLivros = 0;
            return qtdLivrosAnterior;
        }
    }
    public void transferir(Biblioteca destino, Integer quantidade){
        if(quantidade != null &&
                this.ativa == true &&
                destino.ativa == true &&
                quantidade <= this.qtdLivros &&
                quantidade > 0){
            this.qtdLivros -= quantidade;
            destino.qtdLivros += quantidade;
        }
    }
    public Boolean reajustarMulta(Double percentual){
        if (percentual != null && percentual > 0){
            this.multaDiaria += (this.multaDiaria * percentual);
            return true;
        } else {
            return false;
        }
    }
}
