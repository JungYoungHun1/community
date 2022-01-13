const msg = {
    isDel: '삭제하시겠습니까?',
    fnIsDel : function(target) {
        return `${target}을(를) ` + this.isDel;
    }
}

const regex = {
    id: /^([a-zA-Z0-9]{4,15})$/,
    pw: /^([a-zA-Z0-9!@_]{4,20})$/,
    nm: /^([가-힣]{2,5})$/,
    isWrongId : function (val){
        return !this.id.test(val);
    },
    isWrongPw : function (val){
        return !this.pw.test(val);
    },
    isWrongNm : function (val){
        return !this.nm.test(val);
    },
}