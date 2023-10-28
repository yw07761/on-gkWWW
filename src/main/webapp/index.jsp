<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.repositories.ExperienceRepository" %>
<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.repositories.CandidateRepository" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--    <%--%>
<%--        CandidateRepository candidateRepository = new CandidateRepository();--%>
<%--    %>--%>

    <form action="ControllerServlet" method="get">
        <button type="submit" name="action" value="addCan">Submit</button>
    </form>
    <a href="candidate.jsp">Candidate</a>
    <a href="report1.jsp">Report1</a>
    <a href="report2.jsp">Report2</a>

</body>
</html>