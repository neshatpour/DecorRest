package sadad.co.ir.service;

public class BaseDecorator implements Service {

    protected final Service wrappedService;

    public BaseDecorator(Service wrappedService) {
        this.wrappedService = wrappedService;
    }

    @Override
    public String action(String type) {
        return wrappedService.action(type);
    }
}
