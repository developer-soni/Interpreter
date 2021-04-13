package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        framePointer.add(0);
    }

    public void dump(){


        int index = 0;
        if (framePointer.size() > 1) {
            for (int i = 1; i < framePointer.size(); i++) {
                System.out.print(runTimeStack.subList(index, framePointer.get(i)));
                index = framePointer.get(i);
            }
        }
        System.out.println(runTimeStack.subList(index, runTimeStack.size()));

    }

    public int peek ()
    {
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    public int pop()
    {
        int top;
        if(!runTimeStack.isEmpty()){
            top = runTimeStack.get(runTimeStack.size()- 1);
            runTimeStack.remove(runTimeStack.size() - 1);
        } else {
            top = 0;
        }

        return top;
    }

    public int push(int i)
    {
        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt (int offset)
    {
        int size = this.runTimeStack.size() - offset;
        framePointer.push(size);
    }

    public void popFrame()
    {
        int top = runTimeStack.get(runTimeStack.size() - 1);
        while(runTimeStack.size() != framePointer.peek()) {
            runTimeStack.remove(runTimeStack.size()- 1);
        }
        framePointer.pop();
        runTimeStack.add(top);
    }

    public int store(int offset)
    {
        int top;
        if(!runTimeStack.isEmpty()){
            top = runTimeStack.get(runTimeStack.size()- 1);
            runTimeStack.remove(runTimeStack.size() - 1);
        } else {
            top = 0;
        }
        runTimeStack.add(framePointer.peek() + offset, top);
        return top;
    }

    public int load(int offset)
    {
        int top = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(top);
        return top;
    }

    public Integer push(Integer i)
    {
        runTimeStack.add(i);
        return i;
    }

}
