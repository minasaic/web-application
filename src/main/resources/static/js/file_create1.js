const fileInput = document.getElementById('userFile');
const sizeLimit = 1024 * 1024 * 1;
const handleFileSelect = () => {
	const files = fileInput.files;
	for (let i = 0; i < files.length; i++){
		if (files[i].size > sizeLimit) {
		  alert('ファイルサイズは1MB以下にしてください'); // エラーメッセージを表示
		  fileInput.value = ''; // inputの中身をリセット
		  return; // 終了する
		}
	}
}
fileInput.addEventListener('change', handleFileSelect);
alert("hello word!")
