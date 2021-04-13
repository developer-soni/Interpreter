package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean isDumping;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram()
    {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            System.out.println(code.toString());
            this.dumping(code);
            programCounter++;

        }
    }

    public void newFrameAt(int off) {
        runTimeStack.newFrameAt(off);
    }

    public int pop() {
        return runTimeStack.pop();
    }

    public int push(int i) {
        return runTimeStack.push(i);
    }

    public void pushReturnAddrs() {
        returnAddress.push(programCounter);
    }

    public void setPC(int address) {
        programCounter = address;
    }

    public void halt() {
        isRunning = false;
    }

    public int load(int xVal) {
        return runTimeStack.load(xVal);
    }

    public int store(int xVal) {
        return runTimeStack.store(xVal);
    }

    public int popReturnAddrs() {
        return returnAddress.pop();
    }

    public void popFrame() {
        runTimeStack.popFrame();
    }

    public int peek() {
        return runTimeStack.peek();
    }

    public void setDumps(boolean b) {
        this.isDumping = b;
    }

    private void dumping(ByteCode code)
    {
        if(isDumping && !(code instanceof DumpCode)) {
            runTimeStack.dump();
        }
    }



}
