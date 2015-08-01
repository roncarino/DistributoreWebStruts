<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><s:property value="getText('index.title')"/></title>
	<link type="text/css" rel="stylesheet" href="/DistributoreWebStruts/style/menu_principale.css" />
</head>

<body>
	<h1><s:property value="getText('index.header')"/></h1>
	<div id="menuPrincipale">
		<div class="gestioneTessere">
			<s:a href="gestioneTessere.action"><s:property value="getText('index.menu.gestioneTessere')"/></s:a>
		</div>
		<div class="gestioneDistributore">
			<s:a href="gestioneDistributore.action"><s:property value="getText('index.menu.gestioneDistributore')"/></s:a>
		</div>
		<div class="erogazione">
			<s:a href="erogazione.action"><s:property value="getText('index.menu.erogazione')"/></s:a>
		</div>	
	</div>
	
	<s:url id="urlEN" namespace="/" action="index" >
  			<s:param name="request_locale">en</s:param>
	</s:url>
	<s:url id="urlIT" namespace="/" action="index" >
  			<s:param name="request_locale">it</s:param>
	</s:url>
	
	<div id="language">	
		<div class="eng"><s:a href="%{urlEN}">ENG</s:a></div>
		<div class="ita"><s:a href="%{urlIT}">ITA</s:a></div>
	</div>
</body>
</html>