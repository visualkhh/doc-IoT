jQuery.fn.trim = function(str) {
	return typeof(str) == 'string' ? str.replace(/^\s\s*/, '').replace(/\s\s*$/, '') : '';
};
// var serviceArray = [ twitter , me2day , facebook , yozm , cyworld , tistory , guest , mk , ibk , dt , khan , nocut , asiae , hankyung , open_y_jp , open_y , mixi , dtnews , moamoney , stoo , fnnews , mbn , lge , busan , kukinews , homeplus , newshankuk , betanews , gonggamkr , m25 , yes24 , cocofun , sejongpac , tenniskorea , yeongnamilbo , yonhapnews , cfe , ditto, ytn , rapportian , kyobobook , samsungmyanycar , asiae_er , asiae10 , samsungwebzine , funkia , habitatkorea , madeinu , naseoul, speedmate , qua , mkapp , greengrowth , nocuthealth , hk , relief , samsungseri, lgcyking, guro, seoul, newstalk, kangnara, ibk_give]; 
LivereLib = function() {
	
	this.livere_commons	= {
		yozm			: { name : 'yozm' },
		twitter			: { name : 'twitter' },
		me2day			: { name : 'me2day' },
		facebook		: { name : 'facebook' },
		cyworld			: { name : 'cyworld' },
		tistory			: { name : 'tistory' },
			open_y_jp	: { 
							name : 'open_y_jp',
							loginGate	: function() {
								window.open( livereLib.util.getLoginPageURL("openid") + "&name=" + open_y_jp.name );
							} 
						  },
			open_y		: { 
							name : 'open_y',
							loginGate	: function() {
								window.open( livereLib.util.getLoginPageURL("openid") + "&name=" + open_y.name );
							} 
						  },
		mixi			: { name : 'mixi' },
		mk				: { name : 'mk' },
		ibk				: { name : 'ibk' },
		dt				: { name : 'dt' },
		guest			: { name : 'guest' },
		moamoney		: { name : 'moamoney' },
		dtnews			: { name : 'dtnews' },
		khan			: { name : 'khan' },
		nocut			: { name : 'nocut' },
		asiae			: { name : 'asiae' },
		hankyung		: { name : 'hankyung' },
		stoo			: { name : 'stoo' },
		fnnews			: { name : 'fnnews' },
		mbn				: { name : 'mbn' },
		lge				: { name : 'lge' },
		busan			: { name : 'busan' },
		kukinews		: { name : 'kukinews' },
		homeplus		: { name : 'homeplus' },
		newshankuk		: { name : 'newshankuk' },
		betanews		: { name : 'betanews' },
		gonggamkr		: { name : 'gonggamkr' },
		m25				: { name : 'm25' },
			yes24		: { 
							name : 'yes24',
							openUserPage	: function( replyData ) {
								window.open("http://blog.yes24.com/blog/blogMain.aspx?blogid=" + replyData.member_id);
							} 
						  },
		cocofun			: { name : 'cocofun' },
		sejongpac		: { name : 'sejongpac' },
		tenniskorea		: { name : 'tenniskorea' },
		yeongnamilbo	: { name : 'yeongnamilbo' },
		yonhapnews		: { name : 'yonhapnews' },
		cfe				: { name : 'cfe' },
		ditto			: { name : 'ditto' },
		ytn				: { name : 'ytn' },
		rapportian		: { name : 'rapportian' },
		kyobobook		: { name : 'kyobobook' },
		samsungmyanycar	: { name : 'samsungmyanycar' },
		asiae_er		: { name : 'asiae_er' },
		asiae10			: { name : 'asiae10' },
		samsungwebzine	: { name : 'samsungwebzine' },
		funkia			: { name : 'funkia' },
		habitatkorea	: { name : 'habitatkorea' },
			madeinu		: { 
							name : 'madeinu',
							openUserPage	: function( replyData ) {
								window.open( "http://www.mywho.com/" + replyData.member_id );
							} 
						  },
		naseoul			: { name : 'naseoul' },
		speedmate		: { name : 'speedmate' },
		qua				: { name : 'qua' },
		kolon			: { name : 'kolon' },
		mkapp			: { name : 'mkapp' },
		greengrowth		: { name : 'greengrowth' },
		nocuthealth		: { name : 'nocuthealth' },
		hk				: { name : 'hk' },
		relief			: { name : 'relief' },
		samsungseri		: { name : 'samsungseri' },
		lgcyking		: { name : 'lgcyking' },
		guro			: { name : 'guro' },
		seoul			: { name : 'seoul' },
		newstalk		: { name : 'newstalk' },
		kangnara		: { name : 'kangnara' },
		ibk_give		: { name : 'ibk_give' },
		head			: { name : 'head' }	
	};
	
	jQuery.each( this.livere_commons , function( ii , vv ) {

		if( !vv.hasOwnProperty('loginGate') ) {
			vv.loginGate	= function() {
				window.open( livereLib.util.getLoginPageURL( vv.name ) );
			}
		}

		if( !vv.hasOwnProperty('openUserPage') ) {
			vv.openUserPage	= function(replyData) {
				if( !livereLib.util.isEmpty(replyData.member_url) )
					window.open( replyData.member_url );
			}
		}
	} );
	
	this.getService		= function( serviceName ) {
		return this.livere_commons.hasOwnProperty( serviceName ) ? this.livere_commons[serviceName] : null;
	};

	this.mergedMemberData = false;
	
	this.charset = typeof(document.charset) == "undefined" ? document.characterSet : document.charset;
	
	this.dispatchEvent = function( paramData ) {
		jQuery( this ).trigger(paramData['type'] , paramData);
	};
	
	var initDataRequest = false;
	this.dataInited = function() {
		if( !initDataRequest ) {
			initDataRequest = true;
			return false;
		}
		return initDataRequest;
	};
	
	this.isLogged = function() {
		
		if( !livereLib.mergedMemberData ) {
			livereLib.fire( null , "updateLinkAccData");
		}
		
		var s_datas = livereLib.getSmartLoginData();
		var returnFlag = false;
		if( s_datas ) {
			jQuery(	s_datas['linkage_accs'] ).each( function( ii , vv ) {
				if( livereLib.getService(vv).member_islogin == '1' ) returnFlag = true;
			} );
		}
		
		return returnFlag;
	};
	
	this.isOwner	= function( replyData ) {
		
		var m1	= replyData.member_group_seq;
		m1		= livereLib.util.isEmpty(m1) ? 0 : m1;
		var m2;

		if( !livereLib.mergedMemberData ) {
			livereLib.fire( null , "updateLinkAccData");
		}
		
		if( livereLib.isLogged() ) {
			var pri = livereLib.getPrimaryDomain();
			m2		= pri.member_group_seq;

			var a_array = [];
			a_array.push( m1 );
			
			var livere_data = livereSharedData.livereReply.livere_data;
			if( !livereLib.util.isEmpty(livere_data) ) {
				a_array.push( livere_data.admin_seq );
			}

			var rep_data	= livereSharedData.livereReply.rep_data;
			if( !livereLib.util.isEmpty(rep_data) ) {
				a_array.push( rep_data.admin_seq );
			}

			for(i=0;i<a_array.length;i++) {
				if( m2 == a_array[i] ) return true;
			}
		}
		return false;
	};

	this.deleteAble	= function( replyData ) {
		
		var m1	= replyData.member_group_seq;
		m1		= livereLib.util.isEmpty(m1) ? 0 : m1;
		var m2;

		if( m1 == 0 ) return true;

		if( !livereLib.mergedMemberData ) {
			livereLib.fire( null , "updateLinkAccData");
		}
		
		if( livereLib.isLogged() ) {
			var pri = livereLib.getPrimaryDomain();
			m2		= pri.member_group_seq;

			var a_array = [];
			a_array.push( m1 );
			
			var livere_data = livereSharedData.livereReply.livere_data;
			if( !livereLib.util.isEmpty(livere_data) ) {
				a_array.push( livere_data.admin_seq );
			}

			var rep_data	= livereSharedData.livereReply.rep_data;
			if( !livereLib.util.isEmpty(rep_data) ) {
				a_array.push( rep_data.admin_seq );
			}

			for(i=0;i<a_array.length;i++) {
				if( m2 == a_array[i] ) return true;
			}
		}
		return false;
	};
	
	this.isPrimary = function( member_seq ) {
		
		if( !livereLib.mergedMemberData ) {
			livereLib.fire( null , "updateLinkAccData");
		}
		var s_datas = livereLib.getSmartLoginData();
		if( typeof(s_datas) == 'object' ) {
			var group_data = s_datas['group_data'];
			return group_data.primary_member_seq == member_seq;
		} else
			return false;
	};
	
	this.fire	= function( params , commands ) {
		params = params == null ? {} : params;
		if( commands == 'customAPI' ) {
			livereLib.control.customAPI( params );
		} else {
			var fun = eval( "livereLib.control." + commands );
			if( typeof(fun) == 'function' ) {
				params['command'] = commands;
				fun( params );
			}
		}
	};
	
	this.setRedirectPath	= function() {
		if( typeof( livereLib.redirect_path ) == 'string' ) {
			livereSharedData.smartLogin.redirect_path = encodeURIComponent( livereLib.redirect_path );
		} else {
			if( typeof(livereSharedData.smartLogin.redirect_path) == 'string' ) {
				livereSharedData.smartLogin.redirect_path	= livereSharedData.smartLogin.redirect_path;
			} else {
				livereSharedData.smartLogin.redirect_path	= encodeURIComponent(window.location.href);
			}
		}
	};

	
	this.smartLoginInited = false;
	this.start	= function( callbackFunction ) {
		// return false;
		if( livereLib.smartLoginInited ) {
			if( typeof(callbackFunction) == 'function' ) {
				callbackFunction();
			}
			return;
		}
		
		livereLib.smartLoginInited = true;
		livereLib.setRedirectPath();
		
		livereSharedData.smartLogin.smartlogin_seq	= 33;
		livereSharedData.common.consumer_seq		= 29;
		
		var request = livereLib.url( "smartlogin" );
		
		jQuery.getJSON( request , function(data) {
			
			var result = livereLib.util.toJson( data );
			
			livereSharedData.smartLogin.datas = result.resultData;
			livereLib.fire( null , "updateLinkAccData" );
			
			var eventData = {};
			eventData['type']	= 'livereEvent';
			eventData['key']	= 'commitProperties';
			eventData['value']	= 'smartlogin';
			
			livereLib.dispatchEvent( eventData );
			
			if( typeof(callbackFunction) == 'function' ) {
				callbackFunction();
			}

		} );
	};
	
	this.livereInited = false;
	this.initLivereReply	= function( params ) {
		if( livereLib.livereInited ) return;
		livereLib.livereInited = true;
		
		var request = livereLib.url( "livereDataLoad" , params );
		 jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );

			livereSharedData.livereReply.managers		= result['MANAGERS'];
			livereSharedData.livereReply.livere_data	= result['LIVERE'];
			livereSharedData.livereReply.plugin_data	= result['PLUGINS'];
			livereSharedData.livereReply.rep_data		= result['REP'];
			livereSharedData.livereReply.reply_data		= result['RE_LIST'];
			livereSharedData.livereReply.initMessage	= result['initMessage'];
			
			var fun = function() {
				var eventData = {};
				eventData['type']	= 'livereEvent';
				eventData['key']	= 'livereDataInitComplete';
				eventData['value']	= 'livereReply';
				
				livereLib.dispatchEvent( eventData );
			};
			
			livereLib.fire( fun , "pluginLoad" ); 
		} );
	};

	this.renewLivere	= function( n_refer, n_title ) {
		livere_refer	= n_refer;
		livere_title		= n_title;

		jQuery("#livereContainer > *").remove();

		livereLib.livereInited = false;
		livereLib.smartLoginInited = false;
		livereSharedData.livereReply.rep_data = null;
		livereReply = new Livere( livere_livere_seq , livere_refer, livere_title );
		livereReply.tistoryReplySync = new Livere_TistoryReplySync();
		livereLib.start();
	};
	
	this.control = {};
	
	this.control.pluginLoad			= function( callbackFunction ) {
		
		if( livereLib.util.isEmpty(livereSharedData.livereReply.plugin_data) && livereLib.util.isEmpty(livereSharedData.livereReply.livere_data.custom_script_path) ) {
			callbackFunction();
			return;
		}
		
		if( livereLib.util.isEmpty(livereSharedData.livereReply.plugin_data) )
			livereSharedData.livereReply.plugin_data = [];
		
		if( !livereLib.util.isEmpty( livereSharedData.livereReply.livere_data.custom_script_path ) )
			livereSharedData.livereReply.plugin_data.push( {script_path	: livereSharedData.livereReply.livere_data.custom_script_path} ); 
		
		var loaded_plugin_length = 0;
		var plugin_length = livereSharedData.livereReply.plugin_data.length;

		jQuery( livereSharedData.livereReply.plugin_data ).each( function( ii , vv ) {

			if( vv.css_path != '' ) livereLib.cssLoad( vv.css_path );
			if( vv.custom_css_path != '' ) livereLib.cssLoad( vv.custom_css_path );

			jQuery.getScript( vv.script_path , function() {
				var var_id = vv.id;
				var plugin = eval("livereReply." + var_id);

				if( plugin ) {
					if( vv.param_data != '' ) {
						var params = vv.param_data.split(",");
						jQuery(params).each( function( xx , vals ) {
							var value = eval( "vv.param" + (xx+1) );
							eval( "livereReply." + var_id + "." + vals + " = '" + value + "';" );
						} );
					}

					if( vv.plugin_type == 'object' || typeof(plugin.init) == 'function' ) {
						plugin.init();
					}
					
				}
				
				
				if( ++loaded_plugin_length >= plugin_length ) {
					callbackFunction();
				}
			} );
		} );
		
		
	};
	this.control.action				= function( params ) {
		params = params == null ? {} : params;
		
		var request = livereLib.url( "API_Livere" , params );
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			
			var eventData = {
				type		: "livereEvent",
				key			: "actionComplete",
				value		: result,
				requestData	: params
			};
			
			livereLib.dispatchEvent( eventData );
		} );
	};
	this.control.customAPI			= function( params ) {
		params = params == null ? {} : params;
		
		var callbackFun = params['callback'];
		var eventKeyStr = params['eventKey'];
		
		params['callback'] = null;
		
		var request = livereLib.url( "API_Livere" , params );
		
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			if( !livereLib.util.isEmpty( callbackFun ) ) {
				var fun = eval( callbackFun );
				fun( data );
			}
			if( !livereLib.util.isEmpty( eventKeyStr ) ) {
				var eventData = {};
				eventData['type']	= 'livereEvent';
				eventData['key']	= eventKeyStr;
				eventData['value']	= result;
				
				livereLib.dispatchEvent( eventData );
			}
		});
	};
	this.control.snsAction			= function( params ) {
		params = params == null ? {} : params;
		
		var request = livereLib.url( "API_Livere" , params );
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			
			var eventData = {};
			eventData['type']	= 'livereEvent';
			eventData['key']	= 'snsActionComplete';
			eventData['value']	= result;
			
			livereLib.dispatchEvent( eventData );
		} );
	};
	this.control.searchMemberData	= function( params ) {
		params = params == null ? {} : params;
		
		var request = livereLib.url( "API_Livere" , params );
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			
			var eventData = {};
			eventData['type']	= 'livereEvent';
			eventData['key']	= 'searchMemberDataComplete';
			eventData['value']	= result;
			
			livereLib.dispatchEvent( eventData );
		} );
	};
	this.control.getExCount			= function( params ) {
		params = params == null ? {} : params;
		var url = "http://count.livere.co.kr/getCount.php?livereCallBack=?&type=" + params['type'];
		url		+= "&" + params['key'] + "=" + params['value'];

		jQuery.getJSON( url , function(data) {
			var eventData = {};
			eventData['type']	= 'livereEvent';
			eventData['key']	= 'getExCountComplete';
			eventData['value']	= data;
			
			livereLib.dispatchEvent( eventData );
		} );
	};
	this.control.plusExCount		= function( params ) {
		params = params == null ? {} : params;
		var url = "http://count.livere.co.kr/plusCount.php?livereCallBack=?&type=" + params['type'];
		url		+= "&" + params['key'] + "=" + params['value'] + "&plus=" + params['plus'];
		
		jQuery.getJSON( url , function(data) {
			var eventData = {};
			eventData['type']	= 'livereEvent';
			eventData['key']	= 'plusExCountComplete';
			eventData['value']	= data;
			
			livereLib.dispatchEvent( eventData );
		} );
	};
	this.articleActionFlag	= false;
	this.control.articleAction		= function( params ) {
		
		if( livereLib.articleActionFlag ) return;
		livereLib.articleActionFlag	= true;

		params = params == null ? {} : params;
		
		var request = livereLib.url( "API_Livere" , params );
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			
			result['reply']		= params['reply'];

			var eventData = {};
			eventData['type']	= 'livereEvent';
			eventData['key']	= 'articleActionComplete';
			eventData['value']	= result;
			
			livereLib.dispatchEvent( eventData );

			livereLib.articleActionFlag = false;
		} );
	};
	this.control.deleteReply		= function( params ) {
		
		params = params == null ? {} : params;
		
		params['command'] = 'deleteReply';
		
		var request = livereLib.url( "API_Livere" , params );
		
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			result['reply']	= livereReply.getReplyObject( params.target_seq );

			var eventData = {};
			eventData['type']	= 'livereEvent';
			eventData['key']	= 'replyDeleteEvent';
			eventData['value']	= result;
			
			livereLib.dispatchEvent( eventData );
		} );
	};
	
	this.control.changeUserData		= function( params ) {
		var request = livereLib.url( "API_Livere" , params );
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			livereSharedData.smartLogin.datas = result.resultData;
			
			livereLib.fire( null , "updateLinkAccData" );
			
			var eventData = {};
			eventData['type']	= 'livereEvent';
			eventData['key']	= 'renewMemberData';
			eventData['value']	= 'fin';
			
			livereLib.dispatchEvent( eventData );
		});
	};
	
	this.control.serviceLogout		= function( params ) {
		
		params = params == null ? {} : params;
		var request = livereLib.url( "API_Livere" , params );
		
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			if( result.result == '200' ) {
				
				if( result.command == 'clearLoginData' ) {
					livereSharedData.smartLogin.datas.accessable_group_data = null;
					
					jQuery( livereSharedData.smartLogin.datas.linkage_accs ).each( function( ii , vv ) {
						livereLib.getService( vv ).member_islogin = '0';
					} );
					
					var eventData = {};
					eventData['type']	= 'livereEvent';
					eventData['key']	= 'livereLogout';
					eventData['value']	= 'fin';
					
					livereLib.dispatchEvent( eventData );
				} else {
					livereSharedData.smartLogin.datas = result.resultData;
					livereLib.fire( null , "updateLinkAccData" );
					
					var eventData = {};
					eventData['type']	= 'livereEvent';
					eventData['key']	= 'renewMemberData';
					eventData['value']	= 'fin';
					
					livereLib.dispatchEvent( eventData );
				}
					
			} else {
				livereLib.control.checkError( result );
			}
			
		} );
		
	};
	this.control.setPosting		= function( params ) {
		params = params == null ? {} : params;
		var request = livereLib.url( "API_Livere" , params );
		
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			if( result.result == '200' ) {
				
				livereSharedData.smartLogin.datas = result.resultData;
				livereLib.fire( null , "updateLinkAccData" );
				
				var eventData = {};
				eventData['type']	= 'livereEvent';
				eventData['key']	= 'renewMemberData';
				eventData['value']	= 'fin';
				
				livereLib.dispatchEvent( eventData );
			} else {
				livereLib.control.checkError( result );
			}
		} );
	};
	this.control.setPrimary		= function( params ) {
		params = params == null ? {} : params;
		
		var request = livereLib.url( "API_Livere" , params );
		
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			if( result.result == '200' ) {
				livereSharedData.smartLogin.datas = result.resultData;
				livereLib.fire( null , "updateLinkAccData" );
				
				var eventData = {};
				eventData['type']	= 'livereEvent';
				eventData['key']	= 'renewMemberData';
				eventData['value']	= 'fin';
				
				livereLib.dispatchEvent( eventData );
			} else {
				livereLib.control.checkError( result );
			}
		} );
	};

	this.control.livereLogout	= function( params ) {
		params = params == null ? {} : params;
		
		var request = livereLib.url( "API_Livere" , params );
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			if( result.result == '200' ) {
				livereSharedData.smartLogin.datas.accessable_group_data = null;
				
				jQuery( livereSharedData.smartLogin.datas.linkage_accs ).each( function( ii , vv ) {
					livereLib.getService( vv ).member_islogin = '0';
				} );
				
				var eventData = {};
				eventData['type']	= 'livereEvent';
				eventData['key']	= 'livereLogout';
				eventData['value']	= 'fin';
				
				livereLib.dispatchEvent( eventData );
			} else {
				livereLib.control.checkError( result );
			}
		} );
	};
	
	this.control.renewMemberData = function( params ) {
		params = params == null ? {} : params;
		params['command'] = 'sessionLogin';
		
		var request = livereLib.url( "API_Livere" , params , true );
		jQuery.getJSON( request , livereLib.control.renewMemberProcess );
	};
	
	this.control.renewMemberProcess = function( params ) {
		var result = livereLib.util.toJson( params );
		livereSharedData.smartLogin.datas = result.resultData;
		
		livereLib.fire( null , "updateLinkAccData" );
		
		var eventData = {};
		eventData['type']	= 'livereEvent';
		eventData['key']	= 'renewMemberData';
		eventData['value']	= 'fin';
		
		livereLib.dispatchEvent( eventData );
	};
	
	this.control.updateLinkAccData = function() {
		
		var smartlogindata = livereLib.getSmartLoginData();
		
		if( smartlogindata != null ) {
			var group_data		= smartlogindata['group_data'];
			var linkage_accs	= smartlogindata['linkage_accs'];
			
			if( group_data != null ) {
				
				var member_datas	= group_data['member_datas'];
				
				jQuery( linkage_accs ).each( function( ii , linked_acc ) {
					linked_acc = livereLib.getService(linked_acc);
					jQuery( member_datas ).each( function ( ii , login_acc ) {
						if( linked_acc.name == login_acc.member_domain ) {
							jQuery.extend( linked_acc , login_acc );
							livereLib.mergedMemberData = true;
						}
					} );
				} );
			}
		}
		
	};
	
	this.control.writeReply = function( params ) {
		var request = livereLib.url( "API_Livere" , params );
		
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			if( result.result == '200' ) {
				
				var reply = result.resultData;
				livereSharedData.livereReply.rep_data.rep_seq = reply.rep_seq;
				reply.regdate = result.requestDate;
				
				var eventData = {};
				eventData['type']	= 'livereEvent';
				eventData['key']	= 'writeDone';
				eventData['value']	= reply;
				
				livereLib.dispatchEvent( eventData );
				
			} else {
				alert( result.message );
			}

			livereLib.dispatchEvent( {
				type	: 'livereEvent',
				key		: 'writeProcessComplete',
				value	: reply
			} );
		} );
	};
	
	// @deprecated
	this.control.checkError = function( result ) {
		return;
	};
	
	this.control.relationAction = function( params ) {
		var request = livereLib.url( "API_Livere" , params );
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			
			var eventData = {};
			eventData['type']	= 'livereEvent';
			eventData['key']	= 'relationComplete';
			eventData['value']	= result;
			
			livereLib.dispatchEvent( eventData );
		} );
	};
	
	this.control.getCount	= function( params ) {
		var request = livereLib.url( "API_Livere" , params );
		
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			if( result.result == '200' ) {
				
				var replyData = result.resultData;
				
				var eventData = {};
				eventData['type']	= 'livereEvent';
				eventData['key']	= 'getCountComplete';
				eventData['value']	= replyData;
				
				livereLib.dispatchEvent( eventData );
			}
		});
	};
	this.control.getArticle = function( params ) {
		var request = livereLib.url( "API_Livere" , params );
		
		jQuery.getJSON( request , function(data) {
			var result = livereLib.util.toJson( data );
			var replyData = result.resultData;
			
			var eventData = {};
			eventData['type']	= 'livereEvent';
			eventData['key']	= 'getArticleComplete';
			eventData['value']	= replyData;
			
			livereLib.dispatchEvent( eventData );
		});
	};
	
	this.initRepData = function() {
		params = {
				refer : livere_refer,
				title : livere_title,
				command : 'initRepData'
		};
		var request = livereLib.url( "API_Livere" , params );
		jQuery.getJSON( request );
	};
	
	this.smartloginInit	= function() {
		if( !livereLib.dataInited() ) {
			
			livereLib.setRedirectPath();
			
			var params = {
				redirect_path	: livereSharedData.smartLogin.redirect_path, 
				smartlogin_seq	: smartlogin_seq, 
				consumer_seq	: livere_consumer_seq
			};
			
			livereLib.fire( params , "smartLoginStart" );
		}
	};
	
	this.getReply	= function( reply_seq ) {
		return livereReply.getReplyObject( reply_seq );
	};
	
	// @deprecated
	this.getMemberDataByServiceName = function( serviceName ) {
		return livereLib.getService( serviceName );
	};
	
	this.getSmartLoginData = function() {
		var u_data = livereSharedData.smartLogin.datas;
		if( u_data != null ) {
			var returnObject = {
					linkage_accs	: u_data.linkage_accs,
					group_data		: u_data.accessable_group_data,
					member_datas	: u_data.accessable_group_data ? u_data.accessable_group_data.member_datas : null, 
					sync_type		: u_data.sync_type,
					sync_acc		: u_data.sync_acc,
					button_container: u_data.button_container,
					view_container	: u_data.view_container, 
					checkurl		: u_data.checkurl,
					loginurl		: u_data.loginurl,
					logouturl		: u_data.logouturl
			};
			return returnObject;
		}
		return null;
	};

	this.readyObject	= function( objName ) {
		var obj = navigator.appName.indexOf("Microsoft") != -1 ? window[objName] : window.document[objName];
		if( typeof(obj.startWithPrimaryData) == 'function' ) {
			obj.startWithPrimaryData( livereLib.getPrimaryDomain() );
		}
	};
	
	this.debug = function( obj ) {
		livereLib.util.debug( obj );
	};
	
	this.alert	= function( obj ) {
		txtValue = "";
		
		if( typeof(obj) == 'string' ) {
			txtValue = obj;
		} else {
			obj = eval( obj );
			
			for(var x in obj) { txtValue += [x, obj[x]]+"\n\r\n"; }
		}
		
		alert( txtValue );
	};
	
	this.getPrimaryDomain = function() {
		var domain_object = null;
		var s_l = livereLib.getSmartLoginData();
		
		if( s_l != null && s_l.member_datas != null ) {
			var prim_mem_seq = s_l.group_data.primary_member_seq;
			jQuery.each( s_l.member_datas , function( ii , vv ) {
				if( vv.member_seq == prim_mem_seq ) {
					domain_object = livereLib.getService( vv.member_domain );
					return false;
				}
			} );
			return domain_object;
		}
		return null;
	};
	
	this.getPrimaryDomainToString = function() {
		var data = livereLib.getPrimaryDomain();
		if( data == null ) return "";
		var str = "";
			str	+= "{";
			str	+= "'member_domain':'" + data.member_domain + "' ,";
			str += "'member_group_seq' : '" + data.member_group_seq + "',";
			str += "'member_icon': '" + data.member_icon + "',";
			str += "'member_name': '" + data.member_name + "',";
			str += "'member_id': '" + data.member_id + "',";
			str += "'member_islogin': '" + data.member_islogin + "',";
			str += "'member_ispost': '" + data.member_ispost + "' ,";
			str += "'member_seq': '" + data.member_seq + "' ,";
			str += "'member_pw': '" + data.member_pw + "'"; 
			str += "}";
		return str;
	};
	
	
	this.request	= function( params , callback ) {
		var url = params['url'];
		params['url'] = null;
		var paramsString = livereLib.util.objectToParameters( params );
		var requestURL = url + "?" + paramsString + "&livereCallBack=?&dummy=" + Math.random();
		jQuery.getJSON( requestURL , function(data) {
			if( typeof(callback) == 'function' ) callback(data);
		} );
	};
	
	
	this.url = function( urlAddon , params ) {
		urlAddon = this.getUrl( urlAddon );
		
		var paramsString = "";
		
		if( params != null ) {
			paramsString = livereLib.util.objectToParameters( params ); 
		}
		
		paramsString = paramsString == "" ? "?" : paramsString +"&";
		paramsString += "dummy=" + Math.random() + "&livereCallback=?";
		
		if( paramsString.indexOf("smartlogin_seq=") < 0 && livereSharedData.smartLogin.smartlogin_seq )
			paramsString += "&smartlogin_seq=" + livereSharedData.smartLogin.smartlogin_seq;
		
		if( paramsString.indexOf("consumer_seq=") < 0 )
			paramsString += "&consumer_seq=" + livereSharedData.common.consumer_seq;
		
		if( paramsString.indexOf("rep_seq=") < 0 && livereSharedData.livereReply.rep_data )
			paramsString += "&rep_seq=" + livereSharedData.livereReply.rep_data.rep_seq;
		
		if( paramsString.indexOf("livere_seq=") < 0 && livereSharedData.livereReply.livere_seq )
			paramsString += "&livere_seq=" + livereSharedData.livereReply.livere_seq;
		
		if( paramsString.indexOf("?") == 0 ) {
			paramsString = paramsString.substring(1);
		}
		
		return livereSharedData.url + "/" + urlAddon + "?" + paramsString;
	};

	this.normalUrl = function( url , param ) {
		url = "http://" + url;
		var paramsString = livereLib.util.objectToParameters( params );
		if( paramsString != "" )
			return url += "?" + paramsString;
		return url;
	};

	this.getUrl = function( val ) {
		var charset = this.charset.toUpperCase();
		var flag = ( charset == "UTF-8" || charset == "UTF8" || charset == "UTF" );
		
		switch( val ) {
			case "upload" :
				return flag ? val : "upload_kr";
			case "livereDataLoad" :
				return flag ? val : "livereDataLoad_kr";
			case "smartlogin" :
				return flag ? val : "smartlogin_kr";
			case "API_Livere" :
				return flag ? val : "API_Livere_kr";
			case "External_Auth_API" :
				return flag ? val : "External_Auth_API_kr";
				
			default :
				return val;
		}
	};
	
	//TODO cache
	this.cssLoad	= function( cssPath ) {
		if( livereLib.util.isEmpty(cssPath) ) return;
		jQuery("<link rel='stylesheet' type='text/css' href='" + cssPath + "'>").appendTo("head");
	};

	this.setRegdate	= function( reply ) {
		reply.reply_regdate = reply.regdate.year + 1900 + "-" + livereLib.util.addZero( parseInt(reply.regdate.month) + 1 ) + "-" + livereLib.util.addZero(reply.regdate.date);
		reply.reply_regdate += " " + livereLib.util.addZero(reply.regdate.hours) + ":" + livereLib.util.addZero(reply.regdate.minutes) + ":" + livereLib.util.addZero(reply.regdate.seconds);
	};
	this.getMessage		= function( messageKey ) {
		var message = null;
		if( !livereLib.util.isEmpty(window.livereCustomMessage) ) {
			message = eval( "window.livereCustomMessage." + messageKey );
		}
		message = livereLib.util.isEmpty(message) ? eval("livereSharedData.livereReply.initMessage." + messageKey) : message;
		message	= message.replace("\\r"," ");
		message	= message.replace("\\n"," ");
		return message;
	};
	
	this.userActionHistoryArrays = {};
	this.userActionHistory	= function( type , seq ) {
		var arrObject = eval( "livereLib.userActionHistoryArrays." + type );
		if( !arrObject ) {
			arrObject = eval( "livereLib.userActionHistoryArrays." + type + " = Array();" );
		}

		var result = false;
		jQuery( arrObject ).each( function(ii,vv) {
			if( seq == vv ) {
				result = true; return false;
			}
		} );

		if( !result ) arrObject.push( seq );

		return result;
	}

	this.util = {};

	this.util.autoLink = function( obj ) {
		if( livereLib.util.isEmpty( obj ) ) return;
		var re = /((http|https|ftp):\/\/[\w?=&.\/-;#~%-]+(?![\w\s?&.\/;#~%"=-]*>))/g;
		return obj.replace(re, '<a href="$1" target="_blank">$1</a>');
	};

	this.util.isEmpty	= function(value) {
		return ( typeof(value) == 'undefined' || value == null || value == '' || value == 'null' ) ? true : false;
	};

	this.util.mouseClickCalc	= function(e) {
		this.x = e.clientX + (document.documentElement.scrollLeft?document.documentElement.scrollLeft:document.body.scrollLeft);
		this.y = e.clientY + (document.documentElement.scrollTop?document.documentElement.scrollTop:document.body.scrollTop);
		return this;
	};

	this.util.centerCalc	= function( targetObject ) {
	    var d = document;
	    var w = d.body.clientWidth;
	    var h = d.body.clientHeight;
	    var x = (window.pageXOffset) ?
	            window.pageXOffset : (d.documentElement && d.documentElement.scrollLeft) ?
	                d.documentElement.scrollLeft : (d.body) ? d.body.scrollLeft : 0;
	    var y = (window.pageYOffset) ?
	            window.pageYOffset : (d.documentElement && d.documentElement.scrollTop) ?
	                d.documentElement.scrollTop : (d.body) ? d.body.scrollTop : 0;
	    
	    var o_w = targetObject.css("width").split("px")[0];
	    var o_h = targetObject.css("height").split("px")[0];

	    return  {
	    		left	: ((w/2)+x) - ( o_w / 2 ),
	    		top		: ((h/2)+y) - ( o_h / 2 )
	    };  	
	};
	this.util.getLoginPageURL	= function( serviceName ) {
		var url = livereSharedData.common.api_login_url + "?service=" + serviceName + "&redirect_path=";
		url += typeof( livereSharedData.smartLogin.redirect_path ) == 'string' ? livereSharedData.smartLogin.redirect_path : encodeURIComponent( window.location.href );
		return url;
	};
	this.util.stripProtocol	= function( url ) {
		if( url != null && url.indexOf( "//" ) > 0 ) {
			url = url.substring(url.indexOf( "//" ) + 2);
		}
		return url;
	};
	this.util.formToParameters = function( fmObject ) {
		var params = "";
		for(i = 0; i < fmObject.length; i++) {
			if(fmObject[i].type != "button" && fmObject[i].value != "") {
				if(fmObject[i].type == "checkbox") {
					params += fmObject[i].name + "=" + (fmObject[i].checked ? "1" : "0");
				} else {
					params += fmObject[i].name + "=" + encodeURIComponent(fmObject[i].value);
				}
				params = i != (fmObject.length - 1) ? params += "&" : params;
			}
		}
		return params;
	};
	this.util.objectToParameters = function( object ) {
		
		var paramsString = "";
		
		jQuery.each( object , function( ii , vv ) {
			paramsString += ( ii + "=" + encodeURIComponent( vv ) + "&" );
		} );
		
		if( paramsString != "" ){
			var value = paramsString.substring( paramsString.length - 1 );
			if( value == "&" )
				paramsString = paramsString.substring( 0 , paramsString.length - 1 );
		}
		
		return paramsString;
	};
	this.util.addZero = function( val ) {
		return val < 10 ? "0" + val : val;
	};
	this.util.timer = function( time , fun ) {
		setTimeout( time , fun );
	};
	this.util.alert = function( memo , command ) {
		alert( memo + "\r\n" + command );
	};
	this.util.isMobileVisitor	= function() {
		var mobileKeyWords = new Array('iphone', 'ipod', 'blackberry', 'android', 'windows ce', 'lg', 'mot', 'samsung', 'sonyericsson');
		var returnFlag = false;
		jQuery( mobileKeyWords ).each( function( ii , vv ) {
			var key = vv.toLowerCase();
			var agent = navigator.userAgent.toLowerCase();
			if (agent.match( vv ) != null){
				returnFlag = true;
		        return false;
		    }
		} );
		
		return returnFlag;		
	};
	this.util.toJson2 = function( str ) {
		return str;
	};

	// @deprecated
	var arrExp = /^\[/g; var objExp = /^{/g; var brExp = /\n|\r|\r\n|\n\r/g;
	this.util.toJson = function( str ) {
		 return str;
	};

	this.util.viewExtended = false;
	
	
};

var livereLib = new LivereLib();
var livereSharedData = {};
livereSharedData.url = "http://dev.livere.co.kr";
livereSharedData.common = {};
livereSharedData.common.api_login_url	= livereSharedData.url + "/API_Service";
livereSharedData.smartLogin = {};
livereSharedData.livereReply = {};