package edu.kis.vh.nursery;

public class FIFORhymer extends DefaultCountingOutRhymer {
    /*
        tworzy tymczasowy stos pomocniczy
     */
    // TODO: zoptymalizowac zuzycie pamieci, najlepiej zadeklarowac ten stos wewnatrz metody countOut()
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
