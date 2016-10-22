package com.maqianyu.nicedrama.map.quickhead;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/22.
 */
public class Bean {


    /**
     * result : 1
     * feeds : [{"following":0,"comments":[],"caption":"还在下雨烦死了","verified":false,"hasMagicFaceTag":true,"tags":[],"time":"2016-10-22 07:02:53","timestamp":1477090973130,"type":1,"user_id":142616088,"comment_count":194,"photo_id":1175178070,"exp_tag":"1_a/1548847878074806273_h85","user_sex":"F","photo_status":0,"us_m":0,"view_count":195951,"like_count":1598,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"BAB489","w":480,"sound":16927,"h":640,"interval":5,"video":16850},"tag_hash_type":1,"user_name":"小★咪姐5210","liked":0,"main_mv_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAyNTJfMTQyNjE2MDg4XzExNzUxNzgwNzBfMl8z.mp4?tag=1-1477096443-h-0-dihsna4uyv-c7b45c8d94907f5c"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAyNTJfMTQyNjE2MDg4XzExNzUxNzgwNzBfMl8z.mp4?tag=1-1477096443-h-1-tfk4grsnil-e4064179f5a92b44"}],"cover_thumbnail_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAyNTJfMTQyNjE2MDg4XzExNzUxNzgwNzBfMl8z_low.webp?tag=1-1477096443-h-0-s3wd4jlgiu-290413a3a5b5d42c"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAyNTJfMTQyNjE2MDg4XzExNzUxNzgwNzBfMl8z_low.webp?tag=1-1477096443-h-1-yqr81bxfff-412e3cc3e49db4ce"}],"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h85"},"reco_reason":"h85"},{"following":0,"music":{"image":"http://img4.kuwo.cn/star/albumcover/500/46/80/2572133421.jpg","artist":"童可可","artistId":"124298","lrc":"http://static.yximgs.com/udata/music/d9S6OzdSVp4_bgm.trcx","chorus":0,"auditionUrl":"http://m.kuwo.cn/?mid=MUSIC_6478447&bdfrom=ks","avatarUrl":"http://img4.kuwo.cn/star/starheads/150/16/85/44330486.jpg","duration":181,"name":"萌萌滴乖乖滴","id":6478447,"type":1},"comments":[],"caption":"没事干，只是发这个小萌萌的视频了\u2026\u2026","poi":{"title":"六安","latitude":31.681499,"longitude":115.887819,"id":16110},"verified":false,"tags":[],"time":"2016-10-20 19:17:40","timestamp":1476962260572,"type":1,"user_id":11876231,"comment_count":56,"photo_id":1170610121,"exp_tag":"1_i/1548847878074806273_h85","user_sex":"M","photo_status":0,"us_m":0,"view_count":411837,"like_count":1002,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"645255","w":480,"sound":7685,"h":640,"interval":19,"video":7633},"tag_hash_type":1,"user_name":"RockyDaddy","liked":0,"main_mv_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/20/19/BMjAxNjEwMjAxOTE3NDBfMTE4NzYyMzFfMTE3MDYxMDEyMV8xXzM=.mp4?tag=1-1477096443-h-0-7k9jqzshev-cb57e8d647bc67e1"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/20/19/BMjAxNjEwMjAxOTE3NDBfMTE4NzYyMzFfMTE3MDYxMDEyMV8xXzM=.mp4?tag=1-1477096443-h-1-pmve4xgpbp-8b6f87fdb6c3af7e"}],"cover_thumbnail_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/20/19/BMjAxNjEwMjAxOTE3NDBfMTE4NzYyMzFfMTE3MDYxMDEyMV8xXzM=_low.webp?tag=1-1477096443-h-0-8dwwlkpcfr-f57fe011fd5f37f9"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/20/19/BMjAxNjEwMjAxOTE3NDBfMTE4NzYyMzFfMTE3MDYxMDEyMV8xXzM=_low.webp?tag=1-1477096443-h-1-u0tcrc0asl-2151aaca9806b7cc"}],"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/09/24/17/BMjAxNjA5MjQxNzM1MDVfMTE4NzYyMzFfMV9oZDIw.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/09/24/17/BMjAxNjA5MjQxNzM1MDVfMTE4NzYyMzFfMV9oZDIw.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/09/24/17/BMjAxNjA5MjQxNzM1MDVfMTE4NzYyMzFfMV9oZDIw.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/09/24/17/BMjAxNjA5MjQxNzM1MDVfMTE4NzYyMzFfMV9oZDIw.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_i/1548847878074806273_h85"},"reco_reason":"h85"},{"following":0,"music":{"image":"http://img4.kuwo.cn/star/albumcover/500/4/94/1844330661.jpg","artist":"韩红","artistId":"1332","lrc":"http://static.yximgs.com/udata/music/1irEkbLsFXo_bgm.trcx","chorus":0,"auditionUrl":"http://m.kuwo.cn/?mid=MUSIC_6105666&bdfrom=ks","avatarUrl":"http://img1.kuwo.cn/star/starheads/150/60/1/1443842864.jpg","duration":152,"name":"九儿-(电视剧《红高粱》主题曲)","id":6105666,"type":1},"comments":[],"caption":"奶奶这是炒菜用的油，不能喝，奶奶95岁了没有见过油。","verified":false,"hasMagicFaceTag":true,"tags":[],"time":"2016-10-21 14:34:22","timestamp":1477031662248,"type":1,"user_id":239999099,"comment_count":2153,"photo_id":1172809110,"exp_tag":"1_a/1548847878074806273_h85","user_sex":"F","photo_status":0,"us_m":0,"view_count":961958,"like_count":9161,"unlike_count":0,"forward_count":1,"ext_params":{"mtype":3,"color":"7C716D","w":480,"sound":17182,"h":640,"interval":5,"video":17100},"tag_hash_type":1,"user_name":"淡定家族~蕊蕊","liked":0,"main_mv_urls":[{"cdn":"bd.a.yximgs.com","url":"http://bd.a.yximgs.com/upic/2016/10/21/14/BMjAxNjEwMjExNDM0MjFfMjM5OTk5MDk5XzExNzI4MDkxMTBfMl8z.mp4?tag=1-1477096443-h-0-sqt56bkoxz-1d806392c4117ef2"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/14/BMjAxNjEwMjExNDM0MjFfMjM5OTk5MDk5XzExNzI4MDkxMTBfMl8z.mp4?tag=1-1477096443-h-1-eoqp2pezic-fd1affb34b492ff0"}],"cover_thumbnail_urls":[{"cdn":"bd.a.yximgs.com","url":"http://bd.a.yximgs.com/upic/2016/10/21/14/BMjAxNjEwMjExNDM0MjFfMjM5OTk5MDk5XzExNzI4MDkxMTBfMl8z_low.webp?tag=1-1477096443-h-0-kn29tywpnk-3581136220cc5b4c"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/14/BMjAxNjEwMjExNDM0MjFfMjM5OTk5MDk5XzExNzI4MDkxMTBfMl8z_low.webp?tag=1-1477096443-h-1-cqfxoudjhc-e95c366e9e623abc"}],"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/04/17/BMjAxNjEwMDQxNzU3NDNfMjM5OTk5MDk5XzJfaGQyMA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/04/17/BMjAxNjEwMDQxNzU3NDNfMjM5OTk5MDk5XzJfaGQyMA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/04/17/BMjAxNjEwMDQxNzU3NDNfMjM5OTk5MDk5XzJfaGQyMA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/04/17/BMjAxNjEwMDQxNzU3NDNfMjM5OTk5MDk5XzJfaGQyMA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h85"},"reco_reason":"h85"},{"following":0,"music":{"image":"http://img3.kuwo.cn/star/albumcover/500/76/24/2389636604.jpg","artist":"7妹","artistId":"215882","chorus":0,"auditionUrl":"http://m.kuwo.cn/?mid=MUSIC_6698754&bdfrom=ks","avatarUrl":"http://img1.kuwo.cn/star/starheads/150/92/66/1775174282.jpg","duration":309,"name":"口哨开场就摇头","id":6698754,"type":1},"comments":[],"caption":"...","verified":false,"hasMusicTag":true,"tags":[],"time":"2016-10-21 23:30:36","timestamp":1477063836900,"type":1,"user_id":18037439,"comment_count":286,"photo_id":1174749077,"exp_tag":"1_a/1548847878074806273_h85","user_sex":"M","photo_status":0,"us_m":0,"view_count":2156096,"like_count":2532,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"3E2724","w":480,"sound":7546,"h":640,"interval":5,"video":7500},"tag_hash_type":1,"user_name":"大爱COC丫","liked":0,"main_mv_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/23/BMjAxNjEwMjEyMzMwMzZfMTgwMzc0MzlfMTE3NDc0OTA3N18yXzM=.mp4?tag=1-1477096443-h-0-fvoyfcnn8t-d873e4d1b3556ca5"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/23/BMjAxNjEwMjEyMzMwMzZfMTgwMzc0MzlfMTE3NDc0OTA3N18yXzM=.mp4?tag=1-1477096443-h-1-ao2awyijub-845ac34333d42b2f"}],"cover_thumbnail_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/23/BMjAxNjEwMjEyMzMwMzZfMTgwMzc0MzlfMTE3NDc0OTA3N18yXzM=_low.webp?tag=1-1477096443-h-0-n03rlokkpw-1bcb5c613e039220"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/23/BMjAxNjEwMjEyMzMwMzZfMTgwMzc0MzlfMTE3NDc0OTA3N18yXzM=_low.webp?tag=1-1477096443-h-1-ydos07a0g9-18a086eaef1129a8"}],"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/09/30/22/BMjAxNjA5MzAyMjU3NTdfMTgwMzc0MzlfMl9oZDY=.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/09/30/22/BMjAxNjA5MzAyMjU3NTdfMTgwMzc0MzlfMl9oZDY=.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/09/30/22/BMjAxNjA5MzAyMjU3NTdfMTgwMzc0MzlfMl9oZDY=.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/09/30/22/BMjAxNjA5MzAyMjU3NTdfMTgwMzc0MzlfMl9oZDY=.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h85"},"reco_reason":"h85"},{"following":0,"music":{"artist":"Jaci Velasquez","artistId":"257","lrc":"http://static.yximgs.com/udata/music/W5kHRRQnR2I_bgm.trcx","chorus":42026,"auditionUrl":"http://m.kuwo.cn/?mid=MUSIC_1100750&bdfrom=ks","avatarUrl":"http://img4.kuwo.cn/star/starheads/150/79/41/3883363289.jpg","duration":223,"name":"Destiny(完整版)","id":1100750,"type":1},"comments":[],"caption":"...","poi":{"title":"北京","latitude":39.999719,"longitude":116.338074,"id":2},"verified":false,"tags":[],"time":"2016-10-21 10:24:30","timestamp":1477016670696,"type":1,"user_id":240508565,"comment_count":24,"photo_id":1172148972,"exp_tag":"1_i/1548847878074806273_h86","user_sex":"F","photo_status":0,"us_m":0,"view_count":146253,"like_count":368,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"795C54","w":480,"sound":17600,"h":640,"interval":20,"video":17538},"tag_hash_type":1,"user_name":" 奥莉＆麻吉 ","liked":0,"main_mv_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/10/BMjAxNjEwMjExMDI0MzBfMjQwNTA4NTY1XzExNzIxNDg5NzJfMV8z.mp4?tag=1-1477096443-h-0-8okakgikho-5138b5a2cfae1ae7"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/10/BMjAxNjEwMjExMDI0MzBfMjQwNTA4NTY1XzExNzIxNDg5NzJfMV8z.mp4?tag=1-1477096443-h-1-fdfts2inkw-fcf23a806d3d1d1f"}],"cover_thumbnail_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/10/BMjAxNjEwMjExMDI0MzBfMjQwNTA4NTY1XzExNzIxNDg5NzJfMV8z_low.webp?tag=1-1477096443-h-0-abecxyb1or-0c931ec31acb9661"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/10/BMjAxNjEwMjExMDI0MzBfMjQwNTA4NTY1XzExNzIxNDg5NzJfMV8z_low.webp?tag=1-1477096443-h-1-sfglcukpjv-0336cf96e643c858"}],"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/17/13/BMjAxNjEwMTcxMzUzMjhfMjQwNTA4NTY1XzFfaGQyNw==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/17/13/BMjAxNjEwMTcxMzUzMjhfMjQwNTA4NTY1XzFfaGQyNw==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/17/13/BMjAxNjEwMTcxMzUzMjhfMjQwNTA4NTY1XzFfaGQyNw==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/17/13/BMjAxNjEwMTcxMzUzMjhfMjQwNTA4NTY1XzFfaGQyNw==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_i/1548847878074806273_h86"},"reco_reason":"h86"},{"following":0,"music":{"image":"http://img1.kuwo.cn/star/albumcover/500/84/99/293528885.jpg","artist":"Made In Heights","artistId":"252630","lrc":"http://static.yximgs.com/udata/music/V2cFWgRTQkA_bgm.trcx","chorus":0,"auditionUrl":"http://m.kuwo.cn/?mid=MUSIC_6454165&bdfrom=ks","avatarUrl":"http://img2.kuwo.cn/star/starheads/150/93/53/2217771127.jpg","duration":220,"name":"Pop It In 2","id":6454165,"type":1},"comments":[],"caption":"早安！谁希望我每天更新，谁希望每天看到我？有木有爱我的宝宝 @没错闹就是你琪姐姐","verified":false,"hasMagicFaceTag":true,"tags":[],"time":"2016-10-21 11:06:49","timestamp":1477019209439,"type":1,"user_id":218035461,"comment_count":0,"photo_id":1172246805,"exp_tag":"1_a/1548847878074806273_h86","user_sex":"F","photo_status":0,"us_m":1,"view_count":156411,"like_count":799,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"B46158","w":480,"sound":17322,"h":640,"interval":5,"video":17250},"tag_hash_type":1,"user_name":" MC另类婷宝","liked":0,"main_mv_urls":[{"cdn":"bd.a.yximgs.com","url":"http://bd.a.yximgs.com/upic/2016/10/21/11/BMjAxNjEwMjExMTA2NDhfMjE4MDM1NDYxXzExNzIyNDY4MDVfMl8z.mp4?tag=1-1477096443-h-0-frbsol1i3u-b3d08c72a1b37815"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/11/BMjAxNjEwMjExMTA2NDhfMjE4MDM1NDYxXzExNzIyNDY4MDVfMl8z.mp4?tag=1-1477096443-h-1-zxr8f5fvfu-f107f2d77ed8e86b"}],"cover_thumbnail_urls":[{"cdn":"bd.a.yximgs.com","url":"http://bd.a.yximgs.com/upic/2016/10/21/11/BMjAxNjEwMjExMTA2NDhfMjE4MDM1NDYxXzExNzIyNDY4MDVfMl8z_low.webp?tag=1-1477096443-h-0-1a3zlg8fam-8ad8091a8c450ded"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/11/BMjAxNjEwMjExMTA2NDhfMjE4MDM1NDYxXzExNzIyNDY4MDVfMl8z_low.webp?tag=1-1477096443-h-1-k1safvctls-20bc8af8a9295fd4"}],"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/10/17/BMjAxNjEwMTAxNzAwMTJfMjE4MDM1NDYxXzJfaGQxOQ==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/10/17/BMjAxNjEwMTAxNzAwMTJfMjE4MDM1NDYxXzJfaGQxOQ==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/10/17/BMjAxNjEwMTAxNzAwMTJfMjE4MDM1NDYxXzJfaGQxOQ==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/10/17/BMjAxNjEwMTAxNzAwMTJfMjE4MDM1NDYxXzJfaGQxOQ==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"us_c":1,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h86"},"reco_reason":"h86"},{"following":0,"comments":[],"caption":"...","verified":false,"hasMagicFaceTag":true,"tags":[],"time":"2016-10-21 23:27:57","timestamp":1477063677628,"type":1,"user_id":13448987,"comment_count":215,"photo_id":1174741281,"exp_tag":"1_a/1548847878074806273_h85","user_sex":"M","photo_status":0,"us_m":0,"view_count":790748,"like_count":2180,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"6B5A59","w":480,"sound":7500,"h":640,"interval":5,"video":7450},"tag_hash_type":1,"user_name":"山东 马甲","liked":0,"main_mv_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/23/BMjAxNjEwMjEyMzI3NTdfMTM0NDg5ODdfMTE3NDc0MTI4MV8yXzM=.mp4?tag=1-1477096443-h-0-mybkajelwu-c41f9dea2633e31e"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/23/BMjAxNjEwMjEyMzI3NTdfMTM0NDg5ODdfMTE3NDc0MTI4MV8yXzM=.mp4?tag=1-1477096443-h-1-wehfuq8b0a-63540baaa9286023"}],"cover_thumbnail_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/23/BMjAxNjEwMjEyMzI3NTdfMTM0NDg5ODdfMTE3NDc0MTI4MV8yXzM=_low.webp?tag=1-1477096443-h-0-sruupy3nqj-87e0f86bdf9606c5"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/23/BMjAxNjEwMjEyMzI3NTdfMTM0NDg5ODdfMTE3NDc0MTI4MV8yXzM=_low.webp?tag=1-1477096443-h-1-vdanhd7vid-0a5abd3c10a9152c"}],"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/08/06/22/BMjAxNjA4MDYyMjI1NDNfMTM0NDg5ODdfMl9oZDE4.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/08/06/22/BMjAxNjA4MDYyMjI1NDNfMTM0NDg5ODdfMl9oZDE4.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/08/06/22/BMjAxNjA4MDYyMjI1NDNfMTM0NDg5ODdfMl9oZDE4.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/08/06/22/BMjAxNjA4MDYyMjI1NDNfMTM0NDg5ODdfMl9oZDE4.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h85"},"reco_reason":"h85"},{"following":0,"comments":[],"caption":"...","verified":false,"hasMagicFaceTag":true,"tags":[],"time":"2016-10-21 12:34:13","timestamp":1477024453724,"type":1,"user_id":318367717,"comment_count":151,"photo_id":1172468416,"exp_tag":"1_a/1548847878074806273_h86","user_sex":"M","photo_status":0,"us_m":0,"view_count":423423,"like_count":229,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"534E49","w":480,"sound":17577,"h":640,"interval":5,"video":17500},"tag_hash_type":1,"user_name":"和谐家园～辉煌国际","liked":0,"main_mv_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/12/BMjAxNjEwMjExMjM0MTNfMzE4MzY3NzE3XzExNzI0Njg0MTZfMl8z.mp4?tag=1-1477096443-h-0-zivmvoiujb-8594c408773e372d"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/12/BMjAxNjEwMjExMjM0MTNfMzE4MzY3NzE3XzExNzI0Njg0MTZfMl8z.mp4?tag=1-1477096443-h-1-rm6wh4eggc-07596a03766503be"}],"cover_thumbnail_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/12/BMjAxNjEwMjExMjM0MTNfMzE4MzY3NzE3XzExNzI0Njg0MTZfMl8z_low.webp?tag=1-1477096443-h-0-atjzdv0lsy-2f5ed2a15d010e2d"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/12/BMjAxNjEwMjExMjM0MTNfMzE4MzY3NzE3XzExNzI0Njg0MTZfMl8z_low.webp?tag=1-1477096443-h-1-3kftlmn2sr-c5a36a7d83db12aa"}],"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/08/26/18/BMjAxNjA4MjYxODU3NDdfMzE4MzY3NzE3XzJfaGQ5MQ==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/08/26/18/BMjAxNjA4MjYxODU3NDdfMzE4MzY3NzE3XzJfaGQ5MQ==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/08/26/18/BMjAxNjA4MjYxODU3NDdfMzE4MzY3NzE3XzJfaGQ5MQ==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/08/26/18/BMjAxNjA4MjYxODU3NDdfMzE4MzY3NzE3XzJfaGQ5MQ==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h86"},"reco_reason":"h86"},{"following":0,"music":{"image":"http://img4.kuwo.cn/star/albumcover/500/84/98/2546543626.jpg","artist":"EXID","artistId":"70245","lrc":"http://static.yximgs.com/udata/music/myXvohsOkko_bgm.trcx","chorus":0,"auditionUrl":"http://m.kuwo.cn/?mid=MUSIC_5269896&bdfrom=ks","avatarUrl":"http://img3.kuwo.cn/star/starheads/150/44/99/158459969.jpg","duration":190,"name":"上和下","id":5269896,"type":1},"comments":[],"caption":"音乐没配上","verified":false,"hasMagicFaceTag":true,"hasMusicTag":true,"tags":[],"time":"2016-10-22 02:29:21","timestamp":1477074561125,"type":1,"user_id":18517478,"comment_count":51,"photo_id":1175041132,"exp_tag":"1_a/1548847878074806273_h85","user_sex":"F","photo_status":0,"us_m":0,"view_count":182009,"like_count":1015,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"7D515E","w":480,"sound":14373,"h":640,"interval":5,"video":14300},"tag_hash_type":1,"user_name":"沐子\u2015\u2015","liked":0,"main_mv_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/22/02/BMjAxNjEwMjIwMjI5MjBfMTg1MTc0NzhfMTE3NTA0MTEzMl8yXzM=.mp4?tag=1-1477096443-h-0-dfxdozckpn-1029f2ebb9c97e5c"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/22/02/BMjAxNjEwMjIwMjI5MjBfMTg1MTc0NzhfMTE3NTA0MTEzMl8yXzM=.mp4?tag=1-1477096443-h-1-a52x8kxnnv-608a49d65db4888c"}],"cover_thumbnail_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/22/02/BMjAxNjEwMjIwMjI5MjBfMTg1MTc0NzhfMTE3NTA0MTEzMl8yXzM=_low.webp?tag=1-1477096443-h-0-grvt2zwdnh-9f8eb8069f47edba"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/22/02/BMjAxNjEwMjIwMjI5MjBfMTg1MTc0NzhfMTE3NTA0MTEzMl8yXzM=_low.webp?tag=1-1477096443-h-1-whoqxdf30m-6d5c155b8802d82f"}],"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/12/16/BMjAxNjEwMTIxNjUyMDFfMTg1MTc0NzhfMl9oZDE2.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/12/16/BMjAxNjEwMTIxNjUyMDFfMTg1MTc0NzhfMl9oZDE2.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/12/16/BMjAxNjEwMTIxNjUyMDFfMTg1MTc0NzhfMl9oZDE2.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/12/16/BMjAxNjEwMTIxNjUyMDFfMTg1MTc0NzhfMl9oZDE2.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h85"},"reco_reason":"h85"},{"following":0,"comments":[],"caption":"...","verified":false,"hasMagicFaceTag":true,"tags":[],"time":"2016-10-21 08:39:12","timestamp":1477010352294,"type":1,"user_id":208308596,"comment_count":244,"photo_id":1171955941,"exp_tag":"1_a/1548847878074806273_h85","user_sex":"F","photo_status":0,"us_m":1,"view_count":140411,"like_count":775,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"9A9DB0","w":480,"sound":7569,"h":640,"interval":5,"video":7500},"tag_hash_type":1,"user_name":"美好的往来","liked":0,"main_mv_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/08/BMjAxNjEwMjEwODM5MTFfMjA4MzA4NTk2XzExNzE5NTU5NDFfMl8z.mp4?tag=1-1477096443-h-0-xuwokjifs2-ce2bac7d51e297b5"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/08/BMjAxNjEwMjEwODM5MTFfMjA4MzA4NTk2XzExNzE5NTU5NDFfMl8z.mp4?tag=1-1477096443-h-1-adtinfrzqv-090b848ae15fd389"}],"cover_thumbnail_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/08/BMjAxNjEwMjEwODM5MTFfMjA4MzA4NTk2XzExNzE5NTU5NDFfMl8z_low.webp?tag=1-1477096443-h-0-ah0luhid4a-c20f41fbdd1d8acc"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/08/BMjAxNjEwMjEwODM5MTFfMjA4MzA4NTk2XzExNzE5NTU5NDFfMl8z_low.webp?tag=1-1477096443-h-1-jkwblyvaot-2818b218ef10e04a"}],"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/08/06/10/BMjAxNjA4MDYxMDI5MjZfMjA4MzA4NTk2XzJfaGQ1MA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/08/06/10/BMjAxNjA4MDYxMDI5MjZfMjA4MzA4NTk2XzJfaGQ1MA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/08/06/10/BMjAxNjA4MDYxMDI5MjZfMjA4MzA4NTk2XzJfaGQ1MA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/08/06/10/BMjAxNjA4MDYxMDI5MjZfMjA4MzA4NTk2XzJfaGQ1MA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h85"},"reco_reason":"h85"},{"following":0,"comments":[],"caption":"   ","verified":false,"hasMagicFaceTag":true,"tags":[],"time":"2016-10-21 20:13:05","timestamp":1477051985979,"type":1,"user_id":257921899,"comment_count":166,"photo_id":1173981013,"exp_tag":"1_a/1548847878074806273_h85","user_sex":"M","photo_status":0,"us_m":1,"view_count":1442834,"like_count":2218,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"7F7362","w":480,"sound":7546,"h":640,"interval":5,"video":7500},"tag_hash_type":1,"user_name":"大王与小王。","liked":0,"main_mv_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/20/BMjAxNjEwMjEyMDEzMDVfMjU3OTIxODk5XzExNzM5ODEwMTNfMl8z.mp4?tag=1-1477096443-h-0-54wbyjp40o-b68de17b8b754c35"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/20/BMjAxNjEwMjEyMDEzMDVfMjU3OTIxODk5XzExNzM5ODEwMTNfMl8z.mp4?tag=1-1477096443-h-1-mkfurtbabx-329c55fc877158af"}],"cover_thumbnail_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/20/BMjAxNjEwMjEyMDEzMDVfMjU3OTIxODk5XzExNzM5ODEwMTNfMl8z_low.webp?tag=1-1477096443-h-0-pjtw6pzetl-69a35d6744e0619b"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/20/BMjAxNjEwMjEyMDEzMDVfMjU3OTIxODk5XzExNzM5ODEwMTNfMl8z_low.webp?tag=1-1477096443-h-1-yj0rax6nfo-df69bc5aed2ea083"}],"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/07/21/17/BMjAxNjA3MjExNzI2NDhfMjU3OTIxODk5XzJfaGQ5NA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/07/21/17/BMjAxNjA3MjExNzI2NDhfMjU3OTIxODk5XzJfaGQ5NA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/07/21/17/BMjAxNjA3MjExNzI2NDhfMjU3OTIxODk5XzJfaGQ5NA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/07/21/17/BMjAxNjA3MjExNzI2NDhfMjU3OTIxODk5XzJfaGQ5NA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h85"},"reco_reason":"h85"},{"following":0,"music":{"image":"http://img1.kuwo.cn/star/albumcover/500/99/42/3254263740.jpg","artist":"倪雅丰","artistId":"2429","lrc":"http://static.yximgs.com/udata/music/kbr38ew9Cao_bgm.trcx","chorus":52099,"auditionUrl":"http://m.kuwo.cn/?mid=MUSIC_135246&bdfrom=ks","avatarUrl":"http://img2.kuwo.cn/star/starheads/150/40/5/91159804.jpg","duration":196,"name":"柠檬树","id":135246,"type":1},"comments":[],"caption":"...","verified":false,"hasMagicFaceTag":true,"hasMusicTag":true,"tags":[],"time":"2016-10-20 17:13:19","timestamp":1476954799870,"type":1,"user_id":4862102,"comment_count":140,"photo_id":1170207950,"exp_tag":"1_a/1548847878074806273_h86","user_sex":"F","photo_status":0,"us_m":0,"view_count":1249882,"like_count":1849,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"948F83","w":480,"sound":7569,"h":640,"interval":5,"video":7500},"tag_hash_type":1,"user_name":"尹白雪公主","liked":0,"main_mv_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/20/17/BMjAxNjEwMjAxNzEzMTlfNDg2MjEwMl8xMTcwMjA3OTUwXzJfMw==.mp4?tag=1-1477096443-h-0-e6gzbdtsng-d7d4f7b66eb43898"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/20/17/BMjAxNjEwMjAxNzEzMTlfNDg2MjEwMl8xMTcwMjA3OTUwXzJfMw==.mp4?tag=1-1477096443-h-1-oxytxjhal3-c8271861b5aeba71"}],"cover_thumbnail_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/20/17/BMjAxNjEwMjAxNzEzMTlfNDg2MjEwMl8xMTcwMjA3OTUwXzJfMw==_low.webp?tag=1-1477096443-h-0-lscbgwvznd-45b5e1d93cd7b2a1"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/20/17/BMjAxNjEwMjAxNzEzMTlfNDg2MjEwMl8xMTcwMjA3OTUwXzJfMw==_low.webp?tag=1-1477096443-h-1-zg5owtzkea-174c55d7edbbcc17"}],"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/09/07/20/BMjAxNjA5MDcyMDQwMjVfNDg2MjEwMl8yX2hkNDk=.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/09/07/20/BMjAxNjA5MDcyMDQwMjVfNDg2MjEwMl8yX2hkNDk=.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/09/07/20/BMjAxNjA5MDcyMDQwMjVfNDg2MjEwMl8yX2hkNDk=.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/09/07/20/BMjAxNjA5MDcyMDQwMjVfNDg2MjEwMl8yX2hkNDk=.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h86"},"reco_reason":"h86"},{"following":0,"comments":[],"caption":"...","verified":false,"tags":[],"time":"2016-10-20 21:53:21","timestamp":1476971601737,"type":1,"user_id":221919905,"comment_count":0,"photo_id":1171185006,"exp_tag":"1_a/1548847878074806273_h86","user_sex":"F","photo_status":0,"us_m":0,"view_count":327067,"like_count":1364,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"A69694","w":480,"sound":17205,"h":640,"interval":5,"video":17150},"tag_hash_type":1,"user_name":"～ 金大大","liked":0,"main_mv_urls":[{"cdn":"bd.a.yximgs.com","url":"http://bd.a.yximgs.com/upic/2016/10/20/21/BMjAxNjEwMjAyMTUzMjFfMjIxOTE5OTA1XzExNzExODUwMDZfMl8z.mp4?tag=1-1477096443-h-0-9wzm8eudjk-996249691ffcce96"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/20/21/BMjAxNjEwMjAyMTUzMjFfMjIxOTE5OTA1XzExNzExODUwMDZfMl8z.mp4?tag=1-1477096443-h-1-juqt46qwj7-4a7ca083d1be9fe9"}],"cover_thumbnail_urls":[{"cdn":"bd.a.yximgs.com","url":"http://bd.a.yximgs.com/upic/2016/10/20/21/BMjAxNjEwMjAyMTUzMjFfMjIxOTE5OTA1XzExNzExODUwMDZfMl8z_low.webp?tag=1-1477096443-h-0-8p6sgyowbt-d1b553d75cead094"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/20/21/BMjAxNjEwMjAyMTUzMjFfMjIxOTE5OTA1XzExNzExODUwMDZfMl8z_low.webp?tag=1-1477096443-h-1-kfou5a72a5-ee9e12d1825a6fab"}],"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/09/08/15/BMjAxNjA5MDgxNTU1MzBfMjIxOTE5OTA1XzJfaGQy.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/09/08/15/BMjAxNjA5MDgxNTU1MzBfMjIxOTE5OTA1XzJfaGQy.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/09/08/15/BMjAxNjA5MDgxNTU1MzBfMjIxOTE5OTA1XzJfaGQy.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/09/08/15/BMjAxNjA5MDgxNTU1MzBfMjIxOTE5OTA1XzJfaGQy.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"us_c":1,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h86"},"reco_reason":"h86"},{"following":0,"music":{"image":"http://img3.kuwo.cn/star/albumcover/500/84/98/2546543626.jpg","artist":"何鹏&张靓颖","artistId":"220942","lrc":"http://static.yximgs.com/udata/music/9Qi4Mb4oooQ_bgm.trcx","chorus":76098,"auditionUrl":"http://m.kuwo.cn/?mid=MUSIC_6242281&bdfrom=ks","avatarUrl":"http://img2.kuwo.cn/star/starheads/150/41/25/2192853126.jpg","duration":236,"name":"饿狼传说(DJ加快版)","id":6242281,"type":1},"comments":[],"caption":"想学训犬请关注我！","verified":false,"hasMagicFaceTag":true,"tags":[],"time":"2016-10-21 19:13:36","timestamp":1477048416310,"type":1,"user_id":317056468,"comment_count":184,"photo_id":1173728347,"exp_tag":"1_a/1548847878074806273_h85","user_sex":"M","photo_status":0,"us_m":0,"view_count":1218915,"like_count":2260,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"65682F","w":480,"sound":17182,"h":640,"interval":5,"video":17100},"tag_hash_type":1,"user_name":"悍马犬舍小磊","liked":0,"main_mv_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/19/BMjAxNjEwMjExOTEzMzVfMzE3MDU2NDY4XzExNzM3MjgzNDdfMl8z.mp4?tag=1-1477096443-h-0-xuz4iibga1-91cd533fb9408d41"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/19/BMjAxNjEwMjExOTEzMzVfMzE3MDU2NDY4XzExNzM3MjgzNDdfMl8z.mp4?tag=1-1477096443-h-1-70h5ot3zcr-c0d6aa9107867e28"}],"cover_thumbnail_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/19/BMjAxNjEwMjExOTEzMzVfMzE3MDU2NDY4XzExNzM3MjgzNDdfMl8z_low.webp?tag=1-1477096443-h-0-ejfdnweiiu-99069c88f51b0de9"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/19/BMjAxNjEwMjExOTEzMzVfMzE3MDU2NDY4XzExNzM3MjgzNDdfMl8z_low.webp?tag=1-1477096443-h-1-ksou1vcf29-f8d9c074cdc0b537"}],"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/09/25/19/BMjAxNjA5MjUxOTM4MDlfMzE3MDU2NDY4XzJfaGQzNQ==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/09/25/19/BMjAxNjA5MjUxOTM4MDlfMzE3MDU2NDY4XzJfaGQzNQ==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/09/25/19/BMjAxNjA5MjUxOTM4MDlfMzE3MDU2NDY4XzJfaGQzNQ==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/09/25/19/BMjAxNjA5MjUxOTM4MDlfMzE3MDU2NDY4XzJfaGQzNQ==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h85"},"reco_reason":"h85"},{"following":0,"music":{"image":"http://img4.kuwo.cn/star/albumcover/500/90/34/3114755228.jpg","artist":"G.E.M.邓紫棋","artistId":"5371","lrc":"http://static.yximgs.com/udata/music/ltJ8JJlUH3Q_bgm.trcx","chorus":0,"auditionUrl":"http://m.kuwo.cn/?mid=MUSIC_3991360&bdfrom=ks","avatarUrl":"http://img2.kuwo.cn/star/starheads/150/39/41/2312174491.jpg","duration":247,"name":"存在","id":3991360,"type":1},"comments":[],"caption":"王志信先生的艺术人生","verified":false,"hasMagicFaceTag":true,"hasMusicTag":true,"tags":[],"time":"2016-10-22 07:27:44","timestamp":1477092464778,"type":1,"user_id":239244821,"comment_count":158,"photo_id":1175203916,"exp_tag":"1_a/1548847878074806273_h85","user_sex":"M","photo_status":0,"us_m":0,"view_count":265269,"like_count":1641,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"817260","w":480,"sound":17391,"h":640,"interval":5,"video":17300},"tag_hash_type":1,"user_name":"书画家王志信先生","liked":0,"main_mv_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzI3NDRfMjM5MjQ0ODIxXzExNzUyMDM5MTZfMl8z.mp4?tag=1-1477096443-h-0-9tybvur5lq-b0876b56a833d5c3"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzI3NDRfMjM5MjQ0ODIxXzExNzUyMDM5MTZfMl8z.mp4?tag=1-1477096443-h-1-nets2gt5we-590209cdb6129fbd"}],"cover_thumbnail_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzI3NDRfMjM5MjQ0ODIxXzExNzUyMDM5MTZfMl8z_low.webp?tag=1-1477096443-h-0-29ntc5hn6j-0dc8b1a4c1ae7d2f"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzI3NDRfMjM5MjQ0ODIxXzExNzUyMDM5MTZfMl8z_low.webp?tag=1-1477096443-h-1-xzie0xstn6-9bb6a7e5829614f5"}],"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/06/BMjAxNjEwMjIwNjMwNDJfMjM5MjQ0ODIxXzJfaGQ5Mg==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/22/06/BMjAxNjEwMjIwNjMwNDJfMjM5MjQ0ODIxXzJfaGQ5Mg==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/22/06/BMjAxNjEwMjIwNjMwNDJfMjM5MjQ0ODIxXzJfaGQ5Mg==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/22/06/BMjAxNjEwMjIwNjMwNDJfMjM5MjQ0ODIxXzJfaGQ5Mg==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h85"},"reco_reason":"h85"},{"following":0,"music":{"image":"http://img4.kuwo.cn/star/albumcover/500/98/58/2652312038.jpg","artist":"龙梅子","artistId":"1647","lrc":"http://static.yximgs.com/udata/music/flsN7o6qnn4_bgm.trcx","chorus":111093,"auditionUrl":"http://m.kuwo.cn/?mid=MUSIC_3531833&bdfrom=ks","avatarUrl":"http://img3.kuwo.cn/star/starheads/150/7/3/2303219695.jpg","duration":373,"name":"心痛到什么时候 (DJ阿远 Remix)","id":3531833,"type":1},"comments":[],"caption":"...","verified":false,"hasMusicTag":true,"tags":[],"time":"2016-10-21 05:40:41","timestamp":1476999641988,"type":1,"user_id":338150002,"comment_count":3,"photo_id":1171803887,"exp_tag":"1_i/1548847878074806273_h85","user_sex":"M","photo_status":0,"us_m":0,"view_count":138641,"like_count":63,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"A1857E","w":480,"sound":7616,"h":640,"interval":25,"video":7566},"tag_hash_type":1,"user_name":"呗喽泰迪小熊熊","liked":0,"main_mv_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/05/BMjAxNjEwMjEwNTQwNDFfMzM4MTUwMDAyXzExNzE4MDM4ODdfMV8z.mp4?tag=1-1477096443-h-0-hbo3k6igwy-795a078119ed9491"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/05/BMjAxNjEwMjEwNTQwNDFfMzM4MTUwMDAyXzExNzE4MDM4ODdfMV8z.mp4?tag=1-1477096443-h-1-bfdk0lfhbq-93b1d8baf665ba20"}],"cover_thumbnail_urls":[{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/21/05/BMjAxNjEwMjEwNTQwNDFfMzM4MTUwMDAyXzExNzE4MDM4ODdfMV8z_low.webp?tag=1-1477096443-h-0-90wmqg7wfw-fa5bc0b3f40ad57b"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/21/05/BMjAxNjEwMjEwNTQwNDFfMzM4MTUwMDAyXzExNzE4MDM4ODdfMV8z_low.webp?tag=1-1477096443-h-1-rrefokk4ds-3d290c09c7d82938"}],"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/09/18/16/BMjAxNjA5MTgxNjQ1NDBfMzM4MTUwMDAyXzFfaGQzMQ==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/09/18/16/BMjAxNjA5MTgxNjQ1NDBfMzM4MTUwMDAyXzFfaGQzMQ==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/09/18/16/BMjAxNjA5MTgxNjQ1NDBfMzM4MTUwMDAyXzFfaGQzMQ==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/09/18/16/BMjAxNjA5MTgxNjQ1NDBfMzM4MTUwMDAyXzFfaGQzMQ==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_i/1548847878074806273_h85"},"reco_reason":"h85"},{"following":0,"comments":[],"caption":"...","verified":false,"hasMagicFaceTag":true,"tags":[],"time":"2016-10-22 07:00:53","timestamp":1477090853930,"type":1,"user_id":219831004,"comment_count":131,"photo_id":1175176229,"exp_tag":"1_a/1548847878074806273_h85","user_sex":"M","photo_status":0,"us_m":0,"view_count":398806,"like_count":993,"unlike_count":0,"forward_count":0,"ext_params":{"mtype":3,"color":"AD9374","w":480,"sound":7546,"h":640,"interval":5,"video":7500},"tag_hash_type":1,"user_name":"兄弟犬业文哥","liked":0,"main_mv_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAwNTNfMjE5ODMxMDA0XzExNzUxNzYyMjlfMl8z.mp4?tag=1-1477096443-h-0-rxtaj4sevv-5c5239636bf249c1"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAwNTNfMjE5ODMxMDA0XzExNzUxNzYyMjlfMl8z.mp4?tag=1-1477096443-h-1-lkhnjh9889-3321572a2b74938a"}],"cover_thumbnail_urls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAwNTNfMjE5ODMxMDA0XzExNzUxNzYyMjlfMl8z_low.webp?tag=1-1477096443-h-0-bococausyy-1d79291c1f434f21"},{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAwNTNfMjE5ODMxMDA0XzExNzUxNzYyMjlfMl8z_low.webp?tag=1-1477096443-h-1-ggqhkohfhg-4cedaf6dab9b0152"}],"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/05/11/11/BMjAxNjA1MTExMTEwMjRfMjE5ODMxMDA0XzJfaGQ4NQ==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/05/11/11/BMjAxNjA1MTExMTEwMjRfMjE5ODMxMDA0XzJfaGQ4NQ==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/05/11/11/BMjAxNjA1MTExMTEwMjRfMjE5ODMxMDA0XzJfaGQ4NQ==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/05/11/11/BMjAxNjA1MTExMTEwMjRfMjE5ODMxMDA0XzJfaGQ4NQ==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"us_c":0,"us_d":1,"forward_stats_params":{"et":"1_a/1548847878074806273_h85"},"reco_reason":"h85"}]
     * pcursor : 1
     * new_notify : 0
     * llsid : 1548847878074806273
     * host-name : td-dz-ls82.yz
     */

