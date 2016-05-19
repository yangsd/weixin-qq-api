package com.qq.popular.bean.menu;

import java.util.List;

/**
 * Created by fang on 2015/10/24.
 */
public class MenuButton {
        private String type;	//click|view
        private String name;
        private String key;
        private String url;
        private Integer media_id;//调用新增永久素材接口返回的合法media_id

        private List<MenuButton> sub_button;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<MenuButton> getSub_button() {
            return sub_button;
        }

        public void setSub_button(List<MenuButton> subButton) {
            sub_button = subButton;
        }

        public Integer getMedia_id() {
            return media_id;
        }

        public void setMedia_id(Integer media_id) {
            this.media_id = media_id;
        }

    public static MenuButton newParentButton(String name,String key,List<MenuButton> btns){
        MenuButton btn = newButton(null,name,key,null);
        btn.setSub_button(btns);
        return btn;
    }
    public static MenuButton newClickButton(String name,String key){
        MenuButton btn = newButton(MenuType.CLICK,name,key,null);
        return btn;
    }
    public static MenuButton newViewButton(String name,String key,String url){
        return newButton(MenuType.VIEW,name,key,url);
    }

    public static MenuButton newButton(MenuType type,String name,String key,String url){
        MenuButton btn = new MenuButton();
        btn.setKey(key);
        if(type != null) {
            btn.setType(type.toString());
        }
        btn.setName(name);
        btn.setUrl(url);
        return btn;
    }

}
