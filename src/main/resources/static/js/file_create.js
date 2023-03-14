const avatarInput = document.getElementById('user-file');
const button = document.getElementById('submit-button');

avatarInput.addEventListener('change', () => {
    const file = avatarInput.files[0];
    const reader = new FileReader();
    reader.addEventListener('load', () => {
	const img = new Image();
    img.src = reader.result;
    const canvas = document.createElement('canvas');
    const ctx = canvas.getContext('2d');
    canvas.width = img.width;
    canvas.height = img.height;
	ctx.drawImage(img, 0, 0);
    // const base64 = canvas.toDataURL();
    // localStorage.setItem('avatar', base64);
    // });
	canvas.toBlob((blob) => {
		localStorage.setItem('user-file', URL.createObjectURL(blob));
		// localStorage.setItem('user-file-name', file.name);
        }, 'image/*');
    });
    reader.readAsDataURL(file);
});

button.addEventListener('click', () => {
    location.href = `/create_confirm?name=${encodeURIComponent(nameInput.value)}&email=${encodeURIComponent(emailInput.value)}&file=${encodeURIComponent(localStorage.getItem('user-file-name'))}`;
});
alert("hello word!")
