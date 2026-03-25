package br.ceub.repository;
import java.util.ArrayList;
import java.util.List;

import br.ceub.model.Livro;

public class LivroRepository {
	
	private List<Livro> livros=new ArrayList<>();

    public Livro salvar(Livro livro) {
    	livros.add(livro);
        return livro;
    }

    public Livro buscarPorId(int id) {
        for (Livro l:livros) {
        	if (l.getId()==id) {
        		return l;
        		}
        	}
        return null;
        }

    public List<Livro> buscarPorNome(String nome) {
    	List<Livro>resultado=new ArrayList<>();
    	for (Livro l:livros) {
    		if (l.getNome().toLowerCase().contains(nome.toLowerCase())) {
    			resultado.add(l);
    		}
    	}
    	return resultado;
    }

    public List<Livro> listarTodos() {
        return livros;
    }

    public void atualizar(Livro livro) {
    	for(int i=0; i<livros.size(); i++) {
    		if(livros.get(i).getId()== livro.getId()) {
    			livros.set(i, livro);
    			break;
    		}
    	}
    }

    public void deletar(int id) {
    	livros.removeIf(l->l .getId()==id);
    }
}
