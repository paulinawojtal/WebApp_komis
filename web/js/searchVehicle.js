/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $('#search').click(function(){
        var selCol = $('#columns').val();
        $.ajax({
            type:'POST',
            data: {columns: columns},
            url:"searchVehicle",
            success: function(result){
                $('#selectedCol').html(result);
            }
        })
    })
});


