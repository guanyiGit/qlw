$(function () {
    $(".form-input").focus(function () {
        $(".search-icon").animate({"left": "251px"}, 500);
        $(this).animate({"text-indent": "2em"}, 500)
    })
    $(".form-input").blur(function () {
        if (!$(this).val()) {
            $(".search-icon").animate({"left": "-33px"}, 500);
            $(this).animate({"text-indent": "4em"}, 500)
        }
    })
});