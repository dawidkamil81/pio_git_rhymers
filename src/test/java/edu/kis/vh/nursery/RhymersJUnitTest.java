package edu.kis.vh.nursery;
import edu.kis.vh.nursery.list.IntLinkedList;

import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {
//projekt poprawny
    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.callCheck();
        Assert.assertEquals(true, result);

        rhymer.countIn(888);

        result = rhymer.callCheck();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }
    //testy dla linked list
    @Test
    public void testPush() {
        IntLinkedList list = new IntLinkedList();
        list.push(5);
        Assert.assertEquals(5, list.top());
        list.push(10);
        Assert.assertEquals(10, list.top());
    }

    @Test
    public void testIsEmpty() {
        IntLinkedList list = new IntLinkedList();
        Assert.assertTrue(list.isEmpty());
        list.push(1);
        Assert.assertFalse(list.isEmpty());
        list.pop();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testTop() {
        IntLinkedList list = new IntLinkedList();
        final int EMPTY_STACK_VALUE = IntLinkedList.EMPTY_STACK_VALUE;
        Assert.assertEquals(EMPTY_STACK_VALUE, list.top());
        list.push(42);
        Assert.assertEquals(42, list.top());
    }

    @Test
    public void testPop() {
        IntLinkedList list = new IntLinkedList();
        final int EMPTY_STACK_VALUE = IntLinkedList.EMPTY_STACK_VALUE;
        Assert.assertEquals(EMPTY_STACK_VALUE, list.pop());

        list.push(1);
        list.push(2);
        list.push(3);
        Assert.assertEquals(3, list.pop());
        Assert.assertEquals(2, list.pop());
        Assert.assertEquals(1, list.pop());
        Assert.assertEquals(EMPTY_STACK_VALUE, list.pop());
    }
}
