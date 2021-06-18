<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEEGGS | USER</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<div class="wrapper">
  <!-- ヘッダー（ここから） -->

    <!--左上ロゴここから
      a href以下に遷移先のServletを記述してください。-->
      
        <a href="Login.html"><div style="position:absolute; top:20px; left:30px;"><img src="images/logo.png" width="300" height="100" alt="SEEGGS"></div></a>
      
      <!-- 左上ロゴ（ここまで） -->

  <!-- ヘッダー（ここまで） -->

  <!-- メイン（ここから） -->
  
  <!--右側ハンバーガーメニューここから
      a href以下に遷移先のServletを記述してください。-->

  <div id="navArea">

    <nav>
      <div class="inner">
        <ul>
          <li><a href="Home.html">ホーム</a></li>
          <li><a href="#">マイプロフィール</a></li>
          <li><a href="User.html">ユーザー情報</a></li>
          <li><a href="Board.html">掲示板</a></li>
          <li><a href="Favor.html">お気に入り一覧</a></li>
          <li><a href="Login.html">ログアウト</a></li>
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
 
 
  <!--スクロールボックスここから
  a href以下に遷移先のServletを記述してください。-->

  <div class="popup-overlay">
    <!--以下プロフィール中身を記述してください-->
  <div class="popup-content">
    <p>マイプロフィール</p>
    <c:forEach var="e" items="${cardList}" ><!--Userテーブルから結果をインポートするときの名称-->
    <form method="POST" action="UserUpdateDeleteServlet">
        <table>
        <tr>
            <td>
                番号<input type="text" name="ID" value="${e.id}"><br>
        </td>
        <td>
                名前<input type="text" name="name" value="${e.name}"><br>
        </td>
    </tr>
    <tr>
        <td>
                会社<input type="text" name="company" value="${e.company}"><br>
                </td>
        <td>
                ニックネーム<input type="text" name="nickname" value="${e.nickname}"><br>
        </td>
    </tr>
    <tr>
        <td>
                出身地<input type="text" name="birthplace" value="${e.bithplace}"><br>
        </td>
        <td>
                自分を一文字で表すと…<input type="text" name="address" value="${e.thisisme}"><br>
        </td>
    </tr>
    <tr>
        <td>
                趣味は？<input type="text" name="zip_code" value="${e.hobby}"><br>
        </td>
        <td>
                研修の意気込みをどうぞ！<input type="text" name="tel" value="${e.future}"><br>
        </td>
    </tr>
    <tr>
        <td>
                <input type="text" name="fax" value="${e.word}"><br>
        </td>
        <td>
    </tr>
    </table>
  </div>
 </div>

<div class="scrollArea">

    <!--プロフィールのポップアップここから
        a href以下に遷移先のServletを記述してください。-->

            <!--以下オープンのためのボタン-->
            <button class="open"><img src="images/プロフィール.png" width="200" height="300" alt="SEEGGS"></button>
    <!--プロフィールのポップアップここまで-->
</div> 

    <!--スクロールボックスここまで-->


    <!-- メイン（ここまで） -->
  

    <!-- フッター（ここから） -->
        <div id="footer">
            <p>&copy; D1ユニコーンのたまご. All rights reserved.</p>
        </div>
    <!-- フッター（ここまで） -->

<!--/div-->




<!-- 以下js及びjQuery処理の記述 -->

<script src="scripts/jquery-3.4.1.min.js"></script>
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

</script>
</body>
</html>
