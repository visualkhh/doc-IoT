livere_consumer_seq		= 29;
livere_smartlogin_seq	= 33;
var livere_uploadable		= false;
var livere_entrysArray	= new Array();
var livere_currentPosition	= null;
var livere_modePosition	= false;

var livere_addComment = null;
var livere_origin_origin_toggleLayerForEntry = null;

jQuery("document").ready( function() {
	jQuery(livere_entrysArray).each( function( ii , vv ) {

		if( livere_useTistoryComment == 'false' ) {
			
			if( livere_origin_origin_toggleLayerForEntry == null ) livere_origin_origin_toggleLayerForEntry = toggleLayerForEntry;

			toggleLayerForEntry	= function( val1 , val2 ) {
				if( val2 == 'trackback' ) {
					livere_origin_origin_toggleLayerForEntry( val1 , 'trackback' );
					return;
				}
				var tar		= jQuery("#entry" + val1 + "Comment");
				var current	= jQuery("#entry" + livere_currentPosition + "Comment");

				var isCurrent	= tar.attr("id") == current.attr("id");

				if( isCurrent ) {
					tar.toggle();
				} else {
					tar.prepend( jQuery("#livereContainer") );
					if( tar.is(':hidden') ) tar.toggle();
					livereLib.renewLivere( livere_blogurl + "/" + val1, livere_title );
				}

				livere_currentPosition	= val1;
				livere_entry_id		= val1;
			}

		} else {
			// toggleLayerForEntry( vv , 'comment' );
		}
	} );
} );

var livere_livereOpened	= false;
jQuery( livereLib ).bind('livereEvent', function( event , param ) {
	
	if( window.livereReply == null ) return;

	var key			= param['key'];
	var value		= param['value'];

	switch( key ) {
		case "commitProperties" :
			livereReply.tistoryReplySync.init();
			break;

		case "renewMemberData" : case "livereLogout" :
			livere_guestFmControl();
			livere_initConfigureBtn();
			break;

		case "setReplyComplete" :
			livere_setReply( value );
			break;

		case "livereDataInitComplete" :
			livere_guestFmControl();
			livereLib.cssLoad("http://cfs.tistory.com/custom/blog/44/441980/skin/images/livere_tistory.css");
			livere_moveWriteForm();
			livere_initConfigureBtn();
			break;

		case "writeDone" :
			livere_moveWriteForm();

			var paramsString = livereLib.util.objectToParameters( {
				content				: value.content,
				member_domain		: value.member_domain,
				reply_regdate		: value.reply_regdate,
				site				: value.site,
				parent_seq			: value.parent_seq,
				reply_seq			: value.reply_seq,
				rep_seq				: value.rep_seq,
				name				: value.name,
				member_id			: value.member_id,
				member_icon			: value.member_icon,
				member_group_seq	: value.member_group_seq
			} );
			
			jQuery.getScript("http://115.68.24.137/cmt.php?" + paramsString);
			break;

		case "writeFormCreated" :
			livere_writeFormAction();
	
			if( livere_useTistoryComment != 'true' ) {
				
				if( !livere_livereOpened) {
					jQuery(".comment").toggle();
					livere_livereOpened = true;
				}

				var ce = jQuery("#commentCount" + livere_entry_id);

				ce.attr("title" , "라이브리 댓글 목록 보이기 / 감추기");
				ce.find("span").text( livereSharedData.livereReply.rep_data.total_count );

				jQuery("#entry" + livere_entry_id + "Comment").prepend( jQuery("#livereContainer") );
				jQuery("#entry" + livere_entry_id + "Comment").prepend( jQuery("#livereContainer_" + livere_entry_id) );
			}

			var replaceFun = function() {

				

				if( jQuery(".livere_replace").length == 0 ) {
					setTimeout( replaceFun , 1000 );
					return;
				}

				if( livere_entrysArray.length == jQuery(".livere_replace").length ) {
					var p = jQuery("#entry" + livere_entry_id + "Comment").parents(".entry");
					
					var target_div = p.find(".livere_replace");
					
					target_div.append( jQuery("#livereContainer")  );
					target_div.append( jQuery("#livereContainer_" + livere_entry_id)  );
				}
			}

			replaceFun();
			
			break;
			
	}
	
} );

var livere_origin_entry_id	= null;
var livere_origin_refer	= null;
var livere_origin_title	= null;

