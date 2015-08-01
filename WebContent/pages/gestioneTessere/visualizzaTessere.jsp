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
	<title><s:property value="getText('visualizzaTessere.title')"/></title>
</head>
<body>
	<h1><s:property value="getText('visualizzaTessere.header')"/></h1>
	<div id="contenitore">
		<div id="menu">
			<menu>
				<li><s:a href="aggiungiTesseraLink.action"><s:property value="getText('menu.aggiungiTessera')"/></s:a></li>
				<li><s:a href="visualizzaTessere.action"><s:property value="getText('menu.visualizzaTessere')"/></s:a></li>
				<li><s:a class="indietro" href="indietro.action"><s:property value="getText('menu.menuPrincipale')"/></s:a></li>
			</menu>
		</div>
		<div id="content">
			<h1 style="text-align: center;"><s:property value="getText('visualizzaTessere.h1')"/></h1>
			<table>
				<tr>
					<th><s:property value="getText('visualizzaTessere.table.codice')"/></th>
					<th><s:property value="getText('visualizzaTessere.table.credito')"/></th>
				</tr>
					
				<s:iterator value="listaTessera" >
					<tr>
						<td><s:property value="codice" /></td>
						<td><s:property value="credito" /></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</body>
</html>