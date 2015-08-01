<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" rel="stylesheet" href="/DistributoreWebStruts/style/style.css" />
	<title><s:property value="getText('aggiungiTessera.title')"/></title>
</head>
<body>
	<h1><s:property value="getText('aggiungiTessera.header')"/></h1>
	<div id="contenitore">
		<div id="menu">
			<menu>
				<li><s:a href="aggiungiTesseraLink.action"><s:property value="getText('menu.aggiungiTessera')"/></s:a></li>
				<li><s:a href="visualizzaTessere.action"><s:property value="getText('menu.visualizzaTessere')"/></s:a></li>
				<li><s:a class="indietro" href="indietro.action"><s:property value="getText('menu.menuPrincipale')"/></s:a></li>
			</menu>
		</div>
		<div id="content">
			<h1><s:property value="getText('aggiungiTessera.h1')"/></h1>
			<s:form action="aggiungiTessera">
				<s:if test="valido == true">
					<s:textfield key="label.codiceTessera" name="codice" value=""></s:textfield>
					<s:textfield key="label.creditoDaInserire" name="credito" value=""></s:textfield>
				</s:if>
				<s:else>
					<s:textfield key="label.codiceTessera" name="codice"></s:textfield>
					<s:textfield key="label.creditoDaInserire" name="credito"></s:textfield>
				</s:else>
				<s:submit key="aggiungiTessera.submit"></s:submit>
			</s:form>
			
			<div id="messaggio">
				<s:if test="valido != null">
					<s:if test="valido == true">
						<p><s:property value="getText('aggiungiTessera.message.true')"/></p>
					</s:if>
					<s:else>
						<p><s:property value="getText('aggiungiTessera.message.false')"/></p>
					</s:else>
				</s:if>
			</div>
		</div>
	</div>
</body>
</html>