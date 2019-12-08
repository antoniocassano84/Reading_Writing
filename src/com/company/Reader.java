package com.company;

import java.util.Random;

public class Reader implements Runnable {

    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for(String last = message.read(); !last.equals("finished");
            last = message.read()) System.out.println(ThreadColor.ANSI_BLUE +
                ">>> " + Thread.currentThread().getName() +
                " is printing: " + last + ThreadColor.ANSI_RESET);
        try {
            Thread.sleep(random.nextInt(2000));
        } catch (InterruptedException ie) {}
    }
}
