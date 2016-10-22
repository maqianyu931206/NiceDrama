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
public class QuickInfoBean {


    /**
     * result : 1
     * pcursor : 5903819602
     * comments : [{"type":0,"content":"可爱摇","time":"2016-10-22 11:06:35","timestamp":1477105595178,"author_name":"何大花","user_id":8891753,"author_id":161786433,"photo_id":1172766595,"user_sex":"M","comment_id":5906351013,"us_m":0,"reply_to":0,"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"headurl":"http://ali2.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg"},{"type":0,"content":"可爱","time":"2016-10-22 10:33:29","timestamp":1477103609057,"author_name":"摇sir阿阳","user_id":8891753,"author_id":126555187,"photo_id":1172766595,"user_sex":"M","comment_id":5905955110,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/06/23/19/BMjAxNjA2MjMxOTU2MTNfMTI2NTU1MTg3XzJfaGQ1OA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/06/23/19/BMjAxNjA2MjMxOTU2MTNfMTI2NTU1MTg3XzJfaGQ1OA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/06/23/19/BMjAxNjA2MjMxOTU2MTNfMTI2NTU1MTg3XzJfaGQ1OA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/06/23/19/BMjAxNjA2MjMxOTU2MTNfMTI2NTU1MTg3XzJfaGQ1OA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/06/23/19/BMjAxNjA2MjMxOTU2MTNfMTI2NTU1MTg3XzJfaGQ1OA==.jpg"},{"type":0,"content":"又社会又可爱","time":"2016-10-22 10:25:54","timestamp":1477103153606,"author_name":"怹ьυ嫒le┉97","user_id":8891753,"author_id":360019818,"photo_id":1172766595,"user_sex":"F","comment_id":5905864472,"us_m":0,"reply_to":0,"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQ0MzBfMzYwMDE5ODE4XzJfaGQ5NA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQ0MzBfMzYwMDE5ODE4XzJfaGQ5NA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQ0MzBfMzYwMDE5ODE4XzJfaGQ5NA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQ0MzBfMzYwMDE5ODE4XzJfaGQ5NA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"headurl":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQ0MzBfMzYwMDE5ODE4XzJfaGQ5NA==.jpg"},{"type":0,"content":"什么歌","time":"2016-10-22 10:09:06","timestamp":1477102145736,"author_name":"乖瘦阿旭妹","user_id":8891753,"author_id":186661811,"photo_id":1172766595,"user_sex":"F","comment_id":5905668761,"us_m":0,"reply_to":0,"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/08/18/07/BMjAxNjA4MTgwNzQ0MDZfMTg2NjYxODExXzJfaGQ3Ng==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/08/18/07/BMjAxNjA4MTgwNzQ0MDZfMTg2NjYxODExXzJfaGQ3Ng==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/08/18/07/BMjAxNjA4MTgwNzQ0MDZfMTg2NjYxODExXzJfaGQ3Ng==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/08/18/07/BMjAxNjA4MTgwNzQ0MDZfMTg2NjYxODExXzJfaGQ3Ng==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"headurl":"http://ali2.a.yximgs.com/uhead/AB/2016/08/18/07/BMjAxNjA4MTgwNzQ0MDZfMTg2NjYxODExXzJfaGQ3Ng==.jpg"},{"type":0,"content":"这头发","time":"2016-10-22 10:00:13","timestamp":1477101613443,"author_name":"夏末凉城空余心","user_id":8891753,"author_id":290909090,"photo_id":1172766595,"user_sex":"U","comment_id":5905569860,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/07/24/19/BMjAxNjA3MjQxOTE1MjlfMjkwOTA5MDkwXzJfaGQw.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/07/24/19/BMjAxNjA3MjQxOTE1MjlfMjkwOTA5MDkwXzJfaGQw.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/07/24/19/BMjAxNjA3MjQxOTE1MjlfMjkwOTA5MDkwXzJfaGQw.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/07/24/19/BMjAxNjA3MjQxOTE1MjlfMjkwOTA5MDkwXzJfaGQw.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/07/24/19/BMjAxNjA3MjQxOTE1MjlfMjkwOTA5MDkwXzJfaGQw.jpg"},{"type":0,"content":"？？？","time":"2016-10-22 09:58:42","timestamp":1477101521589,"author_name":"逸程飞扬","user_id":8891753,"author_id":183771185,"photo_id":1172766595,"user_sex":"M","comment_id":5905552459,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/01/29/18/BMjAxNjAxMjkxODAwMDBfMTgzNzcxMTg1XzJfaGQ3.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/01/29/18/BMjAxNjAxMjkxODAwMDBfMTgzNzcxMTg1XzJfaGQ3.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/01/29/18/BMjAxNjAxMjkxODAwMDBfMTgzNzcxMTg1XzJfaGQ3.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/01/29/18/BMjAxNjAxMjkxODAwMDBfMTgzNzcxMTg1XzJfaGQ3.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/01/29/18/BMjAxNjAxMjkxODAwMDBfMTgzNzcxMTg1XzJfaGQ3.jpg"},{"type":0,"content":"什么歌","time":"2016-10-22 09:14:20","timestamp":1477098859727,"author_name":"精彩大庆 ","user_id":8891753,"author_id":120116269,"photo_id":1172766595,"user_sex":"F","comment_id":5905077945,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQwMzZfMTIwMTE2MjY5XzJfaGQ4NQ==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQwMzZfMTIwMTE2MjY5XzJfaGQ4NQ==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQwMzZfMTIwMTE2MjY5XzJfaGQ4NQ==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQwMzZfMTIwMTE2MjY5XzJfaGQ4NQ==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQwMzZfMTIwMTE2MjY5XzJfaGQ4NQ==.jpg"},{"type":0,"content":"天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美","time":"2016-10-22 08:04:42","timestamp":1477094682301,"author_name":"建宁欧巴.","user_id":8891753,"author_id":30195577,"photo_id":1172766595,"user_sex":"M","comment_id":5904421390,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/18/14/BMjAxNjEwMTgxNDAxMDNfMzAxOTU1NzdfMl9oZDkx.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/18/14/BMjAxNjEwMTgxNDAxMDNfMzAxOTU1NzdfMl9oZDkx.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/18/14/BMjAxNjEwMTgxNDAxMDNfMzAxOTU1NzdfMl9oZDkx.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/18/14/BMjAxNjEwMTgxNDAxMDNfMzAxOTU1NzdfMl9oZDkx.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/10/18/14/BMjAxNjEwMTgxNDAxMDNfMzAxOTU1NzdfMl9oZDkx.jpg"},{"type":0,"content":"","time":"2016-10-22 07:51:12","timestamp":1477093871755,"author_name":"蕙丽YEY","user_id":8891753,"author_id":360761379,"photo_id":1172766595,"user_sex":"F","comment_id":5904312112,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/22/05/BMjAxNjEwMjIwNTI2MjVfMzYwNzYxMzc5XzJfaGQ0OA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/22/05/BMjAxNjEwMjIwNTI2MjVfMzYwNzYxMzc5XzJfaGQ0OA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/05/BMjAxNjEwMjIwNTI2MjVfMzYwNzYxMzc5XzJfaGQ0OA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/22/05/BMjAxNjEwMjIwNTI2MjVfMzYwNzYxMzc5XzJfaGQ0OA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/10/22/05/BMjAxNjEwMjIwNTI2MjVfMzYwNzYxMzc5XzJfaGQ0OA==.jpg"},{"type":0,"content":"无聊呢","time":"2016-10-22 07:38:06","timestamp":1477093085680,"author_name":"李林辉","user_id":8891753,"author_id":360791637,"photo_id":1172766595,"user_sex":"F","comment_id":5904213054,"us_m":0,"reply_to":0,"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/09/BMjAxNjEwMjIwOTE4MjRfMzYwNzkxNjM3XzJfaGQxNw==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/22/09/BMjAxNjEwMjIwOTE4MjRfMzYwNzkxNjM3XzJfaGQxNw==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/22/09/BMjAxNjEwMjIwOTE4MjRfMzYwNzkxNjM3XzJfaGQxNw==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/22/09/BMjAxNjEwMjIwOTE4MjRfMzYwNzkxNjM3XzJfaGQxNw==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"headurl":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/09/BMjAxNjEwMjIwOTE4MjRfMzYwNzkxNjM3XzJfaGQxNw==.jpg"}]
     * host-name : ls53.zw
     * commentCount : 209
     */

