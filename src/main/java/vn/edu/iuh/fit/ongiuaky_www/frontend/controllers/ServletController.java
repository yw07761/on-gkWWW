package vn.edu.iuh.fit.ongiuaky_www.frontend.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.ongiuaky_www.backend.enums.Roles;
import vn.edu.iuh.fit.ongiuaky_www.backend.models.Candidate;
import vn.edu.iuh.fit.ongiuaky_www.backend.models.Experience;
import vn.edu.iuh.fit.ongiuaky_www.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.ongiuaky_www.backend.repositories.ExperienceRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/ControllerServlet")
public class                                                                                                                                                                       ServletController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        CandidateRepository candidateRepository = new CandidateRepository();

        Candidate candidate = new Candidate(7,"ABCD", "abcd@gmail.com", "0987241412");

        Experience experience1 = new Experience(8, "Thanh cong", "XYZ", Roles.STAFF, candidate, LocalDate.of(2002, 8, 12), LocalDate.of(2005, 7, 15));
        Experience experience2 = new Experience(9, "Thanh cong", "XYZ", Roles.MANAGER, candidate, LocalDate.of(2002, 8, 12), LocalDate.of(2005, 7, 15));
        Experience experience3 = new Experience(10, "Thanh cong", "XYZ", Roles.ADMINISTRARION, candidate, LocalDate.of(2002, 8, 12), LocalDate.of(2005, 7, 15));

        List<Experience> experiences = new ArrayList<>();
        experiences.add(experience1);
        experiences.add(experience2);
        experiences.add(experience3);

        candidate.getExperiences().add(experience1);
        candidate.getExperiences().add(experience2);
        candidate.getExperiences().add(experience3);

        candidateRepository.insertCandidate(candidate);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        CandidateRepository candidateRepository = new CandidateRepository();

        if(action.equals("viewCandidateFromRole")){

            int role = Integer.parseInt(request.getParameter("role"));

            List<Candidate> listCan = candidateRepository.getCanditeFromRole(role);

            request.getSession().setAttribute("listCan", listCan);

            RequestDispatcher rd = request.getRequestDispatcher("/report1.jsp");
            rd.include(request,response);


        }
    }
}
