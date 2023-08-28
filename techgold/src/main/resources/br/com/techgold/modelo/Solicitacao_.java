package br.com.techgold.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-08-27T22:59:31.402-0300")
@StaticMetamodel(Solicitacao.class)
public class Solicitacao_ {
	public static volatile SingularAttribute<Solicitacao, Long> id;
	public static volatile SingularAttribute<Solicitacao, Calendar> dataAbertura;
	public static volatile SingularAttribute<Solicitacao, Calendar> dataAndamento;
	public static volatile SingularAttribute<Solicitacao, Calendar> dataFechamento;
	public static volatile SingularAttribute<Solicitacao, Calendar> agendado;
	public static volatile SingularAttribute<Solicitacao, Calendar> agendadoHora;
	public static volatile SingularAttribute<Solicitacao, Calendar> dataAtualizacao;
	public static volatile SingularAttribute<Solicitacao, Cliente> cliente;
	public static volatile SingularAttribute<Solicitacao, Funcionario> funcionario;
	public static volatile SingularAttribute<Solicitacao, String> formaAbertura;
	public static volatile SingularAttribute<Solicitacao, String> solicitante;
	public static volatile SingularAttribute<Solicitacao, String> usuario;
	public static volatile SingularAttribute<Solicitacao, String> prioridade;
	public static volatile SingularAttribute<Solicitacao, String> descricaoProblema;
	public static volatile SingularAttribute<Solicitacao, String> resolucao;
	public static volatile SingularAttribute<Solicitacao, String> status;
	public static volatile SingularAttribute<Solicitacao, String> obs;
	public static volatile SingularAttribute<Solicitacao, String> nivelDeIncidencia;
	public static volatile SingularAttribute<Solicitacao, String> onsiteOffsite;
	public static volatile SingularAttribute<Solicitacao, String> classificacao;
	public static volatile SingularAttribute<Solicitacao, String> statusEmail;
	public static volatile SingularAttribute<Solicitacao, String> abriuChamado;
	public static volatile SingularAttribute<Solicitacao, String> tempoDeAndamento;
	public static volatile SingularAttribute<Solicitacao, String> andamentoDoChamado;
	public static volatile SingularAttribute<Solicitacao, Long> estrela;
	public static volatile SingularAttribute<Solicitacao, String> senha;
	public static volatile SingularAttribute<Solicitacao, Boolean> excluido;
	public static volatile SingularAttribute<Solicitacao, String> caminhoAnexo;
	public static volatile SingularAttribute<Solicitacao, String> comentario;
	public static volatile SingularAttribute<Solicitacao, Long> idChamadoLigacao;
	public static volatile SingularAttribute<Solicitacao, Long> minutos;
	public static volatile SingularAttribute<Solicitacao, Boolean> play;
}
