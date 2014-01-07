/**
 * Copyright (c) 2012 Yhlee
 *
 * Javascript Framework
 *
 * @developer 이용희
 * @version 1.0.0
 * 
 */


if (!window.hanrwjs) {
    window.hanrwjs = {};
}


// 페이지 로드시 처리
$(document).ready(function() {
	// 모든 페이지에서 공통된 초기화 작업이 필요한 경우 여기에 구
    jQuery.ajaxSetup({cache:false});  // 13-09-27 : IE 캐쉬버그 수정용.
});

hanrwjs.log = function(msg, isDevMsg) {
	
	var caller = arguments.callee.caller.name;
	console.log("[" + caller + "] " + msg);
};



/*
 * Form Validator
 */
(function() {
	function validator(){
		// empty constructor
	}
	
	validator.prototype.formats = {
		email: new RegExp('^[a-z0-9!#$%&\'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&\'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$', 'i'),
		ip: /^(\d{1,3}\.){3}\d{1,3}$/,
		date: /^\d{2}[- \/.]?\d{2}[- \/.]?\d{4}$/,
		datetime: /^\d{4}[- \/.]\d{2}[- \/.]\d{4}\s*?\d{2}[- :.]\d{2}[- :.]\d{2}$/,
		juminno: /^\d{6}[- \/.]?\d{7}$/,
		bizno: /^\d{3}[- \/.]?\d{2}[- \/.]?\d{5}$/,
		driverno: /^\d{2}[- \/.]?\d{6}[- \/.]?\d{2}$/,
		phone: /^\d{10,15}$/,
		zip: /^(\d{3})[- \/.]?(\d{3})$/,
		time: /^(\d{2})[: \/.]?(\d{2})$/,
		number: /^\d+$/,
		decimal: /[0-9]+(.[0-9]+)?$/,
		alphanumeric: /^([a-z]|\d|\s|-|\.|_|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+$/i
	};
	
	validator.prototype.errors = {
		empty: '필수입력 값 입니다.',
		checked: '필수 체크 항목입니다.',
		email: '잘못된 Email 형식 입니다.',
		ip: '잘못된 IP 형식 입니다. Example: 111.111.111.111',
		date: '잘못된 DATE 형식 입니다. Example: yyyy-mm-dd',
		datetime: '잘못된 datetime 형식 입니다. Example: yyyy-mm-dd hh:mm:ss',
		juminno: '잘못된 주민번호 형식 입니다.',
		bizno: '잘못된 사업자번호 형식 입니다.',
		driverno: '잘못된 운전면허번호 형식 입니다.',
		phone: '잘못된 전화번호 형식 입니다.',
		zip: '잘못된 우편번호 형식 입니다. Example: 100-001',
		number: '숫자만 입력할 수 있습니다.',
		decimal: '잘못된 숫자 형식입니다.',
		alphanumeric: '한글 및 특수기호를 사용할 수 없습니다.'
	};
	
	/**
	 * 문자열과 format에 맞는 Validate 수행하여 통과여부를 반환 
	 * 
	 * @param type
	 * @param value
	 * @returns {Boolean}
	 */
	validator.prototype.validate = function(type, value) {
		if($.trim(value).search(this.formats[type]) == -1) {
			return false;
		} 
		return true;
	};

	/**
	 * 화면에 Validate 에러를 보여줍니다.
	 * 
	 *  @param DOM Element 에러를 보여줄 대상 DOM 객체
	 *  @param string 출력할 에러 메시지
	 */
	validator.prototype.showError = function(element,errMsg) {
		var eleId = $(element).attr("id");
		$(element).focus();
		if ( $("label[for='" + eleId + "'][generated='true']").length > 0 ) return;
		
		if ($(element).is("div")){
			$(element).addClass('validator_error');
		}else {
			$(element).addClass('validator_error');
		}
		
		var label = $("<label>").html(errMsg).attr({"for":eleId, generated: true});
		label.insertAfter(element);
		label.addClass('error');
	};
	
	/**
	 * Input Element들의 입력값에 대한 Validation을 수행하고 결과를 리턴합니다.
	 * 필수입력 항목은 input tag안에 required="true" 라고 지정합니다.
	 * validtion을 수행할 항목은 input tag안에 data-type="numeric"과 같이 지정합니다.
	 * 사용할 수 있는 validation type은 email,ip,date,datetime,phone,zip,number,decimal,alphanumeric 이 있습니다.
	 * 
	 * @return boolen 
	 */
	window.hanrwjs.validate = function(){
		var validator = new window.hanrwjs.validator();
		var result = true;
		
		$("input[data-type], input[required]").each(function(){
			var type = $(this).attr("data-type");
			var required = $(this).attr("required");
			var inputVal = $.trim($(this).val());
			var eleId = $(this).attr('id');
			
			if ( !(required || inputVal)) {/*do nothing*/}
			else if ( required && !inputVal) {
				validator.showError(this,validator.errors['empty']);
				result = false;
			}else if (type && inputVal.search(validator.formats[type]) == -1) {
				validator.showError(this,validator.errors[type]);
				result = false;
			}else {
				$(this).removeClass('validator_error');
				$("label[for='" + eleId + "'][generated='true']").remove();
			}
		});
		
		$("div[required]").each(function(){
			var eleId = $(this).attr('id');
			if ($(":radio:checked,:checkbox:checked", $(this)).length < 1) {
				validator.showError(this,validator.errors['checked']);
				result = false;
			}else{
				$(this).removeClass('validator_error');
				$("label[for='" + eleId + "'][generated='true']").remove();
			}
		});
		
		return result;
	};
	window.hanrwjs.validator = validator;
	
}());
	
/**
 * 실제로 ajax 통신을 수행하는 API
 * 
 * @param {Object} requestUrl _getServerInfo()의해 만들어진 Convergence Message Framework의 주소
 * @param {Object} message 전달된 전문
 * @param {Object} handle Ajax통신 전, 후, 에러가 발생할 경우 실행할 콜백 함수들 <br> 지정하지 않으면 default 함수들이 실행됩니다.
 * 
 * handle parameter sample
 * {"preHandle":MyPreHandle,"postHandle":MyPostHandle,"errorHandle":MyErrorHandle,"message":ProgessMessage}
 *     
 */
window.hanrwjs.sendRequest = function(requestUrl,message,handle,method,headers)
{
	var sendData = "";
	var resultMsg = "";
	
	if ( !requestUrl || !message ) 
	{
		throw new Error("Invalid Argument!! check parameters");
	}
	
	// sid 옵션과 handel 옵션은 둘 다 생략가능하기 때문에 3번째 옵션값이string 로 넘어오면 sid 라고 판단한다.
	if(typeof handle == "string") {
		method = handle;
	}
	
	if(typeof message =="object"){
		sendData = JSON.stringify(message);
	}else{
		sendData = message;
	}
	
	handle = $.extend({  
        preHandle : defaultPreHandle,  
        postHandle : defaultPostHandle,  
        errorHandle : defaultErrorHandle,
        message : {"title":"서버와 통신중입니다.","content":"","useProgress":true}
    }, handle || {});

	$.ajax({
		type: method || "POST", //"POST",
		url: requestUrl,
		data: sendData,
		dataType: "text",
        headers : headers || {},
		contentType: "application/json; charset=UTF-8",
		timeout: 180000,
		beforeSend: function(req) {
			handle.preHandle();
		},
		error: function (req, status) {
			var rtnMsg = {};
			rtnMsg.HttpStatusCode = req.status;
			rtnMsg.HttpStatusText = req.statusText;
			
			if(status == "error" && req.responseText == "") {
				req.responseText = "네트워크 연결 상태가 원활하지 않습니다. 네트워크 상태를 확인 후 재시도 하여주시기 바랍니다.";
			}
			
			rtnMsg.result = '[' + req.statusText + ']' + req.responseText;
			try {
				handle.errorHandle(rtnMsg);
			}catch(e) {
				hanrwjs.log("에러 핸들러 수행중 오류 발생:" + e.message, true);
			}
		},
		success: function (msg, status, res) {
			try {
				handle.postHandle(msg);
			}catch(e) {
				alert("에러 핸들러 수행 중 오류 발생:" + e.message);
				return;
			}
		}
	});
};

/**
 * hanrwjs.sendRequest 호출시에 preHandle을 지정하지 않았다면 실행된 기본 preHandle.
 * Ajax 요청 전에 실행됩니다. (빈 펑션으로만 존재함.)
 */
function defaultPreHandle() {}

/**
 * hanrwjs.sendRequest 호출시에 preHandle을 지정하지 않았다면 실행된 기본 postHandle.
 * Ajax 요청이 성공하면 실행됩니다.
 * 
 * @param {object} msg  CMF로 부터 받은 결과들을 담아서 호출합니다.
 * 
 */
function defaultPostHandle(msg){
	
}

/**
 * 기본 오류처리 핸들러
 * @param {Object} msg
 */
function defaultErrorHandle(msg)
{
	
}

	

/**
 * select box의 옵션추가
 * @param st_obj	셀렉트박스 엘리먼트 아이디
 * @param arr_txt	텍스트
 * @param arr_val	값
 */
function addSelectItem(st_obj, arr_txt, arr_val) {
	$("#"+st_obj).addOption(arr_val, arr_txt);
}
window.hanrwjs.addSelectItem = addSelectItem;

/**
 * select box의 option 제거 
 * @param st_obj	셀렉트박스 엘리먼트 아이디
 */
function removeSelectItem(st_obj) {
	$("#"+st_obj).removeOptions();
}
window.hanrwjs.removeSelectItem = removeSelectItem;

/**
 * 해당 select 에 val 을 갖는 option을 선택함
 * @since 2013.09
 * @author ndevelop
 * @param obj_id
 * @param val
 */
window.hanrwjs.selectOption = function(obj_id, val) {
    $("#"+ obj_id + " > option[value='"+val+"']").attr("selected", "true");
};

/**
 * select box 제어 API
 *  - addOption(val, txt) : option 을 추가한다.
 *  - removeOption(idx) : 선택되어져 있는 option 을 제거한다. 
 *  			idx가 없을경우 선택되어져 있는 option을 제거.
 *  - removeOptions : 전체 Option을 제거한다. 
 */  
;(function($){
	$.fn.addOption = function(val, txt, idx) {
		if(arguments.length < 2) {
			return this;
		} else if(arguments.length == 2 ) {
			// 문자열로 넘어왔을경우
			if(typeof txt == "string" && typeof val == "string") {
				$("<option/>").attr('value',val).text(txt).appendTo($(this));
			}
			// 배열로 넘어왓을 경우
			else if(typeof txt == "object" && typeof val == "object") {
				if( txt.length != val.length) {
					throw new Error("text 와 value의 element 갯수가 일치하지 않습니다.");
				}
				
				for(var i=0; i < txt.length; i++) {
					$("<option/>").attr('value',val[i]).text(txt[i]).appendTo($(this));
				}
			} else {
				throw new Error("파라메터 타입이 올바르지 않습니다.");
			}
		} else if(arguments.length == 3 ) {
			$("option:eq("+idx+")", $(this)).after("<option value='"+val+"'>"+txt+"</option>"); 
		}
	};

	$.fn.removeOption = function(idx) {
		if(arguments.length == 0) {
			$("option:selected", $(this)).remove();
		} else if(arguments.length == 1) {
			$("option:eq("+idx+")", $(this)).remove(); 
		}
	};
	
	$.fn.removeOptions = function() {
		$("option", $(this)).remove();
	};
})(jQuery);

/*jslint browser: true */ /*global jQuery: true */

/**
 * jQuery Cookie plugin
 *
 * Copyright (c) 2010 Klaus Hartl (stilbuero.de)
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 *
 */

/**
 * Create a cookie with the given key and value and other optional parameters.
 *
 * @example $.cookie('the_cookie', 'the_value');
 * @desc Set the value of a cookie.
 * @example $.cookie('the_cookie', 'the_value', { expires: 7, path: '/', domain: 'jquery.com', secure: true });
 * @desc Create a cookie with all available options.
 * @example $.cookie('the_cookie', 'the_value');
 * @desc Create a session cookie.
 * @example $.cookie('the_cookie', null);
 * @desc Delete a cookie by passing null as value. Keep in mind that you have to use the same path and domain
 *       used when the cookie was set.
 *
 * @param String key The key of the cookie.
 * @param String value The value of the cookie.
 * @param Object options An object literal containing key/value pairs to provide optional cookie attributes.
 * @option Number|Date expires Either an integer specifying the expiration date from now on in days or a Date object.
 *                             If a negative value is specified (e.g. a date in the past), the cookie will be deleted.
 *                             If set to null or omitted, the cookie will be a session cookie and will not be retained
 *                             when the the browser exits.
 * @option String path The value of the path atribute of the cookie (default: path of page that created the cookie).
 * @option String domain The value of the domain attribute of the cookie (default: domain of page that created the cookie).
 * @option Boolean secure If true, the secure attribute of the cookie will be set and the cookie transmission will
 *                        require a secure protocol (like HTTPS).
 * @type undefined
 *
 * @name $.cookie
 * @cat Plugins/Cookie
 * @author Klaus Hartl/klaus.hartl@stilbuero.de
 */

/**
 * Get the value of a cookie with the given key.
 *
 * @example $.cookie('the_cookie');
 * @desc Get the value of a cookie.
 *
 * @param String key The key of the cookie.
 * @return The value of the cookie.
 * @type String
 *
 * @name $.cookie
 * @cat Plugins/Cookie
 * @author Klaus Hartl/klaus.hartl@stilbuero.de
 */
jQuery.cookie = function (key, value, options) {

    // key and value given, set cookie...
    if (arguments.length > 1 && (value === null || typeof value !== "object")) {
        options = jQuery.extend({}, options);

        if (value === null) {
            options.expires = -1;
        }

        if (typeof options.expires === 'number') {
            var days = options.expires, t = options.expires = new Date();
            t.setDate(t.getDate() + days);
        }

        return (document.cookie = [
            encodeURIComponent(key), '=',
            options.raw ? String(value) : encodeURIComponent(String(value)),
            options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
            options.path ? '; path=' + options.path : '',
            options.domain ? '; domain=' + options.domain : '',
            options.secure ? '; secure' : ''
        ].join(''));
    }

    // key and possibly options given, get cookie...
    options = value || {};
    var result, decode = options.raw ? function (s) { return s; } : decodeURIComponent;
    return (result = new RegExp('(?:^|; )' + encodeURIComponent(key) + '=([^;]*)').exec(document.cookie)) ? decode(result[1]) : null;
};


/**
 * Static StringUtils Functions
 */
window.hanrwjs.StringUtils = {
	isEmpty : function(str) {
		if ( str == undefined || str == null ) {
			return true;
		}
		str += "";
		if(str.replace(/^\s+|\s+$/g,'').length == 0) {
			return true;
		}else {
			return false;
		}
	},
	hasText : function(str) {
		
		if ( str == undefined || str == null ) {
			return false;
		} 
		
		if ( String(typeof(str)).toLowerCase() != "string" ) {
			return false;
		}
		
		if ( this.isEmpty(str) ) {
			return false;
		}else{
			return true;
		}
	},
	isNull : function(str) {
		if ( str == undefined || str == null ) {
			return true;
		}else {
			return false;
		}
	}
};



/**
 * JavaScript 기본 유형(String, Number 등)의 기능을 확장하기 위한 함수
 * 
 * @param {Object} name 확장할 메소드 이름
 * @param {Object} func 함수 구현체
 */
Function.prototype.extend = function(name,func) {
	if ( !this.prototype[name] ) {
		this.prototype[name] = func;
	}
	return this;
};

$(function(){
	// 공백제거
	String.extend('trim',function(){
		return this.replace(/^\s+|\s+$/g,'');
	});
	
	// 빈값 여부를 반환
	String.extend('isEmpty',function(){
		return ( this.trim().length == 0);
	});
	
	// 모든 문자열 변환
	String.extend('replaceAll',function(search,replace){
		return this.trim().split(search).join(replace);
	});
	
	String.extend('leftPad',function(size, padChar){
		var tempValue = this.split(""); 
		for (var i = 0; i < size - this.length; i++) {
			tempValue.unshift(padChar);
		} 
		return tempValue.join("");
	});
	
	String.extend('rightPad',function(size, padChar){
		var tempValue = this.split(""); 
		for (var i = 0; i < size - this.length; i++) {
			tempValue.push(padChar);
		} 
		return tempValue.join("");
	});
	
	String.extend('parseInt',function(){
		var result = 0;
		
		try{
			result = parseInt(this, 10);	
		}catch(e) {
			// do nothing
		}
		
		if (isNaN(result)) return 0;
		else return result;
	});
	
	String.extend('isNumber',function(){
		if (this.indexOf(".") > -1)
			return false;
		var tempValue = this.replaceAll(",", "");
		return isFinite(tempValue);
	});
	
	String.extend('isFloat',function(fixedLength){
		var tempValue = this.replaceAll(",", "");
		
		if (isFinite(tempValue)) {
			var prefix = tempValue.indexOf(".");
			if (prefix > -1) {
				if (tempValue.substring(prefix + 1, tempValue.length).length > fixedLength) 
				return false;
			}
			return true;
		} else {
			return false;
		}
	});
	
	//////////////////////////////////////////////////////
	// 문자형숫자로 변환하여 반환
	String.extend('toCharNum', function(){
		return this.replace(/[^0-9]/g, "");
	});
	
	// 숫자형문자로 변환하여 반환
	String.extend('toNumber', function(){
		var val = this.replace(/[^-0-9]/g, "");
		return val.replace(/^(-?)(\d*)([^0-9]*)/, "$1$2");
	});
	
	// 실수형문자로 변환하여 반환
	String.extend('toFloat',function(){
		var val = this.replace(/[^0-9-\.]/g, "");
		return val.replace(/^(-?)(\d*)(\.?)([^0-9]*)([0-9]*)([^0-9]*)/, "$1$2$3$5");
	});
	
	// 숫자 또는 숫자형문자에 천단위 콤마를 추가하여 반환.
	String.extend('toComma',function(){
		var val = this.replaceAll(",", "");
		if (isFinite(val)) {
			var reg = /(^[+-]?\d+)(\d{3})/;
			while (reg.test(val)) {
				val = val.replace(reg, "$1" + "," + "$2");
			}
			return val;
		} else {
			return this;
		}
	});
	
	// 주민번호 형식으로 변환
	String.extend('toJuminNo',function(){
		var val = this.replaceAll("-", "");
		if(this.isNumber()) {
			return val.replace(/(\d{6})(\d{7})/, "$1" + "-" + "$2");
		} else {
			return val.replace(/(\d{6})(\d{1})/, "$1" + "-" + "$2");
		}
	});
	
	// 주민번호 뒷자리를 *형식으로 변환
	String.extend('toSecureJuminNo',function(){
		var val = this.replaceAll("-", "");
		return val.substring(0, 7).replace(/([0-9]{6})([0-9]{1})/,"$1-$2") + "******";	
	});
	
	// 사업자번호 형식으로 변환
	String.extend('toBizNo',function(){
		var val = this.replaceAll("-", "");
		return val.replace(/([0-9]{3})([0-9]{2})([0-9]+)/,"$1-$2-$3");
	});
	
	// 전화번호 형식으로 변환
	String.extend('toPhoneNo',function(){
		var val = this.replaceAll("-", "");
		var str = "";
		if (val.length == 8) {
			//지역번호가 없는 1577
			str = val.replace(/(\d{3,4})(\d{4})/, "$1" + "-" + "$2");
		} else {
			str = val.replace(/(\d{2,3})(\d{3,4})(\d{4})/, "$1" + "-" + "$2" + "-" + "$3");
		}
		return str;
	});
	
	// 날짜 형식인지 체크
	String.extend('isDate',function(){
		var tempValue = this.toCharNum();
	
		var reg = null;
		var matches = null;
		
		if (tempValue.length == 6) {
			reg = /^(\d{4})(\d{2})$/;
			matches = reg.exec(tempValue);
		} else if (tempValue.length == 8) {
			reg = /^(\d{4})(\d{2})(\d{2})$/;
			matches = reg.exec(tempValue);
		} else if (tempValue.length == 12) {
			reg = /^(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})$/;
			matches = reg.exec(tempValue);
		} else if (tempValue.length == 14) {
			reg = /^(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})(\d{2})$/;
			matches = reg.exec(tempValue);
		} else {
			return false;
		}
		
		if (matches == null)
			return false;
		
		if (matches[2] < 1 || matches[2] > 12) { //월
			return false;
		}
		if (matches.length > 3 && (matches[3] < 1 || matches[3] > 31)) { //일
			return false;
		}
		if (matches.length > 3 && (matches[2]==4 || matches[2]==6 || matches[2]==9 || matches[2]==11) && matches[3]==31) { //일
			return false;
		}
		if (matches.length > 3 && matches[2]== 2) {
			var isleap = (matches[1] % 4 == 0 && (matches[1] % 100 != 0 || matches[1] % 400 == 0));
			if (matches[3]>29 || (matches[3]==29 && !isleap)) {       
				return false;
			}
		}
		if (matches.length > 4 && matches[4] > 23) { //시
			return false;
		}
		if (matches.length > 5 && matches[5] > 59) { //분
			return false;
		}
		if (matches.length > 6 && matches[6] > 59) { //초
			return false;
		}
		return true;
	});
	
	String.extend('toDate', function(){
		if (this.isDate() == false)
			throw new Error("잘못된 날짜입니다.");
		
		var tempValue = this.toCharNum();
		var reg = null;
		var matchedArray = null;
		
		if (tempValue.length == 6) {
			reg = /^(\d{4})(\d{2})$/;
			matchedArray = reg.exec(tempValue);
			return new Date(matchedArray[1], (matchedArray[2] - 1));
		} else if (tempValue.length == 8) {
			reg = /^(\d{4})(\d{2})(\d{2})$/;
			matchedArray = reg.exec(tempValue);
			return new Date(matchedArray[1], (matchedArray[2] - 1), matchedArray[3]);
		} else if (tempValue.length == 12) {
			reg = /^(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})$/;
			matchedArray = reg.exec(tempValue);
			return new Date(matchedArray[1], (matchedArray[2] - 1), matchedArray[3], matchedArray[4], matchedArray[5]);
		} else if (tempValue.length == 14) {
			reg = /^(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})(\d{2})$/;
			matchedArray = reg.exec(tempValue);
			return new Date(matchedArray[1], (matchedArray[2] - 1), matchedArray[3], matchedArray[4], matchedArray[5], matchedArray[6]);
		} else {
			throw new Error("yyyy mm dd HH mi ss 형식만 지원합니다.");
		}
		return null;
	});
	
	String.extend('numberToAmtHangul',function(){
		if(!this.isNumber()) throw new Error("숫자가 아니므로 한글 숫자로 변환할 수 없음");

		var sNumber = this.toCharNum().leftPad(16,"0");
		
		var han = [ "천", "백", "십", "조", "천", "백", "십", "억", "천", "백", "십", "만", "천", "백", "십", "" ];
		var nHan = ["영","일","이","삼","사","오","육","칠","팔","구"];
		
        var value = false;
        var cNumber = sNumber.split("");

        var won = new String();

        for (var i = 0; i < cNumber.length; i++) {
            if (cNumber[i] != '0') {
				won += nHan[cNumber[i].parseInt()] + han[i];

                if (i == 3 || i == 7 || i == 11) {
                    value = false;
                }
                else {
                    value = true;
                }
            }
            else {
                if (value && (i == 3 || i == 7 || i == 11 || i == 15)) {
                    won += han[i];
                    value = false;
                }
            }
        }

        if (won.length == 0)
            won += "0원";
        else won += "원";

        return won;
	});
	
	// 우편번호 '-' 붙이기
	String.extend('toZipCode',function(){
		return this.replace(/(\d{3})(\d{3})/, "$1" + "-" + "$2");
	});
	
	Array.extend('contains',function(value){
		if(this == null) return false;
		
		for (var i = 0; i < this.length; i++) {
			if (this[i] == value) {
				return true;
			}
		}
		return false;
	});
	
	Array.extend('indexOf',function(value){
		if (this == null) return -1;
		
		for (var i = 0; i < this.length; i++) {
			if (this[i] == value) {
				return i;
			}
		}
		return -1;
	});
	
	Date.extend('DEFAULT_DATE_FORMAT', "yyyymmdd");
	Date.extend('DASH_DATE_FORMAT', "yyyy-mm-dd");
	Date.extend('DOT_DATE_FORMAT', "yyyy.mm.dd");
	Date.extend('KOR_DATE_FORMAT', "yyyy년mm월dd일");
	
	Date.extend('formatToString', {
		shortMonths: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
	    longMonths: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
	    shortDays: ["일", "월", "화", "수", "목", "금", "토"],
	    longDays: ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"],
	    
	    // Day
	    dd: function(date) { return (date.getDate() < 10 ? "0" : "") + date.getDate(); },
	    d: function(date) { return date.getDate(); },
	    
	    // Weekly
	    wks: function(date) { return (date.getDate() % 10 == 1 && date.getDate() != 11 ? "st" : (date.getDate() % 10 == 2 && date.getDate() != 12 ? "nd" : (date.getDate() % 10 == 3 && date.getDate() != 13 ? "rd" : "th"))); },
	    ws: function(date) { return this.shortDays[date.getDay()]; },
	    wl: function(date) { return this.longDays[date.getDay()]; },
	    wa: function(date) { return date.getDay() + 1; },
	    w: function(date) { return date.getDay(); },
	    
	    // Month
	    mm: function(date) { return (date.getMonth() < 9 ? "0" : "") + (date.getMonth() + 1); },
	    m: function(date) { return date.getMonth() + 1; },
	    ml: function(date) { return this.longMonths[date.getMonth()]; },
	    ms: function(date) { return this.shortMonths[date.getMonth()]; },
	    
	    
	    // Year
	    yyyy: function(date) { return date.getFullYear(); },
	    yy: function(date) { return ("" + date.getFullYear()).substring(2); },
	    yyl: function(date) { return (((date.getFullYear()%4==0)&&(date.getFullYear()%100 != 0)) || (date.getFullYear()%400==0)) ? "1" : "0"; },
	    
	    // Hour
	    HH: function(date) { return (date.getHours() < 10 ? "0" : "") + date.getHours(); },
	    hh: function(date) { return ((date.getHours() % 12 || 12) < 10 ? "0" : "") + (date.getHours() % 12 || 12); },
	    hap: function(date) { return date.getHours() < 12 ? "am" : "pm"; },
	    HAP: function(date) { return date.getHours() < 12 ? "AM" : "PM"; },
	    h12: function(date) { return date.getHours() % 12 || 12; },
	    h: function(date) { return date.getHours(); },
	    
	    // Minute
	    mi: function(date) { return (date.getMinutes() < 10 ? "0" : "") + date.getMinutes(); },
	    
	    // Second
	    ss: function(date) { return (date.getSeconds() < 10 ? "0" : "") + date.getSeconds(); },
	    
	    // Timezone
	    O: function(date) { return (-date.getTimezoneOffset() < 0 ? "-" : "+") + (Math.abs(date.getTimezoneOffset() / 60) < 10 ? "0" : "") + (Math.abs(date.getTimezoneOffset() / 60)) + "00"; },
	    P: function(date) { return (-date.getTimezoneOffset() < 0 ? "-" : "+") + (Math.abs(date.getTimezoneOffset() / 60) < 10 ? "0" : "") + (Math.abs(date.getTimezoneOffset() / 60)) + ":" + (Math.abs(date.getTimezoneOffset() % 60) < 10 ? "0" : "") + (Math.abs(date.getTimezoneOffset() % 60)); },
	    T: function(date) { var m = date.getMonth(); date.setMonth(0); var result = date.toTimeString().replace(/^.+ \(?([^\)]+)\)?$/, "$1"); date.setMonth(m); return result;},
	    Z: function(date) { return -date.getTimezoneOffset() * 60; },
	    // Full Date/Time
	    c: function(date) { return date.toStringByFormat("yyyy-mm-dd THH:mi:ssP"); },
	    r: function(date) { return date.toString(); },
	    U: function(date) { return date.getTime() / 1000; }
	});
	
	Date.extend('toStringByFormat',function(format){
		var date = this;
		return format.replace(/(dd|d|wks|ws|wl|wa|w|mm|ml|ms|mi|m|yyyy|yy1|yy|HH|hh|hap|Hap|HAP|h12|h|ss|O|P|T|Z|c|r|U)/gi,
	        function ($1) {
	            if (date.formatToString[$1]) {
	                return date.formatToString[$1](date);
	            } else {
	                return $1;
	            }
	        }
	    );
	});
	
	Date.extend('compareTo',function(compareDate){
		
		if ( String(typeof(value)).toLowerCase() == "date" ) {
			return -2;
		}
		
		if ( compareDate > this) {
			return -1;
		}else if ( compareDate == this) {
			return 0;
		}else {
			return 1;
		}
	});
	
	Date.extend('getMonthOffset',function(destDate){
		if ( String(typeof(value)).toLowerCase() == "date" ) {
			throw Error("파라미터가 Date 객체가 아닙니다.");
		}
		
		var sign = '';
		var fromDate = [];
		var toDate =  [];
		var offset = 0;
		
		if ( this.compareTo(destDate) > 0) {
			sign = '-';
			
			fromDate.push(destDate.getFullYear());
			fromDate.push(destDate.getMonth());
			fromDate.push(destDate.getDate());
			
			toDate.push(this.getFullYear());
			toDate.push(this.getMonth());
			toDate.push(this.getDate());
		} else if (this.compareTo(destDate) == 0) {
			return 0;
		} else {
			fromDate.push(this.getFullYear());
			fromDate.push(this.getMonth());
			fromDate.push(this.getDate());
			
			toDate.push(destDate.getFullYear());
			toDate.push(destDate.getMonth());
			toDate.push(destDate.getDate());
		}
		
		if ( toDate[1] < fromDate[1]) {
			offset = (toDate[1] + 12) - fromDate[1];
			offset += ((toDate[0]-1)-fromDate[0])*12;
		} else {
			offset = toDate[1] - fromDate[1];
			offset += (toDate[0] - fromDate[0])*12;
		}
		
		return String(sign + offset.toString()).parseInt();
		
	});
	
	Date.extend('getMonthOffset2',function(destDate){
		if ( String(typeof(value)).toLowerCase() == "date" ) {
			throw Error("파라미터가 Date 객체가 아닙니다.");
		}
		
		var yyyy1 = this.getFullYear();
	    var mm1 = ((this.getMonth() < 9 ? "0" : "") + (this.getMonth() + 1));
	    var dd1 = this.getDate();
	    var yyyy2 = destDate.getFullYear();
	    var mm2 = ((destDate.getMonth() < 9 ? "0" : "") + (destDate.getMonth() + 1));
	    var dd2 = destDate.getDate();
	    
	    var yyyy = parseInt(yyyy2, 10) - parseInt(yyyy1, 10);
	    var mm = parseInt(mm1, 10) - parseInt(mm2, 10);
	    var dd = parseInt(dd1, 10) - parseInt(dd2, 10);

	    var periodMonCnt = yyyy*12 - mm;

	    if (mm > 0 || mm < 0) {
	        if (dd > 1) periodMonCnt--;
	        // 시작일의 일자가 1일이고 종료일의 일자가 그달의 마지막날일경우
	        if (dd1 == '01') {
	            if ( (mm2=='04' || mm2=='06' || mm2=='09' || mm2=='11') && (dd2=='30') ) {
	                periodMonCnt++;
	            } else if ( (mm2=='01' || mm2=='03' || mm2=='05' || mm2=='07' || mm2=='08' || mm2=='10' || mm2=='12') && (dd2=='31') ) {
	                periodMonCnt++;
	            } else if ( mm2=='02' ) {
	                var day = (new Date(parseInt(yyyy2, 10), parseInt(mm2, 10), 0)).getDate();
	                if (day+"" == dd2) periodMonCnt++;
	            }
	        }
	    } else if (mm == 0) {
	    	var day = (new Date(destDate - 1)).getDate();
	        var compareDay = day - 1;

	        if (yyyy == 0) {
	            if (dd < -compareDay) periodMonCnt++;
	        } else {
	            if (dd >= 1) periodMonCnt--;
	            else if (dd < -compareDay) periodMonCnt++;
	        }
	    }

	    return periodMonCnt;
	});
	
	Date.extend("getDayOffset",function(destDate){
		if ( String(typeof(value)).toLowerCase() == "date" ) {
			throw Error("파라미터가 Date 객체가 아닙니다.");
		}

		return (destDate.getTime() - this.getTime()) / 1000 / 60 / 60 / 24;
		
	});
	
	Date.extend("getYearOffset",function(destDate){
		if ( String(typeof(value)).toLowerCase() == "date" ) {
			throw Error("파라미터가 Date 객체가 아닙니다.");
		}
		
		var fromYear = this.getFullYear();
		var toYear = destDate.getFullYear();
		
		return toYear - fromYear ;
	});
	
	// 일추가
	Date.extend('addDay',function(offset){
		this.setDate(this.getDate() + parseInt( offset, 10 ));
		return this;
	});
	// 월추가
	Date.extend('addMonth',function(offset){
		var n=this.getDate();
		this.setDate(1);
		this.setMonth(this.getMonth() + parseInt( offset, 10 ));
		this.setDate(Math.min(n,this.getDaysInMonth()));

		return this;
	});
	// 현재연월의 마지막일자
	Date.extend('getDaysInMonth', function(){
		return Date.getDaysInMonth(this.getFullYear(),this.getMonth());
	});	
	
	// 년추가
	Date.extend('addYear',function(offset){
		this.setFullYear(this.getFullYear() + parseInt( offset, 10 ));
		return this;
	});
	// 월의 마지막 일자
	Date.extend('getLastDateOfMonth',function(){
		this.addMonth(1);
		this.setDate(0);
		return this.toStringByFormat('dd');
	});
	
	// 윤년여부 판단
	Date.isLeapYear=function(year){
		return(((year%4===0)&&(year%100!==0))||(year%400===0));
	};
	// 월별 일 수 
	Date.getDaysInMonth=function(year,month){
		return[31,(Date.isLeapYear(year)?29:28),31,30,31,30,31,31,30,31,30,31][month];
	};
});


