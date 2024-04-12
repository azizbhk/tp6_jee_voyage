<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modification voyage</div>
			<div class="card-body">
				<form action="update.do" method="post">
					<div hidden class="form-group">
						<label class="control-label">ID voyage:</label>
						 <input type="text" name="id" class="form-control" value="${voyage.ID_voyage}" />
					</div>
					<div class="form-group">
						<label class="control-label">Nom voyage:</label> 
						<input type="text" name="NOM_departement" class="form-control" value="${voyage.NOM_voyage}" />
					</div>
					<div class="form-group">
						<label class="control-label"></label> <input
							type="text" name="Nb_employee" class="form-control" value="${voyage.nb_voyage}" />
					</div><label class="control-label">Nom de voyage</label>
					
					
					<div class="form-group">
						<select name="college" class="form-control">
							<option value="${voyage.typevoyage.idcol}" selected>${voyage.typevoyage.nomcol}</option>
							<c:forEach items="${colModel.typevoyages}" var="col">
								<c:if test="${col.idcol != voyage.typevoyage.idcol}">
									<option value="${col.idcol}">${col.nomcol}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>