package com.company;

import java.util.Random;

public class Writer implements Runnable {

    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String[] messages = {
                "first message Hello",
                "second message ciaooo",
                "third message ola",
                "fourth message bonjour"
        };

        Random random = new Random();
        for(int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException ie) {}
        }
        message.write("finished.");
    }
}