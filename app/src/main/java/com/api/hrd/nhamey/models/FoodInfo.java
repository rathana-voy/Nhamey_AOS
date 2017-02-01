package com.api.hrd.nhamey.models;

/**
 * Created by Thyreach on 1/10/2017.
 */

public class FoodInfo {

        private String food_name;
        private String food_des;
        private String food_price;
        String  food_image;

        public FoodInfo(String food_name, String food_des, String food_price, String food_image) {
            this.food_name = food_name;
            this.food_des = food_des;
            this.food_price= food_price;
            this.food_image = food_image;
        }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_des() {
        return food_des;
    }

    public void setFood_des(String food_des) {
        this.food_des = food_des;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image;
    }

    public static int getLastContactId() {
        return lastContactId;
    }

    public static void setLastContactId(int lastContactId) {
        FoodInfo.lastContactId = lastContactId;
    }

    private static int lastContactId = 0;

       /* public static ArrayList<FoodInfo> createContactsList(int numContacts) {
            ArrayList<FoodInfo> foodInfo = new ArrayList<FoodInfo>();

            *//*for (int i = 1; i <= numContacts; i++) {
                foodInfo.add(new FoodInfo("ហាកាវ"+ ++lastContactId, "description","5$", R.mipmap.ic_launcher));
            }*//*

            return foodInfo;
        }
*/
}