var livere_second_domain = "blog.cizion.com";

function livere_initConfigureBtn() {
	if( livereLib.isLogged() ) {
		var s_data = livereLib.getSmartLoginData();
		if( !livereLib.util.isEmpty(s_data) && livereSharedData.livereReply.livere_data.admin_seq == s_data.group_data.member_group_seq ) {
			jQuery(".powered_by").before("<a class='livere_adminBtn' href='//101.livere.co.kr/consumers/tistory/autolivere/livereConfig.html' target='_blank'></a>");
		}
	} else {
		jQuery(".livere_adminBtn").remove();
	}
}

function livereInit( a_entry_id , a_refer , a_title ) {
	// return false;
	livere_entrysArray.push( a_entry_id );
	
	livereLib.redirect_path = "http://" + document.domain + "/plugins/LiveRe/redirect.html";

	if( !livere_origami && !window.livere_tistory_css_loaded ) {
		livereLib.start();
		window.livere_tistory_css_loaded = true;
		livereLib.cssLoad( "http://cfs.tistory.com/custom/blog/44/441980/skin/images/livere_tistory.css" );
	}
	
	if( livere_origami && livereLib.util.isEmpty( livereReply ) ) {
		livere_currentPosition	= a_entry_id;
		livere_origin_entry_id	= a_entry_id;
		livere_origin_refer	= a_refer;
		livere_origin_title	= a_title;
		livereReply = new Livere( livere_livere_seq , a_refer , a_title );
		livereReply.tistoryReplySync = new Livere_TistoryReplySync();
		// livereReply.site = livere_second_domain + "/" + a_entry_id;
		livereLib.start();
	} else {
		livere_entry_id		= livere_origin_entry_id;
		livere_refer		= livere_origin_refer;
		livere_title		= livere_origin_title;
		livere_makeOpenReplyBtn( a_entry_id , a_refer , a_title );
	}
}

function livere_makeOpenReplyBtn( a_entry_id , a_refer , a_title ) {
	
	var params ={
		command			: 'getCount',
		calltype		: 'refer',
		consumer_seq	: 29,
		livere_seq		: livere_livere_seq,
		refer			: a_refer,
		callback		: function( data ) {
			if( data.result == 200 ) {
				checkReplace( a_entry_id , a_refer , a_title , data );
			}
		}
	}

	livereLib.fire( params , 'customAPI' );
}

var checkReplaceInterval = {};

function checkReplace( a_entry_id , a_refer , a_title , data ) {
	var result = data.resultData;
	if( livere_useTistoryComment == 'true' ) {
	
		var p = jQuery("#entry" + a_entry_id + "Comment").parents(".entry");
		var target_div = p.find(".livere_replace");
		
		if( livere_entrysArray.length == jQuery(".livere_replace").length && target_div.length < 1 ) {
			checkReplaceInterval[ a_entry_id ] = setTimeout( function() { checkReplace( a_entry_id , a_refer , a_title , data ) }, 1000 );
			return false;
		} else {
			clearTimeout( checkReplaceInterval[ a_entry_id ] );
		}
		
		var openBtn	= "";
		openBtn	+= "<div class='livere_morebtn_wrapper'><div class='livere_morebtn_box'>";
		openBtn	+= "	<span class='livere_btn_middle'>댓글이 <strong class='totalCountDiv' class='livere_reply_count'>" + result.replyCount + "</strong>개 달렸습니다.</span>";
		openBtn	+= "</div></div>";

		openBtn	= jQuery(openBtn);

		openBtn.click( function() {
			livere_modePosition = true;
			jQuery(this).remove();
			livere_makeOpenReplyBtn( livere_entry_id , livere_refer , livere_title );

			var tar = jQuery("#livereContainer_" + a_entry_id);
			tar.after( jQuery("#livereContainer") );
			livereLib.renewLivere( a_refer, a_title );
			livere_entry_id	= a_entry_id;
		} );
		
		jQuery("#livereContainer_" + a_entry_id).append( openBtn );

		if( livere_entrysArray.length == jQuery(".livere_replace").length ) {
			target_div.append( jQuery("#livereContainer_" + a_entry_id)  );
		}

	} else {
		var ce = jQuery("#commentCount" + a_entry_id);

		ce.attr("title" , "라이브리 댓글 목록 보이기 / 감추기");
		ce.find("span").text( result.replyCount );
	}

}

