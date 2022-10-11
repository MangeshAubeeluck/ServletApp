<%@page import="net.javaguides.tutorial.service.ClientCRUDService"%>  
<jsp:useBean id="client" class="net.javaguides.tutorial.model.Client"></jsp:useBean>
<jsp:setProperty property="*" name="client"/>  
<%  
ClientCRUDService.delete(client);
response.sendRedirect("Clients");  
%> 