    private int result;
    private String pcursor;
    /**
     * comments : [{"type":0,"content":"可爱摇","time":"2016-10-22 11:06:35","timestamp":1477105595178,"author_name":"何大花","user_id":8891753,"author_id":161786433,"photo_id":1172766595,"user_sex":"M","comment_id":5906351013,"us_m":0,"reply_to":0,"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"headurl":"http://ali2.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg"},{"type":0,"content":"可爱","time":"2016-10-22 10:33:29","timestamp":1477103609057,"author_name":"摇sir阿阳","user_id":8891753,"author_id":126555187,"photo_id":1172766595,"user_sex":"M","comment_id":5905955110,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/06/23/19/BMjAxNjA2MjMxOTU2MTNfMTI2NTU1MTg3XzJfaGQ1OA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/06/23/19/BMjAxNjA2MjMxOTU2MTNfMTI2NTU1MTg3XzJfaGQ1OA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/06/23/19/BMjAxNjA2MjMxOTU2MTNfMTI2NTU1MTg3XzJfaGQ1OA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/06/23/19/BMjAxNjA2MjMxOTU2MTNfMTI2NTU1MTg3XzJfaGQ1OA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/06/23/19/BMjAxNjA2MjMxOTU2MTNfMTI2NTU1MTg3XzJfaGQ1OA==.jpg"},{"type":0,"content":"又社会又可爱","time":"2016-10-22 10:25:54","timestamp":1477103153606,"author_name":"怹ьυ嫒le┉97","user_id":8891753,"author_id":360019818,"photo_id":1172766595,"user_sex":"F","comment_id":5905864472,"us_m":0,"reply_to":0,"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQ0MzBfMzYwMDE5ODE4XzJfaGQ5NA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQ0MzBfMzYwMDE5ODE4XzJfaGQ5NA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQ0MzBfMzYwMDE5ODE4XzJfaGQ5NA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQ0MzBfMzYwMDE5ODE4XzJfaGQ5NA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"headurl":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQ0MzBfMzYwMDE5ODE4XzJfaGQ5NA==.jpg"},{"type":0,"content":"什么歌","time":"2016-10-22 10:09:06","timestamp":1477102145736,"author_name":"乖瘦阿旭妹","user_id":8891753,"author_id":186661811,"photo_id":1172766595,"user_sex":"F","comment_id":5905668761,"us_m":0,"reply_to":0,"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/08/18/07/BMjAxNjA4MTgwNzQ0MDZfMTg2NjYxODExXzJfaGQ3Ng==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/08/18/07/BMjAxNjA4MTgwNzQ0MDZfMTg2NjYxODExXzJfaGQ3Ng==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/08/18/07/BMjAxNjA4MTgwNzQ0MDZfMTg2NjYxODExXzJfaGQ3Ng==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/08/18/07/BMjAxNjA4MTgwNzQ0MDZfMTg2NjYxODExXzJfaGQ3Ng==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"headurl":"http://ali2.a.yximgs.com/uhead/AB/2016/08/18/07/BMjAxNjA4MTgwNzQ0MDZfMTg2NjYxODExXzJfaGQ3Ng==.jpg"},{"type":0,"content":"这头发","time":"2016-10-22 10:00:13","timestamp":1477101613443,"author_name":"夏末凉城空余心","user_id":8891753,"author_id":290909090,"photo_id":1172766595,"user_sex":"U","comment_id":5905569860,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/07/24/19/BMjAxNjA3MjQxOTE1MjlfMjkwOTA5MDkwXzJfaGQw.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/07/24/19/BMjAxNjA3MjQxOTE1MjlfMjkwOTA5MDkwXzJfaGQw.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/07/24/19/BMjAxNjA3MjQxOTE1MjlfMjkwOTA5MDkwXzJfaGQw.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/07/24/19/BMjAxNjA3MjQxOTE1MjlfMjkwOTA5MDkwXzJfaGQw.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/07/24/19/BMjAxNjA3MjQxOTE1MjlfMjkwOTA5MDkwXzJfaGQw.jpg"},{"type":0,"content":"？？？","time":"2016-10-22 09:58:42","timestamp":1477101521589,"author_name":"逸程飞扬","user_id":8891753,"author_id":183771185,"photo_id":1172766595,"user_sex":"M","comment_id":5905552459,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/01/29/18/BMjAxNjAxMjkxODAwMDBfMTgzNzcxMTg1XzJfaGQ3.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/01/29/18/BMjAxNjAxMjkxODAwMDBfMTgzNzcxMTg1XzJfaGQ3.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/01/29/18/BMjAxNjAxMjkxODAwMDBfMTgzNzcxMTg1XzJfaGQ3.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/01/29/18/BMjAxNjAxMjkxODAwMDBfMTgzNzcxMTg1XzJfaGQ3.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/01/29/18/BMjAxNjAxMjkxODAwMDBfMTgzNzcxMTg1XzJfaGQ3.jpg"},{"type":0,"content":"什么歌","time":"2016-10-22 09:14:20","timestamp":1477098859727,"author_name":"精彩大庆 ","user_id":8891753,"author_id":120116269,"photo_id":1172766595,"user_sex":"F","comment_id":5905077945,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQwMzZfMTIwMTE2MjY5XzJfaGQ4NQ==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQwMzZfMTIwMTE2MjY5XzJfaGQ4NQ==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQwMzZfMTIwMTE2MjY5XzJfaGQ4NQ==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQwMzZfMTIwMTE2MjY5XzJfaGQ4NQ==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/10/22/10/BMjAxNjEwMjIxMDQwMzZfMTIwMTE2MjY5XzJfaGQ4NQ==.jpg"},{"type":0,"content":"天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美天南地北傲娇静最美","time":"2016-10-22 08:04:42","timestamp":1477094682301,"author_name":"建宁欧巴.","user_id":8891753,"author_id":30195577,"photo_id":1172766595,"user_sex":"M","comment_id":5904421390,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/18/14/BMjAxNjEwMTgxNDAxMDNfMzAxOTU1NzdfMl9oZDkx.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/18/14/BMjAxNjEwMTgxNDAxMDNfMzAxOTU1NzdfMl9oZDkx.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/18/14/BMjAxNjEwMTgxNDAxMDNfMzAxOTU1NzdfMl9oZDkx.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/18/14/BMjAxNjEwMTgxNDAxMDNfMzAxOTU1NzdfMl9oZDkx.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/10/18/14/BMjAxNjEwMTgxNDAxMDNfMzAxOTU1NzdfMl9oZDkx.jpg"},{"type":0,"content":"","time":"2016-10-22 07:51:12","timestamp":1477093871755,"author_name":"蕙丽YEY","user_id":8891753,"author_id":360761379,"photo_id":1172766595,"user_sex":"F","comment_id":5904312112,"us_m":0,"reply_to":0,"headurls":[{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/22/05/BMjAxNjEwMjIwNTI2MjVfMzYwNzYxMzc5XzJfaGQ0OA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/22/05/BMjAxNjEwMjIwNTI2MjVfMzYwNzYxMzc5XzJfaGQ0OA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"},{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/05/BMjAxNjEwMjIwNTI2MjVfMzYwNzYxMzc5XzJfaGQ0OA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/22/05/BMjAxNjEwMjIwNTI2MjVfMzYwNzYxMzc5XzJfaGQ0OA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"}],"headurl":"http://js.a.yximgs.com/uhead/AB/2016/10/22/05/BMjAxNjEwMjIwNTI2MjVfMzYwNzYxMzc5XzJfaGQ0OA==.jpg"},{"type":0,"content":"无聊呢","time":"2016-10-22 07:38:06","timestamp":1477093085680,"author_name":"李林辉","user_id":8891753,"author_id":360791637,"photo_id":1172766595,"user_sex":"F","comment_id":5904213054,"us_m":0,"reply_to":0,"headurls":[{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/09/BMjAxNjEwMjIwOTE4MjRfMzYwNzkxNjM3XzJfaGQxNw==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/10/22/09/BMjAxNjEwMjIwOTE4MjRfMzYwNzkxNjM3XzJfaGQxNw==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/10/22/09/BMjAxNjEwMjIwOTE4MjRfMzYwNzkxNjM3XzJfaGQxNw==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/10/22/09/BMjAxNjEwMjIwOTE4MjRfMzYwNzkxNjM3XzJfaGQxNw==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}],"headurl":"http://ali2.a.yximgs.com/uhead/AB/2016/10/22/09/BMjAxNjEwMjIwOTE4MjRfMzYwNzkxNjM3XzJfaGQxNw==.jpg"}]
     * host-name : ls53.zw
     * commentCount : 209
     */

