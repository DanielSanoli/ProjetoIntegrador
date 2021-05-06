package br.com.application.controller;

import br.com.application.dao.ClienteDAO;
import br.com.application.models.Cliente;
import java.util.ArrayList;

public class ClienteController {

    public static boolean cadastrar(String pCpf, String pNome, String pEmail,
            String pTelefone, String pEnderecoLogradouro,
            String pEnderecoNumero, String pEnderecoComplemento, String pSexo) {

        Cliente cliente = new Cliente();
        cliente.setCPF(pCpf);
        cliente.setNome(pNome);
        cliente.setEmail(pEmail);
        cliente.setTelefone(pTelefone);
        cliente.setEnderecoLogradouro(pEnderecoLogradouro);
        cliente.setEnderecoNumero(pEnderecoNumero);
        cliente.setEnderecoComplemento(pEnderecoComplemento);
        cliente.setSexo(pSexo);

        return ClienteDAO.cadastrar(cliente);

    }

    public static ArrayList<String[]> buscarTodos() {
        ArrayList<Cliente> listaRecebida = ClienteDAO.consultarTodos();
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        for (Cliente cliente : listaRecebida) {
            listaRetorno.add(new String[]{
                String.valueOf(cliente.getCodigo()),
                cliente.getCPF(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getEnderecoLogradouro(),
                cliente.getEnderecoNumero(),
                cliente.getEnderecoComplemento(),
                cliente.getSexo()});
        }
        return listaRetorno;
    }

    public static String[] buscarPorCodigo(int pCodigo) {
        Cliente clienteRecebido = ClienteDAO.consultarPorCodigo(pCodigo);
        String[] clienteRetorno = null;
        if (clienteRecebido != null) {
            clienteRetorno = new String[]{
                String.valueOf(clienteRecebido.getCodigo()),
                clienteRecebido.getCPF(),
                clienteRecebido.getNome(),
                clienteRecebido.getEmail(),
                clienteRecebido.getTelefone(),
                clienteRecebido.getEnderecoLogradouro(),
                clienteRecebido.getEnderecoNumero(),
                clienteRecebido.getEnderecoComplemento(),
                clienteRecebido.getSexo()};
        }
        return clienteRetorno;
    }

    public static String[] buscarPorCpf(String pCpf) {
        Cliente clienteRecebido = ClienteDAO.consultarPorCpf(pCpf);
        String[] clienteRetorno = null;
        if (clienteRecebido != null) {
            clienteRetorno = new String[]{
                String.valueOf(clienteRecebido.getCodigo()),
                clienteRecebido.getCPF(),
                clienteRecebido.getNome(),
                clienteRecebido.getEmail(),
                clienteRecebido.getTelefone(),
                clienteRecebido.getEnderecoLogradouro(),
                clienteRecebido.getEnderecoNumero(),
                clienteRecebido.getEnderecoComplemento(),
                clienteRecebido.getSexo()};
        }
        return clienteRetorno;
    }

    public static String[] buscarPorNome(String pNome) {
        Cliente clienteRecebido = ClienteDAO.consultarPorNome(pNome);
        String[] clienteRetorno = null;
        if (clienteRecebido != null) {
            clienteRetorno = new String[]{
                String.valueOf(clienteRecebido.getCodigo()),
                clienteRecebido.getCPF(),
                clienteRecebido.getNome(),
                clienteRecebido.getEmail(),
                clienteRecebido.getTelefone(),
                clienteRecebido.getEnderecoLogradouro(),
                clienteRecebido.getEnderecoNumero(),
                clienteRecebido.getEnderecoComplemento(),
                clienteRecebido.getSexo()};
        }
        return clienteRetorno;
    }

    public static boolean excluir(int pCodigo) {
        return ClienteDAO.excluirPorCodigo(pCodigo);
    }

    public static boolean alterar(int pCodigo, String pCpf, String pNome, String pEmail,
            String pTelefone, String pEnderecoLogradouro,
            String pEnderecoNumero, String pEnderecoComplemento, String pSexo) {

        Cliente cliente = new Cliente();
        cliente.setCodigo(pCodigo);
        cliente.setCPF(pCpf);
        cliente.setNome(pNome);
        cliente.setEmail(pEmail);
        cliente.setTelefone(pTelefone);
        cliente.setEnderecoLogradouro(pEnderecoLogradouro);
        cliente.setEnderecoNumero(pEnderecoNumero);
        cliente.setEnderecoComplemento(pEnderecoComplemento);
        cliente.setSexo(pSexo);

        return ClienteDAO.alterar(cliente);

    }

}
