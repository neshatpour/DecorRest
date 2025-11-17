package sadad.co.ir.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import sadad.co.ir.service.Service;

import java.io.IOException;
import java.io.OutputStream;

public class RestController implements HttpHandler {

    private final Service service;

    public RestController(Service service) {
        this.service = service;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (!httpExchange.getRequestMethod().equals("GET")) {
            httpExchange.sendResponseHeaders(405, -1);
            return;
        }

        String query = httpExchange.getRequestURI().getQuery();
        String input = "empty";
//        System.out.println(input);
        if (query != null && query.startsWith("q=")) {
            input = query.substring(2);
        }

        String output = service.action(input);

        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody();
        os.write(output.getBytes());
        os.close();

    }
}
