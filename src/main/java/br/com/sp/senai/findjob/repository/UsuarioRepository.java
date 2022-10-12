package br.com.sp.senai.findjob.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import br.com.sp.senai.findjob.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

}
