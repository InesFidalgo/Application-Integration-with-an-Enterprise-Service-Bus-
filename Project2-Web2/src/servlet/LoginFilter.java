package servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config)
        throws ServletException {
        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURL = request.getContextPath() + "/Login";
        String regURL = request.getContextPath() + "/register.jsp";
        String reg2URL = request.getContextPath() + "/NewStudent";
        String reg3URL = request.getContextPath() + "/Professores";
        String requestPath = request.getRequestURI();
        String user="";
        if (session== null || session.getAttribute("user")==null){
        	
        }else{
        	user=(String)session.getAttribute("user");
        }

        if (needsAuthentication(user,requestPath) || session == null || session.getAttribute("user") == null) { 
        	if (request.getRequestURI().equals(loginURL))
        		chain.doFilter(req, res);
        	else if (request.getRequestURI().equals(regURL))
        		chain.doFilter(req, res);
        	else if (request.getRequestURI().equals(reg2URL))
        		chain.doFilter(req, res);
        	else if (request.getRequestURI().equals(reg3URL))
        		chain.doFilter(req, res);
        	else
        		response.sendRedirect(request.getContextPath() + "/Login"); 
        } else {
        	if (needsAuthentication(user,requestPath))
        		response.sendRedirect(request.getContextPath() + "/Login"); 
        	else
        		chain.doFilter(req, res); 
        }
    }

    @Override
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }

    //TIPO DE USER PODE ACEDER A:
    private boolean needsAuthentication(String user,String url) {
        String[] validNonAuthenticationUrls =
            { "Login","register.jsp","NewStudent","Professores" };
        String[] validProfessorUrls =
            { "Bye","Login","MenuProfessor","Materials","DownloadMaterial","index2.jsp","upload_ok.jsp","index.jsp","Materiais","deletamaterials.jsp","DeleteMaterial","NewCourse","addproftocourse.jsp","AddProftoCourse","AddStudentToCourse","EditCourse" };
        String[] validStudentUrls =
            { "Bye","Login","MenuStudent","Materials","DownloadMaterial","index2.jsp" };
        String[] validAdminUrls =
            { "Bye","Login","MenuAdmin","Materials","DownloadMaterial","index2.jsp","editarprofessor.jsp","EditarProfessor","EditStudent","EditCourse","editarmaterial.jsp","EditarMaterial","DeleteProfessor","deletealuno.jsp","DeleteAluno","DeleteCourse","deletematerials.jsp","DeleteMaterial","NewCourse","addproftocourse.jsp","AddProftoCourse","AddStudentToCourse","EditCourse" };
        
        String[] chosen = {};
        
        
        if (user==""){
        	chosen=validNonAuthenticationUrls;
        }else if(user.equals("pro")){
        	chosen=validProfessorUrls;
        }else if(user.equals("stu")){
        	chosen=validStudentUrls;
        }else if (user.equals("admin")){
        	chosen=validAdminUrls;
        }else{
        	chosen=validNonAuthenticationUrls;
        }
        for(String validUrl : chosen) {
            if (url.endsWith(validUrl)) {
                return false;
            }
        }
        return true;
    }
}