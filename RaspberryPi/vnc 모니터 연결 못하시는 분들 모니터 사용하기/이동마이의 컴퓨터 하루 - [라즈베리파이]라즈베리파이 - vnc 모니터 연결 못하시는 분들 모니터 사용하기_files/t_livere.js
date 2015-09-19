var livereReply = null;
jQuery.fn.trim = function(str) {
	return typeof(str) == 'string' ? str.replace(/^\s\s*/, '').replace(/\s\s*$/, '') : '';
};
Livere_HTMLFactory = function() {
	this.defaultHtml	= function() {
		var formHTML = "";

		formHTML += "<div id='livere_platform'>";

		formHTML += "<div id='livere_platform_wrapper'>";
		formHTML += "	<div id='livere_event_notice'></div>";
		formHTML += "	<a class='powered_by' href='http://www.livere.com/' target='_blank'></a>";
 
		var guestHTML = "";

		guestHTML += "<div id='livereGuestFm'>";
		guestHTML += "	<form name='livereGuestFm'>";
		guestHTML += "		<label>이름</label><input type='text' class='input_text guestfm' name='guest_name' id='guest_name' />";
		guestHTML += "		<label>패스워드</label><input type='password' class='input_text guestfm' name='guest_passwd' id='guest_passwd' />";
		guestHTML += "		<label>웹사이트</label><input type='text' class='input_text guestfm'  name='guest_homepage' id='guest_homepage' value='http://' />";
		guestHTML += "	</form>";
		guestHTML += "</div>";

		formHTML += guestHTML;

		formHTML += "	<div id='livere_pltform_middle'>";
		formHTML += "			<span class='livere_primarySNS'>";
		formHTML += "				<strong class='snsid'>" + livereSharedData.livereReply.initMessage.snsid + "</strong>";
		formHTML += "			</span>";
		formHTML += "			<fieldset>";
		formHTML += "				<div class='livere_thumbnail'><img class='primaryThumbnail' /></div>";
		formHTML += "                <div class='livere_contentInput'>";
		formHTML += "                    <form id='livereForm' name='livereForm'>";
		formHTML += "                        <input type='hidden' name='short_url' id='short_url' />";
		formHTML += "                        <input type='hidden' name='name' id='name' />";
		formHTML += "                        <input type='hidden' name='parent_seq' id='parent_seq' />";
		formHTML += "                        <textarea name='content' rows='3' cols='90' id='contentText' class='livere_textarea' onkeydown=\"javascript:livereReply.validate(this , 'textareaOnKeyUp')\"></textarea>";
		formHTML += "                    </form>";
		formHTML += "                </div>";
		formHTML += "            </fieldset>";
		formHTML += "	</div>";
		formHTML += "	<div class='livere_pltfrm_top login'>";
		formHTML += "		<div class='livere_sns_icons_wrapper'>";
		formHTML += "		</div>";
		
		//비밀글쓰기 체크박스 로그인 아이콘 영역 안으로 이동
		formHTML += "		<input type='checkbox' class='secret_chk guestfm' name='guest_secret_chk' id='guest_secret_chk' /><label class='secret_chk_text'>" + livereSharedData.livereReply.initMessage.secret_txt + "</label>";
		
		formHTML += "		<a class='logout off'>" + livereSharedData.livereReply.initMessage.afterlogin + "</a>";
		formHTML += "       <div class='livere_sendFunction'><a class='livere_send'></a></div>";
		formHTML += "			<span class='livere_writeCountWrapper'><strong class='writeCount'>0</strong>/" + livereSharedData.livereReply.livere_data.content_maxlen + "자</span>";
		formHTML += "		<span class='livere_pltfrm_txt'>" + livereSharedData.livereReply.initMessage.pltfrm_txt + "</span>";
		formHTML += "	</div>";
		formHTML += "</div>";
		formHTML += "</div>";

		return formHTML;
	};
	
	this.defaultAccountControlBox = function ( account ) {
		var actionControlBox = "<div class='livere_accountLayer'>";
		actionControlBox += "	<a class='livere_layerClose'></a>";
		actionControlBox += "	<dl>";			
		actionControlBox += "		<dd class='livere_accountLayer_sns_icon'><span class='" + account.name + "'>" + account.member_name + "</span></dd>";
		actionControlBox += "		<dd class='livere_accountLayer_button_wrapper'>";
		actionControlBox += "			<a class='livere_primarySet'>" + livereSharedData.livereReply.initMessage.primaryset + "</a>";
		actionControlBox += "			<a class='livere_postingChoice'>" + livereSharedData.livereReply.initMessage.postingset + "</a>";
		actionControlBox += "			<a class='livere_selfLogout'>" + livereSharedData.livereReply.initMessage.logoutset + "</a>";
		actionControlBox += "		</dd>";
		actionControlBox += "	</dl>";
		actionControlBox += "</div>";
		
		return actionControlBox;
	};
	
	this.defaultEmptyReplyHtmlObject = function() {
		var replyWrapper = "";
		replyWrapper += "<div class='articles_wrapper emptyReply'>";
		replyWrapper += "	<div class='livere_articles_body_wrapper'>";
		replyWrapper += "		<p class='livere_emptyReplyText'>삭제된 댓글입니다</p>";
		replyWrapper += "	</div>";
		replyWrapper += "</div>";
		
		return replyWrapper;
	};
	
	this.defaultReplyHtmlObject = function( reply ) {
		reply.reply_regdate = reply.regdate.year + 1900 + "-" + livereLib.util.addZero( parseInt(reply.regdate.month) + 1 ) + "-" + livereLib.util.addZero(reply.regdate.date);
		reply.reply_regdate += " " + livereLib.util.addZero(reply.regdate.hours) + ":" + livereLib.util.addZero(reply.regdate.minutes) + ":" + livereLib.util.addZero(reply.regdate.seconds);
			
		if( reply.member_domain == 'sociallg' ) {
			if( !livereLib.util.isEmpty( reply.member_url ) && !livereLib.util.isEmpty( reply.member_icon ) ) {			
				// member_url is not null
				// member_image is not null
				// member_doman is sociallg
				// member_domain change
				
				if( reply.member_url.indexOf("twitter") > -1 ) {
					reply.member_domain = "twitter";
				} else if ( reply.member_url.indexOf("facebook") > -1 ){
					reply.member_domain = "facebook";
				} else if ( reply.member_url.indexOf("me2day") > -1 ){
					reply.member_domain = "me2day";
				} else if ( reply.member_url.indexOf("yozm") > -1 ){
					reply.member_domain = "yozm";
				} else if ( reply.member_url.indexOf("cyworld") > -1 ){
					reply.member_domain = "cyworld";
				} else if( reply.member_url.indexOf("tistory") > -1 ){
					reply.member_domain = "tistory";
				} else if( reply.member_url.indexOf("weibo") > -1 ){
					reply.member_domain = "weibo_sina";
				}
				
			}
		} 
		
		return reply.reply_seq == reply.parent_seq ? livereReply.htmlFactory.defaultParentReplyHtml( reply ) : livereReply.htmlFactory.defaultSubReplyHtml( reply );
	};
	
	this.defaultParentReplyHtml = function( reply ) {

		var wrapper = "<div class='livere_articles_wrapper'></div>";
		
		var replyThumb  = "";
			replyThumb += "<div class='livere_thumbnail'>";
			replyThumb += "		<img src='" + reply.member_icon + "'/>";
			replyThumb += "</div>";
		
		var replyBody  = "";
			replyBody += "<div class='livere_articles_body_wrapper'> ";
			replyBody += "	<dl class='livere_article_content'>";
			replyBody += "		<dd class='livere_article_writed_info'>";
			replyBody += "		<span class='livere_snsIcon' href='#'>";
			replyBody += "				<a><strong class='" + reply.member_domain + "'>" + reply.name + "</strong></a>";
			replyBody += "				<span class=\"livere_date\">" + reply.reply_regdate + "</span>";
			replyBody += "			</span>";
			replyBody += "		</dd>";
			replyBody += "		<dd class='livere_article_function'>";
		
		var deleteBtn = "			<a><span name='delete' class='livere_delete_reply action_btn'>" + livereSharedData.livereReply.initMessage.deletebtn + "</span></a>";
			
			replyBody += deleteBtn;
			replyBody += "			<a><span name='good' class='livere_like_reply action_btn'>" + livereSharedData.livereReply.initMessage.good.substr(0, 2) + "<strong class='recommend_count'>" + reply.good + "</strong></span></a>";
			
			replyBody += "		</dd>";
			replyBody += "		<dd class='livere_article_text'>";
			replyBody += "			<span class='livere_re_content'>" + reply.content + "</span>";
			replyBody += "		</dd>";
			replyBody += "	</dl>";
			replyBody += "	<div class='livere_articles_right_bottom'></div>";
			replyBody += "</div>";
		
		var replyAddBtn = "<a class='livere_re_reply_button'></a>";

		reply.wrapper = jQuery(wrapper);
		reply.wrapper.append( jQuery(replyThumb) );
		reply.deleteBtn = jQuery( deleteBtn );
		reply.replyBody = jQuery( replyBody );
		reply.replyBody.find(".livere_re_content").append( jQuery(replyAddBtn) );
		reply.wrapper.append( reply.replyBody );
			
		return reply;
	};
	
	
	this.defaultSubReplyHtml = function( reply ) {
		var subReply = "";
			subReply += "<div class='livere_re_reply_article'>";
		
			subReply += "<div class='livere_thumbnail'>";
			subReply += "		<img src='" + reply.member_icon + "'/>";
			subReply += "</div>";
			
			
			subReply += "	<div class='livere_articles_body_wrapper'>";

			subReply += "    <dl class='livere_article_content'>";
			subReply += "       <dd class=\"livere_article_writed_info\">";
			subReply += "           <span class=\"livere_snsIcon\"><strong class=\"" + reply.member_domain + "\">" + reply.name + "</strong></span>";
			subReply += "            <span class=\"livere_date\">" + reply.reply_regdate + "</span>";	
			subReply += "       </dd>";
			
			subReply += "		<dd class=\"livere_article_function\">";
		
		var deleteBtn = "			<a><span name='delete' class='livere_delete_reply action_btn'>" + livereSharedData.livereReply.initMessage.deletebtn + "</span></a>";

			subReply += deleteBtn;
			subReply += "    	</dd>";
					
			subReply += "        <dd class='livere_article_text'>";
			subReply += "            <span class='livere_re_content'>" + reply.content + "</span>";
			subReply += "        </dd>";

			subReply += "    </dl>";
			
			subReply += "	</div>";
			subReply += "</div>";
		
		reply.wrapper = jQuery(subReply);
		reply.replyBody = jQuery(subReply);
		reply.deleteBtn = jQuery( deleteBtn );
		
		return reply;
	};
	
	this.defaultListHeader = function() {
		var listHeaderHTML = "";
		listHeaderHTML += "<div id='livere_comment_sort'>";
		listHeaderHTML += "	<span>" + livereSharedData.livereReply.initMessage.replyCount_txt.substr(0, 4) + "<strong id='totalCountDiv' class='livere_reply_count'>" + livereSharedData.livereReply.rep_data.total_count + "</strong></span>";
		listHeaderHTML += "	<ul class='livere_sort_tab'>";
		listHeaderHTML += "		<li class='livere_on'><a class='livere_newReplyTab livere_sortingTab' id='new'>" + livereSharedData.livereReply.initMessage.time + "</a></li>";
//		listHeaderHTML += "		<li><a class='livere_likeReplyTab livere_sortingTab' id='past'>" + livereSharedData.livereReply.initMessage.past + "</a></li>";
		listHeaderHTML += "		<li><a class='livere_likeReplyTab livere_sortingTab' id='good'>" + livereSharedData.livereReply.initMessage.good + "</a></li>";
		listHeaderHTML += "	</ul>";
		listHeaderHTML += "</div>";
		listHeaderHTML += "<div id='livere_reply_list_wrapper'></div>";

		return listHeaderHTML;
	};
	
	this.defaultCommentForm = function() {
		var replyFormHTML = "";
		
		replyFormHTML += "<div class='livere_re_reply'>";
		replyFormHTML += "    	<form name='re_reply_form' class='livere_re_reply_form' onsubmit='return false;'>";
		replyFormHTML += "        	<textarea type='text' class='livere_txt' id='replyText' ></textarea>"; 
		replyFormHTML += "        	<a class='livere_btn'></a>";
		replyFormHTML += "    	</form>";
		replyFormHTML += "</div>";
		
		return replyFormHTML;
	};
	
	this.linkage_accountHtmlObject = function( domain ) {
		var accountHtmlObject = jQuery("<span id='" + domain.name + "_icon'><a class='" + domain.name + "'></a></span>");
		accountHtmlObject.find("a").click( function() {
			livereReply.iconClick( domain.name );
		} );
		
		domain.icon = jQuery( accountHtmlObject );
		
		return domain;
	};
	
};

