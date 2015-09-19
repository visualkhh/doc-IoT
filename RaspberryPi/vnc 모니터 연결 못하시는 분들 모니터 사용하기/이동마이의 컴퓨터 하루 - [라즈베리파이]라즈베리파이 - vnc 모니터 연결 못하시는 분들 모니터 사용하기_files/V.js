/*!
 * View Javascript Framework, v0.1
 * Copyright (c) 2013 Media Development 6 Team, Media Technology Center, Daum Communications.
 * Licensed under Daum Common License : http://dna.daumcorp.com/forge/docs/daum-license-1.0.txt
 *
 * Includes jQuery.js
 * Copyright (c) 2012 Front-end Technology Center, Daum Communications.
 * Project site: http://play.daumcorp.com/pages/viewpage.action?pageId=70892817
 * Licensed under Daum Common License : http://dna.daumcorp.com/forge/docs/daum-license-1.0.txt
 *
 * Date:
 */
(function(){if(!window.V){var V=window.V={};V.domReady=function(fn){var ie=
/*@cc_on!@*/
false;if(window.addEventListener){document.addEventListener("DOMContentLoaded",fn,false)}else{if(ie){document.attachEvent("onreadystatechange",function(){if(document.readyState=="complete"){fn()}})}}};V.cloneObject=function(obj){if(obj&&typeof(obj)=="object"){var newObj={};for(var p in obj){newObj[p]=obj[p]}return newObj}}}})();(function(b){var a={};b.each(["Quad","Cubic","Quart","Quint","Expo"],function(d,c){a[c]=function(e){return Math.pow(e,d+2)}});b.extend(a,{Sine:function(c){return 1-Math.cos(c*Math.PI/2)},Circ:function(c){return 1-Math.sqrt(1-c*c)},Elastic:function(c){return c===0||c===1?c:-Math.pow(2,8*(c-1))*Math.sin(((c-1)*80-7.5)*Math.PI/15)},Back:function(c){return c*c*(3*c-2)},Bounce:function(e){var c,d=4;while(e<((c=Math.pow(2,--d))-1)/11){}return 1/Math.pow(4,3-d)-7.5625*Math.pow((c*3-2)/22-e,2)}});b.each(a,function(d,c){b.easing["easeIn"+d]=c;b.easing["easeOut"+d]=function(e){return 1-c(1-e)};b.easing["easeInOut"+d]=function(e){return e<0.5?c(e*2)/2:1-c(e*-2+2)/2}})})(jQuery);