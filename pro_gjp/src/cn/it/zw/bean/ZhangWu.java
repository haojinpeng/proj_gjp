package cn.it.zw.bean;

/**
 * 用来封装账务信息的JavaBean。
 */
public class ZhangWu {
    private int id;  //可以放到表bill_type中
    private String user;
    private String title;
    private String bill_time;
    private int type_id;
    private int price;
    private String explain;
    private String name;


    public ZhangWu() {
    }

    public ZhangWu(String user, String title, String bill_time, int type_id, int price, String explain, String name) {
        this.user = user;
        this.title = title;
        this.bill_time = bill_time;
        this.type_id = type_id;
        this.price = price;
        this.explain = explain;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBill_time() {
        return bill_time;
    }

    public void setBill_time(String bill_time) {
        this.bill_time = bill_time;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "id=" + id +"\t"+
                "title=" + title + "\t"+
                "user=" + user +"\t"+
                "bill_time=" + bill_time +"\t"+
                "name=" + name +"\t"+
                "price=" + price +"\t"+
                "explain=" + explain;
    }


}

