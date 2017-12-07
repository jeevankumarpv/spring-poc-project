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
<h1>Employee Details</h1> 
 <center> 
<table border="2" width="70%" cellpadding="2">  
<tr><th>SNO</th><th>Name</th><th>Salary</th></tr>  
    
   <tr>  
   <td>${employee.sno}</td>  
   <td>${employee.name}</td>  
   <td>${employee.salary}</td>
     
   </tr>  
   
   </table>  
  </center>
  <a href="/"></a>