<%@include file="entete.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
		<div align="center"><h1>Les Formateurs</h1></div>
		
		<div class="container-fluide">
			<div class="row">
				<div class="col-lg-4">
					<form action="" method="post">
					
					<table>
						
						<tr>
							<td><label for="nom_m"> Nom : </label> <input type="text" name="nom_m" id="name_m"></td>
							<td><label for="prenom_m">Prenom : </label> <input type="text" name="prenom_m" id="prenom_m"></td>
						</tr>
						
						<tr>
							<td><label for="email_m">Email : </label> <input type="email" name="email_m" id="email_m"></td>
							<td><label for="matiere">Matieres : </label> <input type="text" name="matiere" id="matiere"></td>
						</tr>
					
						<tr>
							<td><label for="passe">Passe : </label> <input type="text" name="passe" id="passe"></td>
							<td> <label>Ajouter</label> <input type="submit" name="envoi" id="envoi" value="Ajouter"></td>
						</tr>
						<tr>
							<h5 style="color: red;">${erreur}</h5> 
							<h5 style="color: greenn;">${succes}</h5> 
						</tr>
					</table>
						
					</form>
				</div>
				
			<div class="col-lg-8">
				<table class="table">
				<thead class="color-blue">
				<th>N°</th>	<th> Prenom </th> <th> Nom </th> <th> Email </th> <th> Actions </th>
				</thead>
				<tbody>
				<c:forEach var="formateur" items="${formateurs}">
					<tr>
							<td><c:out value="${formateur.id}"></c:out></td>
							<td><c:out value="${formateur.prenom}"></c:out></td>
							<td><c:out value="${formateur.nom}"></c:out></td>
							<td> <a href="mailto:${formateur.email}"> <c:out value="${formateur.email}"></c:out> </a></td>
							<td> 
								<a href="#"> <button class="btn btn-primary">Modifier</button> </a>
								<a href="servlet_formateur" name="supp"> <button class="btn btn-danger" name="delete" value="${formateur.id}">Supprimer</button> </a>	
							</td>
					</tr>
				</c:forEach>
			
			</tbody>
			
			<tfoot>
			
			</tfoot>
		
		</table>
				</div>
			</div>
			
		
		</div>
		
		
</body>
</html>