package com.gw.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;

public class MyAccessDeniedHandler implements AccessDeniedHandler {

	private String errorPage;

	public MyAccessDeniedHandler() {

	}

	public MyAccessDeniedHandler(String errorPage) {

		this.errorPage = errorPage;

	}

	public void handle(HttpServletRequest request,
			HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException,
			ServletException {

		if (errorPage != null) { // Put exception into request scope (perhaps
									// ofuse to a view)
			request.setAttribute(WebAttributes.ACCESS_DENIED_403,
					accessDeniedException);

			// Set the 403 status code.
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);

			// forward to error page.
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(errorPage);
			dispatcher.forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_FORBIDDEN,
					accessDeniedException.getMessage());
		}
	}

	public String getErrorPage() {
		return errorPage;
	}

	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}

}