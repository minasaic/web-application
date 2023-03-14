function invalidEmail() {
	var emailInput = document.getElementById("email");
	emailInput.setCustomValidity("※メールアドレスに使用不可な文字が含まれています。");
}
function validEmail() {
	var emailInput = document.getElementById("email");
	emailInput.setCustomValidity("");
}
var emailInput = document.getElementById("email");
emailInput.oninput = validEmail;
emailInput.onblur = invalidEmail;
