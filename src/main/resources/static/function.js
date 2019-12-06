function search(){
    $.ajax({
        url: "/student/show",
        dataType:'json',
        async:true,
        success: function(result ) {
            var table="<table><tr><td>id</td><td>name</td><td>age</td></tr>";
            for(var i=0;i<result.length;i++){
                table=table+"<tr><td>"+result[i].id+"</td><td>"+result[i].name+"</td><td>"+result[i].age+"</td><td><input type='button' value='Delete'  onclick=Delete('"+result[i].id+"')></td><td><input type='button' value='Update' onclick=Update('"+result[i].id+"','"+ i +"')></td></tr>";
            }
            table=table+"</table>";
            $( "#main" ).html(table);
        }
    });
};
function Update(id,number){
    console.log(id,number);
    var num = parseInt(number)+1;
    console.log(num);
    $.ajax({
        url:"/student/show",
        async:true,
        success:function (result) {
            var table="<table><tr><td>id</td><td>name</td><td>age</td></tr>";

            for(var i=0;i<number;i++){
                table=table+"<tr><td>"+result[i].id+"</td><td>"+result[i].name+"</td><td>"+result[i].age+"</td><td><input type='button' value='Delete' onclick=Delete('"+result[i].id+"')></td><td><input type='button' value='Update' onclick=Update('"+result[i].id+"','"+ i +"')></td></tr>";
            }
            table=table+"<tr><td>"+result[number].id+"</td><td><input id=name value='"+result[number].name+"'></td><td><input id='age' value='"+result[number].age+"'></td><td><input type='button' value='Delete' onclick=Delete('"+result[number].id+"')></td><td><input type='button' value='Update' onclick=Update1('"+result[number].id+"','"+result[number].name+"','"+result[number].age+"')></td></tr>";
            for(var i=parseInt(number)+1;i<result.length;i++){
                table=table+"<tr><td>"+result[i].id+"</td><td>"+result[i].name+"</td><td>"+result[i].age+"</td><td><input type='button' value='Delete' onclick=Delete('"+result[i].id+"')></td><td><input type='button' value='Update' onclick=Update('"+result[i].id+"','"+ i +"')></td></tr>";
            }
            table=table+"</table>";
            $( "#main" ).html(table);
        }
    });
}
function Update1(id,name,age) {
    console.log(id,name,age);
    var name01 = $("#name").val();
    var age01 = $("#age").val();
    console.log(name01,age01);
    $.ajax({
        url:"/student/update",
        async:true,
        dataType:"json",
        data:{
            'id':id,
            'name':name01,
            'age':age01
        },
        success:function (result) {
            if(result){
                search();
            }
        }
    });

}
function Delete(id) {
    console.log(id);
    $.ajax({
        url: "/student/delete",
        data:{
            id:id
        },
        async:true,
        success: function(result){
            console.log(result);
            if(result) {
                search();
            }
        }
    });

}

