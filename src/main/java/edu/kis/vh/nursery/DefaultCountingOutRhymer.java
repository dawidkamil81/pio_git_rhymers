package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int EMPTY_STACK_VALUE = -1;
    public static final int STACK_CAPACITY = 12;
    public static final int FULL_STACK_INDEX = 11;
    private final int[] numbers = new int[STACK_CAPACITY];

    public int getTotal() {
        return total;
    }

    private int total = EMPTY_STACK_VALUE;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == EMPTY_STACK_VALUE;
    }

    private boolean isFull() {
        return total == FULL_STACK_INDEX;
    }

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
