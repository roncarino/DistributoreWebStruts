<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" rel="stylesheet" href="/DistributoreWebStruts/style/style.css" />
	<title><s:property value="getText('erogazione.title')"/></title>
</head>
<body>
	<h1><s:property value="getText('erogazione.header')"/></h1>
	<div id="contenitore">
		<div id="menu">
			<menu>
				<li><s:a href="erogaLink.action"><s:property value="getText('menu.effettuaErogazione')"/></s:a></li>
				<li><s:a href="lattineDisponibiliLink.action"><s:property value="getText('menu.lattineDisponibili')"/></s:a></li>
				<li><s:a href="ricaricaTesseraLink.action"><s:property value="getText('menu.ricaricaTessera')"/></s:a></li>
				<li><s:a href="visualizzaDistributore.action"><s:property value="getText('menu.visualizzaDistributore')"/></s:a></li>
				<li><s:a class="indietro" href="indietro.action"><s:property value="getText('menu.menuPrincipale')"/></s:a></li>
			</menu>
		</div>
		<div id="content">
			<h1><s:property value="getText('erogazione.h1')"/></h1>
		</div>
	</div>
</body>
</html>