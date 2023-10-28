<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.enums.Roles" %>
<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.repositories.CandidateRepository" %>
<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.services.CandidateServices" %>
<%@ page import="vn.edu.iuh.fit.ongiuaky_www.backend.models.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.management.relation.Role" %><%--
  Created by IntelliJ IDEA.
  User: CHAU
  Date: 10/27/2023
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report1</title>
</head>
<body>
<form action="ControllerServlet" method="post">

        <select name="role" id="role">
            <option value="1"><%=Roles.ADMINISTRARION%></option>
            <option value="2"><%=Roles.STAFF%></option>
            <option value="3"><%=Roles.MANAGER%></option>
            <option value="4"><%=Roles.EXECUTIVE%></option>
        </select>

        <button type="submit" name="action" value="viewCandidateFromRole">View</button>

        <table>
            <tr>
                <th>CandateID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Phone</th>
            </tr>

            <%
                List<Candidate> list = (List<Candidate>) request.getSession().getAttribute("listCan");
                if(list != null){
                for (Candidate candidate : list){
                long canId = candidate.getId();
            %>

            <tr>
                <td><%=canId%></td>
                <td><%=candidate.getFullName()%></td>
                <td><%=candidate.getEmail()%></td>
                <td><%=candidate.getPhone()%></td>

            </tr>

                <%}
                }%>
        </table>
</form>
</body>
</html>
