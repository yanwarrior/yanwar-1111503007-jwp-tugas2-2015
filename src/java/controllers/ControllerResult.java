package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author yanwar
 */
@WebServlet(name = "ControllerResult", urlPatterns = {"/ControllerResult"})
public class ControllerResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerResult</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerResult at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.output(request, response);
        
    }
    
    public void output(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
        //processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // tahap 1 - menangkap inputan
        String a1 = request.getParameter("angka1");
        String a2 = request.getParameter("angka2");
        
        // tahap 2 - konversi string ke integer
        int angka1 = Integer.parseInt(a1);
        int angka2 = Integer.parseInt(a2);
        
        
        // tahap 3 - membuat batasan nilai
        int batas1 = angka1 + 1;
        int batas2 = angka2 - 1;
        
        // tahap 4 - membuat tampungan dengan array list
        // untuk menampung semua nilai, angka-angka ganjil dan angka-angka genap.
        ArrayList<Integer> semuaNilai = new ArrayList<Integer>();
        ArrayList<Integer> angkaGanjil = new ArrayList<Integer>();
        ArrayList<Integer> angkaGenap = new ArrayList<Integer>();
        
        // tahap 5  - generate semua nilai dari mulai angka1 sampai angka2
        // dimana angka1 harus lebih kecil dari angka2.
        for (int i = angka1; i <= angka2; i++) {
            semuaNilai.add(i);
        }
        
        // tahap 6 - ambil angka genap
        for (int val: semuaNilai) {
            if (val % 2 == 0) {
                angkaGenap.add(val);
            } else {
                // tahap 7 - ambil angka ganjil
                angkaGanjil.add(val);
            }
        }
        
        // tahap 8 - tampilkan
        String msg = "<h2>Hasil Proses</h2><table border='1'>";
        msg += "<tr><td>Semua Data</td><td>" + semuaNilai.toString().replace("[", "").replace("]", "") + "</td></tr>";
        msg += "<tr><td>Angka Ganjil</td><td>" + angkaGanjil.toString().replace("[", "").replace("]", "") + "</td></tr>";
        msg += "<tr><td>Angka Genap</td><td>" + angkaGenap.toString().replace("[", "").replace("]", "") + "</td></tr>";
        msg += "<tr><td>Nilai Terkecil</td><td>" + batas1 + "</td></tr>";
        msg += "<tr><td>Nilai Terbesar</td><td>" + batas2 + "</td></tr>";
        msg += "<tr><td>Waktu Proses</td><td>" + request.getAttribute("timeProc") + "</td></tr>";
        msg += "<tr><td>IP</td><td>" + request.getAttribute("IPAddress") + "</td></tr>";
        msg += "</table><br><a href='/yanwar-1111503007-jwp-tugas2-2015'>Kembali</a>";
        out.println(msg);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
