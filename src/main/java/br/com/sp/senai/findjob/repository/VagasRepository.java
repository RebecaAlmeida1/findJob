package br.com.sp.senai.findjob.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import br.com.sp.senai.findjob.model.CadastroDeVagas;

public interface VagasRepository extends JpaRepository<CadastroDeVagas, Long>{

}
