// const punycode = require("punycode");

function checkEmail() {
	var emailInput = document.getElementById("email").value;
	var regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	// emailInput=punycode.toASCII(emailInput);
	if (emailInput === "") {
		document.getElementById("error").innerHTML = "※メールアドレスを入力してください。";
		document.getElementById("submit-button").disabled = true;
	} else if (!regex.test(emailInput)) {
		document.getElementById("error").innerHTML = "※メールアドレスに使用不可な文字が含まれています。";
		document.getElementById("submit-button").disabled = true;
	} else {
		document.getElementById("error").innerHTML = "";
		document.getElementById("submit-button").disabled = false;
	}
}
