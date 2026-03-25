package br.ceub.repository;
import java.util.ArrayList;
import java.util.List;

import br.ceub.model.Usuario;

public class UsuarioRepository {
	private List<Usuario>usuarios=new ArrayList<>();

    public Usuario salvar(Usuario usuario) {
    	usuarios.add(usuario);
        return usuario;
    }

    public Usuario buscarPorId(int id) {
    	return usuarios.stream().filter(u -> u.getId()==id).findFirst().orElse(null);
        
    }

    public Usuario buscarPorCpf(String cpf) {
    	return (Usuario)usuarios.stream().filter(u -> u.getCpf().equals(cpf));
    }

    public Usuario buscarPorEmail(String email) {
    	return usuarios.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);

    }

    public List<Usuario> buscarPorNome(String nome) {
    	List<Usuario> result= new ArrayList<>();
    	for (Usuario usuario:usuarios) {
    		if (usuario.getNome().contains(nome)) {
    			result.add(usuario);
    		}
    }
    	return result;
    }

    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    public void atualizar(Usuario usuario) {
    	for(int i=0; i<usuarios.size(); i++) {
    		if(usuarios.get(i).getId()== ((Usuario) usuarios).getId()) {
    			usuarios.set(i, usuario);
    			return;
    		}
    	}
    }

    public void deletar(int id) {
    	usuarios.removeIf(usuario ->usuario.getId()== id);
    }
    }

