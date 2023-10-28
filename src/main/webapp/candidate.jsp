<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.services.CandidateServices" %>
<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.models.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.repositories.CandidateRepository" %><%--
  Created by IntelliJ IDEA.
  User: CHAU
  Date: 10/27/2023
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidate</title>
</head>
<body>
    <%
        CandidateRepository candidateRepository = new CandidateRepository();
        List<Candidate> candidateList = candidateRepository.findAllCandidate();
    %>
    <table>
            <tr>
                <th>CandateID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>View</th>
            </tr>

            <%
                for (Candidate candidate : candidateList){
                long canId = candidate.getId();
            %>

            <tr>
                <td><%=canId%></td>
                <td><%=candidate.getFullName()%></td>
                <td><%=candidate.getEmail()%></td>
                <td><%=candidate.getPhone()%></td>
                <td><a href="candidate_details.jsp?can_id=<%=canId%>">Vìew</a></td>

            </tr>

        <%}%>

    </table>
</body>
</html>
