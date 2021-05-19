package br.com.application.models;

public class Operador {
    
    private int codigo;
    private int usuario;
    private int senha;

    public Operador(int usuario, int senha) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Operador() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
}