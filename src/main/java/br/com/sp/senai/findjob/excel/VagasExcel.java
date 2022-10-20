package br.com.sp.senai.findjob.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class VagasExcel {

	public static void lendoVgas(String[] args) {

		try {
			URL link = new URL(
					"https://sesisenaispedu-my.sharepoint.com/:x:/g/personal/rebeca_almeida5_senaisp_edu_br/EeiF6j7ZZrVAk3x3kd-9FE4BfIJ1yIb4URkP02uU6SrINQ?e=e5I6pJ");
			File arquivo = new File(System.getProperty("user.dir"),"cadastroDeVagas.xlsx");
			

			System.out.println("Deu certo, iniciando Download");
			long tempo = System.currentTimeMillis();
			
			
			
			VagasExcel download = new VagasExcel(link);
			download.saveTo(arquivo);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private final URL url;

	public VagasExcel(URL url) {
		this.url = url;
	}

	public void saveTo(File file) throws IOException {
		FileOutputStream out = new FileOutputStream(file);
		saveTo(out);
		out.close();
	}

	public void saveTo(OutputStream out) throws IOException {
		InputStream in = url.openStream();
		byte[] buffer = new byte[8192];
		for (int read = -1; (read = in.read(buffer)) != -1; out.write(buffer, 0, read)) {
		}
		out.flush();
	}

	public static boolean hasExcelFormat(MultipartFile file) {
		// TODO Auto-generated method stub
		return false;
	}
}