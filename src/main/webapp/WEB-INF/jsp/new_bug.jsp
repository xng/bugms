<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>新建bug | cail.cc</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/newmain.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css" />
		<script src="<%=request.getContextPath()%>/js/easyui/jquery.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js" ></script>
	</head>
	<body>
		<div class="easyui-panel"  >
	
	    <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>bug标题:</td>
	    			<td>
	    			<input type="hidden" name="createId" value="${createId }"/>
	    			<input type="hidden" name="updateId" value="${createId }"/>
	    			<input class="easyui-textbox easyui-validatebox cl-width-300" type="text" name="bugTitle" data-options="prompt:'请输入标题',required:true,missingMessage:'标题必填',validType:'length[3,30]',invalidMessage:'请输入至少3个字符最多不过30个字'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>bug描述:</td>
	    			<td>
					<textarea rows=5 name="bugDesc" class="easyui-validatebox cl-width-300" data-options="prompt:'请输入描述',required:true,missingMessage:'描述必填'"></textarea>
					</td>
	    		</tr>
	    		<tr>
	    			<td>严重程度:</td>
	    			<td><select class="easyui-combobox" data-options="editable:false" id="creater" name="bugLevel">
						<option value="1">一般</option>
						<option value="2">紧急</option>
						<option value="3">火急</option>
					</select></td>
	    		</tr>
	    		<tr>
	    			<td>指派给:</td>
	    			<td><select class="easyui-combobox" data-options="editable:false" id="creater" name="assignId">
						<c:forEach items="${devs}" var="dev" varStatus="status">
						<option value="${dev.id }">${dev.userName }</option>
						</c:forEach>
					</select></td>
	    		</tr>
				<tr>
					<td colspan="2"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a></td>
				</tr>
	    	</table>
	    </form>
	</div>
	<script>
		function submitForm(){
			$("#ff").ajaxSubmit({
				url:'new_bug.do',
				type:'post',
				dataType:'json',
				beforeSubmit:function(){
					return $("#ff").form('enableValidation').form('validate');
				},
				success:function(data){
					if(data.errorCode==200){
						alert("成功");
						window.location.href = "bugs.do";
					}else{
						alert(data.errorMsg);
					}
				}
		});
		}
	</script>
	</body>

</html>