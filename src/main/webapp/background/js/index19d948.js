/*function $(a) {
	return document.getElementById(a);
}*/
function trim(a) {
	return (a && a.replace ? a : "").replace(/(^\s*)|(\s*document.getElementById)/g, "");
}
function addClass(a, b) {
	var c = " " + a.className + " ";
	if (c.indexOf(" " + b + " ") < 0) {
		a.className += a.className ? " " + b : b;
	}
	return a;
}
function rmClass(a, b) {
	if (a) {
		if (b) {
			var c = " " + a.className + " ";
			c = c.replace(" " + b + " ", " ");
			a.className = trim(c);
		} else {
			a.className = "";
		}
	}
	return a;
}
function rmAllClass(a, b) {
	for (var c = a.length - 1; c >= 0; c--) {
		rmClass(a[c], b);
	}
}
function addAllClass(a, b) {
	for (var c = a.length - 1; c >= 0; c--) {
		addClass(a[c], b);
	}
}
function getType(a) {
	return Object.prototype.toString.call(a).toLowerCase().split(" ")[1]
			.split("]")[0];
}
function getKeys(b) {
	if (typeof b != "object")
		return [];
	var c = [];
	for ( var a in b) {
		c.push(a);
	}
	return c;
}
function formatStylePropertyToJsType(a) {
	if (typeof a == "string")
		return a.replace(/(-\S){1}/g, function(b) {
			return b.charAt(1).toUpperCase();
		});
	return "";
}
function formatStylePropertyToCssType(a) {
	if (typeof a == "string")
		return a.replace(/[A-Z]/g, function(b) {
			return "-" + b.toLowerCase();
		});
	return "";
}
function css(e, d, f) {
	if (!e)
		return;
	if (getType(d) == "object") {
		var b = trim(e.style.cssText).toLowerCase();
		if (b && b.charAt(b.length - 1) != ";")
			b += ";";
		for ( var c in d)
			b += formatStylePropertyToCssType(c) + ":" + d[c] + ";";
		e.style.cssText = b;
		return;
	}
	if (getType(d) == "array")
		return a(e, d);
	if (typeof d == "string") {
		if (f != null) {
			e.style[formatStylePropertyToJsType(c)] = String(f);
			return;
		}
		return a(e, d);
	}
	function a(j, h) {
		if (!j)
			return;
		if (typeof h == "string")
			return j.currentStyle ? j.currentStyle[formatStylePropertyToJsType(h)]
					: document.defaultView.getComputedStyle(j, false)[formatStylePropertyToJsType(h)];
		if (getType(h) == "array") {
			var i = {};
			for ( var g in h) {
				i[h[g]] = a(j, h[g]);
			}
			return i;
		}
	}
}
function animation(l, j, e) {
	if (!l || !l.nodeType)
		return;
	j = c(j);
	e = e === 0 ? 0 : e || 300;
	var g = css(l, getKeys(j)), f = 1, h = 20, m = parseInt(e / h), k = (function() {
		var q = {}, p, o;
		for ( var n in g) {
			p = a(g[n]);
			o = a(j[n]);
			q[n] = {
				oldValue : p.num,
				newValue : o.num,
				perValue : (o.num - p.num) / m,
				unit : o.unit
			};
		}
		return q;
	})();
	var d = setTimeout(i, h);
	function i() {
		css(l, b(f));
		f++;
		if (f > m)
			clearTimeout(d);
		else
			d = setTimeout(i, h);
	}
	function b(n) {
		var p = {};
		for ( var o in g)
			p[o] = k[o].oldValue + k[o].perValue * n + k[o].unit;
		return p;
	}
	function a(n) {
		return {
			source : n,
			num : parseInt(n) || 0,
			unit : n.replace(/\d|./g, "") || "px"
		};
	}
	function c(o) {
		o = o || {};
		for ( var n in o)
			o[n] = String(o[n]);
		return o;
	}
}
(function() {
	var j = document.getElementById("ban_select").getElementsByTagName("a"), h = document.getElementById("banner_box"), g = document.getElementById(
			"banners").getElementsByTagName("li"), l = document.getElementById("b_prev"), k = document.getElementById("b_next"), f = 0, m = [], e;
	function a(i) {
		var o = i || 0;
		f = setInterval(function() {
			b(o = (o + 1) % 5);
		}, 5000);
	}
	function d() {
		clearInterval(f);
	}
	function c(o, i) {
		if (o) {
			i <= 0 ? (o.style.display = "none") : (o.style.display = "");
			o.style.opacity = i / 100;
			o.style.filter = "alpha(opacity=" + i + ")";
		}
	}
	function b(i) {
		var o = i;
		rmAllClass(j, "on");
		addClass(j[o], "on");
		var q = 100;
		var p = 0;
		m.push(setInterval(function() {
			q -= 5;
			p += 5;
			if (q < 0 || p > 100) {
				for (var s = g.length - 1; s >= 0; s--) {
					s != o && c(g[s], 0);
				}
				;
				e = o;
				var r;
				while (r = m.pop()) {
					clearInterval(r);
				}
			} else {
				c(g[e], q);
				c(g[o], p);
			}
		}, 30));
	}
	for (var n = j.length - 1; n >= 0; n--) {
		j[n].onclick = function() {
			var i = +this.getAttribute("ban");
			clearInterval(f);
			b(i);
			a(i);
		};
	}
	a();
})();