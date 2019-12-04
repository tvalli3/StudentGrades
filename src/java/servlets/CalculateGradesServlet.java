package servlets;

import business.Student;
import business.StudentIO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tom Valli
 */
public class CalculateGradesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String msg ="", url = "/StudentGrade.jsp";
            Student s = null;
        
        
        try {
            s = new Student();
            
            String sno = request.getParameter("sid");
            if (sno.isEmpty()) {
                msg += "Missing Student ID<br>";
            } else {
                s.setSno(sno);
            }
            
            String lnm = request.getParameter("lastname");
            if (lnm.isEmpty()) {
                msg += "Last name is missing.<br>";
            } else {
                s.setLname(lnm);
            }
            
            String fnm = request.getParameter("firstname");
            if (fnm.isEmpty()) {
                msg += "First name is missing.<br>";
            } else {
                s.setFname(fnm);
            }
            
            request.setAttribute("s", s);
        
        
            String[] scores = { "q1", "q2", "q3", "q4", "q5", "qmkup", "midterm", "probs", "final" };
            for (String score : scores) {
                String scr = request.getParameter(score);
                if (!scr.isEmpty()) {
                    try {
                    double scrval = Double.parseDouble(scr);
                    if (scrval < 0 || scrval > 125) {
                        throw new NumberFormatException(score = " out of bounds.<br>");
                    }
                    switch (score) {
                        case "q1":
                            s.setQ1(scrval);
                            break;
                        case "q2":
                            s.setQ2(scrval);
                            break;
                        case "q3":
                            s.setQ3(scrval);
                            break;
                        case "q4":
                            s.setQ4(scrval);
                            break;
                        case "q5":
                            s.setQ5(scrval);
                            break;
                        case "qmkup":
                            s.setQm(scrval);
                            break;
                        case "midterm":
                            s.setMt(scrval);
                            break;
                        case "probs":
                            s.setPr(scrval);
                            break;
                        case "final":
                            s.setFe(scrval);
                            break;
                    }
                    } catch (Exception e) {
                        msg += "Error on " + score + ": " + e.getMessage() + "<br>";
                    }   
                
                
                } else {
                    msg += score + " is missing.<br>";
                }
            }
            s.calcGrade();
        } catch (Exception e) {
            msg += "Servlet error: " + e.getMessage() + "<br>";
        }
        if (!msg.isEmpty()) {
            url = "/students.jsp";
            request.setAttribute("msg", msg);
        } else {
            ServletContext context = getServletContext();
            String txtpath = context.getRealPath("/WEB-INF/classlist.txt");
            String serpath = context.getRealPath("/WEB-INF/classlist.ser");
            try {
                StudentIO.addStudent(s,txtpath);
                msg = StudentIO.addStudentSer(s,serpath);                
            } catch (IOException e) {
                msg = "Unable to save student: " + e.getMessage() + "<br>";                
            }
            if (!msg.isEmpty()) {
                request.setAttribute("msg", msg);
            }
        }
        
        RequestDispatcher disp = 
                getServletContext().getRequestDispatcher(url);
        disp.forward(request, response);
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
