package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int EMPTY_STACK_VALUE = -1;
    private static final int STACK_CAPACITY = 12;
    private static final int FULL_STACK_INDEX = 11;
    private final int[] numbers = new int[STACK_CAPACITY];

    private int total = EMPTY_STACK_VALUE;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }
    // TODO: zmienic nazwe na  isEmpty()
    public boolean callCheck() {
        return total == EMPTY_STACK_VALUE;
    }

    public boolean isFull() {
        return total == FULL_STACK_INDEX;
    }

    // TODO: zmienic nazwe na  peek()
    protected int peekaboo() {
        if (callCheck())
            return EMPTY_STACK_VALUE;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return EMPTY_STACK_VALUE;
        return numbers[total--];
    }

}
