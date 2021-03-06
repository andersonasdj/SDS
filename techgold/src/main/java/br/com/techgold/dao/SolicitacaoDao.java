package br.com.techgold.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.techgold.data.Data;
import br.com.techgold.entitymanager.EntityFactory;
import br.com.techgold.modelo.Cliente;
import br.com.techgold.modelo.Funcionario;
import br.com.techgold.modelo.Solicitacao;

public class SolicitacaoDao {
	EntityManager manager;

	public SolicitacaoDao() {
		new EntityFactory();
		manager = EntityFactory.getEntityManager();
	}

	public void salvaSolicitcao(Solicitacao solicitacao) {
		solicitacao.setDataAbertura(Calendar.getInstance());
		manager.getTransaction().begin();
		manager.persist(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public Solicitacao salvaSolicitacaoEmail(Long id) {
		manager.getTransaction().begin();
		Solicitacao solicitacao = new Solicitacao(); 
		solicitacao = manager.find(Solicitacao.class, id);
		solicitacao.setStatusEmail("Email enviado");
		manager.merge(solicitacao);
		manager.getTransaction().commit();
		manager.close();
		return solicitacao;
	}
	
	public void salvaSolicitacaoAdmin(Solicitacao solicitacao, Funcionario funcionario, Cliente cliente) {
		solicitacao.setDataAbertura(Calendar.getInstance());
		solicitacao.setStatus("Aberto");
		solicitacao.setFuncionario(funcionario);
		solicitacao.setCliente(cliente);	
		manager.getTransaction().begin();
		manager.persist(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
	public void salvaSolicitacaoAdminAgendado(Solicitacao solicitacao, Funcionario funcionario, Cliente cliente) {
		solicitacao.setDataAbertura(Calendar.getInstance());
		solicitacao.setStatus("Agendado");
		solicitacao.setFuncionario(funcionario);
		solicitacao.setCliente(cliente);
		manager.getTransaction().begin();
		manager.persist(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void finalizaSolicitacao(Solicitacao solicitacao, Funcionario funcionario) {	
		manager.getTransaction().begin();
		Solicitacao solicitacaoFinalizada = manager.find(Solicitacao.class, solicitacao.getId());
		solicitacaoFinalizada.setDataFechamento(Calendar.getInstance());
		solicitacaoFinalizada.setStatus("Finalizado");
		solicitacaoFinalizada.setResolucao(solicitacao.getResolucao());
		solicitacaoFinalizada.setObs(solicitacao.getObs());
		solicitacaoFinalizada.setFuncionario(funcionario);	
		Data daoData = new Data();
		solicitacaoFinalizada.setDiasDur(daoData.difDias(Calendar.getInstance(), solicitacaoFinalizada.getDataAbertura()));
		solicitacaoFinalizada.setHorasDur(daoData.difHoras(Calendar.getInstance(), solicitacaoFinalizada.getDataAbertura()));
		solicitacaoFinalizada.setMinutosDur(daoData.difMin(Calendar.getInstance(), solicitacaoFinalizada.getDataAbertura()));
		manager.persist(solicitacaoFinalizada);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void atualizarSolicitacao(Solicitacao solicitacao, Funcionario funcionario){
		manager.getTransaction().begin();
		Solicitacao solicitacaoEncontrada = manager.find(Solicitacao.class, solicitacao.getId());
		solicitacao.setDataAbertura(solicitacaoEncontrada.getDataAbertura());
		solicitacao.setFuncionario(funcionario);
		solicitacao.setStatusEmail(solicitacaoEncontrada.getStatusEmail());
		manager.merge(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void atualizarSolicitacaoFinalizada(Solicitacao solicitacao, Funcionario funcionario){
		manager.getTransaction().begin();
		Solicitacao solicitacaoEncontrada = manager.find(Solicitacao.class, solicitacao.getId());
		solicitacao.setDataAbertura(solicitacaoEncontrada.getDataAbertura());
		solicitacao.setFuncionario(funcionario);
		solicitacao.setDataFechamento(solicitacaoEncontrada.getDataFechamento());
		solicitacao.setObs(solicitacaoEncontrada.getObs());
		manager.merge(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void atualizarSolicitacaoCliente(Solicitacao solicitacao){
		manager.getTransaction().begin();
		Solicitacao solicitacaoEncontrada = manager.find(Solicitacao.class, solicitacao.getId());
		solicitacao.setDataAbertura(solicitacaoEncontrada.getDataAbertura());
		manager.merge(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void excluiSolicitacao(Solicitacao solicitacao) {
		manager.getTransaction().begin();
		manager.remove(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void excluiSolicitacaoPorId(Long id) {
		Solicitacao solicitacao = new Solicitacao();
		manager.getTransaction().begin();
		solicitacao = manager.find(Solicitacao.class, id);
		manager.remove(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void agendarSolicitacao(Solicitacao solicitacao, Funcionario funcionario){
		Solicitacao solicitacaoEncontrada = new Solicitacao();
		manager.getTransaction().begin();
		solicitacaoEncontrada = manager.find(Solicitacao.class, solicitacao.getId());
		solicitacao.setDataAbertura(solicitacaoEncontrada.getDataAbertura());
		solicitacao.setStatus("Agendado");
		solicitacao.setStatusEmail(solicitacaoEncontrada.getStatusEmail());
		solicitacao.setFuncionario(funcionario);
		manager.merge(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void solicitacaoEmAndamento(Solicitacao solicitacao, Funcionario funcionario){
		Solicitacao solicitacaoEncontrada = new Solicitacao();
		manager.getTransaction().begin();
		solicitacaoEncontrada = manager.find(Solicitacao.class, solicitacao.getId());
		solicitacao.setDataAndamento(Calendar.getInstance());
		solicitacao.setDataAbertura(solicitacaoEncontrada.getDataAbertura());
		solicitacao.setStatus("Em andamento");
		solicitacao.setStatusEmail(solicitacaoEncontrada.getStatusEmail());
		solicitacao.setFuncionario(funcionario);
		manager.merge(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void solicitacaoAgendado(Solicitacao solicitacao, Funcionario funcionario){
		Solicitacao solicitacaoEncontrada = new Solicitacao();
		manager.getTransaction().begin();
		solicitacaoEncontrada = manager.find(Solicitacao.class, solicitacao.getId());
		solicitacao.setDataAndamento(Calendar.getInstance());
		solicitacao.setDataAbertura(solicitacaoEncontrada.getDataAbertura());
		solicitacao.setStatus("Agendado");
		solicitacao.setStatusEmail(solicitacaoEncontrada.getStatusEmail());
		solicitacao.setFuncionario(funcionario);
		manager.merge(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public Solicitacao buscaSolicitacaoId(Long id){
		Solicitacao solicitacaoEncontrada = new Solicitacao();
		manager.getTransaction().begin();
		solicitacaoEncontrada = manager.find(Solicitacao.class, id);
		manager.getTransaction().commit();
		manager.close();
		return solicitacaoEncontrada;
	}

	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesAbertasPorId(Long id) {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus and s.cliente.id=:pClienteId");
			query.setParameter("pClienteId", id);
			query.setParameter("pStatus", "Aberto");
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesAgendadasPorId(Long id) {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus and s.cliente.id=:pClienteId");
			query.setParameter("pClienteId", id);
			query.setParameter("pStatus", "Agendado");
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesAndamentoPorId(Long id) {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus and s.cliente.id=:pClienteId");
			query.setParameter("pClienteId", id);
			query.setParameter("pStatus", "Em andamento");
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesAbertasPorIdDoTecnico(Long id) {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus and s.funcionario.id=:pFuncionarioId");
			query.setParameter("pFuncionarioId", id);
			query.setParameter("pStatus", "Aberto");
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesAgendadasPorIdDoTecnico(Long id) {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus and s.funcionario.id=:pFuncionarioId");
			query.setParameter("pFuncionarioId", id);
			query.setParameter("pStatus", "Agendado");
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesAndamentoPorIdDoTecnico(Long id) {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus and s.funcionario.id=:pFuncionarioId");
			query.setParameter("pFuncionarioId", id);
			query.setParameter("pStatus", "Em andamento");
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesAguardandoPorIdDoTecnico(Long id) {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus and s.funcionario.id=:pFuncionarioId");
			query.setParameter("pFuncionarioId", id);
			query.setParameter("pStatus", "Aguardando usuario");
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		}
	}
	
	public Long listaQtdSolicitacoesAbertasPorIdDoTecnico(Long id) {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.status=:pStatus and s.funcionario.id=:pFuncionarioId");
			query.setParameter("pFuncionarioId", id);
			query.setParameter("pStatus", "Aberto");
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
	
	
	public Long listaQtdSolicitacoesAbertas() {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.status=:pStatus");
			query.setParameter("pStatus", "Aberto");
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
	
	public Long listaQtdSolicitacoesAguardando() {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.status=:pStatus");
			query.setParameter("pStatus", "Aguardando usuario");
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
	
	
	public Long listaQtdSolicitacoesAgendadasPorIdDoTecnico(Long id) {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.status=:pStatus and s.funcionario.id=:pFuncionarioId");
			query.setParameter("pFuncionarioId", id);
			query.setParameter("pStatus", "Agendado");
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
	
	public Long listaQtdSolicitacoesAgendadas() {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.status=:pStatus");
			query.setParameter("pStatus", "Agendado");
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
	
	public Long listaQtdSolicitacoesEmAndamentoPorIdDoTecnico(Long id) {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.status=:pStatus and s.funcionario.id=:pFuncionarioId");
			query.setParameter("pFuncionarioId", id);
			query.setParameter("pStatus", "Em andamento");
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
	
	public Long listaQtdSolicitacoesAguardandoPorIdDoTecnico(Long id) {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.status=:pStatus and s.funcionario.id=:pFuncionarioId");
			query.setParameter("pFuncionarioId", id);
			query.setParameter("pStatus", "Aguardando usuario");
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
	
	public Long listaQtdSolicitacoesEmAndamento() {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.status=:pStatus");
			query.setParameter("pStatus", "Em andamento");
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesPorId(Long id) {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.cliente.id=:pClienteId order by s.id desc");
			query.setParameter("pClienteId", id);
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesPorIdTec(Long id) {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.funcionario.id=:pFuncionarioId order by s.id desc");
			query.setParameter("pFuncionarioId", id);
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaTodasSolicitacoes() {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus1 or s.status=:pStatus2 or s.status=:pStatus3 or s.status=:pStatus4 order by s.id desc");
			
			query.setParameter("pStatus1", "Aberto");
			query.setParameter("pStatus2", "Agendado");
			query.setParameter("pStatus3", "Em andamento");
			query.setParameter("pStatus4", "Aguardando usuario");
			
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaTodasSolicitacoesFinalizadas() {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus order by s.id desc");
			
			query.setParameter("pStatus", "Finalizado");
			
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesAbertas() {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus order by s.id");
			query.setParameter("pStatus", "Aberto");
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesAgendadas() {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus order by s.id");
			query.setParameter("pStatus", "Agendado");
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesAndamento() {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus order by s.id");
			query.setParameter("pStatus", "Em andamento");
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoesAguardando() {
		List<Solicitacao> solicitacaos = new ArrayList<Solicitacao>();

		try {
			Query query = manager
					.createQuery("select s from Solicitacao s where s.status=:pStatus order by s.id");
			query.setParameter("pStatus", "Aguardando usuario");
			solicitacaos = (List<Solicitacao>) query.getResultList();
			if (solicitacaos != null) {
				manager.close();
				return solicitacaos;
			} else {
				manager.close();
				return null;
			}
		} catch (Exception e) {
			manager.close();
			return null;
		} 
	}
	
	public Long listaQtdSolicitacoesAbertasPorIdDoCliente(Long id) {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.status=:pStatus and s.cliente.id=:pClienteId");
			query.setParameter("pClienteId", id);
			query.setParameter("pStatus", "Aberto");
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
	
	public Long listaQtdSolicitacoesAgendadasPorIdDoCliente(Long id) {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.status=:pStatus and s.cliente.id=:pClienteId");
			query.setParameter("pClienteId", id);
			query.setParameter("pStatus", "Agendado");
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
	
	public Long listaQtdSolicitacoesAndamentoPorIdDoCliente(Long id) {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.status=:pStatus and s.cliente.id=:pClienteId");
			query.setParameter("pClienteId", id);
			query.setParameter("pStatus", "Em andamento");
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
	
	public Long listaQtdSolicitacoesPorIdDoCliente(Long id) {
		
		try {
			Query query = manager
					.createQuery("select count(s) from Solicitacao s where s.cliente.id=:pClienteId");
			query.setParameter("pClienteId", id);
			Long qtd = (Long) query.getSingleResult();
			if (qtd != 0) {
				manager.close();
				return qtd;
			} else {
				manager.close();
				return 0L;
			}
		} catch (Exception e) {
			manager.close();
			return 0L;
		}
	}
}