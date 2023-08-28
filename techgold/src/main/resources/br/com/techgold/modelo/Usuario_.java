package br.com.techgold.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-08-27T22:59:31.403-0300")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, Long> id;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, String> usuario;
	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, Integer> mfa;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, String> status;
	public static volatile SingularAttribute<Usuario, Calendar> dataAtualizacao;
	public static volatile SingularAttribute<Usuario, Calendar> ultimoLogin;
	public static volatile SingularAttribute<Usuario, Boolean> statusMfa;
	public static volatile SingularAttribute<Usuario, String> ip;
}
