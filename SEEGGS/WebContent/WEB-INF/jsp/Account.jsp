<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEEGGS | ACCOUNT</title>
<link rel="stylesheet" type="text/css" href="css/admin.css">
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

  <!--アカウント作成フォームここから
    action以下に遷移先のServletを記述してください。
    a href以下に遷移先のServletを記述してください。-->

<div class="scrollArea2">
<form method="POST" enctype="multipart/form-data"  action="AccountServlet">
<div class="form-wrapper4">
  <h1>新規アカウント作成</h1>

    <div class="form-item">
      <label for="ID">ログインID</label>
      <input type="text" name="id" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
      <label for="PASSWORD">ログインパスワード</label>
      <input type="password" name="password" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="PHOTO">顔写真の登録</label>
        <input type="file" name="photo" accept="image/jpeg, image/png">
    </div>

    <div class="form-item">
    	<label for="NAME">名前</label>
    	<input type="text" name="name" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
    	<label for="COMPANY">会社名</label>
    	<input type="text" name="company" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="NICKNAME">ニックネーム</label>
        <input type="text" name="nickname" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="HOBBY">趣味は？</label>
        <input type="text" name="hobby" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="BIRTHPLACE">出身地</label>
        <input type="text" name="birthplace" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="THISISME">自分を一文字で表すと…</label>
        <input type="text" name="thisisme" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="FUTURE">コロナが収まったらやりたいことは？</label>
        <input type="text" name="future" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="WORD">研修の意気込みをどうぞ！</label>
        <input type="text" name="word" required="required" placeholder=""></input>
    </div>

</div>

    <div class="button-panel2">
      <input type="submit" class="button" title="Regist" value="登録"></input>
    </div>

  </form>


  <div class="form-footer">
    <p><a href="LoginServlet">ログイン画面にもどる</a></p>
  </div>
</div>

  <!--アカウント作成フォームここまで-->
</div>
  <!-- メイン（ここまで） -->



  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy;Copyright D1ユニコーンのたまご. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->




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
            ctx.strokeStyle = '#e9e9e9';
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

            line(-1, -1, 1, 1, '#e9e9e9');
            line(1, -1, -1, 1, '#e9e9e9');

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
