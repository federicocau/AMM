<%-- 
    Document   : listaAlunniJson
    Created on : 1-giu-2016, 11.45.48
    Author     : Alessandro
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="oggetto" items="${listaOggetti}">
        <json:object>
            <json:property name="nome" value="${oggetto.nome}"/>
            <json:property name="url" value="${oggetto.url}"/>
            <json:property name="quantita" value="${oggetto.quantita}"/>
            <json:property name="prezzo" value="${oggetto.prezzo}"/>
            <json:property name="id" value="${oggetto.id}"/>
            <json:property name="categoria" value="${oggetto.categoria}"/>
        </json:object>
    </c:forEach>
</json:array>