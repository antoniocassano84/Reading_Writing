package com.company;

public class Message {

    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while(empty) {
            try {
                wait();
            } catch(InterruptedException e) {}
            finally {
                System.out.println(ThreadColor.ANSI_BLUE +
                        "DEBUG: (" + Thread.currentThread().getName() +
                        ") empty: " + empty + "; in while loop waiting..." +
                        ThreadColor.ANSI_RESET);
            }
        }
        empty = true;
        notifyAll();
        System.out.println(ThreadColor.ANSI_BLUE +
                "DEBUG: ("+ Thread.currentThread().getName() +
                ") Message \"" + message + "\" has been read" +
                "; empty is: " + empty + ThreadColor.ANSI_RESET);
        return message;
    }

    public synchronized void write(String message) {
        while(!empty) {
            try {
                wait();
            } catch(InterruptedException e) {}
            finally {
                System.out.println(ThreadColor.ANSI_RED +
                        "DEBUG: (" + Thread.currentThread().getName() +
                        ") empty: " + empty + "; in while loop waiting..." +
                        ThreadColor.ANSI_RESET);
            }
        }
        empty = false;
        this.message = message;
        System.out.println(ThreadColor.ANSI_RED +
                "DEBUG: ("+ Thread.currentThread().getName() +
                ") Message \"" + this.message + "\" has been written"
                + "; empty is: " + empty + ThreadColor.ANSI_RESET);
        notifyAll();
    }
}
