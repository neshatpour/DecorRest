package sadad.co.ir;

import com.sun.net.httpserver.HttpServer;
import sadad.co.ir.controller.RestController;
import sadad.co.ir.service.ConsoleLogDecorator;
import sadad.co.ir.service.FileLogDecorator;
import sadad.co.ir.service.Service;
import sadad.co.ir.service.ServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Service service = new ServiceImpl();

        service = new FileLogDecorator(service);

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/action", new RestController(service));
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
