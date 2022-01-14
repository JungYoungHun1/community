{
    const dataElem = document.querySelector('#data');

    var btnDelElem = document.querySelector('#btnDel');
    var btnModElem = document.querySelector('#btnMod');
    if (btnDelElem) {
        btnDelElem.addEventListener('click', function () {
            if (confirm('삭제하시겠습니까?')) {
                location.href = '/board/del?icategory=' + btnDelElem.dataset.icategory + '&iboard=' + btnDelElem.dataset.iboard;
            } else {
                return;
            }
        })
    }
    if (btnModElem) {
        btnModElem.addEventListener('click', function () {
            location.href = '/board/mod?iboard=' + btnModElem.dataset.iboard;
        })


    }
    const cmtFrmElem = document.querySelector('#cmtFrm');
    if(cmtFrmElem){
        //input text ctnt에서 엔터치면 날아가서 방지해줌
        cmtFrmElem.addEventListener('submit', function (e){
            e.preventDefault();
        });
        cmtFrmElem.btn_submit.addEventListener('click', function (){
            const cmtVal = cmtFrmElem.ctnt.value;
            if(cmtVal.length === 0){
                alert('댓글 내용을 작성해 주세요.');
            }else if(regex.isWrongWith('ctnt', cmtVal)){
                alert(regex.msg.ctnt);
            }else {
                insBoardCmtAjax(cmtVal);
            }
        })
        const insBoardCmtAjax = (val) => {
            fetch('/board/cmt', {
                'method' : 'post',
                'headers' : {
                    'Content-Type' : 'application/json'
                },
                'body': JSON.stringify({
                    'iboard': dataElem.dataset.iboard,
                    'ctnt': val
                })
            })
                .then(res => res.json())
                .then(data => {
                    console.log(data);
                }).catch(err => {
                console.log(err);
            });
        }
    }
}