    private int result;
    private String pcursor;
    private int new_notify;
    private String llsid;
    /**
     * following : 0
     * comments : []
     * caption : 还在下雨烦死了
     * verified : false
     * hasMagicFaceTag : true
     * tags : []
     * time : 2016-10-22 07:02:53
     * timestamp : 1477090973130
     * type : 1
     * user_id : 142616088
     * comment_count : 194
     * photo_id : 1175178070
     * exp_tag : 1_a/1548847878074806273_h85
     * user_sex : F
     * photo_status : 0
     * us_m : 0
     * view_count : 195951
     * like_count : 1598
     * unlike_count : 0
     * forward_count : 0
     * ext_params : {"mtype":3,"color":"BAB489","w":480,"sound":16927,"h":640,"interval":5,"video":16850}
     * tag_hash_type : 1
     * user_name : 小★咪姐5210
     * liked : 0
     * main_mv_urls : [{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAyNTJfMTQyNjE2MDg4XzExNzUxNzgwNzBfMl8z.mp4?tag=1-1477096443-h-0-dihsna4uyv-c7b45c8d94907f5c"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAyNTJfMTQyNjE2MDg4XzExNzUxNzgwNzBfMl8z.mp4?tag=1-1477096443-h-1-tfk4grsnil-e4064179f5a92b44"}]
     * cover_thumbnail_urls : [{"cdn":"tx2.a.yximgs.com","url":"http://tx2.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAyNTJfMTQyNjE2MDg4XzExNzUxNzgwNzBfMl8z_low.webp?tag=1-1477096443-h-0-s3wd4jlgiu-290413a3a5b5d42c"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAyNTJfMTQyNjE2MDg4XzExNzUxNzgwNzBfMl8z_low.webp?tag=1-1477096443-h-1-yqr81bxfff-412e3cc3e49db4ce"}]
     * headurls : [{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}]
     * us_c : 0
     * us_d : 1
     * forward_stats_params : {"et":"1_a/1548847878074806273_h85"}
     * reco_reason : h85
     */

