const image = document.querySelector('img');
const dataURL = localStorage.getItem('imageData');
if (dataURL) {
	image.setAttribute('src', dataURL);
}
