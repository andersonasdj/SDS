package br.com.techgold.modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Solicitacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Calendar dataAbertura;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Calendar dataAndamento;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Calendar dataFechamento;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Calendar agendado;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "HH:mm")
	private Calendar agendadoHora;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Calendar dataAtualizacao;

	@OneToOne
	private Cliente cliente;
	@OneToOne
	private Funcionario funcionario;
	private String formaAbertura;
	private String solicitante;
	private String usuario;
	private String prioridade;
	private String descricaoProblema;
	private String resolucao;
	private String status;
	private String obs;
	private String nivelDeIncidencia;
	private String onsiteOffsite;
	private String classificacao;
	private String statusEmail;
	//private Long diasDur;
	//private Long horasDur;
	//private Long minutosDur;
	private String abriuChamado;
	private String tempoDeAndamento;
	@Lob
	private String andamentoDoChamado;
	private Long estrela;
	private String senha;
	private boolean excluido;
	private String caminhoAnexo;
	private String comentario;
	private Long idChamadoLigacao;
	private Long minutos;
	
	public Solicitacao(){
		
	}
	
	// CONTRUTOR PARA O CAST NO HQL (DAO)
	public Solicitacao(Long id, Calendar dataAbertura, String prioridade, String abriuChamado, String onsiteOffsite, 
			String caminhoAnexo, Cliente cliente, String solicitante, String usuario, String descricaoProblema, String resolucao,
			String obs, String classificacao, String status, Calendar dataFechamento, Calendar dataAndamento,
			Calendar agendado, Calendar agendadoHora, boolean play, Funcionario funcionario) {
		this.id = id;
		this.dataAbertura = dataAbertura;
		this.prioridade = prioridade;
		this.abriuChamado = abriuChamado;
		this.onsiteOffsite = onsiteOffsite;
		this.caminhoAnexo = caminhoAnexo;
		this.cliente = cliente;
		this.solicitante = solicitante;
		this.usuario = usuario;
		this.descricaoProblema = descricaoProblema;
		this.resolucao = resolucao;
		this.obs = obs;
		this.classificacao = classificacao;
		this.status = status;
		this.funcionario = funcionario;
		this.dataFechamento = dataFechamento;
		this.dataAndamento = dataAndamento;
		this.agendado = agendado;
		this.agendadoHora = agendadoHora;
		this.play = play;
	}
	// CONTRUTOR PARA O CAST NO HQL (DAO)
	
	public Long getMinutos() {
		return minutos;
	}

	public void setMinutos(Long minutos) {
		this.minutos = minutos;
	}

	private boolean play;

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public Long getIdChamadoLigacao() {
		return idChamadoLigacao;
	}

	public void setIdChamadoLigacao(Long idChamadoLigacao) {
		this.idChamadoLigacao = idChamadoLigacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getCaminhoAnexo() {
		return caminhoAnexo;
	}

	public void setCaminhoAnexo(String caminhoAnexo) {
		this.caminhoAnexo = caminhoAnexo;
	}

	public boolean isExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}

	public String getFormaAbertura() {
		return formaAbertura;
	}
	
	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public void setFormaAbertura(String formaAbertura) {
		this.formaAbertura = formaAbertura;
	}
	
	public String getStatus() {
		return status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Calendar getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Calendar getAgendado() {
		return agendado;
	}

	public void setAgendado(Calendar agendado) {
		this.agendado = agendado;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getResolucao() {
		return resolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOnsiteOffsite() {
		return onsiteOffsite;
	}

	public void setOnsiteOffsite(String onsiteOffsite) {
		this.onsiteOffsite = onsiteOffsite;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getNivelDeIncidencia() {
		return nivelDeIncidencia;
	}

	public void setNivelDeIncidencia(String nivelDeIncidencia) {
		this.nivelDeIncidencia = nivelDeIncidencia;
	}

	public Calendar getDataAndamento() {
		return dataAndamento;
	}

	public void setDataAndamento(Calendar dataAndamento) {
		this.dataAndamento = dataAndamento;
	}

	public Calendar getAgendadoHora() {
		return agendadoHora;
	}

	public void setAgendadoHora(Calendar agendadoHora) {
		this.agendadoHora = agendadoHora;
	}

	public String getStatusEmail() {
		return statusEmail;
	}

	public void setStatusEmail(String statusEmail) {
		this.statusEmail = statusEmail;
	}

	public String getAbriuChamado() {
		return abriuChamado;
	}

	public void setAbriuChamado(String abriuChamado) {
		this.abriuChamado = abriuChamado;
	}

	public String getAndamentoDoChamado() {
		return andamentoDoChamado;
	}

	public void setAndamentoDoChamado(String andamentoDoChamado) {
		this.andamentoDoChamado = andamentoDoChamado;
	}

	public String getTempoDeAndamento() {
		return tempoDeAndamento;
	}

	public void setTempoDeAndamento(String tempoDeAndamento) {
		this.tempoDeAndamento = tempoDeAndamento;
	}



	public String geraLogSolicitacao(Funcionario funcionario, Cliente cliente){
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date hora = new Date();
		hora = this.getDataAbertura().getTime();
		Date horaAgendado = new Date();
		if(this.getAgendadoHora() != null){
			horaAgendado = this.getAgendadoHora().getTime();
		}
			
		return "* Aberto por: " + this.getAbriuChamado() + "\n\n"
				+ "* Data: " + df.format(this.getDataAbertura().getTime()) + "\n"
				+ "* Hora: " + sdf.format(hora) + "\n"
				+ "* Cliente: " + cliente.getNome() + "\n"
				+ "* Forma de Abertura: " + (this.getFormaAbertura() != null ? this.getFormaAbertura() : "Não classificado") + "\n"
				+ "* Usu�rio Afetado: " + this.getUsuario() + "\n"
				+ "* Problema Relatado: " + this.getDescricaoProblema() + "\n"
				+ "* Observaçãoo: " + (this.getObs() != null ? this.getObs() : "N�o Classificado" ) + "\n"
				+ "* Categoria: " + (this.getClassificacao() != null ? this.getClassificacao() : "Não Classificado") + "\n"
				+ "* Classificação " + (this.getPrioridade() != null ? this.getPrioridade() : "Não Classificado") + "\n"
				+ "* Onsite / Offsite: " + (this.getOnsiteOffsite() != null ? this.getOnsiteOffsite() : "Não Classificado") + "\n"
				+ "* Funcionário Responsável: " + (funcionario != null ? funcionario.getNome() : "Não atribudo") + "\n"
				//+ "* Status: " + this.getStatus() + (this.isPlay() ? "" : " - Pausado") + "\n"
				
				+ "* Status: " + (this.getStatus().equals("Em andamento") ? this.getStatus() + (this.isPlay() ? "" : " - Pausado") + "\n" : this.getStatus() )+ "\n"
				
				+ (this.getStatus().equals("Agendar") ? "* Data de agendamento: " + (this.getAgendado() != null ? df.format(this.getAgendado().getTime()): "Sem data de agendamento") + "\n"
				+ (this.getAgendadoHora() != null ? "* Hora: " + sdf.format(horaAgendado)	: "") + "\n" :"") 
				+ "=========================================================================\n\n";
	}
	
	public String atualizaLogSolicitacao(Funcionario funcionario, String funcionarioLogado){
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdfAgendado = new SimpleDateFormat("HH:mm:ss");
		data = Calendar.getInstance().getTime();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		Date horaAgendado = new Date();
		if(getAgendadoHora() != null){
			horaAgendado = this.getAgendadoHora().getTime();
		}
		
		return (this.getAndamentoDoChamado() != null ? this.getAndamentoDoChamado() : "")
				
				+ "* Alterações realizadas por: " + funcionarioLogado + "\n"
				+ "* Data de Alteração: " + sdf.format(data) + "\n"
				+ "* Forma de Abertura: " + (this.getFormaAbertura() != null ? this.getFormaAbertura() : "Não classificado") + "\n"
				+ "* Usuário Afetado: " + this.getUsuario() + "\n"
				+ "* Problema Relatado: " + this.getDescricaoProblema() + "\n"
				+ "* Observação: " + this.getObs() + "\n"
				+ "* Resolução: " + this.getResolucao() + "\n"
 				+ "* Categoria: " + this.getClassificacao() + "\n"
				+ "* Classificação " + this.getPrioridade() + "\n"
				+ "* Onsite / Offsite: " + this.getOnsiteOffsite() + "\n"
				+ "* Funcion�rio Respons�vel: " + (funcionario != null ? funcionario.getNome() : "Não atribuíodo") + "\n"
				//+ "* Status: " + this.getStatus() + (this.isPlay() ? "" : " - Pausado") + "\n"
				+ "* Status: " + (this.getStatus().equals("Em andamento") ? this.getStatus() + (this.isPlay() ? "" : " - Pausado") + "\n" : this.getStatus() )+ "\n"
				+ (this.getStatus().equals("Agendado") ? "* Data de agendamento: " + ((getAgendado()!=null) ? df.format(this.getAgendado().getTime()): "Sem data de agendamento") + "\n"
				+ (this.getAgendadoHora() != null ? "* Hora: " + sdfAgendado.format(horaAgendado)	: "") + "\n" :"") 
				+ "=========================================================================\n\n";
	}

	public Long getEstrela() {
		return estrela;
	}

	public void setEstrela(Long estrela) {
		this.estrela = estrela;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String geraSenha(){
		String[] carct ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	    String senha="";
	    for (int x=0; x<10; x++){
	        int j = (int) (Math.random()*carct.length);
	        senha += carct[j];
	    }
		return senha;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abriuChamado == null) ? 0 : abriuChamado.hashCode());
		result = prime * result
				+ ((agendado == null) ? 0 : agendado.hashCode());
		result = prime * result
				+ ((agendadoHora == null) ? 0 : agendadoHora.hashCode());
		result = prime
				* result
				+ ((andamentoDoChamado == null) ? 0 : andamentoDoChamado
						.hashCode());
		result = prime * result
				+ ((caminhoAnexo == null) ? 0 : caminhoAnexo.hashCode());
		result = prime * result
				+ ((classificacao == null) ? 0 : classificacao.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result
				+ ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result
				+ ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime * result
				+ ((dataAndamento == null) ? 0 : dataAndamento.hashCode());
		result = prime * result
				+ ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result
				+ ((dataFechamento == null) ? 0 : dataFechamento.hashCode());
		result = prime
				* result
				+ ((descricaoProblema == null) ? 0 : descricaoProblema
						.hashCode());
		result = prime * result + ((estrela == null) ? 0 : estrela.hashCode());
		result = prime * result + (excluido ? 1231 : 1237);
		result = prime * result
				+ ((formaAbertura == null) ? 0 : formaAbertura.hashCode());
		result = prime * result
				+ ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((idChamadoLigacao == null) ? 0 : idChamadoLigacao.hashCode());
		result = prime * result + ((minutos == null) ? 0 : minutos.hashCode());
		result = prime
				* result
				+ ((nivelDeIncidencia == null) ? 0 : nivelDeIncidencia
						.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result
				+ ((onsiteOffsite == null) ? 0 : onsiteOffsite.hashCode());
		result = prime * result + (play ? 1231 : 1237);
		result = prime * result
				+ ((prioridade == null) ? 0 : prioridade.hashCode());
		result = prime * result
				+ ((resolucao == null) ? 0 : resolucao.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result
				+ ((solicitante == null) ? 0 : solicitante.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((statusEmail == null) ? 0 : statusEmail.hashCode());
		result = prime
				* result
				+ ((tempoDeAndamento == null) ? 0 : tempoDeAndamento.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitacao other = (Solicitacao) obj;
		if (abriuChamado == null) {
			if (other.abriuChamado != null)
				return false;
		} else if (!abriuChamado.equals(other.abriuChamado))
			return false;
		if (agendado == null) {
			if (other.agendado != null)
				return false;
		} else if (!agendado.equals(other.agendado))
			return false;
		if (agendadoHora == null) {
			if (other.agendadoHora != null)
				return false;
		} else if (!agendadoHora.equals(other.agendadoHora))
			return false;
		if (andamentoDoChamado == null) {
			if (other.andamentoDoChamado != null)
				return false;
		} else if (!andamentoDoChamado.equals(other.andamentoDoChamado))
			return false;
		if (caminhoAnexo == null) {
			if (other.caminhoAnexo != null)
				return false;
		} else if (!caminhoAnexo.equals(other.caminhoAnexo))
			return false;
		if (classificacao == null) {
			if (other.classificacao != null)
				return false;
		} else if (!classificacao.equals(other.classificacao))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (dataAbertura == null) {
			if (other.dataAbertura != null)
				return false;
		} else if (!dataAbertura.equals(other.dataAbertura))
			return false;
		if (dataAndamento == null) {
			if (other.dataAndamento != null)
				return false;
		} else if (!dataAndamento.equals(other.dataAndamento))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (dataFechamento == null) {
			if (other.dataFechamento != null)
				return false;
		} else if (!dataFechamento.equals(other.dataFechamento))
			return false;
		if (descricaoProblema == null) {
			if (other.descricaoProblema != null)
				return false;
		} else if (!descricaoProblema.equals(other.descricaoProblema))
			return false;
		if (estrela == null) {
			if (other.estrela != null)
				return false;
		} else if (!estrela.equals(other.estrela))
			return false;
		if (excluido != other.excluido)
			return false;
		if (formaAbertura == null) {
			if (other.formaAbertura != null)
				return false;
		} else if (!formaAbertura.equals(other.formaAbertura))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idChamadoLigacao == null) {
			if (other.idChamadoLigacao != null)
				return false;
		} else if (!idChamadoLigacao.equals(other.idChamadoLigacao))
			return false;
		if (minutos == null) {
			if (other.minutos != null)
				return false;
		} else if (!minutos.equals(other.minutos))
			return false;
		if (nivelDeIncidencia == null) {
			if (other.nivelDeIncidencia != null)
				return false;
		} else if (!nivelDeIncidencia.equals(other.nivelDeIncidencia))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (onsiteOffsite == null) {
			if (other.onsiteOffsite != null)
				return false;
		} else if (!onsiteOffsite.equals(other.onsiteOffsite))
			return false;
		if (play != other.play)
			return false;
		if (prioridade == null) {
			if (other.prioridade != null)
				return false;
		} else if (!prioridade.equals(other.prioridade))
			return false;
		if (resolucao == null) {
			if (other.resolucao != null)
				return false;
		} else if (!resolucao.equals(other.resolucao))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (solicitante == null) {
			if (other.solicitante != null)
				return false;
		} else if (!solicitante.equals(other.solicitante))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusEmail == null) {
			if (other.statusEmail != null)
				return false;
		} else if (!statusEmail.equals(other.statusEmail))
			return false;
		if (tempoDeAndamento == null) {
			if (other.tempoDeAndamento != null)
				return false;
		} else if (!tempoDeAndamento.equals(other.tempoDeAndamento))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}