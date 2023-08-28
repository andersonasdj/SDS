package br.com.techgold.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-08-27T22:59:31.394-0300")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Usuario_ {
	public static volatile SingularAttribute<Cliente, String> endereco;
	public static volatile SingularAttribute<Cliente, String> telefone1;
	public static volatile SingularAttribute<Cliente, String> telefone2;
	public static volatile SingularAttribute<Cliente, String> cnpj;
	public static volatile SingularAttribute<Cliente, String> razaoSocial;
	public static volatile SingularAttribute<Cliente, String> responsavelTecnico;
	public static volatile SingularAttribute<Cliente, Double> latitude;
	public static volatile SingularAttribute<Cliente, Double> longitude;
	public static volatile SingularAttribute<Cliente, Boolean> redFlag;
	public static volatile SingularAttribute<Cliente, Boolean> vip;
	public static volatile SingularAttribute<Cliente, FuncionarioCliente> funcionarioCliente;
}
