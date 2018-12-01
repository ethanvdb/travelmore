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
        $(".reis-filter").slideUp();
        $(".open-filter").show();
    });


    
     $("#inputLand").click(function(){
         $(".form-group").animate({ left: '0%', width:'100%'});
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


