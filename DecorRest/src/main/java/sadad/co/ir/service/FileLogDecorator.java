package sadad.co.ir.service;

public class FileLogDecorator extends BaseDecorator{

    public FileLogDecorator(Service wrappedService) {
        super(wrappedService);
    }

    @Override
    public String action(String type) {
        System.out.println("FileLogDecorator.action invoked! = " + type);
        LogToFile.INSTANCE.logToFile(type);
        return super.action(type);
    }
}