Livere = function( livere_seq , refer , title ) {
	
	this.htmlFactory = new Livere_HTMLFactory();
	
	livereSharedData.livereReply.livere_seq		= livere_seq;
	livereSharedData.livereReply.refer			= refer;
	livereSharedData.livereReply.title			= title;
	
	this.fire		= function( command ) {
		var fireData = {};
		fireData['ownerObject'] = this;
		
		livereLib.fire( fireData , command );
	};
	
	this.init	= function() {
		livereSharedData.livereReply.livere_seq		= livere_seq;
		livereSharedData.livereReply.refer			= refer;
		livereSharedData.livereReply.title			= title;
		
		var params = {
			refer	: livereSharedData.livereReply.refer,
			title	: livereSharedData.livereReply.title
		};

		if( livereLib.rowsnum ) params['rowsnum'] = livereLib.rowsnum;
		livereLib.initLivereReply(params);
	};
	
	this.secondStep = function() {
		
		var customCssPath = null;
		livereReply.guestIcon	= livereSharedData.livereReply.livere_data.guest_icon_url;
		livereReply.guestIcon	= livereLib.util.isEmpty(livereReply.guestIcon) ? 'http://cfs.tistory.com/custom/blog/44/441980/skin/images/basic_tistory.gif' : livereReply.guestIcon;

		
		if( livereLib.util.isMobileVisitor() ) {
			if( livereSharedData.livereReply.livere_data.load_default_m_css == '1' )
				livereLib.cssLoad( 'http://cfs.tistory.com/custom/blog/44/441980/skin/images/default.css' );
			customCssPath = livereSharedData.livereReply.livere_data.mobile_css_path; 
		} else {
			if( livereSharedData.livereReply.livere_data.load_default_css == '1' )
				livereLib.cssLoad( 'http://cfs.tistory.com/custom/blog/44/441980/skin/images/default.css' );
			customCssPath = livereSharedData.livereReply.livere_data.css_path;
		}
		
		livereLib.cssLoad( customCssPath );
		
		/** 글쓰기 폼 셋팅 **/
		var wf = jQuery( livereReply.htmlFactory.defaultHtml() );
		wf.find(".livere_send").click( function() {
			livereReply.write();
		} );
		wf.find(".logout").click( function() {
			livereLib.fire( {} , "livereLogout" );
		});
		
		jQuery("#" + livereSharedData.livereReply.livere_data.targetDiv ).append( wf );
		
		var data = {};
		data['type']	= 'livereEvent';
		data['key']		= 'writeFormCreated';
		data['value']	= 'true';
		
		livereLib.dispatchEvent( data );
		
		/** 계정 셋팅 **/
		livereReply.setAccounts();
		
		/** 리스트 셋팅 **/
		if( livereSharedData.livereReply.livere_data.listviewable == 1 && livereSharedData.livereReply.reply_data )
			livereReply.setReplyList( livereSharedData.livereReply.reply_data );
	};
	
	this.validate = function( object , command ) {
		switch( command ) {
			case "textareaOnKeyUp" :
				livereReply.validate.textareaOnKeyUp( object );
			break;
		}
	};
	
	this.validate.textareaOnKeyUp = function( object ) {
		/** 로그인 여부 체크 **/
		var max_len = livereSharedData.livereReply.livere_data.content_maxlen;
	    var str_len = object.value.length;
	    jQuery(".livere_writeCountWrapper").html( "<strong class='writeCount'>" + str_len + "</strong>/" + max_len + "자" );
	    if(str_len > max_len) {
	    	alert( max_len + "" + livereSharedData.livereReply.initMessage.textCount_txt);
	    	object.value = object.value.substring(0, max_len);
	    	
	    	livereReply.validate(object , "textareaOnKeyUp");
	    }
	};
	
	this.comment = function( reply_seq ) {
		
		var target_reply_object = livereReply.getReplyObject( reply_seq );

		if( target_reply_object.wrapper.find(".livere_re_reply").length > 0 ) {
			jQuery(".livere_re_reply").remove();
			return;
		} else {
			jQuery(".livere_re_reply").remove();
		}
		
		var fm = jQuery( livereReply.htmlFactory.defaultCommentForm() );
		
		jQuery( livereReply.listArray ).each( function(ii , vv) {
			if( vv.reply_seq == reply_seq ) {
				vv.wrapper.find(".livere_articles_right_bottom").after( fm );
				return false;
			}
		} );
		
		fm.ready( function() {
			jQuery(this).find( ".livere_btn" ).click( function() {
				jQuery("#parent_seq").val( reply_seq );
				jQuery("#contentText").val( jQuery("#replyText").val() );
				livere_originContent	= jQuery("#replyText").val();
				livereReply.write();
				jQuery(".livere_re_reply").remove();
			} );
			jQuery(this).find("#replyText").bind("keydown", function() {
				livereReply.validate(this , 'textareaOnKeyUp');
			});
		} );
		
		jQuery("#replyText").focus();
		

		var smartlogindata = livereLib.getSmartLoginData();
		
		if( smartlogindata != null ) {
			var group_data		= smartlogindata['group_data'];
			if( group_data != null ) {
				var member_datas	= group_data['member_datas'];
			
				jQuery( member_datas ).each( function ( ii , vv ) {
					if( vv.member_domain == target_reply_object.member_domain ) {
						var requestParams = {};
						requestParams['member_seq'] = vv.member_seq;
						livereLib.fire(requestParams, "setPrimary");
						
						
						switch( target_reply_object.member_domain ) {
							case "twitter" :
								jQuery("#replyText").val( "@" + target_reply_object.name + " " );
								break;
							case "me2day" :
								jQuery("#replyText").val( "\\" + target_reply_object.name + "\\ " );
								break;
							case "yozm" :
								jQuery("#replyText").val( "@" + target_reply_object.name + "@ " );
								break;
						}
						
						return false;
					}
				});
			}
		}
	};
	
	this.getAccountControlBox = function( account ) {
		/** 컨트롤 박스 레이어 **/
		var actionControlBox = livereReply.htmlFactory.defaultAccountControlBox( account );
		var box = jQuery( actionControlBox );
		
		jQuery( actionControlBox ).ready( function() {
			box.find("a").click( function() {
				
				var btn_class = jQuery(this).attr("class");
				
				var requestParams = {};
				requestParams['member_seq'] = account.member_seq;
				
				switch( btn_class ) {
					case "livere_layerClose" :
						jQuery(".livere_accountLayer").remove();		
						jQuery("#livere_platform").removeClass("livere_layerOn");
						break;
					case "livere_primarySet" :
						livereLib.fire(requestParams, "setPrimary");
						break;
					case "livere_postingChoice" :
						livereLib.fire( requestParams , "setPosting" );
						break;
					case "livere_selfLogout" :
						livereLib.fire( requestParams , "serviceLogout" );
						break;
				}
			} );
		} );
		
		return box;
	};
	
	this.drawPrimaryUserData = function() {
		
		var logged = livereLib.isLogged();
		
		if( logged ) {
			var primaryMember = livereLib.getPrimaryDomain();
			jQuery("#livereForm #name").val( primaryMember.member_name );
			var img = new Image();
			img.onload	= function() {
				jQuery(".primaryThumbnail").removeClass("off").attr("src", primaryMember.member_icon );
			}
			img.onerror	= function() {
				jQuery(".primaryThumbnail").removeClass("off").attr("src", "http://cfs.tistory.com/custom/blog/44/441980/skin/images/basic_tistory.gif" );
			}
			img.src	= primaryMember.member_icon;
			jQuery(".logout").removeClass("off");
			jQuery(".livere_primarySNS > strong").removeClass().addClass( primaryMember.name).text( primaryMember.member_name );
			jQuery("#contentText").val( livereReply.titleInit ? livereReply.title + " "  : "" );
		} else {
			jQuery("#livereForm #name").val("");
			jQuery(".primaryThumbnail").addClass("off").attr("src", "");
			jQuery(".logout").addClass("off");
			jQuery(".livere_primarySNS > strong").removeClass().addClass("snsid").text( livereSharedData.livereReply.initMessage.snsid );
//			jQuery("#contentText").val( livereSharedData.livereReply.initMessage.title );
			jQuery("#contentText").val( "" );
		}
	};
	
	this.getArticle = function( pageNo ) {
		/** 파라미터 preparing **/
		if( !livereReply.status.nowListLoading ) {
			livereReply.status.nowListLoading = true;
			
			var params = {};
			params['calltype']	= 'rep_seq';
			params['command']	= 'getArticle';
			params['sort']		= livereReply.status.sort;
			params['viewpage']	= pageNo ? pageNo : livereReply.status.viewPage;
			params['rowsnum']	= livereLib.rowsnum;
			
			if( !livereLib.util.isEmpty( livereReply.status.search_key ) ) {
				params['search_key']	= livereReply.status.search_key;
				params['search_value']	= livereReply.status.search_value;
			}
			
			livereLib.fire( params, "getArticle" );
		}
	};
	
	this.deleteHandler		= function( result ) {
		if( result.result == '200' ) {
			/** 삭제성공 해당 글 삭제 **/
			var target_object = livereReply.getReplyObject( result.resultData.reply_seq );
			target_object.wrapper.remove();
			jQuery("#totalCountDiv").text( --livereSharedData.livereReply.rep_data.total_count );
			//livereReply.listArray.shift( target_object );
			var newListArray = [];
			jQuery( livereReply.listArray ).each( function( ii , vv ) {
				if( vv.reply_seq !=  result.resultData.reply_seq) {
					newListArray.push(vv);
				}
			});
			livereReply.listArray = newListArray;
		}
	};
	this.actionCompleteHandler	= function( result , requestData ) {
		switch( result.result ) {
			case 200 :
				var reply_object = livereReply.getReplyObject( requestData['reply_seq'] );
				var target_reply_html = reply_object.wrapper.find(".livere_article_function span[name=" + requestData['do_name'] + "] strong");
				var currVal = target_reply_html.text();
					target_reply_html.text( ++currVal );
				if( requestData['do_code'] == 203 ) alert( livereLib.getMessage( 'police_accept_message' ) );
				else alert( livereLib.getMessage( 'actionbtntext' ) );
				break;
			default :
				if( requestData['do_code'] == 203 ) alert( livereLib.getMessage( 'police_duplicate_message' ) );
				else alert( livereLib.getMessage( 'duplicate' ) );
				break;
		}
	};
	this.articleActionHandler	= function( result ) {
		switch( result.result ) {
			case 200 :
				var reply_object = livereReply.getReplyObject( result.resultData.target_seq );
				if( reply_object == null || result.resultData.target_type != 'reply_seq' ) return;

				var action_type	= result.resultData.action_type;
				var target_reply_html = reply_object.wrapper.find(".livere_article_function span[name=" + action_type + "] strong");
				if( target_reply_html.length == 1 ) {
					var currVal = target_reply_html.text();
					target_reply_html.text( ++currVal );
				}
				break;
			default :
				// alert( "articleActionHandler " + result.result );
				break;
		}
	};
	this.getArticleHandler = function( replyData ) {
		var tabs = jQuery(".livere_sort_tab").find("li");
		jQuery.each( tabs , function(ii , vv ) {
			jQuery(vv).removeClass();
		} );
		tabs.find("#" + livereReply.status.sort).parent().addClass("livere_on");
		
		if( livereReply.status.viewPage == 1 ) {
			jQuery("#livere_reply_list_wrapper").empty();
			livereReply.listArray = [];
		}
		
		livereReply.setReplyList( replyData );
		livereReply.status.nowListLoading = false;
	};
	
	/** 탭바 설정 **/
	this.setListHeader = function() {
		if( jQuery("#livere_comment_sort").length != 0 ) return;
		
		var listHeader = jQuery(livereReply.htmlFactory.defaultListHeader());
		
		jQuery(listHeader).find(".livere_sortingTab").click( function() {
			var id = jQuery(this).attr("id");
			
			if( livereReply.status.viewPage == 1 && livereReply.status.sort == id )
				return;
		
			livereReply.status.sort = id;
			livereReply.status.viewPage = 1;
			livereReply.status.calltype = 'rep_seq';
			livereReply.status.search_key	= null;
			livereReply.status.search_value	= null;
			
			livereReply.getArticle();
		});
		
		jQuery("#livere_platform_wrapper").after( listHeader );
		
		var eventData = {};
		eventData['type']	= 'livereEvent';
		eventData['key']	= 'setListHeaderComplete';
		eventData['value']	= listHeader;
			
		livereLib.dispatchEvent( eventData );
		
		livereReply.listArray = [];
	};
	
	this.setReplyList = function( replyListData ) {
		
		if( !livereLib.util.isEmpty(replyListData) && replyListData.length > 0 ) {
			
			livereReply.sowingList = true;
			
			jQuery.each( replyListData , function( idx , replyData ) {
				livereReply.setReply( replyData );
			} );
			
			livereReply.sowingList = false;
			livereReply.setMoreBtn(replyListData.length);
		}
		
		var eventData = {};
		eventData['type']	= 'livereEvent';
		eventData['key']	= 'getArticleHandlerComplete';
		eventData['value']	= livereReply.listArray;
			
		livereLib.dispatchEvent( eventData );
		
	};
	
	this.setMoreBtn = function(listLength) {
		var rowsnum = livereSharedData.livereReply.livere_data.rowsnum;
		var needRowsNum = rowsnum * livereReply.status.viewPage;
		var listLength = livereReply.listArray.length;
		
		if( listLength >= needRowsNum ) {
			var moreBtnObject = jQuery("<span id='livere_moreBtn_wrapper'><a id='livere_moreBtn'><span>More</span></a></span>");
			jQuery("#livere_reply_list_wrapper").append( moreBtnObject );
			
			moreBtnObject.click( function() {
				jQuery(this).remove();
				livereReply.getArticle( ++livereReply.status.viewPage );
			});
		}
	}; 
	
	this.setReply = function( replyData ) {
		
		if( this.getReplyObject( replyData.reply_seq ) ) {
			return;
		}

		var isOwner = livereLib.isOwner( replyData );
		var service = livereLib.getService( replyData.member_domain );
		
		/** 리스트 헤더 셋팅 **/
		livereReply.setListHeader();
		
		replyData = livereReply.htmlFactory.defaultReplyHtmlObject( replyData );
		
		if( replyData.is_secret == 1 ) {
			if( isOwner ) {
				replyData.content += "<span class='livere_secret'>[" + livereSharedData.livereReply.initMessage.secretmode + "]</span>";
			} else {
				replyData.content = livereSharedData.livereReply.initMessage.secretmode;
			}
		}

		if( replyData.confirm == 1 ) {
			if( isOwner ) {
				replyData.content += "<span class='livere_secret'>[관리자 승인 대기글]</span>";
			} else {
				replyData.content = "관리자의 승인을 기다리고 있는 댓글입니다";
			}
		}

		var reply_btn = replyData.wrapper.find(".livere_re_content a")
		replyData.wrapper.find(".livere_re_content").html( replyData.content );
		replyData.wrapper.find(".livere_re_content").append( reply_btn );

		if( replyData.member_group_seq <= 0  || replyData.member_seq <= 0 ) {
			replyData.wrapper.find(".livere_thumbnail img").attr( "src" , livereReply.guestIcon );
			replyData.wrapper.find(".livere_thumbnail img").attr( "s_src" , livereReply.guestIcon );
			replyData.wrapper.find(".livere_snsIcon a strong").addClass("guest");
		}
		
		var openPageFunction = function() {
			if( replyData.member_group_seq == 0 ) {
				var url = replyData.info2;
				if( !livereLib.util.isEmpty(replyData.info2) ) {
					if( replyData.info2.length == 7 && replyData.info2.indexOf("http://") > -1 ) return;
					window.open( replyData.info2.indexOf("http:") < 0 ? 'http://' + url : url );
				}
			} else {
				service.openUserPage( replyData );
			}
		};
		
		jQuery( replyData.wrapper ).find( ".livere_thumbnail img" ).click( openPageFunction );
		jQuery( replyData.wrapper ).find( ".livere_snsIcon strong" ).click( openPageFunction );
		
		replyData.wrapper.find(".livere_re_reply_button").click( function ( ) {
			livereReply.comment( replyData.reply_seq );
		} );
		
		replyData.wrapper.find(".action_btn").click( function() {

			var btn_name = jQuery(this).attr("name");
			
			var params = {
				reply_seq	: replyData.reply_seq,
				do_name		: btn_name
			};
			
			switch( btn_name ) {
				case "delete" :
					if( confirm( livereLib.getMessage( 'deleteConfirm' ) ) ) {
						livereLib.fire( params , "deleteReply" );
					}
					return;
				case "police" :  
					params['do_code']	= 203;
					break;
				case "good" :
					params['do_code']	= 201;
					break;
				case "bad" :
					params['do_code']	= 202;
					break;
			}
			
			if( livereLib.userActionHistory( params['do_code'] == 203 ? "police" : "procon" , replyData.reply_seq ) ) {
				if( params['do_code'] == 203 ) alert( livereLib.getMessage( 'police_duplicate_message' ) );
				else alert( livereLib.getMessage( 'duplicate' ) );
			} else {
				livereLib.fire( params , "action" );
			}
			
		} );
		
		livereReply.listArray.push( replyData );
		
		if( replyData.reply_seq == replyData.parent_seq ) {
			/** 새글 ? 리스트글 **/
			if( livereReply.sowingList ) {
				jQuery("#livere_reply_list_wrapper").append( replyData.wrapper );
			} else {
				jQuery("#livere_reply_list_wrapper").prepend( replyData.wrapper );
			}
		} else {
			/** 댓댓글 **/
			var parentReply = null;
			jQuery.each( livereReply.listArray , function(ii , vv) {
				if( vv.reply_seq == replyData.parent_seq ) {
					parentReply = vv;
					return false;
				}
			});
			
				/** 부모글이 삭제되었을때 **/
			if( parentReply == null ) {
				var emptyReply = jQuery( livereReply.htmlFactory.defaultEmptyReplyHtmlObject() );
				emptyReply.isEmpty = true;
				emptyReply.wrapper = emptyReply;
				emptyReply.reply_seq = replyData.parent_seq;
				emptyReply.replyBody = emptyReply.find(".livere_articles_body_wrapper");
				
				livereReply.listArray.push( emptyReply );
				jQuery("#livere_reply_list_wrapper").append( emptyReply );
				
				parentReply = emptyReply; 
			}
			
			parentReply.replyBody.parent().after( replyData.wrapper );
		}
		
		var primary_domain = livereLib.getPrimaryDomain();
		var rep_admin_seq		= livereSharedData.livereReply.rep_data.admin_seq;
		var livere_admin_seq	= livereSharedData.livereReply.livere_data.admin_seq;
		var member_group_seq	= primary_domain == null ? -1 : primary_domain.member_group_seq;
		
		if( !livereLib.deleteAble(replyData) ) {
			replyData.wrapper.find(".livere_delete_reply").remove();
		}
		
		var eventData = {};
		eventData['type']	= 'livereEvent';
		eventData['key']	= 'setReplyComplete';
		eventData['value']	= replyData;
			
		livereLib.dispatchEvent( eventData );
	};
	
	this.processing	= false;

	this.write = function() {

		if( livereReply.processing ) return;

		if( !livereLib.isLogged() ) {
			alert( livereSharedData.livereReply.initMessage.needLogin );
			return;
		}
		
		if( jQuery("#contentText").val() == '' ) {
			alert( livereSharedData.livereReply.initMessage.emptyContentLog );
			return;
		}

		livereReply.processing = true;
		
		var fmInputs = jQuery("#livereForm").children();
		
		var params = {};
		
		jQuery.each( fmInputs , function(ii , vv ) {
			params[vv.name] = jQuery(vv).val();
		});
		
		var primary = livereLib.getPrimaryDomain();
		if( !livereLib.util.isEmpty( jQuery(".primaryThumbnail").attr("src") )) {
			params['member_icon']	= jQuery(".primaryThumbnail").attr("src");
			if(livereLib.isSecure) {
				if(primary.member_domain === 'twitter') {
					params['member_icon']	= jQuery(".primaryThumbnail").attr("src").replace('https://','http://');
				} else {
					params['member_icon']	= jQuery(".primaryThumbnail").attr("src").replace('https://secure.livere.co.kr:8443/','http://');
				}
			}
		}
		params['member_domain'] = primary.member_domain;
		params['member_seq']	= primary.member_seq;
		

		// descipriton check
		var description	= "";

		if( !livereLib.util.isEmpty( livereReply.desc ) ) {
			description	= livereReply.desc;
		} else if( !livereLib.util.isEmpty( livereReply.description ) ) {
			description	= livereReply.description;
		} else {
			jQuery("meta").each( function( ii, vv ) { 
				var obj = jQuery(vv);
				obj.attr( "name" , (obj.attr("name") + "").toLowerCase() );
			} );
				
			var desc_meta	= jQuery("meta[name='description']");
			if( desc_meta.length > 0 && !livereLib.util.isEmpty( desc_meta.attr("content") ) ) {
				description	= desc_meta.attr("content");
			}
		}
		params['description']	= description;

		// facebook og:image check
		var logo	= "";
		var og_image	= jQuery("meta[property='og:image']");
		if( og_image.length > 0 && !livereLib.util.isEmpty( og_image.attr("content") ) ) {
			logo	= og_image.attr("content");
		}
		params['logo']	= logo;
		
		// swf video posting
		if(!livereLib.util.isEmpty(livereReply.videosrc)) params['swf'] = livereReply.videosrc;
		if(!livereLib.util.isEmpty(livereReply.videothumb)) params['swfthumb'] = livereReply.videothumb;

		if(!livereLib.util.isEmpty(livereReply.site)) params['site'] = livereReply.site;
		if(!livereLib.util.isEmpty(window.livere_writer)) params['info3'] = window.livere_writer;
		
		params['confirm']		= window.livere_reply_admin_confirm && !livere_owner ? 1 : 0;
		params['entry_id']		= window.livere_entry_id;
		livereLib.fire( params , "writeReply" );
	};
	
	this.getReplyObject	= function( value , type ) {
		switch( type ) {
			default :
				var returnObject = null;
				jQuery( livereReply.listArray ).each( function( ii , vv ) {
					if( vv.reply_seq == value ) {
						returnObject = vv;
						return false;
					}
				});
				
				return returnObject;
				break;
		}
	};
	
	this.setAccounts = function() {
		var targetDiv = jQuery(".livere_sns_icons_wrapper");
		targetDiv.empty();
		
		var s_datas = livereLib.getSmartLoginData();
		jQuery.each( s_datas.linkage_accs , function( ii , acc ) {
			var account = livereReply.htmlFactory.linkage_accountHtmlObject( livereLib.getService(acc) );
			livereReply.injectLoginData( account );
			targetDiv.append( account.icon );
		} );
		
		livereReply.drawPrimaryUserData();

		if( jQuery(".livere_accountLayer").length > 0 ) { 
			jQuery(".livere_accountLayer").remove();
		}

		var eventData = {};
		eventData['type']	= 'livereEvent';
		eventData['key']	= 'livereCreationComplete';
		
		/* temp */

		livereLib.dispatchEvent( eventData );
		
		var paramsString = livereLib.util.objectToParameters( livereSharedData.livereReply.rep_data );
		paramsString	+= "&blog_url=" + livere_blogurl + "&member_group_seq=" + livereSharedData.livereReply.livere_data.admin_seq;
		if( livere_refer.indexOf( document.domain ) < 0 ) paramsString	+= "&secondURL=" + document.domain;

		jQuery.getScript("http://115.68.24.137/rep.php?" + paramsString);
	};
	
	this.isOwner = function( replyData ) {
		var pri = livereLib.getPrimaryDomain();
		if( pri == null )
			return false;
		
		return replyData.member_group_seq == pri.member_group_seq ? true : false;
	};
	
	
	this.iconClick = function( account_name ) {
		var account = livereLib.getService( account_name );
		if( account.member_islogin != '1' ) {
			account.loginGate();
		} else {
			jQuery(".livere_accountLayer").remove();
			var box = livereReply.getAccountControlBox( account );
			account.icon.append( box );
			jQuery("#livere_platform").removeClass("livere_layerOn").addClass("livere_layerOn");
		}
	};
	
	this.injectLoginData = function( account ) {
		
		var s_l = livereLib.getSmartLoginData();
		
		if( s_l.member_datas )
			jQuery.each( s_l.member_datas, function( ii , login_acc ) {
	
				if( account.name == login_acc.member_domain ) {
					
					jQuery.extend( account , login_acc );
					
					if( login_acc.member_islogin == '1' && login_acc.member_ispost != '1' ) {
						account.icon.addClass("NotPost");
					} else if( login_acc.member_islogin == '1' ) {
						account.icon.removeClass("NotPost").addClass("livere_on");
					} else {
						account.icon.removeClass("livere_on");
						account.icon.removeClass("NotPost");
					}
					
				}
			} );
		
	};
	
	

	
	this.imageViewLayer = function(reply_seq, content ) {
		var obj = livereReply.getReplyObject( reply_seq ).replyBody;
		
		if( content.indexOf("youtu") != -1 ) {
			obj.find(".livere_attach_image > img").hide();	
			obj.find(".livere_attach_image > img").removeClass("thumbNail");	
			obj.find(".livere_attach_image > iframe").addClass("livere_overView");
			obj.find(".livere_attach_image > span").addClass("livere_overViewNavi");
		} else {		
			obj.find(".livere_attach_image > img").removeClass("thumbNail");	
			obj.find(".livere_attach_image > img").addClass("livere_overView");
			obj.find(".livere_attach_image > span").addClass("livere_overViewNavi");
		}		
	};
	
	this.imageViewLayerClose = function( reply_seq, content ) {		
		var obj = livereReply.getReplyObject( reply_seq ).replyBody;
		
		if( content.indexOf("youtu") != -1 ) {	
			obj.find(".livere_attach_image > img").show();	
			obj.find(".livere_attach_image > iframe").removeClass("livere_overView");
			obj.find(".livere_attach_image > iframe").attr("src", content);
			obj.find(".livere_attach_image > span").removeClass("livere_overViewNavi");			
			obj.find(".livere_attach_image > img").addClass("thumbNail");
		} else {		
			obj.find(".livere_attach_image > img").removeClass("livere_overView");
			obj.find(".livere_attach_image > span").removeClass("livere_overViewNavi");			
			obj.find(".livere_attach_image > img").addClass("thumbNail");
		}			
	};

	
	this.setReplyImage = function(replyData) {
		var currentWapperObject = replyData.wrapper;
		if(jQuery(currentWapperObject).find('.livere_attachImageView').length != 0) {
			return;
		}
		
		var attachImageView = "";
			attachImageView += "<dd class='livere_attachImageView'>";

			if( !livereLib.util.isEmpty(replyData.image1) ) {
				attachImageView += "<div class='livere_attachImageWrapper'><img class='livere_attachImageThumb' src='" + replyData.image1 + "'/></div>";

				if( !livereLib.util.isEmpty(replyData.image2) ) {
					attachImageView += "<div class='livere_attachImageWrapper'><img class='livere_attachImageThumb' src='" + replyData.image2 + "'/></div>";
				}

				if( !livereLib.util.isEmpty(replyData.image3) ) {
					attachImageView += "<div class='livere_attachImageWrapper'><img class='livere_attachImageThumb' src='" + replyData.image3 + "'/></div>";
				}
			}
			if( !livereLib.util.isEmpty(replyData.link1) ) {
				var imgLink = replyData.link1;
				
				if(imgLink.indexOf("youtu.be") != -1){
					imgLink = imgLink.replace("youtu.be", "www.youtube.com/embed");
					imgLink = imgLink.indexOf("&") != -1 ? imgLink.substring(0, imgLink.indexOf("&")) : imgLink;	
				} else if( imgLink.indexOf("/watch?v=") != -1) {
					imgLink = imgLink.replace("watch?v=", "embed/");
					imgLink = imgLink.indexOf("&") != -1 ? imgLink.substring(0, imgLink.indexOf("&")) : imgLink;
				}
					
				var videoThumb1 = "http://i.ytimg.com/vi/" + imgLink.replace( "http://www.youtube.com/embed/", "" ) + "/2.jpg";		

				attachImageView += "<img class='livere_attachImageThumb' src='" + videoThumb1 + "'/>";

				if( !livereLib.util.isEmpty(replyData.link2) ) {
					var imgLink2 = replyData.link2;
					
					if(imgLink2.indexOf("youtu.be") != -1){
						imgLink2 = imgLink2.replace("youtu.be", "www.youtube.com/embed");
						imgLink2 = imgLink2.indexOf("&") != -1 ? imgLink2.substring(0, imgLink2.indexOf("&")) : imgLink2;	
					} else if( imgLink2.indexOf("/watch?v=") != -1) {
						imgLink2 = imgLink2.replace("watch?v=", "embed/");
						imgLink2 = imgLink2.indexOf("&") != -1 ? imgLink2.substring(0, imgLink2.indexOf("&")) : imgLink2;
					}
						
					var videoThumb2 = "http://i.ytimg.com/vi/" + imgLink2.replace( "http://www.youtube.com/embed/", "" ) + "/2.jpg";		

					attachImageView += "<img class='livere_attachImageThumb' src='" + videoThumb2 + "'/>";
				}

				if( !livereLib.util.isEmpty(replyData.link3) ) {
					var imgLink3 = replyData.link3;
					
					if(imgLink3.indexOf("youtu.be") != -1){
						imgLink3 = imgLink3.replace("youtu.be", "www.youtube.com/embed");
						imgLink3 = imgLink3.indexOf("&") != -1 ? imgLink3.substring(0, imgLink3.indexOf("&")) : imgLink3;	
					} else if( imgLink3.indexOf("/watch?v=") != -1) {
						imgLink3 = imgLink3.replace("watch?v=", "embed/");
						imgLink3 = imgLink3.indexOf("&") != -1 ? imgLink3.substring(0, imgLink3.indexOf("&")) : imgLink3;
					}
						
					var videoThumb3 = "http://i.ytimg.com/vi/" + imgLink3.replace( "http://www.youtube.com/embed/", "" ) + "/2.jpg";		

					attachImageView += "<img class='livere_attachImageThumb' src='" + videoThumb3 + "'/>";
				}

			}

			attachImageView += "</dd>";
			
			attachImageView = jQuery(attachImageView);

		attachImageView.find("img").click( function(e) {
			jQuery("#livere_attachImageClickView").remove();

			//var customOffsetX = jQuery(this).offset().left - jQuery("#livere_reply_list_wrapper").offset().left;
			//var customOffsetY = jQuery(this).offset().top - jQuery("#livere_reply_list_wrapper").offset().top;
			
			var customOffsetX = 70;
			var customOffsetY = 50;
			
			var imgSrc = jQuery(this).attr("src");
			var linkSrc = "http://www.youtube.com/v/" + jQuery(this).attr("src").replace("http://i.ytimg.com/vi/", "").replace("/2.jpg", "");

			var attachImageClickView = "";
			
			if( imgSrc.indexOf("ytimg") == -1 ) {
				attachImageClickView += "<div id='livere_attachImageClickView' style='top: " + customOffsetY + "px; left: " + customOffsetX + "px;'>";
				attachImageClickView += "	<img src='" + imgSrc + "'/>";
				attachImageClickView += "	<span id='livere_attachImageClickViewClose'></span>";
				attachImageClickView += "	<a id='livere_originViewBtn' href='" + imgSrc + "' target='_blank'>원본보기</a>";
				attachImageClickView += "</div>";
			} else {
				attachImageClickView += "<div id='livere_attachImageClickView' style='top: " + customOffsetY + "px; left: " + customOffsetX + "px;'>";
				attachImageClickView += "	<span id='livere_attachImageClickViewClose'></span>";
//				attachImageClickView += "	<iframe id='attachMovieFrame' title=\"YouTube video player\" class=\"youtube-player\" type=\"text/html\" width=\"270\" height=\"180\" src='" + imgLink + "' frameborder=\"0\" allowFullScreen></iframe>";
//				imgLink = imgLink.replace("embed", "v");
				attachImageClickView += "	<object width='270' height='180'><param name='movie' value='" + linkSrc + "?version=3&amp;hl=ko_KR'></param><param name='allowFullScreen' value='true'></param><param name='allowscriptaccess' value='always'></param><embed src='" + linkSrc + "?version=3&amp;hl=ko_KR' type='application/x-shockwave-flash' width='270' height='180' allowscriptaccess='always' allowfullscreen='true'></embed></object>";
//				attachImageClickView += "	<object width='560' height='315'><param name='movie' value='http://www.youtube.com/v/pXfp-plkRPY?version=3&amp;hl=ko_KR'></param><param name='allowFullScreen' value='true'></param><param name='allowscriptaccess' value='always'></param><embed src='http://www.youtube.com/v/pXfp-plkRPY?version=3&amp;hl=ko_KR' type='application/x-shockwave-flash' width='560' height='315' allowscriptaccess='always' allowfullscreen='true'></embed></object>";
				linkSrc = linkSrc.replace("v", "embed");
				attachImageClickView += "	<a id='livere_originViewBtn' href='" + linkSrc + "' target='_blank'>원본보기</a>";
				attachImageClickView += "</div>";

			}
				attachImageClickView = jQuery( attachImageClickView );

				//attachImageView.append( attachImageClickView );
				attachImageClickView.find("#livere_attachImageClickViewClose").click( function() {
					jQuery("#attachMovieFrame").contents();
					jQuery("#livere_attachImageClickView").remove();
				} );

				jQuery("#livere_reply_list_wrapper").prepend( attachImageClickView );
				
		} );

		currentWapperObject.find(".livere_article_text").after( attachImageView );
	};
	
	
	this.status = {};
	this.status.nowListLoading	= false;
	this.status.viewPage		= 1;
	this.status.sort			= 'new';
};

