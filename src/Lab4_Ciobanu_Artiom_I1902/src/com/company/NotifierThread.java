package com.company;

public class NotifierThread extends Thread
{
    public void run()
    {
        System.out.println("NotifierThread has started to work!");

        try
        {
            synchronized (this)
            {
                 wait(1000);

                System.out.println("NotifierThread is notifying.");
                notifyAll();
            }
        } catch (InterruptedException interruptedException)
        {
            //interrupt();
            System.out.println(interruptedException.getMessage());
        }
    }
}
