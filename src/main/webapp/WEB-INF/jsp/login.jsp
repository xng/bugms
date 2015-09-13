<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>BugMS登录 | www.cail.cc</title>
		<link rel="stylesheet" href="css/newmain.css" />
		<link rel="stylesheet" href="js/easyui/themes/default/easyui.css" />
		<script src="js/easyui/jquery.min.js" type="text/javascript"></script>
		<script src="js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/newmain.js" ></script>
		<script type="text/javascript" src="js/jquery.form.js" ></script>
		<script src="js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
	</head>
	<body >
	<div style="width:400px;height:200px;margin:50px auto;" data-options="top:200," >
	<div  class="easyui-panel" title="BugMS登录">
	<form id="ff"  class="easyui-form" data-options="novalidate:true">
        <table cellpadding="5">
			<tr>
				<td>帐号:</td>
				<td>
				<input class="easyui-validatebox easyui-textbox" type="text" name="userAccount" data-options="prompt:'请输入帐号',required:true" />
				</td>
			</tr>
			<tr>
				<td>密码:</td>
				<td>
				<input class="easyui-validatebox easyui-textbox" type="password"  name="userPwd" data-options="required:true,missingMessage:'密码必填'"/>
				</td>
			</tr>
			<tr>
				<td colspan="2"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">登录</a></td>
			</tr>
		</table>
    </form>
	</div>
	</div>
	<script>
	function submitForm(){
		$("#ff").ajaxSubmit({
				url:'login.do',
				type:'post',
				dataType:'json',
				beforeSubmit:function(){
					return $("#ff").form('enableValidation').form('validate');
				},
				success:function(data){
					if(data.errorCode==200){
						window.location.href="index.do";
					}else{
						alert(data.errorMsg);
					}
				}
		});
	}
	$(function(){
		$('input').keydown(function (e) {
            if (e.keyCode == 13) {
            	submitForm();
            }
        });
	})
	</script>
	</body>

</html>