package br.com.techgold.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-08-27T22:59:31.403-0300")
@StaticMetamodel(Tarefa.class)
public class Tarefa_ {
	public static volatile SingularAttribute<Tarefa, Long> idTarefa;
	public static volatile SingularAttribute<Tarefa, Long> numero;
	public static volatile SingularAttribute<Tarefa, String> descricaoTarefa;
	public static volatile SingularAttribute<Tarefa, String> obs;
	public static volatile SingularAttribute<Tarefa, String> responsavelTarefa;
	public static volatile SingularAttribute<Tarefa, String> caminhoAnexo;
	public static volatile SingularAttribute<Tarefa, String> obsComplementares;
	public static volatile SingularAttribute<Tarefa, Checklist> checklist;
}
