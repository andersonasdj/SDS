package br.com.techgold.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-08-27T22:59:31.398-0300")
@StaticMetamodel(Email.class)
public class Email_ {
	public static volatile SingularAttribute<Email, Long> id;
	public static volatile SingularAttribute<Email, String> email;
	public static volatile SingularAttribute<Email, String> senha;
	public static volatile SingularAttribute<Email, String> smtp;
	public static volatile SingularAttribute<Email, Integer> portaSmtp;
	public static volatile SingularAttribute<Email, String> assunto;
	public static volatile SingularAttribute<Email, String> mensagem;
	public static volatile SingularAttribute<Email, Boolean> sslStatus;
	public static volatile SingularAttribute<Email, Boolean> autenticacao;
	public static volatile SingularAttribute<Email, String> funcaoDoEmail;
	public static volatile SingularAttribute<Email, String> cc;
	public static volatile SingularAttribute<Email, String> nomeAssinatura;
	public static volatile SingularAttribute<Email, String> numeroAssinatura;
	public static volatile SingularAttribute<Email, String> emailAssinatura;
	public static volatile SingularAttribute<Email, String> linkDominio;
}
