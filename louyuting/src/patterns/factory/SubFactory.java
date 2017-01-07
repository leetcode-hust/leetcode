package patterns.factory;

/**
 * Created by louyuting on 17/1/6.
 */
public class SubFactory implements IFactory{

    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
