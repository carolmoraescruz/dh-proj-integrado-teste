package com.minerva.bridge.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.minerva.bridge.domain.entity.Curso;
import com.minerva.bridge.domain.entity.PessoaFisica;
import com.minerva.bridge.domain.entity.PessoaJuridica;
import com.minerva.bridge.domain.entity.Turma;
import com.minerva.bridge.domain.entity.enums.AreaInteresse;
import com.minerva.bridge.domain.entity.enums.TipoPCD;
import com.minerva.bridge.repository.CursoRepository;
import com.minerva.bridge.repository.PessoaFisicaRepository;
import com.minerva.bridge.repository.PessoaJuridicaRepository;
import com.minerva.bridge.repository.TurmaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private PessoaFisicaRepository pfRepository;
	
	@Autowired
	private PessoaJuridicaRepository pjRepository;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public void run(String... args) throws Exception {
		
		Curso c1 = new Curso(null, "Java", "3 meses", AreaInteresse.TI_SOFTWARE, "Web", "Ensino fundamental", "..");
		Curso c2 = new Curso(null, "Javascript", "2 meses", AreaInteresse.TI_SOFTWARE, "Web", "Ensino médio", "..");
		
		cursoRepository.saveAll(Arrays.asList(c1, c2));
		
		Turma t1 = new Turma(null, "19 h às 20 h", LocalDate.parse("08/03/2022", dtf), LocalDate.parse("05/08/2022", dtf), c1);
		Turma t2 = new Turma(null, "7 h às 11 h", LocalDate.parse("02/05/2022", dtf), LocalDate.parse("30/05/2022", dtf), c1);
		Turma t3 = new Turma(null, "19 h às 20 h", LocalDate.parse("08/03/2022", dtf), LocalDate.parse("05/08/2022", dtf), c2);
		
		turmaRepository.saveAll(Arrays.asList(t1, t2, t3));
		
		PessoaFisica p1 = new PessoaFisica(null, "Jane", "janedoe@teste.com", "Endereço teste", "Doe", "Jane", "305.820.780-83", LocalDate.parse("20/06/2005", dtf), TipoPCD.DEFICIENCIA_AUDITIVA, "");
		PessoaFisica p2 = new PessoaFisica(null, "John", "johndoe@teste.com", "Endereço teste", "Doe", "Jimmy", "927.815.860-72", LocalDate.parse("20/06/2005", dtf), TipoPCD.DEFICIENCIA_AUDITIVA, "");
		PessoaJuridica p3 = new PessoaJuridica(null, "Natura", "natura@natura.com.br", "Endereço 2", "11.951.768/0001-67", "Beleza");
		PessoaJuridica p4 = new PessoaJuridica(null, "Digital House", "dh@dh.com.br", "Endereço 3", "21.790.549/0001-05", "TI");
		
		pfRepository.saveAll(Arrays.asList(p1, p2));
		pjRepository.saveAll(Arrays.asList(p3, p4));
		
		t1.getAlunos().add(p1);
		t1.getAlunos().add(p2);
		t2.getAlunos().add(p1);
		t3.getAlunos().add(p2);
		
		turmaRepository.saveAll(Arrays.asList(t1, t2, t3));
		
	}

}
