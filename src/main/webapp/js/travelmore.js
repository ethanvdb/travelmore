$(document).ready(function(){
    $(".reis-zoek").hide();
    $(".reis-filter").hide();

    $(".zoeken-menuknop").click(function(){
        zoekToggle();
    });

    $(".open-filter").click(function(){
        $(".reis-filter").slideDown();
        $(".open-filter").hide();
    });

    $(".filter-knop").click(function () {
        $(".reis-filter").slideUp(function(){
            $(".open-filter").show();
        });
    });


    
     $("#inputLand").click(function(){
         $(".form-group").animate({ left: '0%', width:'100%'});
    });

    $imgSrc = $('#imgProfile').attr('src');
    function readURL(input) {

        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#imgProfile').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }
    $('#btnChangePicture').on('click', function () {
        // document.getElementById('profilePicture').click();
        if (!$('#btnChangePicture').hasClass('changing')) {
            $('#profilePicture').click();
        }
        else {
            // change
        }
    });
    $('#profilePicture').on('change', function () {
        readURL(this);
        $('#btnChangePicture').addClass('changing');
        $('#btnChangePicture').attr('value', 'Confirm');
        $('#btnDiscard').removeClass('d-none');
        // $('#imgProfile').attr('src', '');
    });
    $('#btnDiscard').on('click', function () {
        // if ($('#btnDiscard').hasClass('d-none')) {
        $('#btnChangePicture').removeClass('changing');
        $('#btnChangePicture').attr('value', 'Change');
        $('#btnDiscard').addClass('d-none');
        $('#imgProfile').attr('src', $imgSrc);
        $('#profilePicture').val('');
        // }
    });

    
});

function zoekToggle(){
    if($(".reis-zoek").is(":hidden")){
        $(".reis-zoek").slideDown();
    }else{
        $(".reis-zoek").slideUp();
        $(".form-group").css("left", "35%");
        $(".form-group").width("30%");
    }
}




