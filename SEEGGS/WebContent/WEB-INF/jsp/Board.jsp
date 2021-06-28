<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SEEGGS | BOARD</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>

<body>
<canvas id="canvas"></canvas>
<div class="wrapper">
  <!-- ヘッダー（ここから） -->

    <!--左上ロゴここから
      a href以下に遷移先のServletを記述してください。-->

        <a href="/SEEGGS/HomeServlet"><div style="position:absolute; top:20px; left:30px;"><img src="images/logo.png" width="300" height="100" alt="SEEGGS"></div></a>

      <!-- 左上ロゴ（ここまで） -->

  <!-- ヘッダー（ここまで） -->

  <!-- メイン（ここから） -->

  <!--右側ハンバーガーメニューここから
      a href以下に遷移先のServletを記述してください。-->

  <div id="navArea">

    <nav>
      <div class="inner">
        <ul>
          <li><a href="HomeServlet">ホーム</a></li>
          <li><a href="ProfileServlet">マイプロフィール</a></li>
          <li><a href="UserServlet">ユーザー情報</a></li>
          <li><a href="BoardServlet">掲示板</a></li>
          <li><a href="LogoutServlet">ログアウト</a></li>
        </ul>
      </div>
    </nav>

    <div class="toggle_btn">
      <span></span>
      <span></span>
      <span></span>
    </div>

    <div id="mask"></div>

  </div>

  <!--右側ハンバーガーメニューここまで-->

  <!--検索バーここから
  action以下に遷移先を記述してください-->

  <div class="mother">
  <form method="POST" action="SearchServlet" class="search_container">
    <input type="text" name="contents" size="25" placeholder="　キーワード検索">
    <input type="submit" name="regist" value="&#xf002">
  </form>
  </div>

  <!--検索バーここまで-->

  <!--掲示板カテゴリここから
  a href以下に遷移先を記述してください-->

    <div class="mother2">
      <!--ノウハウ共有スレッドボタンここから-->
        <div class="form-wrapper2">
            <div class="button-panel3">
              <a href="/SEEGGS/ThreadServlet?type=1"><input type="submit" class="button" title="Login" value="ノウハウ共有掲示板"></input></a>
            </div>
        </div>
      <!--ノウハウ共有スレッドボタンここまで-->

      <!--エラー共有スレッドボタンここから-->
        <div class="form-wrapper3">
          <div class="button-panel3">
              <a href="/SEEGGS/ThreadServlet?type=2"><input type="submit" class="button" title="Login" value="エラー共有掲示板"></input></a>
          </div>
        </div>
      <!--エラー共有スレッドボタンここまで-->

      <!--お悩み相談スレッドボタンここから-->
      <div class="form-wrapper3">
        <div class="button-panel3">
            <a href="/SEEGGS/ThreadServlet?type=3"><input type="submit" class="button" title="Login" value="お悩み相談掲示板"></input></a>
        </div>
      </div>
      <!--お悩み相談スレッドボタンここまで-->
    </div>

    <div class="mother3">
      <!--質問スレッドボタンここから-->
        <div class="form-wrapper2">
            <div class="button-panel3">
              <a href="/SEEGGS/ThreadServlet?type=4"><input type="submit" class="button" title="Login" value="講師に質問！"></input></a>
            </div>
        </div>
      <!--質問スレッドボタンここまで-->

      <!--ジモトークスレッドボタンここから-->
        <div class="form-wrapper3">
          <div class="button-panel3">
              <a href="/SEEGGS/ThreadServlet?type=5"><input type="submit" class="button" title="Login" value="ジモトーーーク！"></input></a>
          </div>
        </div>
      <!--ジモトークスレッドスレッドボタンここまで-->

      <!--休日何してるスレッドボタンここから-->
      <div class="form-wrapper3">
        <div class="button-panel3">
            <a href="/SEEGGS/ThreadServlet?type=6"><input type="submit" class="button" title="Login" value="休日何してる？"></input></a>
        </div>
      </div>
      <!--休日何してるスレッドボタンここまで-->
    </div>
  <!--掲示板カテゴリここまで-->

  <!-- メイン（ここまで） -->


  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy; D1ユニコーンのたまご. All rights reserved.</p>
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

//ハンバーガーメニューここから

(function($) {
  var $nav   = $('#navArea');
  var $btn   = $('.toggle_btn');
  var $mask  = $('#mask');
  var open   = 'open'; // class指定
  // menuオープン
  $btn.on( 'click', function() {
    if ( ! $nav.hasClass( open ) ) {
      $nav.addClass( open );
    } else {
      $nav.removeClass( open );
    }
  });
  // ポップアップ閉じる
  $mask.on('click', function() {
    $nav.removeClass( open );
  });
} )(jQuery);

//ハンバーガーメニューここまで



//プロフィールポップアップのjs

//「マイプロフィール」ボタンがクリックされたときに、activeを .popup および .popup-content に追加
$(".open").on("click", function(){
  $(".popup-overlay, .popup-content").addClass("active");
});

//「閉じる」ボタンがクリックされたときに、activeを .popup および .popup-content から削除
$(".close, .popup-overlay").on("click", function(){
  $(".popup-overlay, .popup-content").removeClass("active");
});

//プロフィールポップアップのjsここまで


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
