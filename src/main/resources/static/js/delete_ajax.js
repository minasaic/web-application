// $(function() {
//     $("button").on('click', function() {
//         $.ajax({
//             success: function() {
// 				alert("seiko");
//             },
//             error: function() {
//                 alert('通信に失敗しました。');
//             }
//         });
//     });
// });
$(function() {
    $("button").on('click', function() {
        $.ajax({
            
            success: function() {
                alert("seikou")
            },
            error: function() {
                alert('通信に失敗しました。');
            }
        });
    });
});

// $(function() {
//     $('#ajaxButton').on('click', function() {
//         $.ajax({
//             url: '/js/data.txt',
//             type: 'GET',
//             dataType: 'text',
//             success: function(data) {
//                 $('#result').html(data);
//             },
//             error: function() {
//                 alert('通信に失敗しました。');
//             }
//         });
//     });
// });
alert("hehe");


// $(document).ready(function() {
//     $(".delete-button").on("click", function() {
//         var id = $(this).data("id");
//         $.ajax({
//             type: "POST",
//             url: "/delete",
//             data: {id: id},
//             success: function() {
//                 // 削除が成功した場合の処理をここに記述する
//             }
//         });
//     });
// });
