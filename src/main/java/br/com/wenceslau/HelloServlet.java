package br.com.wenceslau;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe que expõe o acesso ao endpoint
 * http://domain/contextPath/hello
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Metodo chamado quando uma requisição GET é feita ao endereço
     * http://{domain}/{contextPath}/hello
     *
     * @param request Objeto que permite acesso aos dados recebidos na requisição
     * @param response Objeto que permite envio de dados ao requisitor
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Recupera um parametro recebido na URL como QUERY parameter
        String nome = request.getParameter("nome");

        String msg = String.format("Hi %s. Get Request received: %s", nome, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        //Adiciona no request uma mensagem que sera usada na pagina JSP
        request.setAttribute("message", msg );

        //Permite encaminhar o retorno da requisição ao uma pagina
        RequestDispatcher rd = request.getRequestDispatcher("/hello.jsp");

        //Encaminha para a pagina definida no path do dispatcher,
        rd.forward(request, response);

    }

}