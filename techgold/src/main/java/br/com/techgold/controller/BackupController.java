package br.com.techgold.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.techgold.dao.SolicitacaoDao;
import br.com.techgold.modelo.Funcionario;

@Controller
public class BackupController {

	@RequestMapping("/backupDiario")
	public String backupDiario(HttpSession session, Model model) {
		Funcionario funcionario = session.getAttribute("funcionarioLogado") != null?(Funcionario) session.getAttribute("funcionarioLogado"):(Funcionario) session.getAttribute("tecnicoLogado");
		if (funcionario != null) {
			SolicitacaoDao daoSolicitacao = new SolicitacaoDao();
			model.addAttribute("solicitacoes",daoSolicitacao.listarSolicitacoesBackupNaoConcluidas());
			return funcionario.getFuncao()+"/relatorio-backup";
		} else {
			return "redirect:login";
		}
	}
}
