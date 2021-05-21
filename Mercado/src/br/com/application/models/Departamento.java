package br.com.application.models;

public class Departamento {
    
    private String descricao;
    private int codigo;
    
    public Departamento() {
    }
    
    public Departamento (String descricao){
        this.descricao = descricao;      
    }

    public Departamento(String descricao, int codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }   

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }    

    public void setUsuario(int pUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setSenha(int pSenha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDescricao(int pDescricao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}