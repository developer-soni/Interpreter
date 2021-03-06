package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.virtualmachine.VirtualMachine;

public class GotoCode extends ByteCode {

    private String GOlabel;
    private int PCaddress;

    @Override
    public void init(ArrayList array)
    {
        GOlabel = (String) array.get(0);
    }

    @Override
    public void execute(VirtualMachine VM)
    {
        VM.setPC(PCaddress);
    }

    public void setAddress(Integer x)
    {
        this.PCaddress = x;
    }

    public String getLabel()
    {
        return GOlabel;
    }

    @Override
    public String toString() {
        return "GOTO " + GOlabel;
    }
}
