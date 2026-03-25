package br.ceub.service;
import java.util.List;

import br.ceub.model.Usuario;
import br.ceub.repository.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.salvar(usuario);
    }

    public Usuario buscarPorId(int id) {
        return usuarioRepository.buscarPorId(id);
    }

    public Usuario buscarPorCpf(String cpf) {
        return usuarioRepository.buscarPorCpf(cpf);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.buscarPorEmail(email);
    }

    public List<Usuario> buscarPorNome(String nome) {
        return usuarioRepository.buscarPorNome(nome);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.listarTodos();
    }

    public void alterar(Usuario usuario) {
    	usuarioRepository.atualizar(usuario);
    }

    public void remover(int id) {
    	usuarioRepository.deletar(id);
    }
}
