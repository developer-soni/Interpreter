package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.virtualmachine.VirtualMachine;

public class WriteCode extends ByteCode{

    public void execute(VirtualMachine VM) {
        System.out.println(VM.peek());
    }

    public void init (ArrayList<String> args) {

    }
    public String toString() {
        return "WRITE";
    }
}
