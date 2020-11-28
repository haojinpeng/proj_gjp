package cn.it.zw.bean;

public class Menu {

    //主菜单
    public static void MAINMENU() {
        System.out.println("*********主菜单**********");
        System.out.println("**      1 添加记录     **");
        System.out.println("**      2 查找记录     **");
        System.out.println("**      3 删除记录     **");
        System.out.println("**      4 修改记录     **");
        System.out.println("**      5 排序记录     **");
        System.out.println("**      6 退出系统     **");
        System.out.println("*************************");
        System.out.println("请输入正确的数字，最小是：1  最大是：6");
    }

    //添加菜单
    public static void ADDMENU() {
        System.out.println("*********添加菜单**********");
        System.out.println("**      1 添加新记录     **");
        System.out.println("**      2 查看全记录     **");
        System.out.println("**      3 返回上一级     **");
        System.out.println("**************************");
        System.out.println("请输入正确的数字，最小是：1  最大是：3");
    }

    //查找菜单
    public static void SEARCHMENU(){
        System.out.println("*********查找菜单**********");
        System.out.println("**    1 按照类型查找     **");
        System.out.println("**    2 按照日期查找     **");
        System.out.println("**    3 按照用户查找     **");
        System.out.println("**    4 按照标题查找     **");
        System.out.println("**    5 查 询 所 有     **");
        System.out.println("**    6 返回上级目录     **");
        System.out.println("**************************");
        System.out.println("请输入正确的数字，最小是：1  最大是：6");
    }

    //排序菜单
    public static void SORTMENU(){
        System.out.println("*********排序菜单**********");
        System.out.println("**    1 按照标题排序     **");
        System.out.println("**    2 按照时间排序    **");
        System.out.println("**    3 按照用户排序     **");
        System.out.println("**    4 按照金额排序     **");
        System.out.println("**    5 返回上级目录     **");
        System.out.println("**************************");
        System.out.println("请输入正确的数字，最小是：1  最大是：5");
    }
}
