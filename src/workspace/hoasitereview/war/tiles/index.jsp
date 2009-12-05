<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@page import="javax.jdo.PersistenceManager"%>
<%@page import="com.sitereview.server.services.*"%>
<%@page import="com.sitereview.server.dao.*"%>
<%@page import="java.util.List"%>

	<h2>Welcome to Home Owners Association Site Review</h2>
	<p><span></span></p>
	<p>You will a lot of useful information to assist you in create a web site for your neighborhood</p>
	<p>&nbsp;</p>
	
	
	<h2>Provider overview</h2>
	  <img src="/images/img_2.jpg" width="77" height="77" alt="img" />
	<p><span>Information provided here is consolidated user input. If you notice information that is inaccurate, please post a comment</span></p>
	<p>Click on any of the providers to to see more details and user reviews</p>
	<div class="bg"></div>
	
	<% Object[] providers = ProviderService.getAll().toArray(); 
	pageContext.setAttribute("providers", providers);
	%>
	<c:forEach var="p" items="${providers}" >
		<p><strong>${p.name}</strong></p>
		<p>Consensus: ${p.consensus}</p>
		<p><a href="/reviews/details.tiles?key=${p.key.id}" class="green">Read More</a></p>
		<div class="bg"></div>
	</c:forEach>