    private List<FeedsBean> feeds;

    public static Bean objectFromData(String str) {

        return new Gson().fromJson(str, Bean.class);
    }

    public static Bean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Bean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Bean> arrayBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<Bean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Bean> arrayBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Bean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }


    public List<FeedsBean> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedsBean> feeds) {
        this.feeds = feeds;
    }

    public static class FeedsBean {
        private int following;
        private String caption;
        private boolean verified;
        private boolean hasMagicFaceTag;
        private String time;
        private long timestamp;
        private int type;
        private int user_id;
        private int comment_count;
        private int photo_id;
        private String exp_tag;
        private String user_sex;
        private int photo_status;
        private int us_m;
        private int view_count;
        private int like_count;
        private int unlike_count;
        private int forward_count;
        /**
         * mtype : 3
         * color : BAB489
         * w : 480
         * sound : 16927
         * h : 640
         * interval : 5
         * video : 16850
         */

        private ExtParamsBean ext_params;
        private int tag_hash_type;
        private String user_name;
        private int liked;
        private int us_c;
        private int us_d;
        /**
         * et : 1_a/1548847878074806273_h85
         */

        private ForwardStatsParamsBean forward_stats_params;
        private String reco_reason;
        private List<?> comments;
        private List<?> tags;
        /**
         * cdn : tx2.a.yximgs.com
         * url : http://tx2.a.yximgs.com/upic/2016/10/22/07/BMjAxNjEwMjIwNzAyNTJfMTQyNjE2MDg4XzExNzUxNzgwNzBfMl8z.mp4?tag=1-1477096443-h-0-dihsna4uyv-c7b45c8d94907f5c
         */

        private List<MainMvUrlsBean> main_mv_urls;
        private List<MainMvUrlsBean> cover_thumbnail_urls;
        /**
         * cdn : js.a.yximgs.com
         * url : http://js.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg
         * urlPattern : http://js.a.yximgs.com/uhead/AB/2016/10/14/10/BMjAxNjEwMTQxMDU2MjVfMTQyNjE2MDg4XzJfaGQ2Mg==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate
         */

        private List<HeadurlsBean> headurls;

        public static FeedsBean objectFromData(String str) {

            return new Gson().fromJson(str, FeedsBean.class);
        }

        public static FeedsBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), FeedsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<FeedsBean> arrayFeedsBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<FeedsBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<FeedsBean> arrayFeedsBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<FeedsBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getFollowing() {
            return following;
        }

        public void setFollowing(int following) {
            this.following = following;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public boolean isVerified() {
            return verified;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public boolean isHasMagicFaceTag() {
            return hasMagicFaceTag;
        }

        public void setHasMagicFaceTag(boolean hasMagicFaceTag) {
            this.hasMagicFaceTag = hasMagicFaceTag;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getPhoto_id() {
            return photo_id;
        }

        public void setPhoto_id(int photo_id) {
            this.photo_id = photo_id;
        }

        public String getExp_tag() {
            return exp_tag;
        }

        public void setExp_tag(String exp_tag) {
            this.exp_tag = exp_tag;
        }

        public String getUser_sex() {
            return user_sex;
        }

        public void setUser_sex(String user_sex) {
            this.user_sex = user_sex;
        }

        public int getPhoto_status() {
            return photo_status;
        }

        public void setPhoto_status(int photo_status) {
            this.photo_status = photo_status;
        }

        public int getUs_m() {
            return us_m;
        }

        public void setUs_m(int us_m) {
            this.us_m = us_m;
        }

        public int getView_count() {
            return view_count;
        }

        public void setView_count(int view_count) {
            this.view_count = view_count;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public int getUnlike_count() {
            return unlike_count;
        }

        public void setUnlike_count(int unlike_count) {
            this.unlike_count = unlike_count;
        }

        public int getForward_count() {
            return forward_count;
        }

        public void setForward_count(int forward_count) {
            this.forward_count = forward_count;
        }

        public ExtParamsBean getExt_params() {
            return ext_params;
        }

        public void setExt_params(ExtParamsBean ext_params) {
            this.ext_params = ext_params;
        }

        public int getTag_hash_type() {
            return tag_hash_type;
        }

        public void setTag_hash_type(int tag_hash_type) {
            this.tag_hash_type = tag_hash_type;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public int getLiked() {
            return liked;
        }

        public void setLiked(int liked) {
            this.liked = liked;
        }

        public int getUs_c() {
            return us_c;
        }

        public void setUs_c(int us_c) {
            this.us_c = us_c;
        }

        public int getUs_d() {
            return us_d;
        }

        public void setUs_d(int us_d) {
            this.us_d = us_d;
        }

        public ForwardStatsParamsBean getForward_stats_params() {
            return forward_stats_params;
        }

        public void setForward_stats_params(ForwardStatsParamsBean forward_stats_params) {
            this.forward_stats_params = forward_stats_params;
        }

        public String getReco_reason() {
            return reco_reason;
        }

        public void setReco_reason(String reco_reason) {
            this.reco_reason = reco_reason;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public List<MainMvUrlsBean> getMain_mv_urls() {
            return main_mv_urls;
        }

        public void setMain_mv_urls(List<MainMvUrlsBean> main_mv_urls) {
            this.main_mv_urls = main_mv_urls;
        }

        public List<MainMvUrlsBean> getCover_thumbnail_urls() {
            return cover_thumbnail_urls;
        }

        public void setCover_thumbnail_urls(List<MainMvUrlsBean> cover_thumbnail_urls) {
            this.cover_thumbnail_urls = cover_thumbnail_urls;
        }

        public List<HeadurlsBean> getHeadurls() {
            return headurls;
        }

        public void setHeadurls(List<HeadurlsBean> headurls) {
            this.headurls = headurls;
        }

        public static class ExtParamsBean {
            private int mtype;
            private String color;
            private int w;
            private int sound;
            private int h;
            private int interval;
            private int video;

            public static ExtParamsBean objectFromData(String str) {

                return new Gson().fromJson(str, ExtParamsBean.class);
            }

            public static ExtParamsBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ExtParamsBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ExtParamsBean> arrayExtParamsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ExtParamsBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ExtParamsBean> arrayExtParamsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ExtParamsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public int getMtype() {
                return mtype;
            }

            public void setMtype(int mtype) {
                this.mtype = mtype;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            public int getSound() {
                return sound;
            }

            public void setSound(int sound) {
                this.sound = sound;
            }

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }

            public int getInterval() {
                return interval;
            }

            public void setInterval(int interval) {
                this.interval = interval;
            }

            public int getVideo() {
                return video;
            }

            public void setVideo(int video) {
                this.video = video;
            }
        }

        public static class ForwardStatsParamsBean {
            private String et;

            public static ForwardStatsParamsBean objectFromData(String str) {

                return new Gson().fromJson(str, ForwardStatsParamsBean.class);
            }

            public static ForwardStatsParamsBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ForwardStatsParamsBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ForwardStatsParamsBean> arrayForwardStatsParamsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ForwardStatsParamsBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ForwardStatsParamsBean> arrayForwardStatsParamsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ForwardStatsParamsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getEt() {
                return et;
            }

            public void setEt(String et) {
                this.et = et;
            }
        }

        public static class MainMvUrlsBean {
            private String cdn;
            private String url;

            public static MainMvUrlsBean objectFromData(String str) {

                return new Gson().fromJson(str, MainMvUrlsBean.class);
            }

            public static MainMvUrlsBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), MainMvUrlsBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<MainMvUrlsBean> arrayMainMvUrlsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<MainMvUrlsBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<MainMvUrlsBean> arrayMainMvUrlsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<MainMvUrlsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getCdn() {
                return cdn;
            }

            public void setCdn(String cdn) {
                this.cdn = cdn;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class HeadurlsBean {
            private String cdn;
            private String url;
            private String urlPattern;

            public static HeadurlsBean objectFromData(String str) {

                return new Gson().fromJson(str, HeadurlsBean.class);
            }

            public static HeadurlsBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), HeadurlsBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<HeadurlsBean> arrayHeadurlsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<HeadurlsBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<HeadurlsBean> arrayHeadurlsBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<HeadurlsBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getCdn() {
                return cdn;
            }

            public void setCdn(String cdn) {
                this.cdn = cdn;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUrlPattern() {
                return urlPattern;
            }

            public void setUrlPattern(String urlPattern) {
                this.urlPattern = urlPattern;
            }
        }
    }
}
