package br.ceub.controller;
import java.util.List;

import br.ceub.model.Usuario;
import br.ceub.service.UsuarioService;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario cadastrar(Usuario usuario) {
    	return usuarioService.cadastrar(usuario);
    }

    public Usuario buscarPorId(int id) {	
    	return usuarioService.buscarPorId(id);
}

    public Usuario buscarPorCpf(String cpf) {
        return usuarioService.buscarPorCpf(cpf);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioService.buscarPorEmail(email);
    }

    public List<Usuario> buscarPorNome(String nome) {
        return usuarioService.buscarPorNome(nome);
    }

    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    public Usuario alterar(Usuario usuario) {
    	usuarioService.alterar(usuario);
    	return usuario;
    }

    public void remover(int id) {
    	usuarioService.remover(id);
    }
}
