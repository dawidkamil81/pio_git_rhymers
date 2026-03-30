package edu.kis.vh.nursery;

public class FIFORhymer extends DefaultCountingOutRhymer {
    /*
        tworzy tymczasowy stos pomocniczy
     */
    private final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /*
        zamienia LIFO w FIO czyli odwraca stos
         przenosi elementy do tymczasowego stosu,
         nastepnie zwraca najstarszy element.
     */
    @Override
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
