package patterns.factory;

/**
 * Created by louyuting on 17/1/6.
 */
public class AddFactory implements IFactory{

    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
