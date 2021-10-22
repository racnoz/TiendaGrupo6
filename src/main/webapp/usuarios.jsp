<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	var usuarios = $.ajax({
		type: "GET",
		url: "http://localhost:8080/listarUsuarios",
		success: function(data){
			$.each(data, function(i, item){
				lista = document.getElementById("mytable");
				var tr = document.createElement("tr");
				var columna1 = document.createElement("td");
				columna1.innerHTML = item.cedulaUsuario;
				var columna2 = document.createElement("td");
				columna2.innerHTML = item.emailUsuario;
				var columna3 = document.createElement("td");
				columna3.innerHTML = item.nombreUsuario;
				var columna4 = document.createElement("td");
				columna4.innerHTML = item.password;
				var columna5 = document.createElement("td");
				columna5.innerHTML = item.usuario;
				var columna6 = document.createElement("td");
				columna6.innerHTML = "<a href='eliminarUsuarios?cedula='+item.cedulaUsuario+> Eliminar </a>";
				var columna7 = document.createElement("td");
				columna7.innerHTML = "<a href='editar'> Editar </a>";
				
				lista.appendChild(tr);
				tr.appendChild(columna1);
				tr.appendChild(columna2);
				tr.appendChild(columna3);
				tr.appendChild(columna4);
				tr.appendChild(columna5);
				tr.appendChild(columna6);
				tr.appendChild(columna7);
				
			})
		}
	})
</script>
</head>
<body>
 <h1>Usuarios</h1>
 
 <table>
 	<thead>
 		<tr>Cedula</tr>
 		<tr>Correo</tr>
 		<tr>Nombre</tr>
 		<tr>Contraseña</tr>
 		<tr>Usuario</tr>
 		<tr>Nombre</tr>
 		<tr>Eliminar</tr>
 		<tr>Editar</tr>
 	
 	</thead>
 	<tbody id="mytable">
 	
 	</tbody>
 </table>
</body>
</html>