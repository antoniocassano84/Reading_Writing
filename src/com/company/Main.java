package com.company;

public class Main {

    public static void main(String[] args) {

        Message message = new Message();

        Thread writerThread = new Thread(new Writer(message));
        writerThread.setName("WriterThread"); writerThread.start();

        Thread readerThread = new Thread(new Reader(message));
        readerThread.setName("ReaderThread"); readerThread.start();
    }
}



