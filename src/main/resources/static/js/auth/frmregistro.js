function validarFormulario() {
  const nombres = document.getElementById("nombres").value;
  const apellidos = document.getElementById("apellidos").value;
  const email = document.getElementById("email").value;
  const usuario = document.getElementById("nomusuario").value;
  const password = document.getElementById("password").value;

  const errores = {
    nombres: document.getElementById("nombresError"),
    apellidos: document.getElementById("apellidosError"),
    email: document.getElementById("emailError"),
    usuario: document.getElementById("usuarioError"),
    password: document.getElementById("passwordError")
  };

  const letrasRegex = /^[A-Za-z\s]+$/;
  const emailRegex = /^\S+@\S+\.\S+$/;
  const passwordRegex = /^(?=.*[A-Z])(?=.*\d).{5,}$/;

  if (nombres.trim() === "") {
    errores.nombres.textContent = "El campo no puede estar vacío";
    document.getElementById("nombres").style.borderColor = "red";
    return false;
  }
  if (!letrasRegex.test(nombres)) {
    errores.nombres.textContent = "El campo solo puede contener letras";
    document.getElementById("nombres").style.borderColor = "red";
    return false;
  }
  errores.nombres.textContent = "";
  document.getElementById("nombres").style.borderColor = "";

  if (apellidos.trim() === "") {
    errores.apellidos.textContent = "El campo no puede estar vacío";
    document.getElementById("apellidos").style.borderColor = "red";
    return false;
  }
  if (!letrasRegex.test(apellidos)) {
    errores.apellidos.textContent = "El campo solo puede contener letras";
    document.getElementById("apellidos").style.borderColor = "red";
    return false;
  }
  errores.apellidos.textContent = "";
  document.getElementById("apellidos").style.borderColor = "";

  if (email.trim() === "") {
    errores.email.textContent = "El campo no puede estar vacío";
    document.getElementById("email").style.borderColor = "red";
    return false;
  }
  if (!emailRegex.test(email)) {
    errores.email.textContent = "El campo no tiene un formato válido";
    document.getElementById("email").style.borderColor = "red";
    return false;
  }
  errores.email.textContent = "";
  document.getElementById("email").style.borderColor = "";

	if (usuario.trim() === "") {
	  errores.usuario.textContent = "El campo no puede estar vacío";
	  document.getElementById("nomusuario").style.borderColor = "red";
	  return false;
	}
	if (usuario.length < 4 || usuario.length > 15) {
	  errores.usuario.textContent = "El campo debe tener entre 5 y 15 caracteres";
	  document.getElementById("nomusuario").style.borderColor = "red";
	  return false;
	}
	errores.usuario.textContent = "";
	document.getElementById("nomusuario").style.borderColor = "";

	if (password.trim() === "") {
	  errores.password.textContent = "El campo no puede estar vacío";
	  document.getElementById("password").style.borderColor = "red";
	  return false;
	}
	if (!passwordRegex.test(password)) {
	  errores.password.textContent =
	    "La contraseña debe tener al menos 5 caracteres, una mayúscula y un número";
	  document.getElementById("password").style.borderColor = "red";
	  return false;
	}
	errores.password.textContent = "";
	document.getElementById("password").style.borderColor = "";

	return true;
}

function resetearMensajesError() {
	const errores = {
		nombres: document.getElementById("nombresError"),
		apellidos: document.getElementById("apellidosError"),
		email: document.getElementById("emailError"),
		usuario: document.getElementById("usuarioError"),
		password: document.getElementById("passwordError")
	};

	Object.values(errores).forEach((error) => (error.textContent = ""));
}

document.addEventListener("DOMContentLoaded", function () {
	resetearMensajesError();

	const btnGuardar = document.getElementById("btnGuardar");
	btnGuardar.addEventListener("click", function (event) {
		event.preventDefault();

		if (validarFormulario()) {
			document.querySelector("form").submit();
		}
	});
});
