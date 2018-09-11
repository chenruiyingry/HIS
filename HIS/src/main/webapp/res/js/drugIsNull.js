// JavaScript Document
var err='';

/*获取id*/
function getID(id){
    obj=document.getElementById(id);
    if (obj==null) obj=document.all.id;
    return obj;
}

/*判断修改是否为空*/
function isUpdate(){
	var name = getID('name').value;
	var funcction = getID('funcction').value;
	var manufacturer = getID('manufacturer').value;
	var purchase_price = getID('purchase_price').value;
	var sale_price = getID('sale_price').value;
	var store = getID('store').value;
	if(name.length<1 || funcction.length<1 || manufacturer.length<1 || purchase_price.length<1 || sale_price.length<1 || store.length<1){
		err+='请完整填写信息';
		return false;
	}else{
		return true;
	}
}

/*判断添加是否为空*/
function isAdd(){
	var name = getID('name1').value;
	var funcction = getID('funcction1').value;
	var manufacturer = getID('manufacturer1').value;
	var purchase_price = getID('purchase_price1').value;
	var sale_price = getID('sale_price1').value;
	var unit1 = getID('unit1').value;
	var spec = getID('spec1').value;
	var produce_date = getID('produce_date1').value;
	var effective_date = getID('effective_date1').value;
	if(name.length<1 || funcction.length<1 || manufacturer.length<1 || purchase_price.length<1 || sale_price.length<1 || unit1.length<1
		|| spec.length<1 || produce_date.length<1 || effective_date.length<1
	){
		err+='请完整填写信息';
		return false;
	}else{
		return true;
	}
}

function check1(){
	if(isUpdate() == true){
		return true;
	}else{
		err='';
		isUpdate();
		alert(err);
		return false;
	}
}
function check2(){
	if(isAdd() == true){
		return true;
	}else{
		err='';
		isAdd();
		alert(err);
		return false;
	}
}