package br.com.application.dao;

import java.util.ArrayList;

public interface ICrud<T> {

    boolean cadastrar(T t);

    boolean alterar(T t);

    ArrayList<T> buscarTodos();

    T buscarPorCodigo(int codigo);

    boolean excluirTodos(int codigo);

    boolean excluirPorCodigo(int codigo);

}