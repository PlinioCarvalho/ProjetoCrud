package model.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private LocalDate dataNascimento;
	private LocalDate dataContratacao;
	@ManyToOne
	private Cargo cargo;

	public Funcionario() {

	}

	public Funcionario(String nome, String dataNascimento, Cargo cargo) {
		this.nome = nome;
		this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.dataContratacao = LocalDate.now();
		this.cargo = cargo;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public Cargo getCargo() {
		return cargo;
	}

}
