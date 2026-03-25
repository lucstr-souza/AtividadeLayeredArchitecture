package br.ceub.service;
import java.time.LocalDate;
import java.util.List;

import br.ceub.model.Emprestimo;
import br.ceub.model.Livro;
import br.ceub.repository.EmprestimoRepository;
import br.ceub.repository.LivroRepository;
import br.ceub.repository.UsuarioRepository;

public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;
    private UsuarioRepository usuarioRepository;
    private LivroRepository livroRepository;
    private static int proximoId = 1;

    public EmprestimoService() {
        this.emprestimoRepository = new EmprestimoRepository();
        this.usuarioRepository = new UsuarioRepository();
        this.livroRepository = new LivroRepository();
    }

    public EmprestimoService(EmprestimoRepository emprestimoRepository, 
                            UsuarioRepository usuarioRepository, 
                            LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    public Emprestimo realizarEmprestimo(int usuarioId, int livroId, int diasEmprestimo) {
    	Livro livro = livroRepository.buscarPorId(livroId);
    	if(livro == null)
    		throw new RuntimeException("Livro não encontrado.");
    	
    	List<Emprestimo> emprestimosAtivos = emprestimoRepository.listarEmprestimosAtivos();
    	for (Emprestimo e : emprestimosAtivos) {
    		if (e.getLivroId() == livroId) {
    			throw new  RuntimeException("Livro ja emprestado.");
    		}
    	}
    	
    	LocalDate dataAtual = LocalDate.now();
    	Emprestimo e = new Emprestimo(
    			proximoId++,
    			usuarioId,
    			livroId,
    			dataAtual,
    			dataAtual.plusDays(diasEmprestimo)
    			);
    	
    	emprestimoRepository.salvar(e);
    	return e;
    	
    }

    public void devolverLivro(int emprestimoId) {
    }

    public List<Emprestimo> buscarEmprestimosDoUsuario(int usuarioId) {
        return null;
    }

    public List<Emprestimo> buscarEmprestimosAtivosDoUsuario(int usuarioId) {
        return null;
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        return null;
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return null;
    }

    public Emprestimo buscarPorId(int id) {
        return null;
    }

    public boolean verificarAtraso(int emprestimoId) {
        return false;
    }
}
