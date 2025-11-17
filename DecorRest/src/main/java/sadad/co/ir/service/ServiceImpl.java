package sadad.co.ir.service;

public class ServiceImpl implements Service {
    @Override
    public String action(String type) {
        return "action" + type + "done!";
    }
}