    private int commentCount;
    /**
     * type : 0
     * content : 可爱摇
     * time : 2016-10-22 11:06:35
     * timestamp : 1477105595178
     * author_name : 何大花
     * user_id : 8891753
     * author_id : 161786433
     * photo_id : 1172766595
     * user_sex : M
     * comment_id : 5906351013
     * us_m : 0
     * reply_to : 0
     * headurls : [{"cdn":"ali2.a.yximgs.com","url":"http://ali2.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg","urlPattern":"http://aliimg.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src"},{"cdn":"js.a.yximgs.com","url":"http://js.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg","urlPattern":"http://js.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg@base@tag%3DimgScale%26r%3D0%26q%3D85%26w%3D{w}%26h%3D{h}%26rotate"}]
     * headurl : http://ali2.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg
     */

    private List<CommentsBean> comments;




    public static QuickInfoBean objectFromData(String str) {

        return new Gson().fromJson(str, QuickInfoBean.class);
    }

    public static QuickInfoBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), QuickInfoBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<QuickInfoBean> arrayQuickInfoBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<QuickInfoBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<QuickInfoBean> arrayQuickInfoBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<QuickInfoBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class CommentsBean {
        private int type;
        private String content;
        private String time;
        private long timestamp;
        private String author_name;
        private int user_id;
        private int author_id;
        private int photo_id;
        private String user_sex;
        private long comment_id;
        private int us_m;
        private int reply_to;
        private String headurl;
        /**
         * cdn : ali2.a.yximgs.com
         * url : http://ali2.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg
         * urlPattern : http://aliimg.a.yximgs.com/uhead/AB/2016/06/09/21/BMjAxNjA2MDkyMTQ4NDlfMTYxNzg2NDMzXzJfaGQyNA==.jpg@0e_0o_0l_{h}h_{w}w_85q.src
         */

        private List<HeadurlsBean> headurls;

        public static CommentsBean objectFromData(String str) {

            return new Gson().fromJson(str, CommentsBean.class);
        }

        public static CommentsBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), CommentsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<CommentsBean> arrayCommentsBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<CommentsBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<CommentsBean> arrayCommentsBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<CommentsBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(int author_id) {
            this.author_id = author_id;
        }

        public int getPhoto_id() {
            return photo_id;
        }

        public void setPhoto_id(int photo_id) {
            this.photo_id = photo_id;
        }

        public String getUser_sex() {
            return user_sex;
        }

        public void setUser_sex(String user_sex) {
            this.user_sex = user_sex;
        }

        public long getComment_id() {
            return comment_id;
        }

        public void setComment_id(long comment_id) {
            this.comment_id = comment_id;
        }

        public int getUs_m() {
            return us_m;
        }

        public void setUs_m(int us_m) {
            this.us_m = us_m;
        }

        public int getReply_to() {
            return reply_to;
        }

        public void setReply_to(int reply_to) {
            this.reply_to = reply_to;
        }

        public String getHeadurl() {
            return headurl;
        }

        public void setHeadurl(String headurl) {
            this.headurl = headurl;
        }

        public List<HeadurlsBean> getHeadurls() {
            return headurls;
        }

        public void setHeadurls(List<HeadurlsBean> headurls) {
            this.headurls = headurls;
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
