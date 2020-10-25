<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value = '${pageContext.request.contextPath}'/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://kit.fontawesome.com/c1d8b25418.js" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOO9 LJH</title>
    
    <style>
        html, body{
            height: 100%;
            width: 100%;

            display: flex;
            align-items: center;
            flex-direction: column;
            
            font-weight:1000;
            outline: none;
            box-shadow: 5px 10px 8px -8px #888888;
        } 
        #div_body{
            height: 100%;
            width: 80%;
            border-radius : 5px;
            display: flex;
            overflow: auto;
        }
		
		#div_left{
		    width: 90%;
		    border: 5px solid rgb(12, 113, 87); 
		    margin-right: 5px;
		    box-shadow: 15px 15px 15px -5px #888888;
		    display: flex;
		    flex-direction: column;
		}
		
		#div_right{
			display:flex;
			justify-content:space-between; 
			flex-direction: column;
		}
</style>
<script>
document.addEventListener('DOMContentLoaded', (event) => 
{

});
</script>
</head>
<body>
	<%@ include file = "/WEB-INF/views/include/header.jspf" %>

    
    <div id = "div_body">
        <div id="div_left">
        	<c:choose>   		
	    		<c:when test="${BODY == 'CLOTING_LIST'}">
	    			<%@ include file="/WEB-INF/views/clothing/clothing_list.jspf" %>
	    		</c:when>
	    		
	    		<c:when test="${BODY == 'CLOTHING_WRITE' }">
	    			<%@ include file="/WEB-INF/views/clothing/clothing_write.jspf" %>
	    		</c:when>
	    		
	    		<c:when test="${BODY == 'CLOTHING_DETAIL'}">
	    			<%@ include file ="/WEB-INF/views/clothing/clothing_detail.jspf" %>
	    		</c:when>
	    		
	    		<c:otherwise>
	    			<%@include file="/WEB-INF/views/include/index.jspf" %>
	    		</c:otherwise>
    		</c:choose>
    		
    	<c:choose>	
 			<c:when test="${BODY == 'USER_LOGIN'}">
  			<%@ include file="/WEB-INF/views/user/login.jspf" %>
  			</c:when>
  		
  			<c:when test="${BODY == 'USER_JOIN'}">
  				<%@ include file="/WEB-INF/views/user/join.jspf" %>
  			</c:when>
    	</c:choose>
    		
        </div>        
        <div id="div_right">
			<%@ include file ="/WEB-INF/views/include/nav.jspf" %>
        </div>
    </div>
	
	
	
	
    <%@ include file ="/WEB-INF/views/include/footer.jspf" %>
</body>
</html>