
$(document).ready(function() {
	listarOrdenUsuarios()
});

function listarOrdenUsuarios() {
	$.ajax({
		type: "GET",
		url: "/auth/listar",
		dataType: "json",
		success: function(resultado) {
			$("#tablaUsuarios > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tablaUsuarios > tbody").append("<tr>" +
					"<td>" + value?.idusuario + "</td>" +
					"<td>" + value?.nombres + "</td>" +
					"<td>" + value?.apellidos + "</td>" +
					"<td>" + value?.email + "</td>" +
					"<td>" + value?.nomusuario + "</td>" +
					"<td>" + `·${value.activo === true ? 'Activo' : 'Desactivo'}` + "</td>" +
					"</tr>");
			});
		}
	});
}


