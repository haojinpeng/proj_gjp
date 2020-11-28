package cn.it.zw.bean;

public class Time {
    private String star_time;
    private String end_time;

    public String getStar_time() {
        return star_time;
    }

    public void setStar_time(String star_time) {
        this.star_time = star_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Time() {
    }

    public Time(String star_time, String end_time) {
        this.star_time = star_time;
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Time{" +
                "star_time='" + star_time + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }
}
