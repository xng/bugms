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
</head>
<body>
	<table id="dg" title="用户信息" class="easyui-datagrid"></table>
	<div id="dlg" class="easyui-dialog" title="修改用户信息" 
	 style="width:400px;height:200px;padding:10px"  data-options="iconCls:'icon-save',resizable:true,closed:true,modal:true">
		<form id="fm"  class="easyui-form" data-options="novalidate:true">
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
				<input class="easyui-validatebox easyui-textbox" type="text"  name="userRole" data-options="required:true,missingMessage:'密码必填'"/>
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
		    nowrap: false,
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
		        { field: 'userRole', title: '角色',editor:'text',sortable:true },
		        { field: 'userAccount', title: '登录帐号' },
		        { field: 'userMail', title: '用户邮箱' },
		        { field: 'action', title: '操作',formatter:function formatOper(val,row,index){  
		            return '<a href="#" onclick="editUser('+index+')">修改</a>';  
		        } }
		    ]]
		});
	});
	
	function editUser(index){
	    $('#dg').datagrid('selectRow',index);// 关键在这里  
	    var row = $('#dg').datagrid('getSelected');  
	    if (row){
	    	console.log(row)
	        $('#dlg').dialog('open');  
	    	console.log( $('#fm'))
	        $('#fm').form('load',row);  
	    }  
	} 
	</script>
</body>
</html>