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
	<title><s:property value="getText('eroga.title')"/></title>
</head>
<body>
	<h1><s:property value="getText('eroga.header')"/></h1>
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
			<h1><s:property value="getText('eroga.h1')"/></h1>
			<s:form action="eroga">
				<s:if test="valido == true">
					<s:textfield key="label.codiceTessera" name="codiceTessera" value=""></s:textfield>
					<s:textfield key="label.codiceBevanda" name="codiceBevanda" value=""></s:textfield>
				</s:if>
				<s:else>
					<s:textfield key="label.codiceTessera" name="codiceTessera"></s:textfield>
					<s:textfield key="label.codiceBevanda" name="codiceBevanda"></s:textfield>
				</s:else>
				<s:submit key="eroga.submit"></s:submit>
			</s:form>
			
			<div id="messaggio">
				<s:if test="valido != null">
					<s:if test="valido == true">
						<p><s:property value="getText('eroga.message.true')"/></p>
					</s:if>
					<s:else>
						<p><s:property value="getText('eroga.message.false')"/></p>
					</s:else>
				</s:if>
			</div>
		</div>
	</div>
</body>
</html>