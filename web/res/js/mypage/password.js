var changeElem = document.querySelector('#change');
if(changeElem) {
    changeElem.addEventListener('submit', function (e) {
        const currentupwVal = changeElem.currentupw.value;
        const upwVal = changeElem.upw.value;
        const chkupwVal = changeElem.chkupw.value;
        if (currentupwVal.length === 0){
            alert('현재 비밀번호를 작성해 주세요.');
            e.preventDefault();
        }else if(upwVal.length === 0){
            alert('변경 비밀번호를 작성해 주세요.');
            e.preventDefault();
        }else if(upwVal !== chkupwVal){
            alert('변경 비밀번호를 확인해 주세요.');
            e.preventDefault();
        }else if(regex.isWrongPw(currentupwVal)){
            alert('현재 비밀번호를 확인하여 주세요.');
            e.preventDefault()
        }else if(regex.isWrongPw(upwVal)){
            alert('변경 비밀번호는 대소문자+숫자 조합으로 작성해 주세요.');
            e.preventDefault()
        }

    })
}

