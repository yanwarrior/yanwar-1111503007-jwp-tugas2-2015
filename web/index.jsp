<%-- 
    Document   : index
    Created on : Sep 25, 2015, 9:08:03 AM
    Author     : yanwar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tugas 1.2</title>
    </head>
    <body>
        <h1>Tugas 1.2 (Tugas2) - Genap Ganjil</h1>
        <h4>Yanwar Solahudin - 1111503007</h4>
        <table>
            <form method="POST" action="proses">
            <tr>
                <th>Angka Pertama:</th>
                <td><input type="number" name="angka1" min="1" max="100"></td>
            </tr>
            <tr>
                <th>Angka Kedua:</th>
                <td><input type="number" name="angka2" min="1" max="100"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="submit" value="Olah"/> 
                </td>
            </tr>
            </form>
        </table>
    </body>
</html>
