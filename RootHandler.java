import java.io.*;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RootHandler implements HttpHandler{
    public void handle(HttpExchange he) throws IOException {
        he.sendResponseHeaders(200,0);
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(he.getResponseBody() ));



            out.write(
                    "<html>" +
                            "<head>" +
                            "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css\"/>" +
                            "        <style>" +
                            "            * {font-family: Futura, \"Trebuchet MS\", Arial, sans-serif;" +
                            "                padding: 0;" +
                            "                margin: 0;" +
                            "                text-decoration: none;" +
                            "            }" +
                            "            a {" +
                            "                color: inherit;" +
                            "            }" +
                            "            header h1 {" +
                            "                color: white;" +
                            "            }" +
                            "            header {" +
                            "                background: #000;" +
                            "                display: flex;" +
                            "                padding: 0.75em 3%;" +
                            "                justify-content: space-between;" +
                            "                align-items: center;" +
                            "                color: white;" +
                            "            }" +
                            "            header i {" +
                            "                padding: 0.15em 0.5em;" +
                            "                font-size: 1.5em;" +
                            "" +
                            "            }" +
                            "            header h1 {" +
                            "                line-height: 1.5em;" +
                            "            }" +
                            "            .logo-cont, i, nav > ul {" +
                            "                display: flex;" +
                            "                justify-content: center;" +
                            "                align-items: center;" +
                            "            }" +
                            "            nav ul {" +
                            "                list-style-type: none;" +
                            "                padding: 0;" +
                            "                font-size: 1.25em;" +

                            "            }" +

                            "            nav ul li {" +
                            "                padding: 0.5em;" +
                            "            }" +
                            "            nav ul li:hover {" +
                            "                cursor: pointer;" +
                            "            }" +
                            "        </style>" +
                            "    </head>" +
                            "    <body>" +
                            "        <header>" +
                            "            <a class=\"logo-cont\" href=\"/\">" +
                            "                <i class=\"bi bi-bag-check-fill\"></i>" +
                            "                <h1>EverythingStore</h1>" +
                            "            </a>" +
                            "            <nav>" +
                            "                <ul>" +
                            "                    <li><a href=\"/products\">Products</a></li>" +
                            "                    <li><a href=\"/customers\">Customers</a></li>" +
                            "                    <li>Login</li>" +
                            "                </ul>" +
                            "            </nav>" +

                            "        </header>" +
                            "" +
                            "    </body>" +
                            "</html>"
            );
            out.close();




    }

}