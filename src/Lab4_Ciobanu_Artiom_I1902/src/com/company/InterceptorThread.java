package com.company;

public class InterceptorThread extends Thread
{
    Thread _runnable;

    public InterceptorThread(Thread runnable)
    {
        _runnable = runnable;
    }

    public synchronized void run()
    {
        System.out.println("InterceptorThread has started to work!");

        //_runnable.start();

        _runnable.run();

        try
        {
            System.out.println("InterceptorThread is waiting.");
            wait();

            System.out.println("InterceptorThread is resuming.");
        } catch (InterruptedException interruptedException)
        {
            //interrupt();
            System.out.println(interruptedException.getMessage());
        }

    }
}
