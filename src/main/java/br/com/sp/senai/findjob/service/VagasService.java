package br.com.sp.senai.findjob.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.sp.senai.findjob.excel.VagasExcel;
import br.com.sp.senai.findjob.model.CadastroDeVagas;
import br.com.sp.senai.findjob.repository.VagasRepository;
@Service
public class VagasService {
	
		@Autowired
		private VagasRepository repVaga;

		 public void save(MultipartFile file) {
			    try {
			      List<CadastroDeVagas> vagas = VagasExcel.excelToTutorials(file.getInputStream());
			      repVaga.saveAll(vagas);
			    } catch (IOException e) {
			      throw new RuntimeException("fail to store excel data: " + e.getMessage());
			    }
			  }

			  public List<CadastroDeVagas> getAllTutorials() {
			    return repVaga.findAll();
			  }
			}

