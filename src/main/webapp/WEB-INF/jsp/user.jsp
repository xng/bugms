<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>bugms | cail.cc</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/newmain.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/icon.css">
<script src="<%=request.getContextPath()%>/js/easyui/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js" ></script>
</head>
<body>
	<table id="dg" title="用户信息" class="easyui-datagrid"></table>
	<div id="dlg" class="easyui-dialog" title="修改用户信息" 
	 style="width:300px;height:300px;padding:10px"  data-options="resizable:true,closed:true,modal:true">
		<form id="ff"  class="easyui-form" data-options="novalidate:true">
        <table cellpadding="5">
       		<tr>
				<td>帐号:</td>
				<td>
				<input class="easyui-validatebox easyui-textbox" type="text" name="userAccount" data-options="prompt:'请输入帐号',required:true" />
				<input type="hidden" name="id"/>
				</td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td>
				<input class="easyui-validatebox easyui-textbox" type="text" name="userName" data-options="prompt:'请输入帐号',required:true" />
				</td>
			</tr>
			<tr>
				<td>角色:</td>
				<td>
				<select class="easyui-combobox" name="userRole" data-options="required:true, editable:false ">
					<option value="admin">管理员</option>
					<option value="tester">测试人员</option>
					<option value="dev">开发人员</option>
					<option value="man">经理</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td>
				<input class="easyui-validatebox easyui-textbox" type="text"  name="userMail" data-options="required:true,validType:'email',missingMessage:'邮箱必填'"/>
				</td>
			</tr>
			<tr>
				<td colspan="2"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a></td>
			</tr>
		</table>
    </form>
	</div>
	<script type="text/javascript">
	
	$(function(){
		$('#dg').datagrid({
			width:500,
		    url: '<%=request.getContextPath()%>/user/userList.do',
		    method: 'get',
		    idField: 'id',
		    fitColumns:true,
		    singleSelect:true,
		    striped:true,
		    pagination: true,
		    toolbar:toolbar,
		    pageSize: 10,
		    pageList: [10, 20, 50, 100, 150, 200],
		    loadFilter:function(data){
		    	if(data.errorCode==200){
		    		return data.data;
		    	}
		    },
		    columns: [[
				{ field: 'id', title: 'ID' },
		        { field: 'userName', title: '姓名' },
		        { field: 'userRole', title: '角色',sortable:true },
		        { field: 'userAccount', title: '登录帐号' },
		        { field: 'userMail', title: '用户邮箱' },
		        { field: 'action', title: '操作',formatter:function formatOper(val,row,index){  
		            return '<a href="#" onclick="editUser('+row.id+')">修改</a>';  
		        } }
		    ]]
		});
	});
	
	function editUser(index){
	    $('#dg').datagrid('selectRow',index);
	    var row = $('#dg').datagrid('getSelected');  
	    if (row){
	    	 $('#dlg').dialog({
		        	iconCls:'icon-edit',
		        	title:'修改用户'
		        }).dialog('open');
	        $('#ff').form('load',row);  
	    }  
	} 
	function submitForm(){
		$("#ff").ajaxSubmit({
				url:'saveorUpdateUser.do',
				type:'post',
				dataType:'json',
				beforeSubmit:function(){
					return $("#ff").form('enableValidation').form('validate');
				},
				success:function(data){
					if(data.errorCode==200){
				        $('#dlg').dialog('close'); 
							alert('成功');
						 $('#dg').datagrid('reload');
					}else{
						alert(data.errorMsg);
					}
				}
		});
	}
	var toolbar = [{
		text:'新用户',
		iconCls:'icon-add',
		handler:function(){
			$('#ff').form('clear');
	        $('#dlg').dialog({
	        	iconCls:'icon-add',
	        	title:'新增用户(默认密码六个1)'
	        }).dialog('open');  
		}
	}];
	</script>
</body>
</html>