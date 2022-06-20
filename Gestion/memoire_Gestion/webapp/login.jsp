<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: olive;">
		<main>
		<div align="center" style="margin: 10px 10px">
		<div align="center" style="border: 2px solid;width: 40%;background-color: aqua;" class="container">
		<p style="background-color: red;margin: 5px 5px;color: black; font-weight: bold; font-size: 20px;" >
			 ${erreurs} 
		</p>
			<div>
			<h1>Login</h1>
			<img alt="Inconnu" src="images/inconnu1.jpg" width="150px" height="150px" style="margin: 10px 10px;">
			
		</div>
		
		<div class="connexion" align="center">
			<form method="post" action="connexionServlet" >
				<p>
					<label for="email">Email : </label> <input type="email" name="email" id="email" value="${email}">
				
					<label for="passe">Passe : </label> <input type="password" maxlength="4" name="passe" id="passe" value="${passe}">
				</p>
				<br>
				<p>	
				<table>
					<h4>Type de Compte : </h4>
					<tr>
						<td><input type="radio" name="typeCompte" id="formateurs" value="formateurs"><label for="formateurs">Formateurs</label> </td>
						<td><input type="radio" active name="typeCompte" id="apprenants" value="apprenants"><label for="apprenants">Apprenants</label></td>
						<td><input type="radio" name="typeCompte" id="administrateur" value="administrateur"><label for="administrateur">Administrateur</label></td>
					</tr>
				
				
				
				
				</table>
				</p>
				
				<p>
					<input type="submit" name="Connexion" value="Connexion">
				</p>
			</form>
		</div>
		</div>
		</div>
	</main>

</body>
</html>