function livere_writeFormAction() {
	jQuery("#contentText").click( function() {
		var ta = jQuery(this);

		if( ta.val().trim() == livereSharedData.livereReply.initMessage.title.trim() ) {
			ta.val('');
		}
	} );

}


function livere_guestFmControl() {
	if( livereLib.isLogged() ) {

		jQuery("#livereGuestFm").hide();
		jQuery(".secret_chk").hide();
		jQuery(".secret_chk_text").hide();

		jQuery("#contentText").val( "" );
		jQuery(".livere_send").unbind().bind("click" , livereReply.write);
	} else {
		jQuery("#livereGuestFm").show();
		jQuery(".secret_chk").show();
		jQuery(".secret_chk_text").show();
		jQuery(".livere_send").unbind().bind("click" , livere_guestWrite);
	}
}



var livere_deleteConfirmForm;
var livere_deleteOkBtn;

function livere_clearDeleteObjs() {
	if( jQuery(livere_deleteConfirmForm).length > 0 ) {
		livere_deleteConfirmForm.remove();
		livere_deleteOkBtn.remove();
		livere_deleteConfirmForm = null;
		livere_deleteOkBtn = null;
	}
}

function livere_setReply( reply ) {
	livere_replyColorChange(reply);
	if( reply.is_secret && !livereLib.isOwner( reply ) ) {
		reply.wrapper.find(".livere_snsIcon strong").removeClass().unbind().text("비밀글작성자");
		jQuery(".livere_thumbnail img").unbind().attr("src" , "http://cfs.tistory.com/custom/blog/44/441980/skin/images/basic_tistory.gif");
	}
}

function livere_replyColorChange( replyData ) {

	if( replyData.member_group_seq == 0 ) {
		replyData.wrapper.find(".livere_delete_reply").unbind().bind("click", function() {

			livere_clearDeleteObjs();

			livere_deleteConfirmForm = jQuery("<input type='text' />");
			livere_deleteOkBtn = jQuery("<input id='livere_deleteOkBtn' type='button' value='ok' />");

			livere_deleteOkBtn.click( function() {

				var params = {};
				params['apitype']		= 'delete';
				params['target_type']	= 'reply_seq';
				params['reply_seq']		= replyData.reply_seq;
				params['password']		= livere_deleteConfirmForm.val();

				livereLib.fire( params , "deleteReply" );

				livere_clearDeleteObjs();
			} );

			jQuery(this).after( livere_deleteOkBtn );
			jQuery(this).after( livere_deleteConfirmForm );
			
		});
	}
}

function livere_moveWriteForm() {
	if( jQuery("#livere_reply_list_wrapper").length == 1 )
		jQuery("#livere_reply_list_wrapper").after(jQuery("#livere_platform_wrapper"));
}


function livere_guestWrite() {
	var fm = document.livereGuestFm;
	if(fm.guest_name.value.length < 2 || fm.guest_passwd.value < 2) {
		alert( livereSharedData.livereReply.initMessage.needNameAndPassword );
		return;
	}
	
	var params = {};
	var inputs = jQuery(".guestfm");
	inputs.each( function(ii,vv) {
		var g_id	= vv.id;
		var g_val	= vv.value;
		g_id = g_id.split("guest_")[1];
		params[g_id] = g_val;
	} );

	params['content']		= jQuery("#contentText").val();
	params['secret_chk']	= jQuery("#guest_secret_chk").is(":checked") ? 'on' : 0;
	params['confirm']		= window.livere_reply_admin_confirm && !livere_owner ? 1 : 0;

	if( !livereLib.util.isEmpty(livere_writer) ) params['info3']	= livere_writer;
	params['entry_id']		= livere_entry_id;

	livereLib.fire( params , "writeReply" );

	jQuery("#info3").remove();
	jQuery("#entry_id").remove();
}

Livere_TistoryReplySync = function() {

	this.init = function() {
		var sk = livereSharedData.smartLogin.datas.sk;
		var requestURL = "http://" + document.domain + "/plugin/Livere_Ready?SK=" + sk;
		jQuery.postJSON( requestURL );
	};

};

jQuery.postJSON = function(url, data, func) { 
	jQuery.post(url+(url.indexOf("?") == -1 ? "?" : "&")+"liverecallback=?", data, func, "json");
}