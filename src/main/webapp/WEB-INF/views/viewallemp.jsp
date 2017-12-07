<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
 <style>
body {
    background-color: #d0e4fe;
}

h1 {
    color: orange;
    text-align: center;
}

</style>
</head>
<h1>All Employee Details</h1>
  
 <center> 
<table border="2" width="70%" cellpadding="2">  
<tr><th>Sno</th><th>Name</th><th>Salary</th></tr>  
   <c:forEach var="employee" items="${employeeList}">   
   <tr>  
   <td>${employee.sno}</td>  
   <td>${employee.name}</td> 
   <td>${employee.salary}</td> 
     
   </tr>  
   </c:forEach>  
   </table>  
   </center>
   <a href="/"></a>
   