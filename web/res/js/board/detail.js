var btnDelElem = document.querySelector('#btnDel');
var btnModElem = document.querySelector('#btnMod');
if(btnDelElem) {
    btnDelElem.addEventListener('click', function () {
        if (confirm('삭제하시겠습니까?')) {
            location.href = '/board/del?icategory=' + btnDelElem.dataset.icategory + '&iboard=' + btnDelElem.dataset.iboard;
        } else {
            return;
        }
    })
}
if(btnModElem){
    btnModElem.addEventListener('click', function (){
        location.href = '/board/mod?iboard=' + btnModElem.dataset.iboard;
    })
}