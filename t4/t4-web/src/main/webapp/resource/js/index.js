$(function () {
    $(document).on('click','#guide', function () {
        $(this).toggleClass('toggle');
    });

    Waves.displayEffect();

    $(document).on('click','.s-profile a', function () {
        $(this).next().slideToggle(200);
        $(this).parent().toggleClass('toggle');
    });

    $(document).on('click','.sub-menu a', function () {
        $(this).next().slideToggle(200);
        $(this).parent().toggleClass('toggle');
    });
});

// 选项卡操作
$(function () {
    $(document).on('click', '.content_tab li', function () {
        $('.content_tab li').removeClass('cur');
        $(this).addClass('cur');

        Tab.closeTab($(this));

    });
});


var Tab = {
    addTab: function (title, url) {
        var index = url.replace(/\//g,'_').replace(/\?/g,'_').replace(/&/g,'_').replace(/=/g,'_').replace(/:/g,'_');
        // 如果不存在选项卡，则添加。如果存在，则点击切换。
        if ($('#tab_'+index).length == 0){
            $('.content_tab li').removeClass('cur');
            var tab = '<li id="tab_' + index + '" data-index="' + index + '" class="cur"><a class="waves-effect waves-light">'+title+'</a></li>';
            $('.content_tab > ul').append(tab);
        } else {
            $('#tab_'+index).trigger('click');
        }
    },
    closeTab: function ($item) {
         var closeable = $item.data('closeable');
         if (closeable != false) {
             if ($item.hasClass('cur')) {
                 $item.prev().trigger('click');
             }
             $item.remove();
         }
    }
};