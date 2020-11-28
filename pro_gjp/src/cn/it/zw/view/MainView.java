package cn.it.zw.view;

import cn.it.zw.bean.Menu;
import cn.it.zw.bean.ZhangWu;
import org.apache.commons.dbutils.QueryRunner;

import java.util.Scanner;

import static cn.it.zw.view.DeleteView.deleteByxuhao;

public class MainView {
    static Scanner scanner = new Scanner(System.in);

    //主菜单
    public static void mainView(){
        while (true){
            Menu.MAINMENU();
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    addView();    //添加菜单
                    break;
                case 2:
                    queryView();  //查找菜单
                    break;
                case 3:
                    deleteView();   //删除菜单
                    break;
                case 4:
                    updateView();  //修改菜单
                    break;
                case 5:
                    sortView();   //排序菜单
                    break;
                case 6:
                    System.exit(0);
                    default:
                        break;
            }
        }
    }

    private static void sortView() {
        a:
        while (true){
            Menu.SORTMENU();
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    SortView.SortBytitle();
                    break ;
                case 2:
                    SortView.SortBydata();
                    break ;
                case 3:
                    SortView.SortByuser();
                    break ;
                case 4:
                    SortView.SortByprice();
                    break ;
                case 5:
                    break a;
            }
        }
    }

    private static void updateView() {
        UpdateView.updateInfo();
    }

    private static void deleteView() {
        DeleteView.deleteByxuhao();
    }

    //查找菜单
    private static void queryView() {
        a:
        while (true){
            Menu.SEARCHMENU();
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    QueryView.queryAllBytype();
                    break;
                case 2:
                    AddView.queryAllBydata();
                    break;
                case 3:
                    QueryView.queryAllByuser();
                    break;
                case 4:
                    QueryView.queryAllBytitle();
                    break;
                case 5:
                    QueryView.queryZhangWuAll();
                    break;
                case 6:
                    break a;
            }
        }
    }

    private static void addView(){
        a:
        while (true){
            Menu.ADDMENU();
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    AddView.addView();
                    break;
                case 2:
                    AddView.queryAllBydata();
                    break;
                case 3:
                    break a;
                default:
                    break;
            }
        }
    }


}
