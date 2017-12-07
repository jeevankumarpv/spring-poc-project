<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
  <style>
body {
    background-color: #d0e4fe;
}

</style>
</head>

       <form:form method="get" action="searchdata">    
        <table >    
         <tr>    
          <td>Emp id : </td>   
          <td><form:input path="sno"  /></td>  
         </tr>    
         
         <tr>    
          <td colspan="2"><input type="submit" value="Search" /></td>    
         </tr>    
        </table>    
       </form:form>