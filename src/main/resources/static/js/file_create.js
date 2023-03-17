const fileInput = document.getElementById('img');

fileInput.onchange = function () {
    var fileData = this.files[0];
    const reader = new FileReader();
    reader.readAsDataURL(fileData);
    reader.onload = function (e) {
        const dataURL = this.result;
        localStorage.setItem('imageData', dataURL);
    }
}
