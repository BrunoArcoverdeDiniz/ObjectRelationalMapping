package entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import util.TipoPessoa;

//@Entity(name = "Pessoa")
@Entity
public class Pessoa {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "gen_pessoa", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen_pessoa", sequenceName = "seq_pessoa", schema="aulajpa")
	private int id;
	
	@Column(name = "nome", length=250, nullable = false)
	private String nome;
	
	@Column(name = "salario", precision=2, nullable = false)
	private Double salario;

	@Column(name = "tipo_pessoa")
	@Enumerated(EnumType.ORDINAL)
	private TipoPessoa tipoPessoa;
	
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Transient
	private String desc;
	
	@Column(name = "historico")
	@Lob
	private char[] historico;
	
	@Column(name = "foto")
	@Lob
	private byte[] foto;
	
	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Dispositivo> dispositivos;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getDescricao() {
		String desc = this.id + this.nome;
		return desc;
	}

	public void setDescricao() {
		String desc = this.id + this.nome;
		this.desc = desc;
	}
	
	public char[] getHistorico() {
		return historico;
	}

	public void setHistorico(char[] historico) {
		this.historico = historico;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", salario=" + salario + ", tipoPessoa=" + tipoPessoa
				+ ", dataNascimento=" + dataNascimento + "]";
	}
	
}
