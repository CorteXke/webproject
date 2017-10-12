
package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;


public class indexServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EtteremErtekeloPU");
            EntityManager em = emf.createEntityManager();
            
            if(request.getParameter("feladat").equals("listazas")){
                StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllEtterem");
                List<Object[]> ettermek = spq.getResultList();
                JSONArray etteremTomb = new JSONArray();
                for(Object[]etterem : ettermek){
                JSONObject etteremAdatok = new JSONObject();
                    etteremAdatok.put("id",etterem[0]);
                    etteremAdatok.put("nev",etterem[1]);
                    etteremAdatok.put("kiszolgalas",etterem[2]);
                    etteremAdatok.put("higienia",etterem[3]);
                    etteremAdatok.put("minoseg",etterem[4]);
                    etteremAdatok.put("ar",etterem[5]);
                    etteremAdatok.put("nyitvatartas", etterem[6]);
                    etteremAdatok.put("kep",etterem[7]);
                  etteremTomb.put(etteremAdatok);
                    
                }//for vége
            out.write(etteremTomb.toString());
            
            }//if vége
        }//try vége
        catch(Exception e){
        System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
