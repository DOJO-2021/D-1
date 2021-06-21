<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SEEGGS | THREAD</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
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
          <li><a href="FavorServlet">お気に入り一覧</a></li>
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
  <!--スクロールボックスここから-->
  <div class="scrollArea3">
  <!--スレッドここから
  action以下に遷移先のサーブレットを記述してください。
  ${#} ${e.}に対象のEL式を記述してください。
  name以下に記述してください-->

    <c:forEach var="e" items="${FavorList}" ><!--Userテーブルから結果をインポートするときの名称-->
    <form method="POST" action="/SEEGGS/FavorServlet">
      <div class="textBox" name="contents" value= ${e.contents}>
        <ul>
          <li no="1" class="add" onclick="addfav('1')"><span>♡</span></li>
          <li no="1" class="remove" onclick="removefav('1')"><span>:トランプのハート:</span></li>
        </ul>
       </div>
     </form>
     </c:forEach>
    </div>
  <!--スレッドここまで-->
</div>
　<!--スクロールボックスここまで-->
  <!-- メイン（ここまで） -->
  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy; D1ユニコーンのたまご. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->



<!--お気に入りボタンSVGアニメーションここから-->
<svg xmlns="http://www.w3.org/2000/svg" style="display:none"><symbol id="heart" viewBox="0 0 1792 1792"><path d="M896 1664q-26 0-44-18l-624-602q-10-8-27.5-26T145 952.5 77 855 23.5 734 0 596q0-220 127-344t351-124q62 0 126.5 21.5t120 58T820 276t76 68q36-36 76-68t95.5-68.5 120-58T1314 128q224 0 351 124t127 344q0 221-229 450l-623 600q-18 18-44 18z"/></symbol>>
</svg>
<!--お気に入りボタンSVGアニメーションここまで-->
<!-- 以下js及びjQuery処理の記述 -->
<script src="js/jquery-3.4.1.min.js"></script>
<script>
'use strict';
$(document).ready(function() {
  /* [ログイン]ボタンをクリックしたときの処理 */
  $('#submit').on('click', function() {
    if (!$('#user_id').val() || !$('#password').val()) {
      $('#error_message').text('※IDとパスワードを入力してください！');
      return false; /* 送信しない */
    }
    $('error_message').text(null);
    return true;  /* 送信する */
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
//お気に入り実装ここから
/*"表示ソースの切り替え" */
function togleitem(oid,event){
    if(event == 'add'){
        // 未チェック(class="add")を非表示にして、チェック済(class="remove")を表示する
        $('li.add[no=' + oid + ']').hide();
        $('li.remove[no=' + oid + ']').show();
    } else if(event == 'remove'){
        // チェック済(class="remove")を非表示にして、未チェック(class="add")を表示する
        $('li.add[no=' + oid + ']').show();
        $('li.remove[no=' + oid + ']').hide();
    }
}
/* "ページロード時にローカルストレージの中をチェック" */
$(function(){
  $('ul .remove').hide();  // お気に入り中の表示は一時的に非表示に。
  // お気に入りリストに存在するか確認
  var key = 'お気に入りID';
  var getjson = localStorage.getItem(key);
  var oidlist = JSON.parse(getjson);
  if(oidlist != null){
    oidlist.forEach( function( oid ) {
      togleitem(oid,'add');
    });
  }
})
/* "お気に入りに追加機能" */
function addfav(oid){
    var key = 'お気に入りID';                       // キーの名前を指定
    // ローカルストレージから値を取得
    var getjson = localStorage.getItem(key);
    var oidlist = JSON.parse(getjson);
    if(oidlist == null){
        // 初めて「お気に入りID」というキーがローカルストレージに登録される時の処理
        oidary = new Array(oid);
        var setjson = JSON.stringify(oidary);
        localStorage.setItem(key, setjson);
        togleitem(oid,'add');
    } else {
        // 既に「お気に入りID」というキーが存在する時
        if(oidlist.indexOf(oid) == -1){
            // 且つ、まだお気に入りIDに登録されていない時
            oidlist.push(oid);
            var setjson = JSON.stringify(oidlist);
            localStorage.setItem(key, setjson);
            togleitem(oid,'add');
        }
    }
}
/* "お気に入りから削除機能" */
function removefav(oid){
    var key = 'お気に入りID';                       // キーの名前を指定
    // ローカルストレージから値を取得
    var getjson = localStorage.getItem(key);
    var oidlist = JSON.parse(getjson);
    if(oidlist != null){
        // 「お気に入りID」というキーが存在した時
        var checkitem = oidlist.indexOf(oid);     // 配列の何番目に該当のIDがあるかを見る
        if(checkitem != -1){
            // 「お気に入りID」の中に該当のIDが見つかった時
            oidlist.splice( checkitem, 1 );
            var setjson = JSON.stringify(oidlist);
            localStorage.setItem(key, setjson);
            togleitem(oid,'remove');
        }
    }
}
    //お気に入り機能ここまで
</script>
</body>
</html>