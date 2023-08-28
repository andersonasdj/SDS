package br.com.techgold.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-08-27T22:59:31.358-0300")
@StaticMetamodel(Checklist.class)
public class Checklist_ {
	public static volatile SingularAttribute<Checklist, Long> id;
	public static volatile SingularAttribute<Checklist, Long> numeroChecklist;
	public static volatile SingularAttribute<Checklist, String> tituloChecklist;
	public static volatile SingularAttribute<Checklist, String> nomeCliente;
	public static volatile SingularAttribute<Checklist, String> nomeResponsavel;
	public static volatile SingularAttribute<Checklist, Calendar> dataCriacao;
}
