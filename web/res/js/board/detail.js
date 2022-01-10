var btnDelElem = document.querySelector('#btnDel');
if(btnDelElem) {
    btnDelElem.addEventListener('click', function () {
        if (confirm('삭제하시겠습니까?')) {
            location.href = '/board/del?icategory=' + btnDelElem.dataset.icategory + '&iboard=' + btnDelElem.dataset.iboard;
        } else {
            return;
        }
    })
}