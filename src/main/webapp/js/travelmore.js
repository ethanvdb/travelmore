$(document).ready(function(){
    $(".reis-zoek").hide();

    $(".zoeken-menuknop").click(function(){
        zoekToggle();
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