/**
 * 사용자 접속정보 판별
 */
(function() {
	var detectInfo = {
		init : function(){
			this.browser = this.detectBrowser(navigator.userAgent.toLowerCase());
			this.OS = this.detectOS();
			this.screenSize = this.detectScreenSize(this.browser);
		},
		detectBrowser : function(userAgent) {
			var modelName = "";
			
			if(/test-st_/.test(userAgent)) {
				// TODO :: TEST- 로 시작하면서 공백으로 끝날때까지가 모델명이 됨.
				var uaArr = userAgent.split(" ");
				for(var i=0; i < uaArr.length; i++) {
					if(/test-st_/.test(uaArr[i])) {
						modelName = uaArr[i].toUpperCase();
						break;
					}
				}
			} else if(/chrome/.test( userAgent )) {
				modelName = "Chrome";
			} else if(/webkit/.test( userAgent ) && !/chrome/.test( userAgent )) {
				modelName = "Safari";
			} else if(/opera/.test( userAgent )) {
				modelName = "Opera";
			} else if(/msie/.test( userAgent ) && !/opera/.test( userAgent )) {
				modelName = "msie";
			} else if(/mozilla/.test( userAgent ) && !/(compatible|webkit)/.test( userAgent )) {
				modelName = "Firefox";
			} 

			return modelName;
		},
		detectScreenSize : function(clientBrowser){
			if(/TEST-ST_/.test(clientBrowser) ) {
				return clientBrowser.replace("TEST-ST_","");
			} else {
				return "";
			}
		},
		detectOS : function() {
			var osInfo = [
				{
					dataString: navigator.platform,
					idxString: "Win",
					identity: "Windows"
				},
				{
					dataString: navigator.platform,
					idxString: "Mac",
					identity: "Mac"
				},
				{
					dataString: navigator.userAgent,
					idxString: "Android",
					identity: "Android"
				},
				{
					dataString: navigator.userAgent,
					idxString: "iPhone",
					identity: "iOS"
				},
				{
					dataString: navigator.platform,
					idxString: "Linux",
					identity: "Linux"
				}
			];
			
			var osName = "";

			for (var i=0; i < osInfo.length; i++) {
				var dataString = osInfo[i].dataString;
				
				if (dataString.indexOf(osInfo[i].idxString) != -1) {
					osName = osInfo[i].identity;
				}
			}

			return osName;
		}
	};

	detectInfo.init();
	
	window.hanrwjs.client = { os : detectInfo.OS, screenSize: detectInfo.screenSize ,browser : detectInfo.browser };
})();

hanrwjs.mkSearchConditionParam = function() {
    var params = {};
    if ( hanrwjs.StringUtils.hasText($("#curPage").val()) ) {
        params.curPage = $("#curPage").val();
    }
    if ( hanrwjs.StringUtils.hasText($("#qstr").val()) ) {
        params.qstr = $("#qstr").val();
        params.column = 'subject';
    }

    return $.param(params);
}