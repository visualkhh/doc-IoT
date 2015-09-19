var rptidx = 0;
var loadinterval = 3000;
var rptLoadList = 0;

//포스트 번호 매칭하기
function loadPostList(){

	if ( rptLoadList < 4 && $("#post_uid").val() < 1) {
	
		jQuery.ajax({
				url:'/widget/new_mixup/loadPostList.php',
				data: { platform:$("#platform").val(),
					guid:$("#guid").val(),
					muid:$("#muid").val(),
					rdate:$("#rdate").val()
				},
				type:'GET',
				success:function(result){
					if ( result > 0 ) {
			
						$("#post_uid").val(result); 
						$("#status").val("1"); 
						loadMixup();
						loadBottom();
					} 
		 	        }
		}); 
	
		if ( rptLoadList == 3 && $("#post_uid").val() < 1 ) {
			loadStopMixup();
		}

		rptLoadList++; 
		setTimeout(loadPostList, loadinterval);
	}

}

//브라우져 구분
function getNavigatorType() {
	if ( navigator.appName == "Microsoft Internet Explorer" )
		return 1;
	else if ( navigator.appName == "Netscape" )
		return 2;
	else
		return 0;
}

function loadMixupWait() {

	jQuery.ajax({
			url:'/widget/new_mixup/getMixup.php',
			data: { post_status:"6" 
			},
			type:'POST',
			success:function(result){
				$("#mixup_btn").html(result); 
	 	        }
	}); 
}

function loadChangeMixup(cnt) {

	jQuery.ajax({
			url:'/widget/new_mixup/getMixup.php',
			data: { post_uid:$("#post_uid").val(),
				post_status:$("#status").val(),
				sign_uid:$("#sign_uid").val(),
				media_uid:$("#muid").val(),
				arg_plus:'3',
				arg_cnt:cnt
			},
			type:'POST',
			success:function(result){
				$("#mixup_btn").html(result); 
	 	        }
	}); 

}

function loadStopMixup() {

	jQuery.ajax({
			url:'/widget/new_mixup/getMixup.php',
			data: { post_status:4
			},
			type:'POST',
			success:function(result){
				$("#mixup_btn").html(result); 
	 	        }
	}); 

}

function loadMixup() {

	jQuery.ajax({
			url:'/widget/new_mixup/getMixup.php',
			data: { post_uid:$("#post_uid").val(),
				post_status:$("#status").val(),
				sign_uid:$("#sign_uid").val(),
				muid:$("#muid").val()
			},
			type:'POST',
			success:function(result){
				$("#mixup_btn").html(result); 
	 	        }
	}); 

}

//믹스업하기
function mixupProc(post_uid, member_uid, ipaddr, arg, cnt,muid) { 

	if ( muid == 0 || !muid ) { 
		location.reload();
		return false;
	}
		
	if ( arg == 1 ) {
		$("#LoginMixup").show();
		$("#LoginMixup").fadeOut(2000); 
		return false;
	} 

	loadMixupWait();

	jQuery.ajax({
			url:'/widget/new_mixup/mixupProc.php',
			data: { post_uid:post_uid,
				member_uid:member_uid,
				ipaddr:ipaddr,
				media_uid:muid
			},
			type:'POST',
			success:function(result){
				if ( result == "-1" ) { 
					loadMixup(); 
				} else if ( result == "-2" ) {
					loadMixup();
				} else {
					loadChangeMixup(cnt);
				}
	 	        }
	}); 
}

//위젯 메인글 클릭시 pv 입력
function openPost(post_uid) {

	var f = document.iform;
	f.action = "/widget/new_mixup/mainlist_pv.php";
	f.target = "innerframe";
	f.pid.value = post_uid;
	f.submit();
	
	var target_url = "http://mixsh.com/r/" + post_uid;

	window.open(target_url,"mainlist","toolbar=yes,menubar=yes,location=yes,directories=yes,resizable=yes,scrollbars=1"); 
} 

jQuery(document).ready(function(){

	loadPostList(); 
	loadMixup();

}); 
