package com.devcolibri.servlets;

import com.devcolibri.crud.CarService;
import com.devcolibri.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Shevtsov on 028 28.03.16.
 */
@WebServlet("/web")
public class ServletConfig extends HttpServlet {

    CarService service = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");//Позволяет выводить кирилицу
        PrintWriter out = resp.getWriter();
        out.println("<h2>Привет Servlet doGet</h2><br> Again");

        //Получаем все авто с БД
        List<Car> cars = service.getAll();

        //Выводим полученый список авто
        for (Car c : cars) {
            out.println("<h2>" + c + "</h2>");
        }

        out.close();
        System.out.println("Info from get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");//Позволяет выводить кирилицу
        PrintWriter out = resp.getWriter();
        out.println("<h2>Привет Servlet doPost</h2><br> Again");
        out.close();
        System.out.println("Info from post");

    }
}
