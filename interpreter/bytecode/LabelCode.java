package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.virtualmachine.VirtualMachine;

public class LabelCode extends ByteCode{

    private String label;

    public void init(ArrayList<String> array)
    {
        label =  array.get(0);
    }

    public void execute(VirtualMachine VM)
    {
    }

    public String getLabel()
    {
        return label;
    }

    public String toString()
    {
        return "LABEL " + label;
    }
}
