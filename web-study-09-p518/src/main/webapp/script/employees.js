function loginCheck(){
	if(document.frm.userid.value.length==0) {
		alert("아이디를 입력해주세요.");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pass.value=="") {
			alert("암호를 입력해주세요.");
			frm.pass.focus();
			return false;
		}
	return ture;
}

function myPageCheck(){
	if(document.frm.pass.value.length==0) {
			alert("비밀번호를 입력해주세요.");
			frm.pass.focus();
			return false;
		}
	if(document.frm.name.value.length==0) {
		alert("이름을 입력해주세요.");
		frm.name.focus();
		return false;
	}	
	return true;
}
/*function formChange() {
  const inputs = document.querySelectorAll('input');

  inputs.forEach(input => {
    const value = input.value;
    const parent = input.parentElement;

    // 부모 요소 안에 input만 있으면, 그걸 텍스트로 대체
    parent.innerText = value;
  });
}*/