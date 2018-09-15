// JavaScript Document
var err='';
function getID(id){
    obj=document.getElementById(id);
    if (obj==null) obj=document.all.id;
    return obj;
}

/*判断修改内容是否为空*/
function UpdateIsNull(){
	var name = getID('name').value;
	var introduction = getID('introduction').value;
	if(name.length<1 || introduction.length<1){
		err+='请完整填写表单\n';
		return false;
	}else{
		return true;	
	}
}

/*判断添加内容是否为空*/
function insertIsNull(){
	var name = getID('name1').value;
	var introduction = getID('introduction1').value;
	if(name.length<1 || introduction.length<1){
		err+='请完整填写表单\n';
		return false;
	}else{
		return true;	
	}
}

/*判断修改内容是否为空*/
function check(){
	err="";
	if(UpdateIsNull() == true){
		return true;	
	}else{
		UpdateIsNull();
		swal({
			title: '操作失败...',
			text: err,
			type: 'error'
		})
		return false;	
	}
}

/*判断添加内容是否为空*/
function check1(){
	err="";
	if(insertIsNull() == true){
		return true;	
	}else{
		insertIsNull();
		swal({
			title: '操作失败...',
			text: err,
			type: 'error'
		})
		return false;	
	}
}