<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
    <div class="card"> 
        <div class="card-header">
            Confirmation Ajout Voyage
        </div>
        <div class="card-body">
            <form action="save.do" method="post"> <!-- Ajout de la balise <form> -->
                <div class="form-group">
                    <label class="control-label">ID :</label>
                    <input type="text" name="ID_departement" class="form-control" value="${departement.ID_voyage}"/>

                    <label class="control-label">Nom voyage:</label>
                    <input type="text" name="NOM_departement" class="form-control" value="${departement.NOM_voyage}"/>
                </div>

                <div class="control-label">
                    <label class="control-label"></label>
                    <input type="text" name="Nb_employee" class="form-control" value="${departement.Nb_employee}"/>
                </div>
					<div class="form-group">
					  <label class="control-label">Nom TypeVoyage </label>
						<select name="voyage" class="form-control">
							<c:forEach items="${colModel.voyages}" var="col">
								<option value="${col.idcol}">${col.nomcol}</option>
							</c:forEach>
						</select>
					</div>

					<button type="submit" class="btn btn-primary">Ajouter</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
