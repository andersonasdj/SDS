package br.com.techgold.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {

		String uri = request.getRequestURI();
		if (uri.endsWith("login") || uri.endsWith("loginMobile") 
				|| uri.endsWith("create") || uri.endsWith("gravaAdmin")
				|| uri.endsWith("logar") || uri.contains("assets") 
				|| uri.endsWith("exibirProtocolo") || uri.endsWith("protocolo")
				|| uri.endsWith("enviaClassificacao")
				|| uri.endsWith("nova")
				|| uri.endsWith("auto")
				|| uri.endsWith("avancarAuto")
				|| uri.endsWith("avancarSuporte")
				|| uri.endsWith("salvarSuporte")
				|| uri.endsWith("logarAuto")
				|| uri.endsWith("mfa")
				|| uri.endsWith("logarMfa")) { 
			return true;
		}
		if (request.getSession().getAttribute("clienteLogado") != null) {
			return true;
		}
		if (request.getSession().getAttribute("funcionarioLogado") != null) {
			return true;
		}
		if (request.getSession().getAttribute("tecnicoLogado") != null) {
			return true;
		}
		response.sendRedirect("login");
		return false;
	}
}