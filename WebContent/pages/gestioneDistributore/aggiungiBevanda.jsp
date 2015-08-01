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
	<title><s:property value="getText('aggiornaBevanda.title')"/></title>
</head>
<body>
	<h1><s:property value="getText('aggiornaBevanda.header')"/></h1>
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
			<h1><s:property value="getText('aggiornaBevanda.h1')"/></h1>
			
			<s:form action="aggiungiBevanda">
				<s:if test="valido == true">
					<s:textfield key="label.nomeBevanda" name="nome" value=""></s:textfield>
					<s:textfield key="label.codiceBevanda" name="codice" value=""></s:textfield>
					<s:textfield key="label.prezzo" name="prezzo" value=""></s:textfield>
				</s:if>
				<s:else>
					<s:textfield key="label.nomeBevanda" name="nome"></s:textfield>
					<s:textfield key="label.codiceBevanda" name="codice"></s:textfield>
					<s:textfield key="label.prezzo" name="prezzo"></s:textfield>
				</s:else>
				<s:submit key="aggiornaBevanda.submit"></s:submit>
			</s:form>
			
			<div id="messaggio">
				<s:if test="valido != null">
					<s:if test="valido == true">
						<p><s:property value="getText('aggiungiBevanda.message.true')"/></p>
					</s:if>
					<s:else>
						<p><s:property value="getText('aggiungiBevanda.message.false')"/></p>
					</s:else>
				</s:if>
			</div>	
		</div>
	</div>
</body>
</html>