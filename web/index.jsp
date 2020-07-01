<%-- 
    Document   : index
    Created on : 30/06/2020, 02:52:49 PM
    Author     : Humberto Manjarres
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
          
        <script>

        let a = 0, b = 0, c = 0, d = 0, e = 0;
        function moneda(n) {
        if (n === 50) {
        a = a + 1;
        document.getElementById("moneda1").value = a;
        } else if (n === 100) {
        b = b + 1;
        document.getElementById("moneda2").value = b;
        } else if (n === 200) {
        c = c + 1;
        document.getElementById("moneda3").value = c;
        } else if (n === 500) {
        d = d + 1;
        document.getElementById("moneda4").value = d;
        } else if (n === 1000) {
        e = e + 1;
        document.getElementById("moneda5").value = e;
        }

        }
        

    </script>
   
    <title>ALCANCIA</title>
</head>
<body>
    <nav class="navbar navbar-light bg-info">
        <a class="navbar-brand" href="principal.jsp">
            <img src="imagenes/monedas.png" width="30" height="30" class="d-inline-block align-top" alt="logoCar" loading="lazy">
            <strong>Alcancia</strong>
        </a>
        Ing Humberto Manjarres Gelis.
    </nav>

    <div class="row">
        <div class="card col-sm-4">
            <div class="card-body">
                <form action="Controlador" method="POST" name="formAlcancia">
                    <div class="form-group">
                        <label><strong>MONEDAS</strong></label>
                    </div>
                    <div class="form-group">
                        <a onclick="moneda(50);" class="btn btn-warning">$50</a>
                        <a onclick="moneda(100);" class="btn btn-warning">$100</a>
                        <a onclick="moneda(200);" class="btn btn-warning">$200</a>
                        <a onclick="moneda(500);" class="btn btn-warning">$500</a>
                        <a onclick="moneda(1000);" class="btn btn-warning">$1000</a>
                    </div>
                    CONTROL.
                    <div class="form-group">
                        <label>$50 <input type="number" autocomplete="off" id="moneda1" min="1" name="txtMoneda1" class="form-control" style="width: 60px"></label>
                        <label>$100 <input type="number" autocomplete="off" id="moneda2" min="1" name="txtMoneda2" class="form-control" style="width: 60px"></label>
                        <label>$200 <input type="number" autocomplete="off" id="moneda3" min="1" name="txtMoneda3" class="form-control" style="width: 60px"></label>
                        <label>$500 <input type="number" autocomplete="off" id="moneda4" min="1" name="txtMoneda4" class="form-control" style="width: 60px"></label>
                        <label>$1000 <input type="number" autocomplete="off" id="moneda5" min="1" name="txtMoneda5" class="form-control" style="width: 60px"></label>
                    </div>
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Limpiar" class="btn btn-success">
                    <input type="submit" name="accion" value="Vaciar Alcancia" class="btn btn-danger">
                </form>

            </div>
        </div>
        <div class="col-sm-8">
            <table class="table table-hover" style="text-align: center">
                <thead>
                    <tr>
                        <th>Moneda</th>
                        <th>Cantidad x Moneda</th>
                        <th>Valor total x Moneda</th>
                    </tr>
                </thead>

                <tbody style="text-align: center">
                    <c:forEach var="money" items="${lista_monedas}">
                        <tr>
                            <td>${money.getMoneda()}</td>
                            <td>${money.getCantidad()}</td>
                            <td>${money.getValor()}</td>
                        </tr>
                    </c:forEach>
                    <tr style="background: #D7DBDD">
                        <td><strong>Total</strong></td>
                        <td>
                            <strong>${totalCantidad}</strong>   
                        </td>
                        <td>$ <strong>${totalValor}</strong></td>
                    </tr>
                </tbody>
            </table>


        </div>
    </div>
                  
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>