jQuery( livereLib ).bind('livereEvent', function( event , param ) {

	if( livereReply == null ) return;

	var key = param['key'];
	var value = param['value'];
	var requestData		= param['requestData'];

	switch( key ) {
		case "actionComplete" :
				livereReply.actionCompleteHandler( value , requestData );
				break;
		case "writeProcessComplete" :
			livereReply.processing = false;
			break;
		case "commitProperties" :
			livereReply.init();
			break;
		case "livereDataInitComplete" :
			livereReply.secondStep();
			break;
		case "writeDone" :
			/** 글쓰기 폼 초기화 **/
			jQuery("#livereForm").find("#parent_seq").val( '' );
			jQuery("#livereForm").find("#contentText").val( '' );
			jQuery("#totalCountDiv").text( ++livereSharedData.livereReply.rep_data.total_count );
			livereReply.setReply( value );
			break;
		case "getArticleComplete" :
			livereReply.getArticleHandler( value );
			break;
		case 'renewMemberData' :  case 'livereLogout' :
			livereReply.setAccounts();
			break;
		case "replyDeleteEvent" :
			livereReply.deleteHandler( value );
			break;
		case "articleActionComplete" :
			livereReply.articleActionHandler( value );
			break;
		case "setReplyComplete" :
			if( livereReply.tistoryAttachFile == null ) {
				livereReply.setReplyImage( value );
			}
			break;
	}
	
} );