var a = 3;
var newM = 0;
function message() {
	var a = $.blinkTitle.show();
	setTimeout(function() {
		$.blinkTitle.clear(a)
	}, 8e3)
}
$(document).ready(function() {

		var 
			b = "../assets/img/head/1.png",
			c = "../assets/img/head/2.png",
			d = "用户3";
		$(".close_btn").click(function() {
			//$(".chatBox").hide()
			//$("#user"+a).remove();
			//$("#user"+(a+1)).addClass("choosed").siblings().removeClass("choosed")
			//$(".mes" + (a+1)).show().siblings().hide()
		}), $(".chat03_content li").mouseover(function() {
			$(this).addClass("hover").siblings().removeClass("hover")
		}).mouseout(function() {
			$(this).removeClass("hover").siblings().removeClass("hover")
		}), $(".chat03_content li").click(function() {
			var b = $(this).index() + 1;
			newM = 0;
			a = b, c = "../assets/img/head/2.png", d = $(this).find(".chat03_name").text(), $(".chat01_content").scrollTop(0), $(this).addClass("choosed").siblings().removeClass("choosed"), $(".talkTo a").text($(this).children(".chat03_name").text()), $(".mes" + b).show().siblings().hide(),$("#newmes"+b).hide()
		}), $(".ctb01").mouseover(function() {
			$(".wl_faces_box").show()
		}).mouseout(function() {
			$(".wl_faces_box").hide()
		}), $(".wl_faces_box").mouseover(function() {
			$(".wl_faces_box").show()
		}).mouseout(function() {
			$(".wl_faces_box").hide()
		}), $(".wl_faces_close").click(function() {
			$(".wl_faces_box").hide()
		}), $(".wl_faces_main img").click(function() {
			var a = $(this).attr("src");
			$("#editor1").val($("#editor1").val() + "*#" + a.substr(a.indexOf("img/") + 4, 6) + "#*"), $("#editor1").focusEnd(), $(".wl_faces_box").hide()
		}), $(".chat02_bar img").click(function() {
			send();
			
		}), document.onkeydown = function(a) {
			var b = document.all ? window.event : a;
			return 13 == b.keyCode ? (send(), !1) : void 0
		}, $.fn.setCursorPosition = function(a) {
			return 0 == this.lengh ? this : $(this).setSelection(a, a)
		}, $.fn.setSelection = function(a, b) {
			if (0 == this.lengh) return this;
			if (input = this[0], input.createTextRange) {
				var c = input.createTextRange();
				c.collapse(!0), c.moveEnd("character", b), c.moveStart("character", a), c.select()
			} else input.setSelectionRange && (input.focus(), input.setSelectionRange(a, b));
			return this
		}, $.fn.focusEnd = function() {
			this.setCursorPosition(this.val().length)
		}
	}),
	function(a) {
		a.extend({
			blinkTitle: {
				show: function() {
					var a = 0,
						b = document.title;
					if (-1 == document.title.indexOf("\u3010")) var c = setInterval(function() {
						a++, 3 == a && (a = 1), 1 == a && (document.title = "\u3010\u3000\u3000\u3000\u3011" + b), 2 == a && (document.title = "\u3010\u65b0\u6d88\u606f\u3011" + b)
					}, 500);
					return [c, b]
				},
				clear: function(a) {
					a && (clearInterval(a[0]), document.title = a[1])
				}
			}
		})
	}(jQuery);