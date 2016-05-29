package com.qq.popular.bean.media;

/**
 * QQ上传素材的媒体类型
 * Created by sdyang on 2016/5/29.
 */
public enum MediaType {
    image_jpg{
        @Override
        public String fileSuffix() {
            return "jpg";
        }

        @Override
        public String uploadType() {
            return "image";
        }

        @Override
        public String contentType() {
            return "image/jpg";
        }
    },image_jpeg{
        @Override
        public String fileSuffix() {
            return "jpeg";
        }

        @Override
        public String uploadType() {
            return "image";
        }

        @Override
        public String contentType() {
            return "image/jpeg";
        }
    },image_png{
        @Override
        public String fileSuffix() {
            return "png";
        }

        @Override
        public String uploadType() {
            return "image";
        }

        @Override
        public String contentType() {
            return "image/png";
        }
    },image_gif{
        @Override
        public String fileSuffix() {
            return "gif";
        }

        @Override
        public String uploadType() {
            return "image";
        }

        @Override
        public String contentType() {
            return "image/gif";
        }
    },voice_mp3 {

        @Override
        public String fileSuffix() {
            return "mp3";
        }

        @Override
        public String uploadType() {
            return "voice";
        }

        @Override
        public String contentType() {
            return "audio/mp3";
        }
    },voice_wma {

        @Override
        public String fileSuffix() {
            return "wma";
        }

        @Override
        public String uploadType() {
            return "voice";
        }

        @Override
        public String contentType() {
            return "audio/x-ms-wma";
        }
    },voice_wmv {

        @Override
        public String fileSuffix() {
            return "wmv";
        }

        @Override
        public String uploadType() {
            return "voice";
        }

        @Override
        public String contentType() {
            return "video/x-ms-wmv";
        }
    },voice_amr {

        @Override
        public String fileSuffix() {
            return "amr";
        }

        @Override
        public String uploadType() {
            return "voice";
        }

        @Override
        public String contentType() {
            return "audio/amr";
        }
    },video_mp4 {
        @Override
        public String fileSuffix() {
            return "mp4";
        }

        @Override
        public String uploadType() {
            return "video";
        }

        @Override
        public String contentType() {
            return "video/mpeg4";
        }
    };


    public abstract String fileSuffix();//文件扩展名

    public abstract String uploadType();//上传类型

    public abstract String contentType();//ContentType


}
