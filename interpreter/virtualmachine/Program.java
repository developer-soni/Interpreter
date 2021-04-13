package interpreter.virtualmachine;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private static HashMap<String, Integer> labels = new HashMap<>();


    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    public int getSize() {
        return this.program.size();
    }

    public void addByteCode(ByteCode byteVal)
    {
        if(byteVal instanceof LabelCode)
        {
            LabelCode value = (LabelCode) byteVal;
            Integer PCAddress = this.program.size();
            labels.put(value.getLabel(), PCAddress);
        }
        program.add(byteVal);
    }
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress(Program program) {

        for (int i = 0; i < program.getSize(); i++)
        {
            if (program.getCode(i) instanceof GotoCode)
            {
                GotoCode val = (GotoCode) program.getCode(i);
                val.setAddress(labels.get(val.getLabel()));

            }
            if (program.getCode(i) instanceof CallCode)
            {
                CallCode val = (CallCode) program.getCode(i);
                val.setAddress(labels.get(val.getLabel()));

            }
            if (program.getCode(i) instanceof FalseBranchCode)
            {
                FalseBranchCode val = (FalseBranchCode) program.getCode(i);
                val.setAddress(labels.get(val.getLabel()));

            }
        }

    }
}
