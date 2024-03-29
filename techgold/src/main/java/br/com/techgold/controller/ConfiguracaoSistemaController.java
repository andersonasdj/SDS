package br.com.techgold.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.techgold.dao.EmailDao;
import br.com.techgold.dao.SistemaDao;
import br.com.techgold.modelo.Email;
import br.com.techgold.modelo.Funcionario;
import br.com.techgold.modelo.Sistema;

@Controller
public class ConfiguracaoSistemaController {
	
	@RequestMapping("/config")
	public String config(Model model, HttpSession session) {
		if (session.getAttribute("funcionarioLogado") != null) {
				return "Administrador/config";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping("/configEmail")
	public String configEmail(Model model, HttpSession session) {
		if (session.getAttribute("funcionarioLogado") != null) {
			EmailDao daoEmail = new EmailDao();
			List<Email> emails = new ArrayList<Email>();
			emails = daoEmail.listaEmailConfig();
			if (emails.size() == 0){
				return "Administrador/configuracao-email-form";
			} else{
				EmailDao daoListaConfigEmail = new EmailDao();
				model.addAttribute("configuracoes", daoListaConfigEmail.listaEmailConfig());
				return "Administrador/configuracao-email-list";
			}
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/configEmailForm")
	public String configEmailList(Model model, HttpSession session) {
		if (session.getAttribute("funcionarioLogado") != null) {
			return "Administrador/configuracao-email-form";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/configImg")
	public String configImg(Model model, HttpSession session) {
		if (session.getAttribute("funcionarioLogado") != null) {
			SistemaDao dao = new SistemaDao();
			List<Sistema> sistema = new ArrayList<Sistema>();
			sistema	= dao.listaSistemaConfig();
			if(sistema.size() == 0){
				return "Administrador/configuracao-img";
			} else {
				SistemaDao daoSistemaImg = new SistemaDao();
				model.addAttribute("sistemas", daoSistemaImg.listaSistemaConfig());
				return "Administrador/configuracao-img-list";
			}
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/salvarConfigImg")
	public String salvarConfigImg(Sistema sistema, HttpSession session) {
		if (session.getAttribute("funcionarioLogado") != null) {
			if(sistema.getId() != null){
				SistemaDao dao = new SistemaDao();
				dao.atualizar(sistema);
			} if (sistema.getId() == null) {
				SistemaDao dao = new SistemaDao();
				dao.salvar(sistema);
			}
			return "redirect:homePage";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/editConfigImg")
	public String editConfigImg(Long id, Model model, HttpSession session) {
		if (session.getAttribute("funcionarioLogado") != null) {
			SistemaDao sistemalDao = new SistemaDao();
			Sistema imgConfig = sistemalDao.buscarPorId(id);
			model.addAttribute("imgConfig", imgConfig);
			return "Administrador/configuracao-img-edit";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/editConfigEmail")
	public String editConfigEmail(Long id, Model model, HttpSession session) {
		if (session.getAttribute("funcionarioLogado") != null) {
			EmailDao emailDao = new EmailDao();
			Email emailConfig = emailDao.buscarPorId(id);
			model.addAttribute("emailConfig", emailConfig);
			return "Administrador/configuracao-email-edit";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/salvarConfigEmail")
	public String salvarConfigEmail(Email email, HttpSession session) {
		if (session.getAttribute("funcionarioLogado") != null) {
			if(email.getId() != null){
				EmailDao daoEmail = new EmailDao();
				daoEmail.atualizar(email);
				return "redirect:configEmail";
			}else if(email.getId() == null){
				EmailDao daoEmail = new EmailDao();
				daoEmail.salvar(email);
				return "redirect:homePage";
			}else {
				return "redirect:login";
			}
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/removeConfigEmail")
	public String removeConfigEmail(Long id, HttpSession session, Model model) {
		if (session.getAttribute("funcionarioLogado") != null) {
			EmailDao dao = new EmailDao();
			dao.excluir(id);
			return "redirect:config";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/removeConfigImg")
	public String removeConfigImg(Long id, HttpSession session, Model model) {
		if (session.getAttribute("funcionarioLogado") != null) {
			SistemaDao dao = new SistemaDao();
			dao.excluir(id);
			return "redirect:config";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/versao")
	public String versao(Model model, HttpSession session) {
		Funcionario funcionario = session.getAttribute("funcionarioLogado") != null?(Funcionario) session.getAttribute("funcionarioLogado"):(Funcionario) session.getAttribute("tecnicoLogado");
		if (funcionario != null) {
				return funcionario.getFuncao()+"/versao";
		} else {
			return "redirect:login";
		}
	}
}