package main.java.org.homework;

import com.google.gson.Gson;

import java.util.Arrays;

public class User {
    private String name;
    private int order;
    private String address;
    private String[] family;

    public User(String name, int order, String address, String[] family) {
        this.name = name;
        this.order = order;
        this.address = address;
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getFamily() {
        return family;
    }

    public void setFamily(String[] family) {
        this.family = family;
    }
    @Override
    public String toString(){
        return this.name+","+this.order+","+this.address+","+ Arrays.toString(family);
    }

    public static void main(String[] args){
        String[] arr = {"김만두","근육만두","참치만두","소시지만두","호떡만두"};
        User user = new User("gamja",15,"jinjub",arr);
        Gson gson = new Gson();
        String a = gson.toJson(user);
        System.out.println(a);

        if(a!=null){
            User reUser = gson.fromJson(a, User.class);
            System.out.println(reUser.toString());
        }
    }
}
