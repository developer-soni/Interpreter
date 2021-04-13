package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.virtualmachine.VirtualMachine;

public class HaltCode extends ByteCode {

    public void execute (VirtualMachine VM)
    {
        VM.halt();
    }

    public void init(ArrayList<String> args) {
    }
    public String toString()
    {
        return "HALT";
    }

}
