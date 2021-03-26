package edu.escuelaing.arep;

import com.google.gson.*;
import spark.Request;
import spark.Response;
import edu.escuelaing.arep.model.RequestOperation;
import edu.escuelaing.arep.service.Service;
import edu.escuelaing.arep.service.ServiceImpl;
import static spark.Spark.*;

public class App {
    private static final Gson gson = new Gson();
    private static final Service service = new ServiceImpl();

    public static void main(String args[]) {

        port(getPort());
        get("/", (req, res) -> inputDataPage(req, res));
        get("/tan", (req, res) -> tanOperation(req, res));
        get("/asin", (req, res) -> asinOperation(req, res));

    }

    /**
     * metodo muestra pagina principal para inteaccion con el usuario
     * @param req
     * @param res
     * @return
     */
    private static String inputDataPage(Request req, Response res) {
        String pageContent = "<!DOCTYPE html> <html> <body>" + "<h2>Servicio de Calculadora - Parcial 2</h2>"
                + "<form action=\"/tan\">" + "  Ingrese su numero para calcular la Tangente <br>"
                + "  <input type=\"text\" name=\"TAN\" >" + "  <br><br>"
                + "  <input type=\"submit\" value=\"Calcular tangente\">" + "</form>" + "<b>.</b>"
                + "<form action=\"/asin\">" + "  Ingrese su numero para calcular el Arcoseno <br>"
                + "  <input type=\"text\" name=\"ASIN\" >" + "  <br><br>"
                + "  <input type=\"submit\" value=\"Calcuar arcoseno\">" + "</form>" + "</body>" + "</html>";
        return pageContent;
    }

    /**
     * metodo encargado de solicitar el calulculo y mostart el json en pantalla
     * @param req
     * @param res
     * @return
     */
    private static Object tanOperation(Request req, Response res) {

        Double n = Double.parseDouble(req.queryParams("TAN"));
        RequestOperation resultado = service.getTan(n);
        res.header("Content-Type", "application/json");
        return gson.toJson(resultado);

    }

     /**
     * metodo encargado de solicitar el calulculo y mostart el json en pantalla
     * @param req
     * @param res
     * @return
     */
    private static Object asinOperation(Request req, Response res) {

        Double n = Double.parseDouble(req.queryParams("ASIN"));
        RequestOperation resultado = service.getAsin(n);
        res.header("Content-Type", "application/json");
        return gson.toJson(resultado);

    }

    /**
     * metodo que setea el puerto
     * @return
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}