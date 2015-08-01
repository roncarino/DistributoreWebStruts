<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" rel="stylesheet" href="/DistributoreWebStruts/style/style.css" />
	<title><s:property value="getText('visualizzaBevande.title')"/></title>
</head>
<body>
	<h1><s:property value="getText('visualizzaBevande.header')"/></h1>
	<div id="contenitore">
		<div id="menu">
			<menu>
				<li><s:a href="aggiornaColonnaLink.action"><s:property value="getText('menu.aggiornaColonna')"/></s:a></li>
				<li><s:a href="aggiungiBevandaLink.action"><s:property value="getText('menu.aggiungiBevanda')"/></s:a></li>
				<li><s:a href="visualizzaBevande.action"><s:property value="getText('menu.visualizzaBevande')"/></s:a></li>
				<li><s:a class="indietro" href="indietro.action"><s:property value="getText('menu.menuPrincipale')"/></s:a></li>
			</menu>
		</div>
		<div id="content">
			<h1 style="text-align: center;"><s:property value="getText('visualizzaBevande.h1')"/></h1>
			<table>
				<tr>
					<th><s:property value="getText('visualizzaBevande.table.nome')"/></th>
					<th><s:property value="getText('visualizzaBevande.table.prezzo')"/></th>
					<th><s:property value="getText('visualizzaBevande.table.codice')"/></th>
				</tr>
					
				<s:iterator value="listaBevande" >
					<tr>
						<td><s:property value="name" /></td>
						<td><s:property value="prezzo" /></td>
						<td><s:property value="codice" /></td>
					</tr>
				</s:iterator>	
			</table>
		</div>
	</div>
</body>
</html>