// 팝업을 띄울때 공통 코드 처리
function open_win(url, name) {
	window.open(url, name, "width=500, height=310");
}

// 비밀번호만 체크할 경우 자바스크립트를 이용
function passCheck() {
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}