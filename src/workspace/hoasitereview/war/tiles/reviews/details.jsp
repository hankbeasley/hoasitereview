<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@page import="javax.jdo.PersistenceManager"%>
<%@page import="com.sitereview.server.dao.*"%>
<%@page import="java.util.List"%>

    <%
    int i = 4;//one change
	PersistenceManager pm = PMF.get().getPersistenceManager();
	Provider provider = pm.getObjectById(Provider.class, Integer.parseInt(request.getParameter("key")));
	pageContext.setAttribute("p", provider);
	%>
	<h2>${p.name}</h2>
    <p><span>Information provided here is consolidated user input. If you notice information that is inaccurate, please post a comment</span></p>
    
	
		<p>Consensus: ${p.consensus}</p>
		<p>Price: ${p.price}</p>
		<div class="twocolumn">
		<strong>Pros</strong>
		<ul>
			<li>Feature rich</li>
			<li>Quick startup</li>
		</ul>
		</div>
		
		<div class="twocolumn">
		<strong>Cons</strong>
		<ul>
			<li>Price</li>
		</ul>
		</div>
		<div class="clr"></div>
		
		<div class="divider"></div>
		<h3>User comments</h3>
		<div class="bg2"></div>
	<%
	for(UserComment comment : provider.getUserComments()){
	%>
		<p>Name: <%=comment.getName() %></p>
		<p>Comment:<%=comment.getComment() %></p>
		<div class="bg"></div>
	<%}%>

	
	<form action="/postComment" method="post">
	<fieldset>
	<legend>Post a comment</legend>
	<label for="comment">Name:</label><input type="text" name="name" /><BR />
	<label for="comment">Comment:</label><textarea cols="40" rows="7" name="comment" ></textarea> <BR />
	<input type="submit" value="submit" />
	<input type="hidden" value="<%=provider.getKey().getId() %>" name="providerId" />
	</fieldset>
	</form>

      