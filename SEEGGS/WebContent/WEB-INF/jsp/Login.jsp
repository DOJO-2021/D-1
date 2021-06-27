<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEEGGS | LOGIN</title>
<link rel="stylesheet"  href="css/common.css">
</head>
<body>
<canvas id="canvas"></canvas>
<div class="wrapper">
  <!-- ヘッダー（ここから） -->

    <!--真ん中ロゴここから
      a href以下に遷移先のServletを記述してください。-->

    <h1 id="logo">
     <a href="/SEEGGS/LoginServlet"><img src="images/logo.png" width="300" height="100" alt="SEEGGS"></a>
   </h1>
   <!-- 真ん中ロゴ（ここまで） -->

  <!-- ヘッダー（ここまで） -->

  <!-- メイン（ここから） -->

  <!--ログインフォームここから
    action以下に遷移先のServletを記述してください。
    a href以下に遷移先のServletを記述してください。-->

  <form method="POST" action="/SEEGGS/LoginServlet">
<div class="form-wrapper">
  <h1>ログイン</h1>
  <form>
    <div class="form-item">
      <label for="ID"></label>
      <input type="id" name="id" required="required" placeholder="ID"></input>
    </div>
    <div class="form-item">
      <label for="PW"></label>
      <input type="password" name="password" required="required" placeholder="PW"></input>
    </div>
    <div class="button-panel2">
      <input type="submit" class="button" title="Login" value="Login"></input>
    </div>
  </form>
  <div class="form-footer">
    <p><a href="/SEEGGS/AccountServlet"><u>新規アカウント登録はこちら</u></a></p>
  </div>
</div>

  <!--ログインフォームここまで-->

  <!-- メイン（ここまで） -->



  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy;Copyright D1ユニコーンのたまご. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->

</div>


<!-- 以下js及びjQuery処理の記述 -->

<script src="js/jquery-3.4.1.min.js"></script>
<script>
'use strict';

$(document).ready(function() {
  /* [ログイン]ボタンをクリックしたときの処理 */
  $('#submit').on('click', function() {
    if (!$('#user_id').val() || !$('#password').val()) {
      $('#error_message').text('※IDとパスワードを入力してください！');
      return false;	/* 送信しない */
    }
    $('error_message').text(null);
    return true;	/* 送信する */
  });

});


/*背景*/
var Canvas = document.getElementById('canvas');
var ctx = Canvas.getContext('2d');

var resize = function() {
    Canvas.width = Canvas.clientWidth;
    Canvas.height = Canvas.clientHeight;
};
window.addEventListener('resize', resize);
resize();

var elements = [];
var presets = {};

presets.o = function (x, y, s, dx, dy) {
    return {
        x: x,
        y: y,
        r: 12 * s,
        w: 5 * s,
        dx: dx,
        dy: dy,
        draw: function(ctx, t) {
            this.x += this.dx;
            this.y += this.dy;

            ctx.beginPath();
            ctx.arc(this.x + + Math.sin((50 + x + (t / 10)) / 100) * 3, this.y + + Math.sin((45 + x + (t / 10)) / 100) * 4, this.r, 0, 2 * Math.PI, false);
            ctx.lineWidth = this.w;
            ctx.strokeStyle = '#ebc7a5';
            ctx.stroke();
        }
    }
};

presets.x = function (x, y, s, dx, dy, dr, r) {
    r = r || 0;
    return {
        x: x,
        y: y,
        s: 20 * s,
        w: 5 * s,
        r: r,
        dx: dx,
        dy: dy,
        dr: dr,
        draw: function(ctx, t) {
            this.x += this.dx;
            this.y += this.dy;
            this.r += this.dr;

            var _this = this;
            var line = function(x, y, tx, ty, c, o) {
                o = o || 0;
                ctx.beginPath();
                ctx.moveTo(-o + ((_this.s / 2) * x), o + ((_this.s / 2) * y));
                ctx.lineTo(-o + ((_this.s / 2) * tx), o + ((_this.s / 2) * ty));
                ctx.lineWidth = _this.w;
                ctx.strokeStyle = c;
                ctx.stroke();
            };

            ctx.save();

            ctx.translate(this.x + Math.sin((x + (t / 10)) / 100) * 5, this.y + Math.sin((10 + x + (t / 10)) / 100) * 2);
            ctx.rotate(this.r * Math.PI / 180);

            line(-1, -1, 1, 1, '#ebc7a5');
            line(1, -1, -1, 1, '#ebc7a5');

            ctx.restore();
        }
    }
};

for(var x = 0; x < Canvas.width; x++) {
    for(var y = 0; y < Canvas.height; y++) {
        if(Math.round(Math.random() * 8000) == 1) {
            var s = ((Math.random() * 5) + 1) / 10;
            if(Math.round(Math.random()) == 1)
                elements.push(presets.o(x, y, s, 0, 0));
            else
                elements.push(presets.x(x, y, s, 0, 0, ((Math.random() * 3) - 1) / 10, (Math.random() * 360)));
        }
    }
}

setInterval(function() {
    ctx.clearRect(0, 0, Canvas.width, Canvas.height);

    var time = new Date().getTime();
    for (var e in elements)
    elements[e].draw(ctx, time);
}, 10);
</script>
</body>
</html>
