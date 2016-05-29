package com.qq.popular;


import com.qq.popular.api.MediaAPI;
import com.qq.popular.bean.media.Media;
import com.qq.popular.bean.media.MediaType;

import java.io.File;

/**
 * Created by sdyang on 2016/3/30.
 */
public class MediaAPITest {

    private static String accessToken = "1_ee881608a8470e070b93ad2a51da2394";

    public static void main(String[] args){
       // BaseResult result = null;

        File file = new File("C:/TCLO2O.jpg");
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
        }

        Media result = MediaAPI.uploadMaterial(TokenAPITest.getToken(), MediaType.image_jpg, file, null);
        if (result.isSuccess()) {
            System.out.println(String.format("Type:%s , Media_id:%s ,Created:%s ", result.getType(),result.getMedia_id(),result.getCreated_at()));
        }
        result.printErrInfo();

    }
}
