package br.ceub.repository;
import java.util.ArrayList;
import java.util.List;

import br.ceub.model.Emprestimo;

public class EmprestimoRepository {
	
	private List<Emprestimo>emprestimos=new ArrayList<>(); 

    public Emprestimo salvar(Emprestimo emprestimo) {
    	emprestimos.add(emprestimo);
        return emprestimo;
    }

    public Emprestimo buscarPorId(int id) {
    	for(Emprestimo e: emprestimos) {
    		if(e.getId()==id)return e;
    	}
        return null;
    }

    public List<Emprestimo> buscarPorUsuario(int usuarioId) {
    	List<Emprestimo> lista= new ArrayList<>();
    	for(Emprestimo e: emprestimos) {
    		if(e.getUsuarioId()== usuarioId)lista.add(e);
    	}
        return lista;
    }

    public List<Emprestimo> buscarEmprestimosAtivos(int usuarioId) {
    	List<Emprestimo> lista= new ArrayList<>();
    	for(Emprestimo e: emprestimos) {
    		if(e.getUsuarioId()== usuarioId && e.isAtivo()) lista.add(e);

    	}
        return lista;
    }

    public List<Emprestimo> listarTodos() {
        return emprestimos;
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
    	List<Emprestimo> lista= new ArrayList<>();
    	for(Emprestimo e: emprestimos) {
    		if(e.isAtivo()) lista.add(e);
    		
    	}
    		return lista;
    }

    public void atualizar(Emprestimo emprestimo) {
    	for(int i=0;i< emprestimos.size(); i++) {
    		if(emprestimos.get(i).getId()==emprestimo.getId()) {
    			emprestimos.set(i, emprestimo);
    			break;
    		}
    	}
    }

    public void deletar(int id) {
    	emprestimos.removeIf(e -> e.getId()==id);
    }
}
