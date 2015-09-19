var ShareEntryWithSNS = {
	services : [ 'twitter', 'me2day', 'facebook', 'mypeople' ],
	actionUrl : '/plugin/sendSNS_Message',
	popupSize : {
		normal : {
			w : 800,
			h : 500
		},
		small : {
			w : 472,
			h : 340
		}
	},
	share : function(service, entryId, entryTitle) {
		if (service && entryId && entryTitle) {
			for ( var i = 0, s; s = this.services[i]; i++) {
				if (service == s) {
					this.post(service, entryId, entryTitle);
					break;
				}
			}
		}
	},
	post : function(service, entryId, entryTitle) {
		var popupSize = this.popupSize;
		var popupWidth = popupSize.normal.w;
		var popupHeight = popupSize.normal.h;
		var url = this.actionUrl + '?service=' + service + '&entryId=' + entryId + '&title=' + encodeURIComponent(entryTitle);
		window.open(url, service, 'width=' + popupWidth + ', height=' + popupHeight + ',resizable=yes,scrollbars=yes');
	},
	showLayer : function(ev, id) {
		var tg = document.getElementById('ttSnsServiceMore-'+id);
		document.body.appendChild(tg);
		var coords = daum.Element.getCoords(document.getElementById('ttSnsWrap-'+id));
		tg.style.display = 'block';
		tg.style.top = (coords.bottom - 1) + 'px';
		tg.style.left = coords.right - tg.offsetWidth + 'px';
		tg.style.zIndex = 99999;
	},
	hideLayer : function(ev, id) {
		var e = ev || window.event;
		var tg = document.getElementById('ttSnsServiceMore-'+id);
		var reltg = (e.relatedTarget) ? e.relatedTarget : e.toElement;
		if(!reltg){//IE bug
			tg.style.display = 'none';
			return;
		}
		while (reltg != tg && reltg.nodeName != 'BODY')
			reltg = reltg.parentNode
		if (reltg !== tg) {
			tg.style.display = 'none';
		}
	}
};