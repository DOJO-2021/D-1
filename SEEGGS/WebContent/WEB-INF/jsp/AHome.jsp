<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEEGGS | HOME</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<div class="wrapper">
  <!-- �w�b�_�[�i��������j -->

    <!--���ネ�S��������
      a href�ȉ��ɑJ�ڐ��Servlet���L�q���Ă��������B-->
      
        <a href="Login.html"><div style="position:absolute; top:20px; left:30px;"><img src="images/logo.png" width="300" height="100" alt="SEEGGS"></div></a>
      
      <!-- ���ネ�S�i�����܂Łj -->

  <!-- �w�b�_�[�i�����܂Łj -->

  <!-- ���C���i��������j -->
  
  <!--�E���n���o�[�K�[���j���[��������
      a href�ȉ��ɑJ�ڐ��Servlet���L�q���Ă��������B-->

  <div id="navArea">

    <nav>
      <div class="inner">
        <ul>
          <li><a href="Home.html">�z�[��</a></li>
          <li><a href="#">�}�C�v���t�B�[��</a></li>
          <li><a href="User.html">���[�U�[���</a></li>
          <li><a href="Board.html">�f����</a></li>
          <li><a href="Favor.html">���C�ɓ���ꗗ</a></li>
          <li><a href="Login.html">���O�A�E�g</a></li>
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
  
  <!--�E���n���o�[�K�[���j���[�����܂�-->

  <!--�v���t�B�[���̃|�b�v�A�b�v��������
  a href�ȉ��ɑJ�ڐ��Servlet���L�q���Ă��������B-->


  <div class="popup-overlay">
    <!--�ȉ��v���t�B�[�����g���L�q���Ă�������-->
     <div class="popup-content">
        <p>�}�C�v���t�B�[��</p>
     </div>
  </div>
  <!--�ȉ��I�[�v���̂��߂̃{�^��-->
  <button class="open"><img src="images/�v���t�B�[��.png" width="200" height="300" alt="SEEGGS"></button>
  
  <!--�v���t�B�[���̃|�b�v�A�b�v�����܂�-->

<div class="mother">
  <!--���[�U�[��񃊃��N�{�^����������-->
    <div class="form-wrapper2">
        <div class="button-panel">
          <a herf="User.html"><input type="submit" class="button" title="Login" value="���[�U�[���"></input></a>
        </div>
    </div>
  <!--���[�U�[��񃊃��N�{�^�������܂�-->

  <!--�f�������N�{�^����������-->

    <div class="form-wrapper3">
      <div class="button-panel">
          <a herf="Board.html"><input type="submit" class="button" title="Login" value="�f����"></input></a>
      </div>
    </div>

  <!--�f�������N�{�^�������܂�-->
</div>
  <!-- ���C���i�����܂Łj -->
  

  <!-- �t�b�^�[�i��������j -->
  <div id="footer">
    <p>&copy; D1���j�R�[���̂��܂�. All rights reserved.</p>
  </div>
  <!-- �t�b�^�[�i�����܂Łj -->

</div>




<!-- �ȉ�js�y��jQuery�����̋L�q -->

<script src="scripts/jquery-3.4.1.min.js"></script>
<script>
'use strict';

$(document).ready(function() {
  /* [���O�C��]�{�^�����N���b�N�����Ƃ��̏��� */
  $('#submit').on('click', function() {
    if (!$('#user_id').val() || !$('#password').val()) {
      $('#error_message').text('��ID�ƃp�X���[�h����͂��Ă��������I');
      return false;	/* ���M���Ȃ� */
    }
    $('error_message').text(null);
    return true;	/* ���M���� */
  });

});

//�n���o�[�K�[���j���[��������

(function($) {
  var $nav   = $('#navArea');
  var $btn   = $('.toggle_btn');
  var $mask  = $('#mask');
  var open   = 'open'; // class�w��
  // menu�I�[�v��
  $btn.on( 'click', function() {
    if ( ! $nav.hasClass( open ) ) {
      $nav.addClass( open );
    } else {
      $nav.removeClass( open );
    }
  });
  // �|�b�v�A�b�v����
  $mask.on('click', function() {
    $nav.removeClass( open );
  });
} )(jQuery);

//�n���o�[�K�[���j���[�����܂�



//�v���t�B�[���|�b�v�A�b�v��js

//�u�}�C�v���t�B�[���v�{�^�����N���b�N���ꂽ�Ƃ��ɁAactive�� .popup ����� .popup-content �ɒǉ�
$(".open").on("click", function(){
  $(".popup-overlay, .popup-content").addClass("active");
});

//�u����v�{�^�����N���b�N���ꂽ�Ƃ��ɁAactive�� .popup ����� .popup-content ����폜
$(".close, .popup-overlay").on("click", function(){
  $(".popup-overlay, .popup-content").removeClass("active");
});

//�v���t�B�[���|�b�v�A�b�v��js�����܂�

</script>
</body>
</html>
