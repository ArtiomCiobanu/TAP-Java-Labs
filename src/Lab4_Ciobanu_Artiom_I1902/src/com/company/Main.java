package com.company;

//Создайте два подкласса Thread, один, использующий run( ) для запуска,
//и перехватывающий ссылку на второй процесс Thread, а затем вызывающий wait( ).
//Вызов run() второго класса должен вызывать notifyAll( ) для первого процесса
//после нескольких секунд ожидания, так, чтобы первый процесс при этом вывел сообщение.
public class Main
{
    public static void main(String[] args)
    {
        var notifierThread = new NotifierThread();

        var interceptorThread = new InterceptorThread(notifierThread);
        interceptorThread.start();
        //notifierThread.start();
    }
}