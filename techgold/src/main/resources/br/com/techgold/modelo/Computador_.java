package br.com.techgold.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-08-27T22:59:31.397-0300")
@StaticMetamodel(Computador.class)
public class Computador_ {
	public static volatile SingularAttribute<Computador, Long> id;
	public static volatile SingularAttribute<Computador, String> funcao;
	public static volatile SingularAttribute<Computador, String> nomeComputador;
	public static volatile SingularAttribute<Computador, String> nomeDoUsuario;
	public static volatile SingularAttribute<Computador, String> marca;
	public static volatile SingularAttribute<Computador, String> modeloProcessador;
	public static volatile SingularAttribute<Computador, String> familia;
	public static volatile SingularAttribute<Computador, String> tipoProcessador;
	public static volatile SingularAttribute<Computador, Double> frequenciaProcessador;
	public static volatile SingularAttribute<Computador, Double> pontos;
	public static volatile SingularAttribute<Computador, Integer> qtdMemoria;
	public static volatile SingularAttribute<Computador, String> qtdHd;
	public static volatile SingularAttribute<Computador, String> sistemaOperacionalInstalado;
	public static volatile SingularAttribute<Computador, String> officeInstalado;
	public static volatile SingularAttribute<Computador, String> sistemaOperacionalLicenciado;
	public static volatile SingularAttribute<Computador, String> officeLicenciado;
	public static volatile SingularAttribute<Computador, String> antiVirus;
	public static volatile SingularAttribute<Computador, String> serviceTag;
	public static volatile SingularAttribute<Computador, String> obs;
	public static volatile SingularAttribute<Computador, Calendar> dataAtualizacao;
	public static volatile SingularAttribute<Computador, Cliente> cliente;
	public static volatile SingularAttribute<Computador, String> serialWindows;
	public static volatile SingularAttribute<Computador, String> serialOffice;
	public static volatile SingularAttribute<Computador, Calendar> expiracaoAV;
	public static volatile SingularAttribute<Computador, String> status;
	public static volatile SingularAttribute<Computador, Boolean> ssd;
}
