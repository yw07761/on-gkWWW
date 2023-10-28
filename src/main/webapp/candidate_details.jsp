<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.services.ExperienceServices" %>
<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.models.Experience" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.repositories.ExperienceRepository" %><%--
  Created by IntelliJ IDEA.
  User: CHAU
  Date: 10/27/2023
  Time: 12:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidate Details</title>
</head>
<body>
    <%
        ExperienceRepository experienceRepository = new ExperienceRepository();
        long canId = Long.parseLong(request.getParameter("can_id").toString());
        List<Experience> experienceList = experienceRepository.findAllExperienceFromCanId(canId);
    %>
    <table>
        <tr>
            <th>Company</th>
            <th>FromDate</th>
            <th>ToDate</th>
            <th>Role</th>
            <th>WorkDesc</th>
            <th>View</th>
        </tr>

        <%
            for (Experience experience : experienceList){

        %>

        <tr>
            <td><%=experience.getCompanyName()%></td>
            <td><%=experience.getFromDate()%></td>
            <td><%=experience.getToDate()%></td>
            <td><%=experience.getRole()%></td>
            <td><%=experience.getWorkDescription()%></td>

        </tr>

        <%}%>


    </table>

</body>
</html>
