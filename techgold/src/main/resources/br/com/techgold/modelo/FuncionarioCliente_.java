package br.com.techgold.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-08-27T22:59:31.400-0300")
@StaticMetamodel(FuncionarioCliente.class)
public class FuncionarioCliente_ {
	public static volatile SingularAttribute<FuncionarioCliente, Long> idFuncionario;
	public static volatile SingularAttribute<FuncionarioCliente, String> nome;
	public static volatile SingularAttribute<FuncionarioCliente, String> email;
	public static volatile SingularAttribute<FuncionarioCliente, String> cargo;
	public static volatile SingularAttribute<FuncionarioCliente, String> celular;
	public static volatile SingularAttribute<FuncionarioCliente, Cliente> cliente;
}
