<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEEGGS | HOME</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" href="css/modal.css" />
</head>
<body>
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

  <!--プロフィールのポップアップここから
  a href以下に遷移先のServletを記述してください。-->

  <div class="popup-overlay">
    <!--以下プロフィール中身を記述してください-->
     <div class="popup-content">
        <c:forEach var="e" items="${sessionScope.User}" ><!--Userテーブルから結果をインポートするときの名称-->
        <form method="POST" action="UserServlet">
        <table>
            <c:set var="path" value="upload\\" />
            <tr>
                <td>
                      <img width="75" height="100" alt="プロフィール画像" src="${path}${e.photo}"><br>
                </td>
            </tr>
            <tr>
              <tb>
                      名前<br><input type="text" name="remarks" value="${e.name}"><br>
              </td>
              <td>
                      会社<br><input type="text" name="remarks" value="${e.company}"><br>
              </td>
              <td>
                      ニックネーム<br><input type="text" name="remarks" value="${e.nickname}"><br>
              </td>
              <td>
                      研修への意気込みをどうぞ！<br><input type="text" name="word" value="${e.word}"><br>
              </td>
            </tr>
            <tr>
              <td>
                      自分を一文字で表すと…<br><input type="text" name="remarks" value="${e.thisisme}"><br>
              </td>
              <td>
                      出身地<br><input type="text" name="remarks" value="${e.birthplace}"><br>
              </td>
            </tr>
            <tr>
              <td>
                      今後やりたいこと<br><input type="text" name="remarks" value="${e.future}"><br>
              </td>
              <td>
                      趣味は？<br><input type="text" name="remarks" value="${e.hobby}"><br>
              </td>
              <td>
            </tr>
          </table>
          </form>
          </c:forEach>
       </div>
    </div>

    <!--使い方ボタンここから-->

    <!-- Modal HTML embedded directly into document -->
<div id="ex1" class="modal">
  <div style="position: relative; top: -10px;left: -500px;"><img src="images/HomeHowToUseillust.png" width="1000" height="500" alt="SEEGGS"></div>
</div>

<!-- Link to open the modal -->
    <div class="mother11">
      <div class="form-wrapper2">
        <div class="button-panel4">
          <figure><a href="#ex1" rel="modal:open"><img src="images/HomeHowToUseButton.png" width="180" height="250" alt="SEEGGS"></a></figure>
        </div>
      </div>
    </div>
      <!--使い方ボタンここまで-->

    <!--以下オープンのためのボタン-->
    <div class="mother">
      <section id="modalArea" class="modalArea">
      <figure2><button class="open"><img src="images/HomeProfileButton.png" width="300" height="360" alt="SEEGGS"></button></figure2>
    　</section>
    </div>
    <!--プロフィールのポップアップここまで-->

  <div class="mother">
    <!--ユーザー情報リンクボタンここから-->
      <div class="form-wrapper2">
          <div class="button-panel">
            <figure><a href="UserServlet"><img src="images/HomeUserButton.png" width="300" height="360" alt="SEEGGS"></a></figure>
          </div>
      </div>
  </div>
    <!--ユーザー情報リンクボタンここまで-->

    <!--掲示板リンクボタンここから-->
  <div class="mother">
      <div class="form-wrapper2">
        <div class="button-panel">
          <figure><a href="BoardServlet"><img src="images/HomeboardButton.png" width="300" height="360" alt="SEEGGS"></a></figure>
        </div>
  </div>
  </div>
    <!--掲示板リンクボタンここまで-->
  <!-- メイン（ここまで） -->


  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy; D1ユニコーンのたまご. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->

</div>




<!-- 以下js及びjQuery処理の記述 -->

<!-- Remember to include jQuery :) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>

<!-- jQuery Modal -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js">

$('#sub-modal').modal({
	  closeExisting: false
	});

</script>

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

</script>
</body>
</html>
