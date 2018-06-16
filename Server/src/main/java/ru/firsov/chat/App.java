package ru.firsov.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * JavaCore. Level1. Lesson 6
 *
 * @author Firsov Kirill
 * @version dated June 15, 2018
 * @link https://github.com/VanGoghDev
 */

public class App 
{
    public static void main( String[] args )
    {
        ServerSocket serv = null;
        Socket sock = null;
        try{
            serv = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            sock = serv.accept();
            System.out.println("Клиент подключился");
            Scanner sc = new Scanner(sock.getInputStream());
            PrintWriter pw = new PrintWriter(sock.getOutputStream());
            while (true) {
                String str = sc.nextLine();
                if (str.equals("end")) break;
                pw.print("Эхо: " + str);
                pw.flush();
            }
        } catch (IOException e){
            System.out.println("Ошибка инициализации сервера");
        } finally{
            try{
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
