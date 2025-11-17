package sadad.co.ir.service;

public class ConsoleLogDecorator extends BaseDecorator {

    public ConsoleLogDecorator(Service wrappedService) {
        super(wrappedService);
    }

    @Override
    public String action(String type) {
        System.out.println("ConsoleLogDecorator.action invoked! = " + type);
        String result = super.action(type);
        return result;
    }
}
