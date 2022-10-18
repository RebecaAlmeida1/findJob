package br.com.sp.senai.findjob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.sp.senai.findjob.excel.VagasExcel;
import br.com.sp.senai.findjob.model.CadastroDeVagas;
import br.com.sp.senai.findjob.service.VagasService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/excel")
public class VagasController {
	

  @Autowired
  private VagasService fileService;

  @PostMapping("/upload")
  public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
    if (VagasExcel.hasExcelFormat(file)) {
      try {
        fileService.save(file);

        return ResponseEntity.status(HttpStatus.OK).body("deu bom");
      } catch (Exception e) {
    	  System.out.println(e);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("deu ruim");
      }
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nao passou no try");
  }

  @GetMapping("/formsVagas")
  public ResponseEntity<Object> getAllVagas() {
    try {
      List<CadastroDeVagas> vagas = fileService.getAllVagas();
      
      if (vagas.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("está vazio rebecs");
      }

      return ResponseEntity.status(200).body(vagas);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
 
}
