
package br.com.sp.senai.findjob.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sp.senai.findjob.model.Usuario;
import br.com.sp.senai.findjob.repository.UsuarioRepository;



@Service
public class UsuarioService {
	private UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;

	}
	
	public List<Usuario> listarUsuario(){
		List<Usuario> lista = repository.findAll();
		return lista;
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		Usuario novoUsuario = repository.save(usuario);
		return novoUsuario;
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		Usuario novoUsuario = repository.save(usuario);
		return novoUsuario;
	}
	
	public Boolean excluirUsuario(Long id) {
		repository.deleteById(id);
		return true;
	}
}